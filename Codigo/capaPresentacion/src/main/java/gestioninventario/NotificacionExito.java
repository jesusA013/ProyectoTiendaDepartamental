package gestioninventario;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * NotificacionExito.java
 *
 * Pantalla para notificar que la operación se realizó con éxito.
 */
public class NotificacionExito extends JFrame {

    private Navegador navegador;

    public NotificacionExito(Navegador navegador) {
        this.navegador = navegador;
        initComponents();
    }

    private void initComponents() {
        setTitle("Éxito");
        setSize(300, 150);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLayout(new BorderLayout(10, 10));

        JLabel lblMensaje = new JLabel("Folio creado y productos asociados con éxito.", SwingConstants.CENTER);
        add(lblMensaje, BorderLayout.CENTER);

        JButton btnRegresar = new JButton("Regresar al Inicio");
        btnRegresar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                navegador.mostrarDashboard();
            }
        });
        add(btnRegresar, BorderLayout.SOUTH);
    }
}
