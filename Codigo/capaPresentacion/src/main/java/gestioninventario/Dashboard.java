package gestioninventario;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Dashboard.java
 *
 * Pantalla principal del sistema de gestión de inventarios.
 */
public class Dashboard extends JFrame {

    private Navegador navegador;

    public Dashboard(Navegador navegador) {
        this.navegador = navegador;
        initComponents();
    }

    private void initComponents() {
        setTitle("Sistema de Gestión de Inventarios");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400, 300);
        setLocationRelativeTo(null);
        setLayout(new GridLayout(5, 1, 10, 10));

        JLabel lblTitulo = new JLabel("Bienvenido al Sistema de Inventarios", SwingConstants.CENTER);
        lblTitulo.setFont(new Font("Arial", Font.BOLD, 16));
        add(lblTitulo);

        JButton btnNuevoFolio = new JButton("Nuevo Folio");
        JButton btnConsultarInventario = new JButton("Consultar Inventario");
        JButton btnReporteStock = new JButton("Reporte de Stock Agregado");
        JButton btnReporteBajos = new JButton("Reporte de Productos Bajos");

        btnNuevoFolio.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                navegador.mostrarFormularioNuevoFolio();
            }
        });

        btnConsultarInventario.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                navegador.mostrarInventario();
            }
        });

        btnReporteStock.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                navegador.mostrarReporteStockAgregado();
            }
        });

        btnReporteBajos.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                navegador.mostrarReporteProductosBajos();
            }
        });

        add(btnNuevoFolio);
        add(btnConsultarInventario);
        add(btnReporteStock);
        add(btnReporteBajos);
    }
}
