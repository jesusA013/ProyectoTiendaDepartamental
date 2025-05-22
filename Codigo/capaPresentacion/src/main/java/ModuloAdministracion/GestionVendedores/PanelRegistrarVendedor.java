/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package ModuloAdministracion.GestionVendedores;

import DTOs.DatosFiscalesDTO;
import DTOs.DomicilioDTO;
import DTOs.NombreCompletoDTO;
import DTOs.SeguroDTO;
import DTOs.VendedorDTO;
import Interfaces.IVendedorBO;
import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.util.Date;
import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;

/**
 *
 * @author gaspa
 */
public class PanelRegistrarVendedor extends javax.swing.JPanel {
    private final JPanel panelCambiante;
    private final IVendedorBO vendedorBO;
    private JPanel panelVendedores;
    
    private JTextField txtCURP = new JTextField(20);
    private JTextField txtFechaNacimiento = new JTextField(10);
    private JComboBox<String> comboEstadoCivil = new JComboBox<>(new String[]{"Soltero", "Casado", "Divorciado", "Viudo"});

    // Nombre completo
    private JTextField txtNombres = new JTextField(15);
    private JTextField txtApellidoPaterno = new JTextField(15);
    private JTextField txtApellidoMaterno = new JTextField(15);

    // Domicilio personal
    private JTextField txtCalleDom = new JTextField(20);
    private JTextField txtMunicipioDom = new JTextField(20);
    private JTextField txtCiudadDom = new JTextField(20);
    private JTextField txtCPDom = new JTextField(10);

    // Domicilio fiscal
    private JTextField txtRFC = new JTextField(15);
    private JTextField txtCalleFiscal = new JTextField(20);
    private JTextField txtMunicipioFiscal = new JTextField(20);
    private JTextField txtCiudadFiscal = new JTextField(20);
    private JTextField txtCPFiscal = new JTextField(10);
    private JTextField txtCorreoFiscal = new JTextField(20);

    // Seguro
    private JTextField txtNumSeguro = new JTextField(15);
    private JComboBox<String> comboTipoSeguro = new JComboBox<>(new String[]{"IMSS", "ISSSTE", "Privado"});
    /**
     * Creates new form PanelRegistrarVendedor
     */
    public PanelRegistrarVendedor(JPanel panelCambiante,IVendedorBO vendedorBO) {
        initComponents();
        this.panelCambiante=panelCambiante;
        this.vendedorBO=vendedorBO;
        
        panelVendedores = new JPanel();
        
        panelVendedores.setLayout(new BoxLayout(panelVendedores, BoxLayout.Y_AXIS));
        panelVendedores.setAlignmentX(Component.LEFT_ALIGNMENT);
        
        JScrollPane scrollPane = new JScrollPane(panelVendedores);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        scrollPane.setAlignmentX(Component.LEFT_ALIGNMENT);
        
        panelVendedores.add(seccion("Datos Personales", new JComponent[][]{
            {new JLabel("CURP:"), txtCURP},
            {new JLabel("Fecha Nacimiento (yyyy-MM-dd):"), txtFechaNacimiento},
            {new JLabel("Estado Civil:"), comboEstadoCivil}
        }));

        panelVendedores.add(seccion("Nombre Completo", new JComponent[][]{
            {new JLabel("Nombres:"), txtNombres},
            {new JLabel("Apellido Paterno:"), txtApellidoPaterno},
            {new JLabel("Apellido Materno:"), txtApellidoMaterno}
        }));

        panelVendedores.add(seccion("Domicilio Personal", new JComponent[][]{
            {new JLabel("Calle:"), txtCalleDom},
            {new JLabel("Municipio:"), txtMunicipioDom},
            {new JLabel("Ciudad:"), txtCiudadDom},
            {new JLabel("Código Postal:"), txtCPDom}
        }));

        panelVendedores.add(seccion("Datos Fiscales", new JComponent[][]{
            {new JLabel("RFC:"), txtRFC},
            {new JLabel("Calle Fiscal:"), txtCalleFiscal},
            {new JLabel("Municipio Fiscal:"), txtMunicipioFiscal},
            {new JLabel("Ciudad Fiscal:"), txtCiudadFiscal},
            {new JLabel("Código Postal Fiscal:"), txtCPFiscal},
            {new JLabel("Correo:"), txtCorreoFiscal}
        }));

        panelVendedores.add(seccion("Seguro", new JComponent[][]{
            {new JLabel("Número de Seguro:"), txtNumSeguro},
            {new JLabel("Tipo de Seguro:"), comboTipoSeguro}
        }));
        panelContenedor.setLayout(new BorderLayout());
        panelContenedor.add(scrollPane);
    }
    private JPanel seccion(String titulo, JComponent[][] componentes) {
        JPanel panel = new JPanel();
        panel.setLayout(new GridBagLayout());
        panel.setBorder(BorderFactory.createTitledBorder(titulo));

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5);
        gbc.anchor = GridBagConstraints.WEST;

