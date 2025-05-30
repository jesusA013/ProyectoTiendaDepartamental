package ModuloAdministracion.GestionProductos;

import DTOs.ProductoDTO;
import Excepciones.NegocioException;
import Interfaces.IProductoBO;
import java.awt.BorderLayout;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

/**
 *
 * @author gaspa
 */
public class PanelRegistrarProducto extends javax.swing.JPanel {

    private final JPanel panelCambiante;
    private final IProductoBO productoBO;

    /**
     * Creates new form PanelRegistrarProducto
     */
    public PanelRegistrarProducto(JPanel panelCambiante, IProductoBO productoBO) {
        initComponents();
        this.panelCambiante = panelCambiante;
        this.productoBO = productoBO;
    }

    public void registrarProducto() {
        try {
            ProductoDTO productoDTO = new ProductoDTO();
            productoDTO.setNombre(nombreTextField.getText());
            productoDTO.setSKU(SKUTextField.getText());
            productoDTO.setColor(colorTextField.getText());
            productoDTO.setMarca(MarcaTextField.getText());
            productoDTO.setPrecio(Double.parseDouble(precioTextField.getText()));
            productoDTO.setStock(Integer.parseInt(stoclTextField1.getText()));

            productoBO.insertarProducto(productoDTO);

            JOptionPane.showMessageDialog(null, "Producto registrado exitosamente.", "Éxito", JOptionPane.INFORMATION_MESSAGE);
            this.volver();
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(null, "Error: Precio o stock inválido.", "Error", JOptionPane.ERROR_MESSAGE);
        } catch (NegocioException ex) {
            JOptionPane.showMessageDialog(null, "Error al registrar producto: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    public void volver() {
        PanelListadoProductos panelListado = new PanelListadoProductos(panelCambiante, productoBO);
        panelCambiante.setLayout(new BorderLayout());
        panelCambiante.removeAll();
        panelCambiante.add(panelListado, BorderLayout.CENTER);
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
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        nombreTextField = new javax.swing.JTextField();
        SKUTextField = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        MarcaTextField = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        colorTextField = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        imagenLabel = new javax.swing.JLabel();
        volverBTN = new javax.swing.JButton();
        precioTextField = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        stoclTextField1 = new javax.swing.JTextField();
        gestionProductosBTN1 = new javax.swing.JButton();

        setMinimumSize(new java.awt.Dimension(1000, 550));
        setPreferredSize(new java.awt.Dimension(1000, 550));

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 48)); // NOI18N
        jLabel1.setText("Registrar nuevo producto");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 40, -1, -1));

        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jLabel2.setText("Imagen (opcional)");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 150, -1, -1));

        nombreTextField.setColumns(15);
        nombreTextField.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jPanel1.add(nombreTextField, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 150, -1, -1));

        SKUTextField.setColumns(15);
        SKUTextField.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jPanel1.add(SKUTextField, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 200, -1, -1));

        jLabel3.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jLabel3.setText("SKU");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 200, -1, -1));

        MarcaTextField.setColumns(15);
        MarcaTextField.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jPanel1.add(MarcaTextField, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 250, -1, -1));

        jLabel4.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jLabel4.setText("Marca");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 250, -1, -1));

        colorTextField.setColumns(15);
        colorTextField.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jPanel1.add(colorTextField, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 300, -1, -1));

        jLabel5.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jLabel5.setText("Color");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 300, -1, -1));

        jLabel6.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jLabel6.setText("Nombre");
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 150, -1, -1));

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(imagenLabel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 210, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(imagenLabel, javax.swing.GroupLayout.DEFAULT_SIZE, 180, Short.MAX_VALUE)
        );

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 210, 210, 180));

        volverBTN.setBackground(new java.awt.Color(103, 80, 164));
        volverBTN.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        volverBTN.setForeground(new java.awt.Color(255, 255, 255));
        volverBTN.setText("Volver");
        volverBTN.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                volverBTNActionPerformed(evt);
            }
        });
        jPanel1.add(volverBTN, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 460, 210, -1));

        precioTextField.setColumns(15);
        precioTextField.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jPanel1.add(precioTextField, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 350, -1, -1));

        jLabel7.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jLabel7.setText("Precio");
        jPanel1.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 350, -1, -1));

        jLabel8.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jLabel8.setText("Stock Inicial");
        jPanel1.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 400, -1, -1));

        stoclTextField1.setColumns(15);
        stoclTextField1.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jPanel1.add(stoclTextField1, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 400, 160, -1));

        gestionProductosBTN1.setBackground(new java.awt.Color(103, 80, 164));
        gestionProductosBTN1.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        gestionProductosBTN1.setForeground(new java.awt.Color(255, 255, 255));
        gestionProductosBTN1.setText("Registrar Producto");
        gestionProductosBTN1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                gestionProductosBTN1ActionPerformed(evt);
            }
        });
        jPanel1.add(gestionProductosBTN1, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 460, 210, -1));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 1000, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 601, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void volverBTNActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_volverBTNActionPerformed
        this.volver();
    }//GEN-LAST:event_volverBTNActionPerformed

    private void gestionProductosBTN1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_gestionProductosBTN1ActionPerformed
        this.registrarProducto();
    }//GEN-LAST:event_gestionProductosBTN1ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField MarcaTextField;
    private javax.swing.JTextField SKUTextField;
    private javax.swing.JTextField colorTextField;
    private javax.swing.JButton gestionProductosBTN1;
    private javax.swing.JLabel imagenLabel;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JTextField nombreTextField;
    private javax.swing.JTextField precioTextField;
    private javax.swing.JTextField stoclTextField1;
    private javax.swing.JButton volverBTN;
    // End of variables declaration//GEN-END:variables
}
