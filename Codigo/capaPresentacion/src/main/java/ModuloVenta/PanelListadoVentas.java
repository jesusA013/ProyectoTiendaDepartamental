/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package ModuloVenta;

import DTOs.ProductoTablaDTO;
import DTOs.VendedorDTO;
import DTOs.VentaDTO;
import Excepciones.NegocioException;
import Interfaces.IVendedorBO;
import Interfaces.IVentasBO;
import ModuloAdministracion.GestionProductos.PanelAdministradorMenu;
import ModuloAdministracion.GestionProductos.PanelEditarProducto;
import Utilidades.JButtonCellEditor;
import Utilidades.JButtonRenderer;
import control.ControlNavegacion;
import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;
import org.bson.types.ObjectId;

/**
 *
 * @author gaspa
 */
public class PanelListadoVentas extends javax.swing.JPanel {
    JPanel panelCambiante;
    IVentasBO ventaBO;
    IVendedorBO vendedorBO;
    /**
     * Creates new form PanelListadoVentas
     */
    public PanelListadoVentas(JPanel panelCambiante, IVentasBO ventaBO,IVendedorBO vendedorBO) {
        initComponents();
        this.panelCambiante=panelCambiante;
        this.ventaBO = ventaBO;
        this.vendedorBO = vendedorBO;
        metodosIniciales();
    }
    private void metodosIniciales() {
        this.configuracionInicialTabla();
        this.buscarTabla();
    }
    private void configuracionInicialTabla() {
        ActionListener onEditarClickListener = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int filaSeleccionada = tablaProductos.getSelectedRow();
                if (filaSeleccionada != -1) {
                    String estadoFactura = tablaProductos.getValueAt(filaSeleccionada, 4).toString();
                    if ("Facturado".equalsIgnoreCase(estadoFactura)) {
                        JOptionPane.showMessageDialog(tablaProductos, "Esta venta ya ha sido facturada.", "Aviso", JOptionPane.INFORMATION_MESSAGE);
                        return;
                    }

                    try {
                        // Si no está facturado, permitir facturar
                        facturar();
                    } catch (NegocioException ex) {
                        System.out.println("Error: " + ex.getMessage());
                    }
                }
            }
        };
        int indiceColumnaEditar = 5;
        TableColumnModel modeloColumnas = this.tablaProductos.getColumnModel();
        modeloColumnas.getColumn(indiceColumnaEditar)
                .setCellRenderer(new JButtonRenderer("Facturar"));
        modeloColumnas.getColumn(indiceColumnaEditar)
                .setCellEditor(new JButtonCellEditor("Facturar", onEditarClickListener));

        ActionListener onEliminarClickListener = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //Metodo para eliminar
                eliminar();
                metodosIniciales();
            }
        };
        int indiceColumnaEliminar = 6;
        modeloColumnas = this.tablaProductos.getColumnModel();
        modeloColumnas.getColumn(indiceColumnaEliminar)
                .setCellRenderer(new JButtonRenderer("Eliminar"));
        modeloColumnas.getColumn(indiceColumnaEliminar)
                .setCellEditor(new JButtonCellEditor("Eliminar", onEliminarClickListener));
    }
    private void facturar() throws NegocioException {
        ObjectId id = this.getIdSeleccionadoTabla();
        ControlNavegacion.getInstance().irAFacturaDatos(id,1);
    }

    private void eliminar() {
        ObjectId id = this.getIdSeleccionadoTabla();

        int confirmacion = JOptionPane.showConfirmDialog(
            this,
            "¿Estás seguro de que deseas eliminar esta venta?",
            "Confirmar eliminación",
            JOptionPane.YES_NO_OPTION,
            JOptionPane.QUESTION_MESSAGE
        );

        if (confirmacion == JOptionPane.YES_OPTION) {
            try {
                ventaBO.eliminarVenta(id);
                this.metodosIniciales();
                JOptionPane.showMessageDialog(this, "venta eliminada con éxito con el id: " + id);
            } catch (NegocioException e) {
                JOptionPane.showMessageDialog(this, "Error al eliminar la venta: " + e.getMessage());
            }
        } else {
            JOptionPane.showMessageDialog(this, "Eliminación cancelada.");
        }
    }
    private ObjectId getIdSeleccionadoTabla() {
        int indiceFilaSeleccionada = this.tablaProductos.getSelectedRow();
        if (indiceFilaSeleccionada != -1) {
            DefaultTableModel modelo = (DefaultTableModel) this.tablaProductos.getModel();
            int indiceColumnaId = 0;
            Object valor = modelo.getValueAt(indiceFilaSeleccionada, indiceColumnaId);
            if (valor instanceof ObjectId) {
                return (ObjectId) valor;
            } else {
                
                System.out.println("El valor en la columna ID no es un ObjectId");
                return null;
            }
        } else {
            return null;
        }
    }

    private void buscarTabla() {
        try {
            List<VentaDTO> productosTablaLista = this.ventaBO.obtenerVentas();
            DefaultTableModel modelo = (DefaultTableModel) this.tablaProductos.getModel();
            modelo.setRowCount(0);
            this.agregarRegistrosTabla(productosTablaLista);
        } catch (NegocioException ex) {
            System.out.println(ex.getMessage());
        }
    }
    private VendedorDTO buscarVendedor(ObjectId id) throws NegocioException{
        return vendedorBO.obtenerVendedorPorId(id);
    }
    private void agregarRegistrosTabla(List<VentaDTO> carrerasLista) {
        

        DefaultTableModel modeloTabla = (DefaultTableModel) this.tablaProductos.getModel();
        if(!carrerasLista.isEmpty()){
            carrerasLista.forEach(row -> {
                Object[] fila = new Object[5];
                fila[0] = row.getId();
                fila[1] = row.getDetallesVenta().getTotal();
                SimpleDateFormat date = new SimpleDateFormat("dd-MM-yyyy");
                fila[2] = date.format(row.getFecha());
                try {
                    fila[3] = buscarVendedor(row.getVendedorId()).getNombreCompleto().getNombres();
                } catch (NegocioException ex) {
                    System.getLogger(PanelListadoVentas.class.getName()).log(System.Logger.Level.ERROR, (String) null, ex);
                }
                if(row.getFactura().getRfc()!=null){
                    
                    fila[4] = "Facturado";
                }
                else{
                    fila[4]="Sin facturar";
                }
                
                modeloTabla.addRow(fila);
            });
        } 
        
    }
    public void volver(){
        PanelAdministradorMenu panelMenu = new PanelAdministradorMenu(panelCambiante);
        panelCambiante.setLayout(new BorderLayout());
        panelCambiante.removeAll();
        panelCambiante.add(panelMenu,BorderLayout.CENTER);
        panelCambiante.revalidate();
        panelCambiante.repaint();
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablaProductos = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        volverBTN = new javax.swing.JButton();

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        tablaProductos.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        tablaProductos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Id", "Total", "Fecha", "Vendedor", "Facturado", "Gestion", "Gestion"
            }
        ));
        jScrollPane1.setViewportView(tablaProductos);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 80, 940, 280));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 48)); // NOI18N
        jLabel1.setText("Listado de Ventas");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 10, -1, -1));

        volverBTN.setBackground(new java.awt.Color(103, 80, 164));
        volverBTN.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        volverBTN.setForeground(new java.awt.Color(255, 255, 255));
        volverBTN.setText("Volver");
        volverBTN.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                volverBTNActionPerformed(evt);
            }
        });
        jPanel1.add(volverBTN, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 380, 210, -1));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 998, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 429, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void volverBTNActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_volverBTNActionPerformed
        this.volver();
    }//GEN-LAST:event_volverBTNActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tablaProductos;
    private javax.swing.JButton volverBTN;
    // End of variables declaration//GEN-END:variables
}
