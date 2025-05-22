package gestioninventario;

import DTOs.ReporteStockDTO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;

/**
 * ReporteStockAgregado.java
 *
 * Pantalla para generar el reporte de stock agregado.
 */
public class ReporteProductoAgregado extends JFrame {

    private Navegador navegador;
    private JTextField txtFechaInicio;
    private JTextField txtFechaFin;

    public ReporteProductoAgregado(Navegador navegador) {
        this.navegador = navegador;
        initComponents();
    }

    private void initComponents() {
        setTitle("Reporte de Stock Agregado");
        setSize(500, 400);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLayout(new BorderLayout(10, 10));

        // Panel de fechas
        JPanel panelFechas = new JPanel(new GridLayout(2, 2, 10, 10));
        panelFechas.add(new JLabel("Fecha Inicio (dd/MM/yyyy):"));
        txtFechaInicio = new JTextField();
        panelFechas.add(txtFechaInicio);
        panelFechas.add(new JLabel("Fecha Fin (dd/MM/yyyy):"));
        txtFechaFin = new JTextField();
        panelFechas.add(txtFechaFin);
        add(panelFechas, BorderLayout.NORTH);

        // Lista de resultados
        DefaultListModel<String> listModel = new DefaultListModel<>();
        JList<String> lstReporte = new JList<>(listModel);
        add(new JScrollPane(lstReporte), BorderLayout.CENTER);

        // Botones
        JPanel panelBotones = new JPanel(new GridLayout(1, 2, 10, 10));
        JButton btnGenerar = new JButton("Generar Reporte");
        JButton btnRegresar = new JButton("Regresar");

        btnGenerar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    // Parsear fechas
                    Calendar fechaInicio = Calendar.getInstance();
                    String[] inicioParts = txtFechaInicio.getText().split("/");
                    if (inicioParts.length != 3) {
                        throw new IllegalArgumentException("Formato de fecha inicial inválido. Use dd/MM/yyyy.");
                    }
                    fechaInicio.set(Integer.parseInt(inicioParts[2]), Integer.parseInt(inicioParts[1]) - 1, Integer.parseInt(inicioParts[0]));

                    Calendar fechaFin = Calendar.getInstance();
                    String[] finParts = txtFechaFin.getText().split("/");
                    if (finParts.length != 3) {
                        throw new IllegalArgumentException("Formato de fecha final inválido. Use dd/MM/yyyy.");
                    }
                    fechaFin.set(Integer.parseInt(finParts[2]), Integer.parseInt(finParts[1]) - 1, Integer.parseInt(finParts[0]));

                    // Generar reporte
                    List<ReporteStockDTO> reporte = navegador.generarReporteStockAgregado(fechaInicio, fechaFin);
                    listModel.clear();
                    for (ReporteStockDTO item : reporte) {
                        listModel.addElement("Folio: " + item.getNumeroFolio() + ", Fecha: " +
                                new SimpleDateFormat("dd/MM/yyyy").format(item.getFecha().getTime()) +
                                ", Total Productos: " + item.getTotalProductos());
                    }
                } catch (IllegalArgumentException ex) {
                    JOptionPane.showMessageDialog(ReporteProductoAgregado.this, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(ReporteProductoAgregado.this, "Error al generar el reporte: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        btnRegresar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                navegador.mostrarDashboard();
            }
        });

        panelBotones.add(btnGenerar);
        panelBotones.add(btnRegresar);
        add(panelBotones, BorderLayout.SOUTH);
    }
}

