package ModuloVenta;

import DTOs.ProductoVentaDTO;
import Inicio.InicioSesion;
import Interface.IRegistroVenta;
import RegistroVentaException.RegistroException;
import control.ControlNavegacion;
import java.awt.BorderLayout;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author Ángel Ruíz
 */
public class SeleccionMetodoPago extends javax.swing.JFrame {

    IRegistroVenta controlVenta;
    List<ProductoVentaDTO> carritoGlobal;
    private int cantidadProductos = 0;
    private double subtotalProductos = 0;
    private double impuestosProductos = 0;
    private double totalProductos = 0;

    /**
     * Creates new form SeleccionMetodoPago
     *
     * @param controlVenta
     */
    public SeleccionMetodoPago(IRegistroVenta controlVenta) {
        this.controlVenta = controlVenta;
        initComponents();
        lblID.setText("ID: " + InicioSesion.getInstance().getIdCuenta());
    }

    private String pagarTarjeta() throws Exception {
        try {
            return controlVenta.registrarVentaTarjeta(this, carritoGlobal, 
                    InicioSesion.getInstance().getIdUsuario(), 
                    PanelMetodoTarjeta.getInstance().getTxtDigitosTarjeta(),
                    PanelMetodoTarjeta.getInstance().getTxtFechaExpiracion(),
                    PanelMetodoTarjeta.getInstance().getTxtCVC());
        } catch (RegistroException ex) {
            JOptionPane.showMessageDialog(this, "Error al realizar el pago: " + ex.getMessage());
            throw new Exception("Error: " + ex.getMessage());
        }
    }

    private String pagarEfectivo() throws Exception {
        try {
            return controlVenta.registrarVentaEfectivo(this, carritoGlobal, 
                    InicioSesion.getInstance().getIdUsuario(),
                    PanelMetodoEfectivo.getInstance().getTxtEfectivo(),
                    PanelMetodoEfectivo.getInstance().getTxtCambio());
        } catch (RegistroException ex) {
            JOptionPane.showMessageDialog(this, "Error al realizar el pago: " + ex.getMessage());
            throw new Exception("Error: " + ex.getMessage());
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        Metodo = new javax.swing.ButtonGroup();
        panelFondo = new javax.swing.JPanel();
        lblSeleccioneMP = new javax.swing.JLabel();
        panelResumen = new javax.swing.JPanel();
        separadorResumen = new javax.swing.JSeparator();
        labelResumen = new javax.swing.JLabel();
        labelCantidadProductos = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jSeparator2 = new javax.swing.JSeparator();
        labelTotal = new javax.swing.JLabel();
        btnCancelar = new javax.swing.JButton();
        btnRegresar = new javax.swing.JButton();
        btnConfirmar = new javax.swing.JButton();
        lblCantidadProducto = new javax.swing.JLabel();
        lblSubtotal = new javax.swing.JLabel();
        lblImpuestos = new javax.swing.JLabel();
        lblTotal = new javax.swing.JLabel();
        panelCambiante = new javax.swing.JPanel();
        panelSuperior = new javax.swing.JPanel();
        lblID = new javax.swing.JLabel();
        metodoTarjeta = new javax.swing.JRadioButton();
        metodoEfectivo = new javax.swing.JRadioButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        panelFondo.setBackground(new java.awt.Color(255, 255, 255));

        lblSeleccioneMP.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        lblSeleccioneMP.setText("Seleccione Metodo de Pago");

        panelResumen.setBackground(new java.awt.Color(255, 255, 255));

        separadorResumen.setForeground(new java.awt.Color(0, 0, 0));
        separadorResumen.setOrientation(javax.swing.SwingConstants.VERTICAL);

        labelResumen.setFont(new java.awt.Font("Segoe UI", 1, 20)); // NOI18N
        labelResumen.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labelResumen.setText("Resumen");

        labelCantidadProductos.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        labelCantidadProductos.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        labelCantidadProductos.setText("Cantidad productos:");

        jLabel3.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel3.setText("Subtotal:");

        jLabel4.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel4.setText("Impuestos:");

        jSeparator2.setForeground(new java.awt.Color(0, 0, 0));

        labelTotal.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        labelTotal.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        labelTotal.setText("Total:");

        btnCancelar.setBackground(new java.awt.Color(255, 186, 186));
        btnCancelar.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        btnCancelar.setForeground(new java.awt.Color(51, 51, 51));
        btnCancelar.setText("Cancelar");
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });

