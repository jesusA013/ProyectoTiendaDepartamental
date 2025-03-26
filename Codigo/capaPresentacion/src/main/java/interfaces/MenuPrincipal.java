/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package interfaces;

import control.ControlNavegacion;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Image;
import java.awt.Toolkit;
import javax.swing.ImageIcon;

/**
 *
 * @author Jesus
 */
public class MenuPrincipal extends javax.swing.JFrame {
    
    /**
     * Metodo para Crear un nuevo Form MenuPrincipal
     */
    public MenuPrincipal() {
        initComponents();
        setDefaultCloseOperation(javax.swing.WindowConstants.HIDE_ON_CLOSE);
        this.setSize(800, 600);
        
        
        this.getContentPane().setBackground(Color.WHITE);
        
        this.add(panelBotones,BorderLayout.CENTER);
      
       
        
        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelBotones = new javax.swing.JPanel();
        btnOpcionVendedor = new javax.swing.JButton();
        btnOpcionAlmacen = new javax.swing.JButton();
        btnOpcionAdministrador = new javax.swing.JButton();
        lblVendedor = new javax.swing.JLabel();
        lblAdministrador = new javax.swing.JLabel();
        lblAlmacen = new javax.swing.JLabel();
        panelSuperior = new javax.swing.JPanel();
        lblBienvenido = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();

        setBackground(new java.awt.Color(204, 51, 255));
        setResizable(false);

        panelBotones.setBackground(new java.awt.Color(255, 255, 255));

        btnOpcionVendedor.setBackground(new java.awt.Color(128, 0, 128));
        btnOpcionVendedor.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        btnOpcionVendedor.setForeground(new java.awt.Color(255, 255, 255));
        btnOpcionVendedor.setText("Vendedor");
        btnOpcionVendedor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnOpcionVendedorActionPerformed(evt);
            }
        });

        btnOpcionAlmacen.setBackground(new java.awt.Color(128, 0, 128));
        btnOpcionAlmacen.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        btnOpcionAlmacen.setForeground(new java.awt.Color(255, 255, 255));
        btnOpcionAlmacen.setText("Almacen");
        btnOpcionAlmacen.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnOpcionAlmacenActionPerformed(evt);
            }
        });

        btnOpcionAdministrador.setBackground(new java.awt.Color(128, 0, 128));
        btnOpcionAdministrador.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        btnOpcionAdministrador.setForeground(new java.awt.Color(255, 255, 255));
        btnOpcionAdministrador.setText("Administrador");
        btnOpcionAdministrador.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnOpcionAdministradorActionPerformed(evt);
            }
        });

        lblVendedor.setIcon(new javax.swing.ImageIcon(getClass().getResource("/businessman.png"))); // NOI18N

        lblAdministrador.setIcon(new javax.swing.ImageIcon(getClass().getResource("/man-in-suit-and-tie.png"))); // NOI18N

        lblAlmacen.setIcon(new javax.swing.ImageIcon(getClass().getResource("/warehouse.png"))); // NOI18N

        javax.swing.GroupLayout panelBotonesLayout = new javax.swing.GroupLayout(panelBotones);
        panelBotones.setLayout(panelBotonesLayout);
        panelBotonesLayout.setHorizontalGroup(
            panelBotonesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelBotonesLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(panelBotonesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btnOpcionVendedor, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnOpcionAdministrador, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnOpcionAlmacen, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(28, 28, 28)
                .addGroup(panelBotonesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelBotonesLayout.createSequentialGroup()
                        .addComponent(lblAdministrador, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(58, 58, 58))
                    .addGroup(panelBotonesLayout.createSequentialGroup()
                        .addGroup(panelBotonesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblAlmacen)
                            .addComponent(lblVendedor))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        panelBotonesLayout.setVerticalGroup(
            panelBotonesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelBotonesLayout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addGroup(panelBotonesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblVendedor)
                    .addComponent(btnOpcionVendedor, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(42, 42, 42)
                .addGroup(panelBotonesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblAdministrador)
                    .addComponent(btnOpcionAdministrador, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 64, Short.MAX_VALUE)
                .addGroup(panelBotonesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnOpcionAlmacen, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblAlmacen))
                .addGap(33, 33, 33))
        );

        panelSuperior.setBackground(new java.awt.Color(128, 0, 128));

        lblBienvenido.setBackground(new java.awt.Color(255, 255, 255));
        lblBienvenido.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        lblBienvenido.setForeground(new java.awt.Color(255, 255, 255));
        lblBienvenido.setText("Aurea");

        javax.swing.GroupLayout panelSuperiorLayout = new javax.swing.GroupLayout(panelSuperior);
        panelSuperior.setLayout(panelSuperiorLayout);
        panelSuperiorLayout.setHorizontalGroup(
            panelSuperiorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelSuperiorLayout.createSequentialGroup()
                .addGap(33, 33, 33)
                .addComponent(lblBienvenido)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        panelSuperiorLayout.setVerticalGroup(
            panelSuperiorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelSuperiorLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblBienvenido, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(15, 15, 15))
        );

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icono Tienda (1).png"))); // NOI18N

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel2.setText("Bienvenido");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelSuperior, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addComponent(jLabel1)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(170, 170, 170)
                        .addComponent(jLabel2))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(75, 75, 75)
                        .addComponent(panelBotones, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(276, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(panelSuperior, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addGap(28, 28, 28)
                        .addComponent(panelBotones, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(76, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnOpcionVendedorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnOpcionVendedorActionPerformed
        ControlNavegacion.getInstance().irAInicioSesion();
        
    }//GEN-LAST:event_btnOpcionVendedorActionPerformed

    private void btnOpcionAlmacenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnOpcionAlmacenActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnOpcionAlmacenActionPerformed

    private void btnOpcionAdministradorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnOpcionAdministradorActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnOpcionAdministradorActionPerformed

 

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnOpcionAdministrador;
    private javax.swing.JButton btnOpcionAlmacen;
    private javax.swing.JButton btnOpcionVendedor;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel lblAdministrador;
    private javax.swing.JLabel lblAlmacen;
    private javax.swing.JLabel lblBienvenido;
    private javax.swing.JLabel lblVendedor;
    private javax.swing.JPanel panelBotones;
    private javax.swing.JPanel panelSuperior;
    // End of variables declaration//GEN-END:variables
}
