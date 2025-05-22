package gestioninventario;

import DTOs.FolioDTO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Calendar;

/**
 * FormularioNuevoFolio.java
 *
 * Pantalla para ingresar los datos de un nuevo folio.
 */
public class NuevoFolio extends JFrame {

    private Navegador navegador;
    private JTextField txtNumeroFolio;
    private JTextField txtFecha;
    private JTextField txtProveedor;

    public NuevoFolio(Navegador navegador) {
        this.navegador = navegador;
        initComponents();
    }

    private void initComponents() {
        setTitle("Nuevo Folio");
        setSize(400, 300);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLayout(new GridLayout(5, 2, 10, 10));

        add(new JLabel("Número de Folio:"));
        txtNumeroFolio = new JTextField();
        add(txtNumeroFolio);

        add(new JLabel("Fecha (dd/MM/yyyy):"));
        txtFecha = new JTextField();
        add(txtFecha);

        add(new JLabel("Proveedor:"));
        txtProveedor = new JTextField();
        add(txtProveedor);

        JButton btnSiguiente = new JButton("Siguiente");
        JButton btnCancelar = new JButton("Cancelar");

        btnSiguiente.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    FolioDTO folioDTO = new FolioDTO();
                    folioDTO.setNumeroFolio(txtNumeroFolio.getText());
                    folioDTO.setNombreProveedor(txtProveedor.getText());

                    // Parsear la fecha
                    String[] fechaParts = txtFecha.getText().split("/");
                    if (fechaParts.length != 3) {
                        throw new IllegalArgumentException("Formato de fecha inválido. Use dd/MM/yyyy.");
                    }
                    Calendar fecha = Calendar.getInstance();
                    fecha.set(Integer.parseInt(fechaParts[2]), Integer.parseInt(fechaParts[1]) - 1, Integer.parseInt(fechaParts[0]));
                    folioDTO.setFecha(fecha);

                    // Crear el folio
                    navegador.crearFolio(folioDTO);

                    // Navegar a la siguiente pantalla
                    navegador.mostrarAgregarProductos(folioDTO);
                } catch (IllegalArgumentException ex) {
                    JOptionPane.showMessageDialog(NuevoFolio.this, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(NuevoFolio.this, "Error al crear el folio: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        btnCancelar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                navegador.mostrarDashboard();
            }
        });

        add(btnSiguiente);
        add(btnCancelar);
    }
}
