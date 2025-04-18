/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package interfaces;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import DTOs.FacturaDTO;


public class FacturaDatos extends JFrame {
    private JTextField txtRfc, txtNombre, txtCalle, txtNumExterior, txtNumInterior, txtColonia, txtCodigoPostal,
                       txtDelegacion, txtCiudad, txtEstado, txtPais, txtCorreo;
    private JButton btnFacturar, btnCancelar;

    public FacturaDatos() {
        // Configuración básica de la ventana
        setTitle("FacturaDatos");
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        // Panel superior: ID
        JPanel panelId = new JPanel();
        panelId.add(new JLabel("ID: 123456"));
        add(panelId, BorderLayout.NORTH);

        // Panel central: formulario de datos fiscales
        JPanel panelFormulario = new JPanel(new GridLayout(13, 2, 10, 10));
        panelFormulario.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        // Etiquetas y campos de texto
        panelFormulario.add(new JLabel("*RFC:"));
        txtRfc = new JTextField(20);
        panelFormulario.add(txtRfc);

        panelFormulario.add(new JLabel("Nombre o razón social:"));
        txtNombre = new JTextField(20);
        panelFormulario.add(txtNombre);

        panelFormulario.add(new JLabel("Calle:"));
        txtCalle = new JTextField(20);
        panelFormulario.add(txtCalle);

        panelFormulario.add(new JLabel("Número exterior:"));
        txtNumExterior = new JTextField(20);
        panelFormulario.add(txtNumExterior);

        panelFormulario.add(new JLabel("Número interior:"));
        txtNumInterior = new JTextField(20);
        panelFormulario.add(txtNumInterior);

        panelFormulario.add(new JLabel("Colonia:"));
        txtColonia = new JTextField(20);
        panelFormulario.add(txtColonia);

        panelFormulario.add(new JLabel("Código postal:"));
        txtCodigoPostal = new JTextField(20);
        panelFormulario.add(txtCodigoPostal);

        panelFormulario.add(new JLabel("Delegación o municipio:"));
        txtDelegacion = new JTextField(20);
        panelFormulario.add(txtDelegacion);

        panelFormulario.add(new JLabel("Ciudad o localidad:"));
        txtCiudad = new JTextField(20);
        panelFormulario.add(txtCiudad);

        panelFormulario.add(new JLabel("Estado:"));
        txtEstado = new JTextField(20);
        panelFormulario.add(txtEstado);

        panelFormulario.add(new JLabel("*País:"));
        txtPais = new JTextField(20);
        panelFormulario.add(txtPais);

        panelFormulario.add(new JLabel("Correo Electrónico:"));
        txtCorreo = new JTextField(20);
        panelFormulario.add(txtCorreo);

        // Nota sobre campos obligatorios
        JLabel lblObligatorios = new JLabel("*Datos Obligatorios");
        lblObligatorios.setForeground(Color.RED);
        panelFormulario.add(lblObligatorios);
        panelFormulario.add(new JLabel("")); // Espacio vacío para alineación

        add(panelFormulario, BorderLayout.CENTER);

        // Panel inferior: botones
        JPanel panelBotones = new JPanel();
        btnFacturar = new JButton("Facturar");
        btnFacturar.setBackground(new Color(103, 80, 164)); // Morado
        btnFacturar.setForeground(Color.WHITE);
        btnCancelar = new JButton("Cancelar");
        btnCancelar.setBackground(new Color(255, 182, 193)); // Rosa claro
        panelBotones.add(btnFacturar);
        panelBotones.add(btnCancelar);
        add(panelBotones, BorderLayout.SOUTH);

        // Eventos
        btnFacturar.addActionListener(e -> facturar());
        btnCancelar.addActionListener(e -> cancelar());

        
    }

    private void facturar() {
        // Crear un FacturaDTO con los datos ingresados
        FacturaDTO facturaDTO = new FacturaDTO(
            txtRfc.getText(),
            txtCodigoPostal.getText(),
            txtCalle.getText(),
            txtNombre.getText(),
            txtNumExterior.getText(),
            txtNumInterior.getText(),
            txtColonia.getText(),
            txtEstado.getText(),
            txtPais.getText(),
            txtCorreo.getText()
        );
        
        // Mostrar el objeto FacturaDTO 
        JOptionPane.showMessageDialog(this, "Factura generada con éxito:\n" + facturaDTO.toString(), "Éxito", JOptionPane.INFORMATION_MESSAGE);
        
        // FacturaNegocio facturaNegocio = new FacturaNegocio();
        // facturaNegocio.crearFactura(facturaDTO);
    }

    private void cancelar() {
        int confirm = JOptionPane.showConfirmDialog(this, "¿Está seguro de que desea cancelar?", "Confirmar", JOptionPane.YES_NO_OPTION);
        if (confirm == JOptionPane.YES_OPTION) {
            dispose(); // Cierra la ventana
        }
    }


}
