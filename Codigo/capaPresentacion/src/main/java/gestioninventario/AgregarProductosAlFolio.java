package gestionInventario;

import DTOs.ProductoDTO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

/**
 * AgregarProductosAlFolio.java
 *
 * Pantalla para añadir productos a un folio.
 */
public class AgregarProductosAlFolio extends JFrame {

    private Navegador navegador;
    private DefaultListModel<String> listModel;
    private JList<String> lstProductos;

    public AgregarProductosAlFolio(Navegador navegador) {
        this.navegador = navegador;
        initComponents();
    }

    private void initComponents() {
        setTitle("Agregar Productos al Folio");
        setSize(500, 400);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLayout(new BorderLayout(10, 10));

        // Lista de productos seleccionados
        listModel = new DefaultListModel<>();
        lstProductos = new JList<>(listModel);
        // Cargar productos seleccionados del Navegador
        for (ProductoDTO producto : navegador.getProductosSeleccionados()) {
            listModel.addElement(producto.getNombre() + " - " + producto.getStock() + " unidades");
        }
        add(new JScrollPane(lstProductos), BorderLayout.CENTER);

        // Panel de botones
        JPanel panelBotones = new JPanel(new GridLayout(1, 3, 10, 10));
        JButton btnBuscar = new JButton("Buscar Producto");
        JButton btnConfirmar = new JButton("Confirmar");
        JButton btnCancelar = new JButton("Cancelar");

        btnBuscar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                navegador.mostrarBuscarProductos();
            }
        });

        btnConfirmar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (navegador.getProductosSeleccionados().isEmpty()) {
                    JOptionPane.showMessageDialog(AgregarProductosAlFolio.this, "Debe añadir al menos un producto.", "Error", JOptionPane.ERROR_MESSAGE);
                    return;
                }

                try {
                    navegador.asociarProductos();
                    navegador.mostrarConfirmacion();
                } catch (IllegalArgumentException ex) {
                    JOptionPane.showMessageDialog(AgregarProductosAlFolio.this, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        btnCancelar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                navegador.mostrarDashboard();
            }
        });

        panelBotones.add(btnBuscar);
        panelBotones.add(btnConfirmar);
        panelBotones.add(btnCancelar);
        add(panelBotones, BorderLayout.SOUTH);
    }

    public void agregarProducto(ProductoDTO producto) {
        navegador.agregarProducto(producto);
        listModel.addElement(producto.getNombre() + " - " + producto.getStock() + " unidades");
    }
}
