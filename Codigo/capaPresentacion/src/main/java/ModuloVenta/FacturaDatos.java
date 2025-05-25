package ModuloVenta;

import Inicio.InicioSesion;
import Interface.IRegistroVenta;
import RegistroVentaException.RegistroException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.*;
import javax.swing.JOptionPane;
import org.bson.types.ObjectId;

/**
 *
 * @author Ángel Ruíz García - 00000248171
 */
public class FacturaDatos extends javax.swing.JFrame {

    IRegistroVenta controlVenta;
    private static FacturaDatos instancia;
    private Map<String, Map<String, Map<String, List<String>>>> datosUbicacion;
    private String id;

    /**
     * Creates new form FacturaDatos
     *
     * @param controlVenta
     */
    public FacturaDatos(IRegistroVenta controlVenta) {
        this.controlVenta = controlVenta;
        initComponents();
        lblID.setText("ID: " + InicioSesion.getInstance().getIdCuenta());

        datosUbicacion = new HashMap<>();

        // País: México
        Map<String, Map<String, List<String>>> estadosMexico = new HashMap<>();

        // Estado: Sonora
        Map<String, List<String>> ciudadesSonora = new HashMap<>();
        ciudadesSonora.put("Ciudad Obregón", Arrays.asList("Municipio Cajeme"));
        ciudadesSonora.put("Hermosillo", Arrays.asList("Municipio Hermosillo"));
        estadosMexico.put("Sonora", ciudadesSonora);

        // Estado: Jalisco
        Map<String, List<String>> ciudadesJalisco = new HashMap<>();
        ciudadesJalisco.put("Guadalajara", Arrays.asList("Municipio Guadalajara"));
        estadosMexico.put("Jalisco", ciudadesJalisco);

        // Añadir México al mapa principal
        datosUbicacion.put("México", estadosMexico);

        // Llenar combo de países
        for (String pais : datosUbicacion.keySet()) {
            cboPais.addItem(pais);
        }
        cboPais.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String paisSeleccionado = (String) cboPais.getSelectedItem();
                cboEstado.removeAllItems();
                cboCiudadLocalidad.removeAllItems();
                cboDelegacionMunicipio.removeAllItems();

                if (paisSeleccionado != null && datosUbicacion.containsKey(paisSeleccionado)) {
                    Map<String, Map<String, List<String>>> estados = datosUbicacion.get(paisSeleccionado);
                    for (String estado : estados.keySet()) {
                        cboEstado.addItem(estado);
                    }
                }
            }
        });

        cboEstado.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String paisSeleccionado = (String) cboPais.getSelectedItem();
                String estadoSeleccionado = (String) cboEstado.getSelectedItem();
                cboCiudadLocalidad.removeAllItems();
                cboDelegacionMunicipio.removeAllItems();

                if (paisSeleccionado != null && estadoSeleccionado != null) {
                    Map<String, Map<String, List<String>>> estados = datosUbicacion.get(paisSeleccionado);
                    if (estados.containsKey(estadoSeleccionado)) {
                        Map<String, List<String>> ciudades = estados.get(estadoSeleccionado);
                        for (String ciudad : ciudades.keySet()) {
                            cboCiudadLocalidad.addItem(ciudad);
                        }
                    }
                }
            }
        });

        cboCiudadLocalidad.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String paisSeleccionado = (String) cboPais.getSelectedItem();
                String estadoSeleccionado = (String) cboEstado.getSelectedItem();
                String ciudadSeleccionada = (String) cboCiudadLocalidad.getSelectedItem();
                cboDelegacionMunicipio.removeAllItems();

                if (paisSeleccionado != null && estadoSeleccionado != null && ciudadSeleccionada != null) {
                    Map<String, List<String>> ciudades = datosUbicacion.get(paisSeleccionado).get(estadoSeleccionado);
                    if (ciudades.containsKey(ciudadSeleccionada)) {
                        for (String municipio : ciudades.get(ciudadSeleccionada)) {
                            cboDelegacionMunicipio.addItem(municipio);
                        }
                    }
                }
            }
        });

        cboPais.setSelectedIndex(-1);
    }

    public static FacturaDatos getInstance(IRegistroVenta controlVenta) {
        if (instancia == null) {
            instancia = new FacturaDatos(controlVenta);
        }
        return instancia;
    }

    public void setId(String id) {
        this.id = id;
        lblID.setText("ID: " + InicioSesion.getInstance().getIdCuenta());
    }

    private void facturar() throws RegistroException, Exception {
        try {
            controlVenta.facturarVenta(this, id, txtRFC.getText(),
                    txtNombeRazonSocial.getText(), txtCalle.getText(),
                    txtNumExt.getText(), txtNumInt.getText(), txtColonia.getText(),
                    txtCodPostal.getText(), (String) cboPais.getSelectedItem(),
                    (String) cboEstado.getSelectedItem(),
                    (String) cboCiudadLocalidad.getSelectedItem(),
                    (String) cboDelegacionMunicipio.getSelectedItem(), txtCorreo.getText());
        } catch (RegistroException ex) {
            JOptionPane.showMessageDialog(this, "Error al realizar la facturación: " + ex.getMessage());
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

        panelFondo = new javax.swing.JPanel();
        panelSuperior = new javax.swing.JPanel();
        lblID = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        txtRFC = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        txtNombeRazonSocial = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        txtCalle = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        txtNumExt = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        txtNumInt = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        txtColonia = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        txtCodPostal = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        btnFacturar = new javax.swing.JButton();
        btnCanelar = new javax.swing.JButton();
        jLabel17 = new javax.swing.JLabel();
        txtCorreo = new javax.swing.JTextField();
        cboPais = new javax.swing.JComboBox<>();
        cboEstado = new javax.swing.JComboBox<>();
        cboCiudadLocalidad = new javax.swing.JComboBox<>();
        cboDelegacionMunicipio = new javax.swing.JComboBox<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        panelFondo.setBackground(new java.awt.Color(255, 255, 255));
        panelFondo.setMinimumSize(new java.awt.Dimension(800, 580));
        panelFondo.setPreferredSize(new java.awt.Dimension(800, 580));
        panelFondo.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        panelSuperior.setBackground(new java.awt.Color(103, 80, 164));

        lblID.setFont(new java.awt.Font("Segoe UI", 0, 22)); // NOI18N
        lblID.setForeground(new java.awt.Color(255, 255, 255));
        lblID.setText("ID: 00000000000000000");

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

        panelFondo.add(panelSuperior, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 800, -1));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(153, 153, 153));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Datos Obligatorios");
        panelFondo.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 250, 160, -1));

        txtRFC.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        panelFondo.add(txtRFC, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 90, 360, -1));

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel2.setText("RFC");
        panelFondo.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 90, 40, 30));

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel3.setText("Nombre o Razon Social");
        panelFondo.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 130, 210, 30));

        txtNombeRazonSocial.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        panelFondo.add(txtNombeRazonSocial, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 130, 360, -1));

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel4.setText("Calle");
        panelFondo.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 170, 50, 30));

        txtCalle.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        panelFondo.add(txtCalle, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 170, 360, -1));

        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel5.setText("Número Exterior");
        panelFondo.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 210, 210, 30));

        txtNumExt.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        panelFondo.add(txtNumExt, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 210, 360, -1));

        jLabel6.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel6.setText("Número Interior");
        panelFondo.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 250, 210, 30));

        txtNumInt.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        panelFondo.add(txtNumInt, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 250, 360, -1));

        jLabel7.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel7.setText("Colonia");
        panelFondo.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 290, 140, 30));

        txtColonia.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        panelFondo.add(txtColonia, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 290, 360, -1));

        jLabel8.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel8.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel8.setText("Código Postal");
        panelFondo.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 330, 130, 30));

        txtCodPostal.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        panelFondo.add(txtCodPostal, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 330, 360, -1));

        jLabel9.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel9.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel9.setText("País");
        panelFondo.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(186, 370, -1, 30));

        jLabel10.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel10.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel10.setText("Estado");
        panelFondo.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 410, 90, 30));

        jLabel11.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel11.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel11.setText("Ciudad o Localidad");
        panelFondo.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 450, 170, 30));

        jLabel12.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel12.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel12.setText("Delegación o Municipio");
        panelFondo.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(19, 490, -1, 30));

        jLabel13.setIcon(new javax.swing.ImageIcon(getClass().getResource("/asterisco_icono_10x10.png"))); // NOI18N
        panelFondo.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 380, -1, -1));

        jLabel14.setIcon(new javax.swing.ImageIcon(getClass().getResource("/asterisco_icono_10x10.png"))); // NOI18N
        panelFondo.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 260, -1, -1));

        jLabel15.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(153, 153, 153));
        jLabel15.setText("Introduzca Los Datos Fiscales");
        panelFondo.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 60, 250, -1));

        jLabel16.setIcon(new javax.swing.ImageIcon(getClass().getResource("/asterisco_icono_10x10.png"))); // NOI18N
        panelFondo.add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 100, -1, -1));

        btnFacturar.setBackground(new java.awt.Color(103, 80, 164));
        btnFacturar.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        btnFacturar.setForeground(new java.awt.Color(255, 255, 255));
        btnFacturar.setText("Facturar");
        btnFacturar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnFacturarActionPerformed(evt);
            }
        });
        panelFondo.add(btnFacturar, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 280, 140, -1));

        btnCanelar.setBackground(new java.awt.Color(255, 186, 186));
        btnCanelar.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        btnCanelar.setForeground(new java.awt.Color(51, 51, 51));
        btnCanelar.setText("Cancelar");
        btnCanelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCanelarActionPerformed(evt);
            }
        });
        panelFondo.add(btnCanelar, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 320, 140, -1));

        jLabel17.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel17.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel17.setText("Correo Electrónico");
        panelFondo.add(jLabel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 530, 160, 30));

        txtCorreo.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        panelFondo.add(txtCorreo, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 530, 360, -1));

        cboPais.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        panelFondo.add(cboPais, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 370, 360, -1));

        cboEstado.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        cboEstado.setSelectedIndex(-1);
        panelFondo.add(cboEstado, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 410, 360, -1));

        cboCiudadLocalidad.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        cboCiudadLocalidad.setSelectedIndex(-1);
        panelFondo.add(cboCiudadLocalidad, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 450, 360, -1));

        cboDelegacionMunicipio.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        cboDelegacionMunicipio.setSelectedIndex(-1);
        panelFondo.add(cboDelegacionMunicipio, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 490, 360, -1));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelFondo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(panelFondo, javax.swing.GroupLayout.PREFERRED_SIZE, 580, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnFacturarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFacturarActionPerformed
        try {
            facturar();
            txtRFC.setText("");
            txtNombeRazonSocial.setText("");
            txtCalle.setText("");
            txtNumExt.setText("");
            txtNumInt.setText("");
            txtColonia.setText("");
            txtCodPostal.setText("");
            cboPais.setSelectedIndex(-1);
            cboEstado.setSelectedIndex(-1);
            cboCiudadLocalidad.setSelectedIndex(-1);
            cboDelegacionMunicipio.setSelectedIndex(-1);
            txtCorreo.setText("");
        } catch (Exception ex) {
            System.err.println(ex.getMessage());
        }
    }//GEN-LAST:event_btnFacturarActionPerformed

    private void btnCanelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCanelarActionPerformed
        int confirm = JOptionPane.showConfirmDialog(this, "¿Está seguro de que desea cancelar?", "Confirmar", JOptionPane.YES_NO_OPTION);
        if (confirm == JOptionPane.YES_OPTION) {
            CarritoCompra.getInstance(controlVenta).limpiarCarrito();
            setVisible(false);
            control.ControlNavegacion.getInstance().irAMenuPrincipal();
        }
    }//GEN-LAST:event_btnCanelarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCanelar;
    private javax.swing.JButton btnFacturar;
    private javax.swing.JComboBox<String> cboCiudadLocalidad;
    private javax.swing.JComboBox<String> cboDelegacionMunicipio;
    private javax.swing.JComboBox<String> cboEstado;
    private javax.swing.JComboBox<String> cboPais;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JLabel lblID;
    private javax.swing.JPanel panelFondo;
    private javax.swing.JPanel panelSuperior;
    private javax.swing.JTextField txtCalle;
    private javax.swing.JTextField txtCodPostal;
    private javax.swing.JTextField txtColonia;
    private javax.swing.JTextField txtCorreo;
    private javax.swing.JTextField txtNombeRazonSocial;
    private javax.swing.JTextField txtNumExt;
    private javax.swing.JTextField txtNumInt;
    private javax.swing.JTextField txtRFC;
    // End of variables declaration//GEN-END:variables
}
