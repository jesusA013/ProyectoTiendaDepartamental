/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package interfaces;

import control.ControlNavegacion;
import javax.swing.*;
import java.awt.*;

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
//        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);//centar ventana
       
//       setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//        setLocationRelativeTo(null);//centar ventana
// comentario d eprueba
////        panel panelId = new panel();
////        PanelResumen resumen = new PanelResumen();
////         Agregar los paneles al JFrame
//        this.setLayout(new BorderLayout()); // Usar BorderLayout para organizar los componentes
//        // Panel superior (con JLabel y JButton)
//        JPanel panelSuperior = new JPanel();
//        panelSuperior.setLayout(new BorderLayout());
//        panelSuperior.setPreferredSize(new Dimension(800, 50));
//        panelSuperior.setBackground(SystemColor.activeCaption);
//
//        JLabel idLabel = new JLabel("ID: 123456");
//        idLabel.setHorizontalAlignment(SwingConstants.LEFT);
//
//        JButton botonBuscar = new JButton("Buscar Producto");
//
//        panelSuperior.add(idLabel, BorderLayout.WEST);
//        panelSuperior.add(botonBuscar, BorderLayout.EAST);
//
//        //Panel Resumen de compra en proceso
//        JPanel panelResumen = new JPanel();
//        panelResumen.setLayout(new GridLayout(6, 1, 5, 5));
//        panelResumen.setPreferredSize(new Dimension(250, 580));
//        JLabel cantidadProductosJLabel = new JLabel("Cantidad productos:");
//        JLabel subtotalJLabel = new JLabel("Subtotal:");
//        JLabel impuestosJLabel = new JLabel("Impuestos:");
//        JLabel totalJlabel = new JLabel("Total:");
//
//        JButton botonCnacelar = new JButton("Buscar Producto");
//        JButton botonProcederPago = new JButton("Buscar Producto");
//
//        panelResumen.add(cantidadProductosJLabel);
//                panelResumen.add(subtotalJLabel);
//        panelResumen.add(totalJlabel);
//        panelResumen.add(impuestosJLabel);
//                panelResumen.add(botonCnacelar);
//        panelResumen.add(botonProcederPago);
//

