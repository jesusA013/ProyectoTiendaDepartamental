package CapaPresentacion;

import DTOs.FolioDTO;
import DTOs.ProductoDTO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.List;

/**
 * Confirmacion.java
 *
 * Pantalla para confirmar los datos del folio y los productos.
 */
public class Confirmacion extends JFrame {

    private Navegador navegador;
    private FolioDTO folioDTO;
    private List<ProductoDTO> productos;

    public Confirmacion(Navegador navegador, FolioDTO folioDTO, List<ProductoDTO> productos) {
        this.navegador = navegador;
        this.folioDTO = folioDTO;
        this.productos = productos;
        initComponents();
    }

    private void initComponents() {
        setTitle("Confirmación");
        setSize(400, 400);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLayout(new BorderLayout(10, 10));

        // Resumen
        JTextArea txtResumen = new JTextArea();
        txtResumen.setEditable(false);
        StringBuilder resumen = new StringBuilder();
        resumen.append("Número de Folio: ").append(folioDTO.getNumeroFolio()).append("\n");
        resumen.append("Fecha: ").append(new SimpleDateFormat("dd/MM/yyyy").format(folioDTO.getFecha().getTime())).append("\n");
        resumen.append("Proveedor: ").append(folioDTO.getNombreProveedor()).append("\n");
        resumen.append("Productos:\n");
        for (ProductoDTO producto : productos) {
            resumen.append("- ").append(producto.getNombre()).append(" (SKU: ").append(producto.getSku()).append("), Cantidad: ").append(producto.getStock()).append("\n");
        }
        txtResumen.setText(resumen.toString());
        add(new JScrollPane(txtResumen), BorderLayout.CENTER);

        // Botones
        JPanel panelBotones = new JPanel(new GridLayout(1, 2, 10, 10));
        JButton btnConfirmar = new JButton("Confirmar");
        JButton btnCancelar = new JButton("Cancelar");

        btnConfirmar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                navegador.mostrarNotificacionExito();
            }
        });

        btnCancelar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                navegador.mostrarAgregarProductos(folioDTO);
            }
        });

        panelBotones.add(btnConfirmar);
        panelBotones.add(btnCancelar);
        add(panelBotones, BorderLayout.SOUTH);
    }
}
