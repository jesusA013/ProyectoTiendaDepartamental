package gestioninventario;

import DTOs.ProductoDTO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

/**
 * BuscarProductos.java
 *
 * Pantalla para buscar productos por nombre.
 */
public class BuscarProductos extends JFrame {

    private Navegador navegador;
    private DefaultListModel<String> listModel;
    private JList<String> lstResultados;
    private List<ProductoDTO> resultados;

    public BuscarProductos(Navegador navegador) {
        this.navegador = navegador;
        initComponents();
    }

    private void initComponents() {
        setTitle("Buscar Productos");
        setSize(400, 300);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLayout(new BorderLayout(10, 10));

        // Panel de búsqueda
        JPanel panelBusqueda = new JPanel(new GridLayout(1, 2, 10, 10));
        JTextField txtTermino = new JTextField();
        JButton btnBuscar = new JButton("Buscar");

        panelBusqueda.add(txtTermino);
        panelBusqueda.add(btnBuscar);
        add(panelBusqueda, BorderLayout.NORTH);

        // Lista de resultados
        listModel = new DefaultListModel<>();
        lstResultados = new JList<>(listModel);
        add(new JScrollPane(lstResultados), BorderLayout.CENTER);

        // Botones
        JPanel panelBotones = new JPanel(new GridLayout(1, 2, 10, 10));
        JButton btnSeleccionar = new JButton("Seleccionar");
        JButton btnCancelar = new JButton("Cancelar");

        btnBuscar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    listModel.clear();
                    resultados = navegador.buscarProductosPorNombre(txtTermino.getText());
                    for (ProductoDTO producto : resultados) {
                        listModel.addElement(producto.getNombre() + " - SKU: " + producto.getSku());
                    }
                } catch (IllegalArgumentException ex) {
                    JOptionPane.showMessageDialog(BuscarProductos.this, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        btnSeleccionar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int selectedIndex = lstResultados.getSelectedIndex();
                if (selectedIndex == -1) {
                    JOptionPane.showMessageDialog(BuscarProductos.this, "Seleccione un producto.", "Error", JOptionPane.ERROR_MESSAGE);
                    return;
                }

                ProductoDTO productoSeleccionado = resultados.get(selectedIndex);
                String cantidadStr = JOptionPane.showInputDialog(BuscarProductos.this, "Ingrese la cantidad a añadir:");
                try {
                    int cantidad = Integer.parseInt(cantidadStr);
                    if (cantidad <= 0) {
                        throw new IllegalArgumentException("La cantidad debe ser mayor a 0.");
                    }
                    productoSeleccionado.setStock(cantidad);
                    // Añadir el producto a través del Navegador
                    navegador.agregarProducto(productoSeleccionado);
                    navegador.mostrarAgregarProductos(null);
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(BuscarProductos.this, "Cantidad inválida.", "Error", JOptionPane.ERROR_MESSAGE);
                } catch (IllegalArgumentException ex) {
                    JOptionPane.showMessageDialog(BuscarProductos.this, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        btnCancelar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                navegador.mostrarAgregarProductos(null);
            }
        });

        panelBotones.add(btnSeleccionar);
        panelBotones.add(btnCancelar);
        add(panelBotones, BorderLayout.SOUTH);
    }
}
