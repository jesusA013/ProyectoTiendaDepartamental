/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package ModuloAdministracion.GestionVendedores;

import BOs.VentasBO;
import DTOs.VendedorDTO;
import DTOs.VentaDTO;
import Entidades.Vendedor;
import Excepciones.NegocioException;
import Interfaces.IVendedorBO;
import Interfaces.IVentasBO;
import ModuloAdministracion.GestionProductos.PanelAdministradorMenu;
import ModuloAdministracion.GestionProductos.PanelRegistrarProducto;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.util.ArrayList;
import java.util.List;
import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

/**
 *
 * @author gaspa
 */
public class PanelListadoVendedores extends javax.swing.JPanel {
    private final JPanel panelCambiante;
    private final IVendedorBO vendedorBO;
    private final IVentasBO ventasBO;
    private final JPanel panelListado;
    /**
     * Creates new form PanelListadoVendedores
     */
    public PanelListadoVendedores(JPanel panelCambiante, IVendedorBO vendedorBO) {
        initComponents();
        this.panelCambiante = panelCambiante;
        this.vendedorBO = vendedorBO;
        this.ventasBO = new VentasBO();
        
        panelListado = new JPanel();
        
        panelListado.setLayout(new BoxLayout(panelListado, BoxLayout.Y_AXIS));
        panelListado.setBackground(Color.GRAY);
        
        JScrollPane scrollPane = new JScrollPane(panelListado);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        
        panelContenedor.setLayout(new BorderLayout());
        panelContenedor.add(scrollPane);
        cargarVendedores();
        
    }
    private void cargarVendedores() {
        // Limpia la lista primero
        panelListado.removeAll();
        panelListado.revalidate();
        panelListado.repaint();

        try {
            List<VendedorDTO> vendedores = vendedorBO.obtenerTodosLosVendedores();
            System.out.println("Total de vendedores: " + vendedores.size());

            if (vendedores.isEmpty()) {
                // Muestra un mensaje cuando no hay vendedores
                JLabel lblSinVendedores = new JLabel("No hay vendedores registrados.");
                lblSinVendedores.setForeground(Color.WHITE);
                panelListado.add(lblSinVendedores);
            } else {
                for (VendedorDTO vendedor : vendedores) {
                    JPanel fila = crearFilaVendedor(vendedor);
                    panelListado.add(fila);
                }
            }

            panelListado.revalidate();
            panelListado.repaint();

        } catch (NegocioException e) {
            System.out.println("Error al obtener vendedores: " + e.getMessage());

            // También muestra el mensaje en el panel
            JLabel lblError = new JLabel("No hay vendedores registrados.");
            lblError.setForeground(Color.WHITE);
            panelListado.add(lblError);

            panelListado.revalidate();
            panelListado.repaint();
        }
    }
    private JPanel crearFilaVendedor(VendedorDTO vendedor) {
        JPanel fila = new JPanel(new FlowLayout(FlowLayout.LEFT));
        fila.setBorder(BorderFactory.createLineBorder(Color.LIGHT_GRAY));
        fila.setBackground(Color.WHITE);

        String nombre = vendedor.getNombreCompleto() != null
                ? vendedor.getNombreCompleto().getNombres() + " " + vendedor.getNombreCompleto().getApellidoPaterno()
                : "Sin nombre";

        JLabel lblNombre = new JLabel("Nombre: " + nombre);
        JLabel lblCURP = new JLabel("CURP: " + vendedor.getCurp());

        JButton btnEditar = new JButton("Editar");
        btnEditar.addActionListener(e -> editarVendedor(vendedor));

        JButton btnEliminar = new JButton("Eliminar");
        btnEliminar.addActionListener(e -> {
            try {
                eliminarVendedor(vendedor);
            } catch (NegocioException ex) {
                JOptionPane.showMessageDialog(this, "Error al eliminar: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            }
        });
        
        JButton btnReporte = new JButton("Generar Reporte");
        btnReporte.addActionListener(e -> {
            try {
                generarReporte(vendedor);
            } catch (NegocioException ex) {
                System.getLogger(PanelListadoVendedores.class.getName()).log(System.Logger.Level.ERROR, (String) null, ex);
            }
        });

        fila.add(lblNombre);
        fila.add(Box.createHorizontalStrut(20));
        fila.add(lblCURP);
        fila.add(Box.createHorizontalStrut(20));
        fila.add(btnEditar);
        fila.add(btnEliminar);
        fila.add(btnReporte);

        return fila;
    }
    private List<VentaDTO> buscarVentas(VendedorDTO vendedorDTO) throws NegocioException{
        try {
            List<VentaDTO> listaVentas = ventasBO.obtenerVentas();
            List<VentaDTO> nuevaLista = new ArrayList<>();
            for (VentaDTO listaVenta : listaVentas) {
                
                if(listaVenta.getVendedorId().equals(vendedorDTO.getId())){
                    nuevaLista.add(listaVenta);
                }
            }
            return nuevaLista;
        } catch (NegocioException ex) {
            throw new NegocioException("Error: "+ex.getMessage());
        }
        
    }
    private void generarReporte(VendedorDTO vendedor) throws NegocioException{
        JOptionPane.showMessageDialog(this, "Generando reporte del vendedor: " + vendedor.getCurp());
        ReportePDFVendedor reporte = new ReportePDFVendedor();
        String ruta = System.getProperty("user.home") + "/Desktop/reporteVendedor.pdf";
        reporte.generarReporteVendedor(vendedor, this.buscarVentas(vendedor), ruta);
    }
    private void editarVendedor(VendedorDTO vendedor) {
        JOptionPane.showMessageDialog(this, "Editar: " + vendedor.getCurp());
        PanelEditarVendedor panelEditar = new PanelEditarVendedor(panelCambiante, vendedorBO,vendedor);
        panelCambiante.setLayout(new BorderLayout());
        panelCambiante.removeAll();
        panelCambiante.add(panelEditar,BorderLayout.CENTER);
        panelCambiante.revalidate();
        panelCambiante.repaint();
    }

    private void eliminarVendedor(VendedorDTO vendedor) throws NegocioException {
        int confirm = JOptionPane.showConfirmDialog(this,
                "¿Seguro que deseas eliminar a " + vendedor.getCurp() + "?",
                "Confirmar eliminación",
                JOptionPane.YES_NO_OPTION);

        if (confirm == JOptionPane.YES_OPTION) {
            VendedorDTO eliminado = vendedorBO.eliminarVendedor(vendedor.getId());
            if (eliminado!=null) {
                JOptionPane.showMessageDialog(this, "Vendedor eliminado correctamente.");
                cargarVendedores(); // Recarga la lista
            } else {
                JOptionPane.showMessageDialog(this, "No se pudo eliminar el vendedor.", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }
    
    public void volver(){
        PanelAdministradorMenu panelMenu = new PanelAdministradorMenu(panelCambiante);
        panelCambiante.setLayout(new BorderLayout());
        panelCambiante.removeAll();
        panelCambiante.add(panelMenu,BorderLayout.CENTER);
        panelCambiante.revalidate();
        panelCambiante.repaint();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        volverBTN = new javax.swing.JButton();
        registrarBTN = new javax.swing.JButton();
        panelContenedor = new javax.swing.JPanel();

        setMinimumSize(new java.awt.Dimension(1000, 550));

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setMinimumSize(new java.awt.Dimension(1000, 550));
        jPanel1.setPreferredSize(new java.awt.Dimension(1000, 550));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 48)); // NOI18N
        jLabel1.setText("Listado de Vendedores");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 10, -1, -1));

        volverBTN.setBackground(new java.awt.Color(103, 80, 164));
        volverBTN.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        volverBTN.setForeground(new java.awt.Color(255, 255, 255));
        volverBTN.setText("Volver");
        volverBTN.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                volverBTNActionPerformed(evt);
            }
        });
        jPanel1.add(volverBTN, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 450, 210, -1));

        registrarBTN.setBackground(new java.awt.Color(103, 80, 164));
        registrarBTN.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        registrarBTN.setForeground(new java.awt.Color(255, 255, 255));
        registrarBTN.setText("Agregar Vendedor");
        registrarBTN.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                registrarBTNActionPerformed(evt);
            }
        });
        jPanel1.add(registrarBTN, new org.netbeans.lib.awtextra.AbsoluteConstraints(790, 30, -1, -1));

        javax.swing.GroupLayout panelContenedorLayout = new javax.swing.GroupLayout(panelContenedor);
        panelContenedor.setLayout(panelContenedorLayout);
        panelContenedorLayout.setHorizontalGroup(
            panelContenedorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 940, Short.MAX_VALUE)
        );
        panelContenedorLayout.setVerticalGroup(
            panelContenedorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 350, Short.MAX_VALUE)
        );

        jPanel1.add(panelContenedor, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 90, 940, 350));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void volverBTNActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_volverBTNActionPerformed
        this.volver();
    }//GEN-LAST:event_volverBTNActionPerformed

    private void registrarBTNActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_registrarBTNActionPerformed
        PanelRegistrarVendedor panelRegistrar = new PanelRegistrarVendedor(panelCambiante, vendedorBO);
        panelCambiante.setLayout(new BorderLayout());
        panelCambiante.removeAll();
        panelCambiante.add(panelRegistrar,BorderLayout.CENTER);
        panelCambiante.revalidate();
        panelCambiante.repaint();
    }//GEN-LAST:event_registrarBTNActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel panelContenedor;
    private javax.swing.JButton registrarBTN;
    private javax.swing.JButton volverBTN;
    // End of variables declaration//GEN-END:variables
}
