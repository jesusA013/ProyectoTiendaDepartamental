package ModuloAlmacen.GestionInventario;

import DTOs.ProductoTablaDTO;
import Excepciones.NegocioException;
import Interfaces.IMovimientoBO;
import Interfaces.IProductoBO;
import Utilidades.JButtonCellEditor;
import Utilidades.JButtonRenderer;
import control.ControlNavegacion;
import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;
import org.bson.types.ObjectId;

/**
 *
 * @author Ángel Ruíz García - 00000248171
 */
public class InventarioPanelListado extends javax.swing.JPanel {

    private final JPanel panelCambiante;
    private final JFrame pantalla;
    private final IMovimientoBO movimientoBO;
    private final IProductoBO productoBO;

    /**
     * Creates new form PanelListadoProductos
     *
     * @param pantalla
     * @param panelCambiante
     * @param movimientoBO
     * @param productoBO
     */
    public InventarioPanelListado(JFrame pantalla, JPanel panelCambiante, IMovimientoBO movimientoBO, IProductoBO productoBO) {
        initComponents();
        this.movimientoBO = movimientoBO;
        this.productoBO = productoBO;
        this.panelCambiante = panelCambiante;
        this.pantalla = pantalla;
        this.metodosIniciales();
    }

    private void metodosIniciales() {
        this.configuracionInicialTabla();
        this.buscarTabla();
    }

    private void configuracionInicialTabla() {
        ActionListener onDisminuirClickListener = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    //Metodo para disminuir
                    disminuir();
                    metodosIniciales();
                } catch (NegocioException ex) {
                    System.out.println("Error: " + ex.getMessage());
                }
            }
        };
        int indiceColumnaDisminuir = 7;
        TableColumnModel modeloColumnas = this.tablaProductos.getColumnModel();
        modeloColumnas.getColumn(indiceColumnaDisminuir)
                .setCellRenderer(new JButtonRenderer("Disminuir"));
        modeloColumnas.getColumn(indiceColumnaDisminuir)
                .setCellEditor(new JButtonCellEditor("Disminuir", onDisminuirClickListener));

        ActionListener onAumentarClickListener = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //Metodo para aumentar
                aumentar();
                metodosIniciales();
            }
        };
        int indiceColumnaAumentar = 8;
        modeloColumnas = this.tablaProductos.getColumnModel();
        modeloColumnas.getColumn(indiceColumnaAumentar)
                .setCellRenderer(new JButtonRenderer("Aumentar"));
        modeloColumnas.getColumn(indiceColumnaAumentar)
                .setCellEditor(new JButtonCellEditor("Aumentar", onAumentarClickListener));
    }

    private void disminuir() throws NegocioException {
        ObjectId id = this.getIdSeleccionadoTabla();

        InventarioPanelDisminuir panelDisminuir = new InventarioPanelDisminuir(pantalla, panelCambiante, movimientoBO, productoBO, id);
        this.setLayout(new BorderLayout());
        this.removeAll();
        this.add(panelDisminuir, BorderLayout.CENTER);
        this.revalidate();
        this.repaint();
    }

    private void aumentar() {
        ObjectId id = this.getIdSeleccionadoTabla();

        InventarioPanelAumentar panelAumentar = new InventarioPanelAumentar(pantalla, panelCambiante, movimientoBO, productoBO, id);
        this.setLayout(new BorderLayout());
        this.removeAll();
        this.add(panelAumentar, BorderLayout.CENTER);
        this.revalidate();
        this.repaint();
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
            List<ProductoTablaDTO> productosTablaLista = this.productoBO.obtenerTodosParaTabla();
            DefaultTableModel modelo = (DefaultTableModel) this.tablaProductos.getModel();
            modelo.setRowCount(0);
            this.agregarRegistrosTabla(productosTablaLista);
        } catch (NegocioException ex) {
            System.out.println(ex.getMessage());
        }
    }

    private void agregarRegistrosTabla(List<ProductoTablaDTO> productosLista) {

        DefaultTableModel modeloTabla = (DefaultTableModel) this.tablaProductos.getModel();
        if (!productosLista.isEmpty()) {
            productosLista.forEach(row -> {
                Object[] fila = new Object[7];
                fila[0] = row.getId();
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
        pantalla.dispose();
        ControlNavegacion.getInstance().mostrarMenuAlmacen();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelFondo = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablaProductos = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        btnVolver = new javax.swing.JButton();

        setMinimumSize(new java.awt.Dimension(1000, 494));
        setPreferredSize(new java.awt.Dimension(1000, 494));

        panelFondo.setBackground(new java.awt.Color(255, 255, 255));
        panelFondo.setMinimumSize(new java.awt.Dimension(1000, 494));
        panelFondo.setPreferredSize(new java.awt.Dimension(1000, 494));
        panelFondo.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        tablaProductos.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        tablaProductos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Codigo", "Nombre", "Marca", "Color", "Precio", "Stock", "Disminuir", "Aumentar"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, true, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tablaProductos);

        panelFondo.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 80, 940, 280));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 48)); // NOI18N
        jLabel1.setText("Listado de Productos");
        panelFondo.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 10, -1, -1));

        btnVolver.setBackground(new java.awt.Color(103, 80, 164));
        btnVolver.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        btnVolver.setForeground(new java.awt.Color(255, 255, 255));
        btnVolver.setText("Volver");
        btnVolver.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVolverActionPerformed(evt);
            }
        });
        panelFondo.add(btnVolver, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 380, 210, -1));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelFondo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelFondo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnVolverActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVolverActionPerformed
        this.volver();
    }//GEN-LAST:event_btnVolverActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnVolver;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JPanel panelFondo;
    private javax.swing.JTable tablaProductos;
    // End of variables declaration//GEN-END:variables
}
