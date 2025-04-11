/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package interfaces;

import BOs.ProductoCarritoBO;
import DTOs.ProductoCarritoDTO;
import PanelesProductos.PanelProductosCarrito;
import control.ControlNavegacion;
import java.util.LinkedList;
import javax.swing.BoxLayout;

/**
 *
 * @author Jesus
 */
public class CarritoCompra extends javax.swing.JFrame {

    /**
     * Creates new form CarritoCompra
     */
    public CarritoCompra() {
        initComponents();

        setTitle("Carrito de compra"); // nombre venata
        setSize(800, 600); //tamaño ventana
        setLocationRelativeTo(null);//centar ventana

        ProductoCarritoDTO producto1 = new ProductoCarritoDTO("Lentes de sol", "123456", 100.0, "Gucci", "azules");
        ProductoCarritoDTO producto2 = new ProductoCarritoDTO("Calcetines", "23123", 20.0, "Nike", "cafe");
        ProductoCarritoDTO producto3 = new ProductoCarritoDTO("chanclas", "54123", 70.0, "ardidas", "amarilla");
        ProductoCarritoDTO producto4 = new ProductoCarritoDTO("gorra", "44577", 130.0, "NY", "negra");

        PanelProductosCarrito productoPanel1 = new PanelProductosCarrito(producto1);
        PanelProductosCarrito productoPanel2 = new PanelProductosCarrito(producto2);
        PanelProductosCarrito productoPanel3 = new PanelProductosCarrito(producto3);
        PanelProductosCarrito productoPanel4 = new PanelProductosCarrito(producto4);

        LinkedList<PanelProductosCarrito> panelesProductoCarrito = new LinkedList<>();
        panelesProductoCarrito.add(productoPanel1);
        panelesProductoCarrito.add(productoPanel2);
        panelesProductoCarrito.add(productoPanel3);
        panelesProductoCarrito.add(productoPanel4);

        for (PanelProductosCarrito productos : panelesProductoCarrito) {
            panelCambiante.add(productos);
        }

        panelCambiante.setLayout(new BoxLayout(panelCambiante, BoxLayout.Y_AXIS));

        int cantidadProductos = 0;
        int subtotalProductos = 0;
        int impuestosProductos = 0;
        int totalProductos = 0;

        lblImpuestos.setText(Double.toString(51.2));
        lblSubProductos.setText(Double.toString(320));
        lblCantProductos.setText(Integer.toString(4));
        totalJlabel.setText(Double.toString(370.2));

    }
    public void procesarCarrito(){
    LinkedList<ProductoCarritoBO> carritoProductos = new LinkedList<>();
    carritoProductos.add(new ProductoCarritoBO(new ProductoCarritoBO("Lentes de sol","123456",100.00,"Gucci",50),2,200.0));
        carritoProductos.add(new ProductoCarritoBO(new ProductoCarritoBO("Calcetines", "23123", 20.0, "Nike", "cafe"),5,100.0));
        
        double subtotal= calcularSubtotal(carritoProductos);
        double impuestos=calcularImpuestos();
        double total=CalcularTotal();
        
        lblSubProductos.setText(Double.toString(subtotal));
        lblImpuestos.setText(Double.toString(impuestos));
        totalJlabel.setText(Double.toString(total));
        
        registrarVenta(carritoProductos); //aqui se le llama para registrar la venta
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        backgroundPanel = new javax.swing.JPanel();
        panelResumen = new javax.swing.JPanel();
        jSeparator1 = new javax.swing.JSeparator();
        cantidadJLabel = new javax.swing.JLabel();
        subtotalJlabel = new javax.swing.JLabel();
        impuestosJLabel = new javax.swing.JLabel();
        separarTotal = new javax.swing.JSeparator();
        totalJlabel = new javax.swing.JLabel();
        botonCanecelar = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        btnPago = new javax.swing.JButton();
        lblSubProductos = new javax.swing.JLabel();
        lblImpuestos = new javax.swing.JLabel();
        lblCantProductos = new javax.swing.JLabel();
        ScrollProductosCarrito = new javax.swing.JScrollPane();
        PanelProductosScroll = new javax.swing.JPanel();
        panelCambiante = new javax.swing.JPanel();
        panelSuperior = new javax.swing.JPanel();
        lbl_ID = new javax.swing.JLabel();
        lblBuscarProducto = new javax.swing.JTextField();
        btnBuscar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        backgroundPanel.setBackground(new java.awt.Color(255, 255, 255));

        panelResumen.setBackground(new java.awt.Color(255, 255, 255));

        jSeparator1.setForeground(new java.awt.Color(0, 0, 0));
        jSeparator1.setOrientation(javax.swing.SwingConstants.VERTICAL);

        cantidadJLabel.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        cantidadJLabel.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        cantidadJLabel.setText("Cantidad productos:");

        subtotalJlabel.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        subtotalJlabel.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        subtotalJlabel.setText("Subtotal:");

        impuestosJLabel.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        impuestosJLabel.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        impuestosJLabel.setText("Impuestos:");

        separarTotal.setForeground(new java.awt.Color(0, 0, 0));

        totalJlabel.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        totalJlabel.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        totalJlabel.setText("Total:");

        botonCanecelar.setBackground(new java.awt.Color(255, 186, 186));
        botonCanecelar.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        botonCanecelar.setText("Cancelar");
        botonCanecelar.setPreferredSize(new java.awt.Dimension(196, 39));
        botonCanecelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonCanecelarActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel1.setText("Resumen");

        btnPago.setBackground(new java.awt.Color(103, 80, 164));
        btnPago.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        btnPago.setForeground(new java.awt.Color(255, 255, 255));
        btnPago.setText("Proceder a Pago");
        btnPago.setPreferredSize(new java.awt.Dimension(196, 39));
        btnPago.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPagoActionPerformed(evt);
            }
        });

        lblSubProductos.setText("subtotal");

        lblImpuestos.setText("impuestos");

        lblCantProductos.setText("num");

        javax.swing.GroupLayout panelResumenLayout = new javax.swing.GroupLayout(panelResumen);
        panelResumen.setLayout(panelResumenLayout);
        panelResumenLayout.setHorizontalGroup(
            panelResumenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelResumenLayout.createSequentialGroup()
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 11, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(panelResumenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelResumenLayout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(panelResumenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(separarTotal, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(panelResumenLayout.createSequentialGroup()
                                .addGroup(panelResumenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(totalJlabel)
                                    .addComponent(botonCanecelar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(btnPago, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(panelResumenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, panelResumenLayout.createSequentialGroup()
                                            .addComponent(impuestosJLabel)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(lblImpuestos))
                                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, panelResumenLayout.createSequentialGroup()
                                            .addComponent(subtotalJlabel)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(lblSubProductos))
                                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, panelResumenLayout.createSequentialGroup()
                                            .addComponent(cantidadJLabel)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                            .addComponent(lblCantProductos))))
                                .addGap(0, 0, Short.MAX_VALUE)))
                        .addGap(90, 90, 90))
                    .addGroup(panelResumenLayout.createSequentialGroup()
                        .addGap(71, 71, 71)
                        .addComponent(jLabel1)
                        .addGap(0, 0, Short.MAX_VALUE))))
        );
        panelResumenLayout.setVerticalGroup(
            panelResumenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jSeparator1)
            .addGroup(panelResumenLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(35, 35, 35)
                .addGroup(panelResumenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cantidadJLabel)
                    .addComponent(lblCantProductos))
                .addGap(18, 18, 18)
                .addGroup(panelResumenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(subtotalJlabel)
                    .addComponent(lblSubProductos))
                .addGap(33, 33, 33)
                .addGroup(panelResumenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(impuestosJLabel)
                    .addComponent(lblImpuestos))
                .addGap(320, 320, 320)
                .addComponent(separarTotal, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(totalJlabel)
                .addGap(28, 28, 28)
                .addComponent(botonCanecelar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnPago, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(52, Short.MAX_VALUE))
        );

        PanelProductosScroll.setLayout(new java.awt.BorderLayout());

        panelCambiante.setBackground(new java.awt.Color(255, 255, 255));
        PanelProductosScroll.add(panelCambiante, java.awt.BorderLayout.CENTER);

        ScrollProductosCarrito.setViewportView(PanelProductosScroll);

        panelSuperior.setBackground(new java.awt.Color(103, 80, 164));

        lbl_ID.setFont(new java.awt.Font("Segoe UI", 0, 22)); // NOI18N
        lbl_ID.setForeground(new java.awt.Color(255, 255, 255));
        lbl_ID.setText("ID:123456");

        lblBuscarProducto.setBackground(new java.awt.Color(208, 188, 255));
        lblBuscarProducto.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblBuscarProducto.setForeground(new java.awt.Color(102, 102, 102));
        lblBuscarProducto.setText("Buscar Producto");
        lblBuscarProducto.setPreferredSize(new java.awt.Dimension(130, 27));
        lblBuscarProducto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                lblBuscarProductoActionPerformed(evt);
            }
        });

        btnBuscar.setBackground(new java.awt.Color(103, 80, 164));
        btnBuscar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/search (1).png"))); // NOI18N
        btnBuscar.setPreferredSize(new java.awt.Dimension(30, 30));
        btnBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panelSuperiorLayout = new javax.swing.GroupLayout(panelSuperior);
        panelSuperior.setLayout(panelSuperiorLayout);
        panelSuperiorLayout.setHorizontalGroup(
            panelSuperiorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelSuperiorLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lbl_ID)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblBuscarProducto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        panelSuperiorLayout.setVerticalGroup(
            panelSuperiorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelSuperiorLayout.createSequentialGroup()
                .addComponent(lbl_ID)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelSuperiorLayout.createSequentialGroup()
                .addGap(0, 9, Short.MAX_VALUE)
                .addGroup(panelSuperiorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblBuscarProducto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );

        javax.swing.GroupLayout backgroundPanelLayout = new javax.swing.GroupLayout(backgroundPanel);
        backgroundPanel.setLayout(backgroundPanelLayout);
        backgroundPanelLayout.setHorizontalGroup(
            backgroundPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelSuperior, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(backgroundPanelLayout.createSequentialGroup()
                .addComponent(ScrollProductosCarrito, javax.swing.GroupLayout.PREFERRED_SIZE, 540, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(panelResumen, javax.swing.GroupLayout.PREFERRED_SIZE, 231, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(7, Short.MAX_VALUE))
        );
        backgroundPanelLayout.setVerticalGroup(
            backgroundPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, backgroundPanelLayout.createSequentialGroup()
                .addComponent(panelSuperior, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(backgroundPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(ScrollProductosCarrito)
                    .addGroup(backgroundPanelLayout.createSequentialGroup()
                        .addComponent(panelResumen, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addContainerGap())))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(backgroundPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(backgroundPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void botonCanecelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonCanecelarActionPerformed
        // TODO add your handling code here:


        ControlNavegacion.getInstance().irAMenuPrincipal();
    }//GEN-LAST:event_botonCanecelarActionPerformed

    private void btnPagoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPagoActionPerformed
        ControlNavegacion.getInstance().irASeleccionMetodoPago();

    }//GEN-LAST:event_btnPagoActionPerformed

    private void btnBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarActionPerformed



//       ControlNavegacion.getInstance().irABusquedaProducto(lblBuscarProducto.getText());
    }//GEN-LAST:event_btnBuscarActionPerformed

    private void lblBuscarProductoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_lblBuscarProductoActionPerformed
        // TODO add your handling code here:
        lblBuscarProducto.getText();
        
    }//GEN-LAST:event_lblBuscarProductoActionPerformed

    /**
     * @param args the command line arguments
     */

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel PanelProductosScroll;
    private javax.swing.JScrollPane ScrollProductosCarrito;
    private javax.swing.JPanel backgroundPanel;
    private javax.swing.JButton botonCanecelar;
    private javax.swing.JButton btnBuscar;
    private javax.swing.JButton btnPago;
    private javax.swing.JLabel cantidadJLabel;
    private javax.swing.JLabel impuestosJLabel;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JTextField lblBuscarProducto;
    private javax.swing.JLabel lblCantProductos;
    private javax.swing.JLabel lblImpuestos;
    private javax.swing.JLabel lblSubProductos;
    private javax.swing.JLabel lbl_ID;
    private javax.swing.JPanel panelCambiante;
    private javax.swing.JPanel panelResumen;
    private javax.swing.JPanel panelSuperior;
    private javax.swing.JSeparator separarTotal;
    private javax.swing.JLabel subtotalJlabel;
    private javax.swing.JLabel totalJlabel;
    // End of variables declaration//GEN-END:variables
}
