package ModuloAdministracion.GestionProductos;

import DTOs.ProductoTablaDTO;
import Excepciones.NegocioException;
import Interfaces.IProductoBO;
import Utilidades.JButtonCellEditor;
import Utilidades.JButtonRenderer;
import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
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
public class PanelListadoProductos extends javax.swing.JPanel {

    private final JPanel panelCambiante;
    private final IProductoBO productoBO;

    /**
     * Creates new form PanelListadoProductos
     * @param panelCambiante
     * @param productoBO
     */
    public PanelListadoProductos(JPanel panelCambiante, IProductoBO productoBO) {
        initComponents();
        this.productoBO = productoBO;
        this.panelCambiante = panelCambiante;
        this.metodosIniciales();

    }

    private void metodosIniciales() {
        this.configuracionInicialTabla();
        this.buscarTabla();
    }

    private void configuracionInicialTabla() {
        ActionListener onEditarClickListener = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    //Metodo para editar
                    editar();
                } catch (NegocioException ex) {
                    System.out.println("Error: " + ex.getMessage());
                }
            }
        };
        int indiceColumnaEditar = 7;
        TableColumnModel modeloColumnas = this.tablaProductos.getColumnModel();
        modeloColumnas.getColumn(indiceColumnaEditar)
                .setCellRenderer(new JButtonRenderer("Editar"));
        modeloColumnas.getColumn(indiceColumnaEditar)
                .setCellEditor(new JButtonCellEditor("Editar", onEditarClickListener));

        ActionListener onEliminarClickListener = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //Metodo para eliminar
                eliminar();
                metodosIniciales();
            }
        };
        int indiceColumnaEliminar = 8;
        modeloColumnas = this.tablaProductos.getColumnModel();
        modeloColumnas.getColumn(indiceColumnaEliminar)
                .setCellRenderer(new JButtonRenderer("Eliminar"));
        modeloColumnas.getColumn(indiceColumnaEliminar)
                .setCellEditor(new JButtonCellEditor("Eliminar", onEliminarClickListener));
    }

    private void editar() throws NegocioException {
        String id = this.getIdSeleccionadoTabla();

        PanelEditarProducto panelCarrera = new PanelEditarProducto(panelCambiante, productoBO, id);
        this.setLayout(new BorderLayout());
        this.removeAll();
        this.add(panelCarrera, BorderLayout.CENTER);
        this.revalidate();
        this.repaint();
    }

    private void eliminar() {
        String id = this.getIdSeleccionadoTabla();

        int confirmacion = JOptionPane.showConfirmDialog(
                this,
                "¿Estás seguro de que deseas eliminar este producto?",
                "Confirmar eliminación",
                JOptionPane.YES_NO_OPTION,
                JOptionPane.QUESTION_MESSAGE
        );

        if (confirmacion == JOptionPane.YES_OPTION) {
            try {
                productoBO.eliminarProducto(id);
                this.metodosIniciales();
                JOptionPane.showMessageDialog(this, "producto eliminado con éxito con el id: " + id);
            } catch (NegocioException e) {
                JOptionPane.showMessageDialog(this, "Error al eliminar el producto: " + e.getMessage());
            }
        } else {
            JOptionPane.showMessageDialog(this, "Eliminación cancelada.");
        }
    }

    private String getIdSeleccionadoTabla() {
        int indiceFilaSeleccionada = this.tablaProductos.getSelectedRow();
        if (indiceFilaSeleccionada != -1) {
            DefaultTableModel modelo = (DefaultTableModel) this.tablaProductos.getModel();
            int indiceColumnaId = 0;
            Object valor = modelo.getValueAt(indiceFilaSeleccionada, indiceColumnaId);
            if (valor instanceof ObjectId) {
                return (String) valor;
            } else {

                System.out.println("El valor en la columna ID no es un String");
                return null;
            }
        } else {
            return null;
        }
    }

    private void buscarTabla() {
        try {
            List<ProductoTablaDTO> productosTablaLista = this.productoBO.obtenerTodosParaTabla();
            DefaultTableModel modelo = (DefaultTableModel) this.tablaProductos.getModel();
            modelo.setRowCount(0);
            this.agregarRegistrosTabla(productosTablaLista);
        } catch (NegocioException ex) {
            System.out.println(ex.getMessage());
        }
    }

    private void agregarRegistrosTabla(List<ProductoTablaDTO> carrerasLista) {

        DefaultTableModel modeloTabla = (DefaultTableModel) this.tablaProductos.getModel();
        if (!carrerasLista.isEmpty()) {
            carrerasLista.forEach(row -> {
                Object[] fila = new Object[7];
                fila[0] = row.getIdProducto();
                fila[1] = row.getCodigo();
                fila[2] = row.getNombre();
                fila[3] = row.getMarca();
                fila[4] = row.getColor();
                fila[5] = row.getPrecio();
                fila[6] = row.getStock();

                modeloTabla.addRow(fila);
            });
        }

    }

    public void volver() {
        PanelAdministradorMenu panelMenu = new PanelAdministradorMenu(panelCambiante, productoBO);
        panelCambiante.setLayout(new BorderLayout());
        panelCambiante.removeAll();
        panelCambiante.add(panelMenu, BorderLayout.CENTER);
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
        registrarBTN = new javax.swing.JButton();

        setMinimumSize(new java.awt.Dimension(1000, 550));
        setPreferredSize(new java.awt.Dimension(1000, 550));

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        tablaProductos.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        tablaProductos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Id", "Codigo", "Nombre", "Marca", "Color", "Precio", "Stock", "Editar", "Eliminar"
            }
        ));
        jScrollPane1.setViewportView(tablaProductos);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 80, 940, 280));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 48)); // NOI18N
        jLabel1.setText("Listado de Productos");
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

        registrarBTN.setBackground(new java.awt.Color(103, 80, 164));
        registrarBTN.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        registrarBTN.setForeground(new java.awt.Color(255, 255, 255));
        registrarBTN.setText("Nuevo Producto");
        registrarBTN.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                registrarBTNActionPerformed(evt);
            }
        });
        jPanel1.add(registrarBTN, new org.netbeans.lib.awtextra.AbsoluteConstraints(810, 30, -1, -1));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void volverBTNActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_volverBTNActionPerformed
        this.volver();
    }//GEN-LAST:event_volverBTNActionPerformed

    private void registrarBTNActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_registrarBTNActionPerformed
        PanelRegistrarProducto panelRegistrar = new PanelRegistrarProducto(panelCambiante, productoBO);
        panelCambiante.setLayout(new BorderLayout());
        panelCambiante.removeAll();
        panelCambiante.add(panelRegistrar, BorderLayout.CENTER);
        panelCambiante.revalidate();
        panelCambiante.repaint();
    }//GEN-LAST:event_registrarBTNActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton registrarBTN;
    private javax.swing.JTable tablaProductos;
    private javax.swing.JButton volverBTN;
    // End of variables declaration//GEN-END:variables
}
