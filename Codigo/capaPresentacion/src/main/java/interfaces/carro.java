/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package interfaces;

import interfaces.CarritoCompra;
import java.awt.*;
import javax.swing.*;

/**
 *
 * @author melis
 */
public class carro extends JFrame {

    public carro() {
        setTitle("Carrito de Compra");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(800, 600); // Tamaño del JFrame

        // Crear los paneles de forma dinámica
        PanelID panelID = new PanelID();
        PanelResumen panelResumen = new PanelResumen();

        // Establecer el layout manager del JFrame
        setLayout(new BorderLayout());

        // Agregar panelID en la parte superior
        add(panelID, BorderLayout.NORTH);
        panelID.setPreferredSize(new Dimension(800, 20)); // Establecer dimensiones

        // Agregar panelResumen a la derecha
        add(panelResumen, BorderLayout.EAST);

        // Hacer visible el JFrame
        setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new carro());
    }
}

class PanelID extends JPanel {
    public PanelID() {
        setBackground(Color.LIGHT_GRAY); // Solo para visualizar el panel
        // Aquí puedes agregar los componentes específicos para el panel ID
        JLabel idJlabel = new JLabel("Panel ID ");
        add(idJlabel);
                JButton botonBuscarProducto = new JButton ();
        add(botonBuscarProducto);
    }
}

class PanelResumen extends JPanel {
    public PanelResumen() {
        setBackground(Color.CYAN); // Solo para visualizar el panel
        // Aquí puedes agregar los componentes para el resumen del carrito
        JLabel etiquetaResumen = new JLabel("Resumen");
        add(etiquetaResumen);
        
        setPreferredSize(new Dimension(200, 580)); 
    }

    @Override
    public Dimension getPreferredSize() {
        Dimension preferredSize = super.getPreferredSize();
        // Asegurar que el ancho sea el deseado
        preferredSize.width = 200;
        return preferredSize;
    }
}