        btnRegresar.setBackground(new java.awt.Color(208, 188, 255));
        btnRegresar.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        btnRegresar.setForeground(new java.awt.Color(102, 102, 102));
        btnRegresar.setText("Regresar al Carrito");
        btnRegresar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegresarActionPerformed(evt);
            }
        });

        btnConfirmar.setBackground(new java.awt.Color(103, 80, 164));
        btnConfirmar.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        btnConfirmar.setText("Confirmar Pago");
        btnConfirmar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnConfirmarActionPerformed(evt);
            }
        });

        lblCantidadProducto.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        lblCantidadProducto.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblCantidadProducto.setText("0");

        lblSubtotal.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        lblSubtotal.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblSubtotal.setText("0");

        lblImpuestos.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        lblImpuestos.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblImpuestos.setText("0");

        lblTotal.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        lblTotal.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblTotal.setText("0");

        javax.swing.GroupLayout panelResumenLayout = new javax.swing.GroupLayout(panelResumen);
        panelResumen.setLayout(panelResumenLayout);
        panelResumenLayout.setHorizontalGroup(
            panelResumenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelResumenLayout.createSequentialGroup()
                .addComponent(separadorResumen, javax.swing.GroupLayout.PREFERRED_SIZE, 11, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelResumenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jSeparator2)
                    .addComponent(labelResumen, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnCancelar, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnRegresar, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnConfirmar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, panelResumenLayout.createSequentialGroup()
                        .addComponent(labelTotal)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(lblTotal, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(panelResumenLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(panelResumenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(panelResumenLayout.createSequentialGroup()
                                .addComponent(labelCantidadProductos)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(lblCantidadProducto, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(panelResumenLayout.createSequentialGroup()
                                .addComponent(jLabel3)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(lblSubtotal, javax.swing.GroupLayout.PREFERRED_SIZE, 163, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(panelResumenLayout.createSequentialGroup()
                                .addComponent(jLabel4)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(lblImpuestos, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap())
        );
        panelResumenLayout.setVerticalGroup(
            panelResumenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(separadorResumen)
            .addGroup(panelResumenLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(labelResumen)
                .addGap(26, 26, 26)
                .addGroup(panelResumenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelCantidadProductos)
                    .addComponent(lblCantidadProducto))
                .addGap(36, 36, 36)
                .addGroup(panelResumenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(lblSubtotal))
                .addGap(31, 31, 31)
                .addGroup(panelResumenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(lblImpuestos))
                .addGap(50, 50, 50)
                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(panelResumenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelTotal)
                    .addComponent(lblTotal))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnCancelar)
                .addGap(18, 18, 18)
                .addComponent(btnRegresar)
                .addGap(18, 18, 18)
                .addComponent(btnConfirmar)
                .addGap(57, 57, 57))
        );

        panelCambiante.setBackground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout panelCambianteLayout = new javax.swing.GroupLayout(panelCambiante);
        panelCambiante.setLayout(panelCambianteLayout);
        panelCambianteLayout.setHorizontalGroup(
            panelCambianteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 507, Short.MAX_VALUE)
        );
        panelCambianteLayout.setVerticalGroup(
            panelCambianteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 355, Short.MAX_VALUE)
        );

        panelSuperior.setBackground(new java.awt.Color(103, 80, 164));

        lblID.setFont(new java.awt.Font("Segoe UI", 0, 22)); // NOI18N
        lblID.setForeground(new java.awt.Color(255, 255, 255));
        lblID.setText("ID: 0");

        javax.swing.GroupLayout panelSuperiorLayout = new javax.swing.GroupLayout(panelSuperior);
        panelSuperior.setLayout(panelSuperiorLayout);
        panelSuperiorLayout.setHorizontalGroup(
            panelSuperiorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelSuperiorLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblID, javax.swing.GroupLayout.PREFERRED_SIZE, 265, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        panelSuperiorLayout.setVerticalGroup(
            panelSuperiorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lblID, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 50, Short.MAX_VALUE)
        );

        Metodo.add(metodoTarjeta);
        metodoTarjeta.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        metodoTarjeta.setText("Tarjeta Debito/Credito");
        metodoTarjeta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                metodoTarjetaActionPerformed(evt);
            }
        });

        Metodo.add(metodoEfectivo);
        metodoEfectivo.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        metodoEfectivo.setText("Pago en Efectivo");
        metodoEfectivo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                metodoEfectivoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panelFondoLayout = new javax.swing.GroupLayout(panelFondo);
        panelFondo.setLayout(panelFondoLayout);
        panelFondoLayout.setHorizontalGroup(
            panelFondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelSuperior, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(panelFondoLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelFondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(panelCambiante, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(panelFondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addGroup(panelFondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(metodoEfectivo)
                            .addComponent(metodoTarjeta))
                        .addComponent(lblSeleccioneMP)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(panelResumen, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(90, 90, 90))
        );
        panelFondoLayout.setVerticalGroup(
            panelFondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelFondoLayout.createSequentialGroup()
                .addComponent(panelSuperior, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelFondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelFondoLayout.createSequentialGroup()
                        .addComponent(lblSeleccioneMP)
                        .addGap(33, 33, 33)
                        .addComponent(metodoTarjeta)
                        .addGap(28, 28, 28)
                        .addComponent(metodoEfectivo)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(panelCambiante, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(panelResumen, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        getContentPane().add(panelFondo, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 800, 600));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    /**
     *
     * @param evt
     */
    private void metodoTarjetaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_metodoTarjetaActionPerformed
        carritoGlobal = CarritoCompra.getInstance(controlVenta).getCarritoGlobal();
        lblID.setText("ID: " + InicioSesion.getInstance().getIdCuenta());
        
        cantidadProductos = 0;
        subtotalProductos = 0;
        impuestosProductos = 0;
        totalProductos = 0;

        for (ProductoVentaDTO producto : carritoGlobal) {
            cantidadProductos += producto.getCantidad();
            subtotalProductos += producto.getCantidad() * producto.getPrecioUnitario();
        }
        impuestosProductos = subtotalProductos * 0.06;
        totalProductos = subtotalProductos + impuestosProductos;

        this.lblID.setText("ID: " + "123456");
        this.lblCantidadProducto.setText(Integer.toString(cantidadProductos));
        this.lblSubtotal.setText(Double.toString(subtotalProductos));
        this.lblImpuestos.setText(Double.toString(impuestosProductos));
        this.lblTotal.setText(Double.toString(totalProductos));

        PanelMetodoTarjeta paneltarjeta = new PanelMetodoTarjeta();
        panelCambiante.setLayout(new BorderLayout());
        panelCambiante.removeAll();
        panelCambiante.add(paneltarjeta, BorderLayout.CENTER);
        panelCambiante.revalidate();
        panelCambiante.repaint();
    }//GEN-LAST:event_metodoTarjetaActionPerformed

    /**
     *
     * @param evt
     */
    private void metodoEfectivoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_metodoEfectivoActionPerformed
        carritoGlobal = CarritoCompra.getInstance(controlVenta).getCarritoGlobal();
        lblID.setText("ID: " + InicioSesion.getInstance().getIdCuenta());
        
        cantidadProductos = 0;
        subtotalProductos = 0;
        impuestosProductos = 0;
        totalProductos = 0;
        
        for (ProductoVentaDTO producto : carritoGlobal) {
            cantidadProductos += producto.getCantidad();
            subtotalProductos += producto.getCantidad() * producto.getPrecioUnitario();
        }
        impuestosProductos = subtotalProductos * 0.06;
        totalProductos = subtotalProductos + impuestosProductos;

        this.lblID.setText("ID: " + "123456");
        this.lblCantidadProducto.setText(Integer.toString(cantidadProductos));
        this.lblSubtotal.setText(Double.toString(subtotalProductos));
        this.lblImpuestos.setText(Double.toString(impuestosProductos));
        this.lblTotal.setText(Double.toString(totalProductos));
        
        PanelMetodoEfectivo.getInstance().setTotalProductos(totalProductos);
        
        PanelMetodoEfectivo panelEfectivo = new PanelMetodoEfectivo();
        panelCambiante.setLayout(new BorderLayout());
        panelCambiante.removeAll();
        panelCambiante.add(panelEfectivo, BorderLayout.CENTER);
        panelCambiante.revalidate();
        panelCambiante.repaint();
    }//GEN-LAST:event_metodoEfectivoActionPerformed

    /**
     *
     * @param evt
     */
    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        CarritoCompra.getInstance(controlVenta).limpiarCarrito();
        ControlNavegacion.getInstance().irAMenuPrincipal();
    }//GEN-LAST:event_btnCancelarActionPerformed

    /**
     *
     * @param evt
     */
    private void btnRegresarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegresarActionPerformed
        ControlNavegacion.getInstance().irACarritoCompra();
    }//GEN-LAST:event_btnRegresarActionPerformed

    /**
     *
     * @param evt
     */
    private void btnConfirmarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnConfirmarActionPerformed
        String id;
        if (metodoEfectivo.isSelected()) {
            try {
                id = pagarEfectivo();
                ControlNavegacion.getInstance().irVentaFinalizada(id);
            } catch (Exception ex) {
                System.err.println(ex.getMessage());
            }
        } else if (metodoTarjeta.isSelected()) {
            try {
                id = pagarTarjeta();
                ControlNavegacion.getInstance().irVentaFinalizada(id);
            } catch (Exception ex) {
                System.err.println(ex.getMessage());
            }
        } else {
            JOptionPane.showMessageDialog(this, "Seleccione un metodo de pago");
        }
    }//GEN-LAST:event_btnConfirmarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup Metodo;
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnConfirmar;
    private javax.swing.JButton btnRegresar;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JLabel labelCantidadProductos;
    private javax.swing.JLabel labelResumen;
    private javax.swing.JLabel labelTotal;
    private javax.swing.JLabel lblCantidadProducto;
    private javax.swing.JLabel lblID;
    private javax.swing.JLabel lblImpuestos;
    private javax.swing.JLabel lblSeleccioneMP;
    private javax.swing.JLabel lblSubtotal;
    private javax.swing.JLabel lblTotal;
    private javax.swing.JRadioButton metodoEfectivo;
    private javax.swing.JRadioButton metodoTarjeta;
    private javax.swing.JPanel panelCambiante;
    private javax.swing.JPanel panelFondo;
    private javax.swing.JPanel panelResumen;
    private javax.swing.JPanel panelSuperior;
    private javax.swing.JSeparator separadorResumen;
    // End of variables declaration//GEN-END:variables
}