        // Calcular ancho máximo de las etiquetas
        int maxLabelWidth = 0;
        for (JComponent[] linea : componentes) {
            if (linea.length == 2 && linea[0] instanceof JLabel) {
                JLabel label = (JLabel) linea[0];
                maxLabelWidth = Math.max(maxLabelWidth, label.getPreferredSize().width);
            }
        }

        Dimension labelSize = new Dimension(maxLabelWidth, 20);

        int row = 0;
        for (JComponent[] linea : componentes) {
            gbc.gridy = row++;
            gbc.gridx = 0;

            if (linea.length == 1) {
                gbc.gridwidth = 2;
                panel.add(linea[0], gbc);
                gbc.gridwidth = 1;
            } else {
                if (linea[0] instanceof JLabel) {
                    ((JLabel) linea[0]).setPreferredSize(labelSize);
                }
                panel.add(linea[0], gbc);

                gbc.gridx = 1;
                panel.add(linea[1], gbc);
            }
        }

        panel.setAlignmentX(Component.LEFT_ALIGNMENT);
        return panel;
    }
    
    private void registrarVendedor() {
        try {
            // Armar nombre completo
            NombreCompletoDTO nombre = new NombreCompletoDTO();
            nombre.setNombres(txtNombres.getText().trim());
            nombre.setApellidoPaterno(txtApellidoPaterno.getText().trim());
            nombre.setApellidoMaterno(txtApellidoMaterno.getText().trim());

            // Domicilio personal
            DomicilioDTO domicilio = new DomicilioDTO();
            domicilio.setCalle(txtCalleDom.getText().trim());
            domicilio.setDelegacionMunicipio(txtMunicipioDom.getText().trim());
            domicilio.setCiudadLocalidad(txtCiudadDom.getText().trim());
            domicilio.setCodigoPostal(txtCPDom.getText().trim());

            // Domicilio fiscal
            DomicilioDTO domicilioFiscal = new DomicilioDTO();
            domicilioFiscal.setCalle(txtCalleFiscal.getText().trim());
            domicilioFiscal.setDelegacionMunicipio(txtMunicipioFiscal.getText().trim());
            domicilioFiscal.setCiudadLocalidad(txtCiudadFiscal.getText().trim());
            domicilioFiscal.setCodigoPostal(txtCPFiscal.getText().trim());

            // Datos fiscales
            DatosFiscalesDTO datosFiscales = new DatosFiscalesDTO();
            datosFiscales.setRfc(txtRFC.getText().trim());
            datosFiscales.setDomicilioFiscal(domicilioFiscal);
            datosFiscales.setCorreo(txtCorreoFiscal.getText().trim());

            // Seguro
            SeguroDTO seguro = new SeguroDTO();
            seguro.setNumeroSeguro(txtNumSeguro.getText().trim());
            seguro.setTipo(comboTipoSeguro.getSelectedItem().toString());

            // Parsear fecha de nacimiento
            Date fechaNacimiento = null;
            if (!txtFechaNacimiento.getText().isEmpty()) {
                fechaNacimiento = java.sql.Date.valueOf(txtFechaNacimiento.getText().trim());
            }

            // Armar el vendedor
            VendedorDTO vendedor = new VendedorDTO();
            vendedor.setCurp(txtCURP.getText().trim());
            vendedor.setNombreCompleto(nombre);
            vendedor.setDomicilio(domicilio);
            vendedor.setDatosFiscales(datosFiscales);
            vendedor.setSeguro(seguro);
            vendedor.setFechaNacimiento(fechaNacimiento);
            vendedor.setEstadoCivil(comboEstadoCivil.getSelectedItem().toString());
            vendedor.setActivo(true);
            
            VendedorDTO vendedorInsertado = vendedorBO.registrarVendedor(vendedor);

            JOptionPane.showMessageDialog(this, "Vendedor registrado con éxito.\nID: " + vendedorInsertado.getId());
            this.volver();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Error al registrar vendedor:\n" + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            e.printStackTrace();
        }
    }
    public void volver(){
        PanelListadoVendedores panelListado = new PanelListadoVendedores(panelCambiante, vendedorBO);
        panelCambiante.setLayout(new BorderLayout());
        panelCambiante.removeAll();
        panelCambiante.add(panelListado,BorderLayout.CENTER);
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
        panelContenedor = new javax.swing.JPanel();
        gestionProductosBTN1 = new javax.swing.JButton();
        volverBTN = new javax.swing.JButton();

        setMinimumSize(new java.awt.Dimension(1000, 550));
        setPreferredSize(new java.awt.Dimension(1000, 550));

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setMinimumSize(new java.awt.Dimension(1000, 550));
        jPanel1.setPreferredSize(new java.awt.Dimension(1000, 550));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 48)); // NOI18N
        jLabel1.setText("Registrar Vendedor");

        panelContenedor.setMinimumSize(new java.awt.Dimension(988, 400));
        panelContenedor.setPreferredSize(new java.awt.Dimension(988, 400));

        javax.swing.GroupLayout panelContenedorLayout = new javax.swing.GroupLayout(panelContenedor);
        panelContenedor.setLayout(panelContenedorLayout);
        panelContenedorLayout.setHorizontalGroup(
            panelContenedorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        panelContenedorLayout.setVerticalGroup(
            panelContenedorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        gestionProductosBTN1.setBackground(new java.awt.Color(103, 80, 164));
        gestionProductosBTN1.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        gestionProductosBTN1.setForeground(new java.awt.Color(255, 255, 255));
        gestionProductosBTN1.setText("Registrar Vendedor");
        gestionProductosBTN1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                gestionProductosBTN1ActionPerformed(evt);
            }
        });

        volverBTN.setBackground(new java.awt.Color(103, 80, 164));
        volverBTN.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        volverBTN.setForeground(new java.awt.Color(255, 255, 255));
        volverBTN.setText("Volver");
        volverBTN.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                volverBTNActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(panelContenedor, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(volverBTN, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 568, Short.MAX_VALUE)
                        .addComponent(gestionProductosBTN1, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(panelContenedor, javax.swing.GroupLayout.PREFERRED_SIZE, 358, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(volverBTN)
                    .addComponent(gestionProductosBTN1))
                .addContainerGap(72, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void gestionProductosBTN1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_gestionProductosBTN1ActionPerformed
        this.registrarVendedor();
    }//GEN-LAST:event_gestionProductosBTN1ActionPerformed

    private void volverBTNActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_volverBTNActionPerformed
        this.volver();
    }//GEN-LAST:event_volverBTNActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton gestionProductosBTN1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel panelContenedor;
    private javax.swing.JButton volverBTN;
    // End of variables declaration//GEN-END:variables
}
