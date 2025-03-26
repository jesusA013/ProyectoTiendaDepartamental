/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package interfaces;

import javax.swing.*;
import java.awt.*;
import DTOs.*;

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
        panelSuperior.setBackground(new Color(128, 0, 128));
        
        JLabel idLabel = new JLabel("  ID: 123456  ");
        idLabel.setHorizontalAlignment(SwingConstants.LEFT);
        idLabel.setForeground(Color.WHITE);
        idLabel.setFont(new Font("Times New Roman", Font.PLAIN, 18));
        JButton botonBuscar = new JButton("Buscar Producto");
        botonBuscar.setFont(new Font("Times New Roman ", Font.PLAIN, 14));
        panelSuperior.add(idLabel, BorderLayout.WEST);
        panelSuperior.add(botonBuscar, BorderLayout.EAST);

        //Panel Resumen de compra en proceso
        JPanel panelResumen = new JPanel();
        panelResumen.setLayout(new GridLayout(2, 1, 0, 10));
        panelResumen.setPreferredSize(new Dimension(250, 580));
        JLabel resumen = new JLabel("Resumen");
        JLabel cantidadProductosJLabel = new JLabel("Cantidad productos:");
        JLabel subtotalJLabel = new JLabel("Subtotal:");
        JLabel impuestosJLabel = new JLabel("Impuestos:");
        JLabel totalJlabel = new JLabel("Total:");
        panelResumen.setBackground(Color.WHITE);
        JButton botonCnacelar = new JButton("Cancelar");
        JButton botonProcederPago = new JButton("Proceder Pago");
        
        //panel para agregar botones cancelat y proceder pago
        JPanel panelBotones = new JPanel();
        panelBotones.setLayout(new GridLayout(2,1,0,10));
        botonCnacelar.setPreferredSize(new Dimension(20, 20));
        botonProcederPago.setPreferredSize(new Dimension(20, 20));
        panelBotones.setPreferredSize(new Dimension(200, 100));
        panelBotones.add(botonCnacelar);
        panelBotones.add(botonProcederPago);
        
        panelResumen.add(panelBotones, BorderLayout.SOUTH);
        
        resumen.setHorizontalAlignment(SwingConstants.CENTER);
        panelResumen.add(resumen, BorderLayout.NORTH);
        
        panelResumen.add(cantidadProductosJLabel);
        panelResumen.add(subtotalJLabel);
        panelResumen.add(totalJlabel);
        panelResumen.add(impuestosJLabel);
        panelResumen.add(botonCnacelar);
        panelResumen.add(botonProcederPago);
        
        add(panelSuperior, BorderLayout.NORTH);
        add(panelResumen, BorderLayout.EAST);
        
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

    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