//        

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
        procederPago = new javax.swing.JButton();
        panelCambiante = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        jLabel11 = new javax.swing.JLabel();
        botonBuscarProducto = new javax.swing.JButton();
        icono = new javax.swing.JLabel();

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
        botonCanecelar.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        botonCanecelar.setText("Cancelar");
        botonCanecelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonCanecelarActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel1.setText("Resumen");

        procederPago.setBackground(new java.awt.Color(103, 80, 164));
        procederPago.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        procederPago.setForeground(new java.awt.Color(255, 255, 255));
        procederPago.setText("Proceder Pago");
        procederPago.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                procederPagoActionPerformed(evt);
            }
        });

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
                                    .addComponent(cantidadJLabel)
                                    .addComponent(subtotalJlabel, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(impuestosJLabel, javax.swing.GroupLayout.Alignment.TRAILING))
                                .addGap(0, 334, Short.MAX_VALUE)))
                        .addGap(90, 90, 90))
                    .addGroup(panelResumenLayout.createSequentialGroup()
                        .addGroup(panelResumenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(panelResumenLayout.createSequentialGroup()
                                .addGap(107, 107, 107)
                                .addComponent(jLabel1))
                            .addGroup(panelResumenLayout.createSequentialGroup()
                                .addGap(82, 82, 82)
                                .addComponent(procederPago))
                            .addGroup(panelResumenLayout.createSequentialGroup()
                                .addGap(104, 104, 104)
                                .addComponent(botonCanecelar)))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        panelResumenLayout.setVerticalGroup(
            panelResumenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jSeparator1)
            .addGroup(panelResumenLayout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addComponent(jLabel1)
                .addGap(64, 64, 64)
                .addComponent(cantidadJLabel)
                .addGap(29, 29, 29)
                .addComponent(subtotalJlabel)
                .addGap(42, 42, 42)
                .addComponent(impuestosJLabel)
                .addGap(51, 51, 51)
                .addComponent(separarTotal, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(totalJlabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(botonCanecelar)
                .addGap(18, 18, 18)
                .addComponent(procederPago)
                .addGap(16, 16, 16))
        );

        procederPago.getAccessibleContext().setAccessibleName("");

        panelCambiante.setBackground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout panelCambianteLayout = new javax.swing.GroupLayout(panelCambiante);
        panelCambiante.setLayout(panelCambianteLayout);
        panelCambianteLayout.setHorizontalGroup(
            panelCambianteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 492, Short.MAX_VALUE)
        );
        panelCambianteLayout.setVerticalGroup(
            panelCambianteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 515, Short.MAX_VALUE)
        );

        jPanel1.setBackground(new java.awt.Color(103, 80, 164));

        jLabel11.setFont(new java.awt.Font("Segoe UI", 0, 22)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(255, 255, 255));
        jLabel11.setText("ID:123456");

        botonBuscarProducto.setBackground(new java.awt.Color(208, 188, 255));
        botonBuscarProducto.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        botonBuscarProducto.setForeground(new java.awt.Color(255, 255, 255));
        botonBuscarProducto.setText("Buscar Producto");
        botonBuscarProducto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonBuscarProductoActionPerformed(evt);
            }
        });

        icono.setIcon(new javax.swing.ImageIcon(getClass().getResource("/search (1).png"))); // NOI18N
        icono.setPreferredSize(new java.awt.Dimension(30, 30));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel11)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(icono, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(botonBuscarProducto)
                .addGap(397, 397, 397))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel11)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(botonBuscarProducto)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(icono, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        botonBuscarProducto.getAccessibleContext().setAccessibleName("botonBuscar");
        icono.getAccessibleContext().setAccessibleName("icono");

        javax.swing.GroupLayout backgroundPanelLayout = new javax.swing.GroupLayout(backgroundPanel);
        backgroundPanel.setLayout(backgroundPanelLayout);
        backgroundPanelLayout.setHorizontalGroup(
            backgroundPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(backgroundPanelLayout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addComponent(panelCambiante, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(panelResumen, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        backgroundPanelLayout.setVerticalGroup(
            backgroundPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, backgroundPanelLayout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(backgroundPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(panelResumen, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(backgroundPanelLayout.createSequentialGroup()
                        .addComponent(panelCambiante, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 6, Short.MAX_VALUE)))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(backgroundPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 800, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(backgroundPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(14, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void botonCanecelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonCanecelarActionPerformed
        /*si el boton es presionado debe re dirigir a menu principal
        */
        ControlNavegacion.getInstance().irAMenuPrincipal();
        
    }//GEN-LAST:event_botonCanecelarActionPerformed

    private void procederPagoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_procederPagoActionPerformed
        /*este boton debe mostrar al formulario metodo de pago
         */
     procederPago.addActionListener(new java.awt.AWTEventMulticaster.event.ActionListener(){
         
         public void actionPerformed(java.awt.event.ActionEvent evt){
             SeleccionMetodoPago fomularioPago = new SeleccionMetodoPago();
             fomularioPago.setVisible(true);// despliega la ventana
         }
     });
    }//GEN-LAST:event_procederPagoActionPerformed

    private void botonBuscarProductoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonBuscarProductoActionPerformed
        /*Se debe acceder al Buscador
        */ 
       
    }//GEN-LAST:event_botonBuscarProductoActionPerformed

    /**
     * @param args the command line arguments
     */


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel backgroundPanel;
    private javax.swing.JButton botonBuscarProducto;
    private javax.swing.JButton botonCanecelar;
    private javax.swing.JLabel cantidadJLabel;
    private javax.swing.JLabel icono;
    private javax.swing.JLabel impuestosJLabel;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JPanel panelCambiante;
    private javax.swing.JPanel panelResumen;
    private javax.swing.JButton procederPago;
    private javax.swing.JSeparator separarTotal;
    private javax.swing.JLabel subtotalJlabel;
    private javax.swing.JLabel totalJlabel;
    // End of variables declaration//GEN-END:variables
}
