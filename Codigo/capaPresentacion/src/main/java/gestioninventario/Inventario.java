package gestioninventario;


import DTOs.ProductoDTO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

/**
 * Inventario.java
 *
 * Pantalla para consultar el inventario.
 */
public class Inventario extends JFrame {

    private Navegador navegador;

    public Inventario(Navegador navegador) {
        this.navegador = navegador;
        initComponents();
    }

    private void initComponents() {
        setTitle("Consultar Inventario");
        setSize(400, 300);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLayout(new BorderLayout(10, 10));

        // Lista de productos
        DefaultListModel<String> listModel = new DefaultListModel<>();
        JList<String> lstProductos = new JList<>(listModel);
        List<ProductoDTO> productos = navegador.obtenerInventario();
        for (ProductoDTO producto : productos) {
            listModel.addElement(producto.getNombre() + " - SKU: " + producto.getSku() + ", Stock: " + producto.getStock());
        }
        add(new JScrollPane(lstProductos), BorderLayout.CENTER);

        // Botón de regreso
        JButton btnRegresar = new JButton("Regresar");
        btnRegresar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                navegador.mostrarDashboard();
            }
        });
        add(btnRegresar, BorderLayout.SOUTH);
    }
}
