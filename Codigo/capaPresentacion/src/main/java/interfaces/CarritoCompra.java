/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package interfaces;

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

        setTitle("Carriro de compra"); // nombre venata
        setSize(800, 600); //tamaño ventana
//        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);//centar ventana

//        panel panelId = new panel();
//        PanelResumen resumen = new PanelResumen();
//         Agregar los paneles al JFrame
        this.setLayout(new BorderLayout()); // Usar BorderLayout para organizar los componentes
        // Panel superior (con JLabel y JButton)
        JPanel panelSuperior = new JPanel();
        panelSuperior.setLayout(new BorderLayout());
        panelSuperior.setPreferredSize(new Dimension(800, 50));
        panelSuperior.setBackground(SystemColor.activeCaption);

        JLabel idLabel = new JLabel("ID: 123456");
        idLabel.setHorizontalAlignment(SwingConstants.LEFT);

        JButton botonBuscar = new JButton("Buscar Producto");

        panelSuperior.add(idLabel, BorderLayout.WEST);
        panelSuperior.add(botonBuscar, BorderLayout.EAST);

        //Panel Resumen de compra en proceso
        JPanel panelResumen = new JPanel();
        panelResumen.setLayout(new GridLayout(6, 1, 5, 5));
        panelResumen.setPreferredSize(new Dimension(250, 580));
        JLabel cantidadProductosJLabel = new JLabel("Cantidad productos:");
        JLabel subtotalJLabel = new JLabel("Subtotal:");
        JLabel impuestosJLabel = new JLabel("Impuestos:");
        JLabel totalJlabel = new JLabel("Total:");

        JButton botonCnacelar = new JButton("Buscar Producto");
        JButton botonProcederPago = new JButton("Buscar Producto");

        
        setVisible(true);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 800, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 600, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(CarritoCompra.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(CarritoCompra.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(CarritoCompra.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(CarritoCompra.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new CarritoCompra().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
