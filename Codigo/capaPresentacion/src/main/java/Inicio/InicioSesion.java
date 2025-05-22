package Inicio;

import BOs.UsuarioBO;
import BOs.VendedorBO;
import DTOs.UsuarioDTO;
import DTOs.VendedorDTO;
import Excepciones.NegocioException;
import Interfaces.IUsuarioBO;
import Interfaces.IVendedorBO;
import control.ControlNavegacion;
import javax.swing.*;
import java.awt.*;
import java.util.List;
import org.bson.types.ObjectId;

public class InicioSesion extends JFrame {
    
    private static InicioSesion instancia;
    
    private final JTextField txtId;
    private final JPasswordField txtContrasena;
    private final JButton btnIngresar;
    private final JButton btnCancelar;
    private String tipo, nombreUsuario, idCuenta;
    private ObjectId idUsuario;
    private final IUsuarioBO usuarioBO;
//    private final IVendedorBO vendedorBO;

    public InicioSesion() {
        usuarioBO = new UsuarioBO();
//        vendedorBO = new VendedorBO();
        // Configuración básica de la ventana
        setTitle("Inicio de Sesión");
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);

        setLayout(new BorderLayout());

        // Panel superior: Título y borde morado
        JPanel panelTitulo = new JPanel();
        panelTitulo.setBackground(new Color(103,80, 164)); // Morado
        panelTitulo.setPreferredSize(new Dimension(400, 40));
        add(panelTitulo, BorderLayout.NORTH);
        
        JLabel labelInicioSesion = new JLabel("Inicio de Sesion");
        panelTitulo.setLayout(new BorderLayout());
        panelTitulo.add(labelInicioSesion,BorderLayout.WEST);
        labelInicioSesion.setFont(new Font("Segoe UI",Font.PLAIN,22));

        // Panel central: Formulario de inicio de sesión
        JPanel panelFormulario = new JPanel();
        panelFormulario.setLayout(new GridBagLayout());
        panelFormulario.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10); // Espaciado entre componentes

        // Título
        JLabel lblTitulo = new JLabel("Por favor, ingresa sesión para continuar");
        lblTitulo.setFont(new Font("Arial", Font.BOLD, 16));
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 2;
        gbc.anchor = GridBagConstraints.CENTER;
        panelFormulario.add(lblTitulo, gbc);

        // Campo ID
        gbc.gridwidth = 1;
        gbc.anchor = GridBagConstraints.WEST;
        gbc.gridx = 0;
        gbc.gridy = 1;
        panelFormulario.add(new JLabel("ID:"), gbc);

        gbc.gridx = 1;
        txtId = new JTextField("", 15); ///
        panelFormulario.add(txtId, gbc);

        // Icono de usuario
        JLabel lblIconoUsuario = new JLabel("👤"); // Usar un emoji como placeholder
        gbc.gridx = 2;
        panelFormulario.add(lblIconoUsuario, gbc);

        // Campo Contraseña
        gbc.gridx = 0;
        gbc.gridy = 2;
        panelFormulario.add(new JLabel("Contraseña:"), gbc);

        gbc.gridx = 1;
        txtContrasena = new JPasswordField("", 15); ///
        panelFormulario.add(txtContrasena, gbc);

        // Icono de candado
        JLabel lblIconoCandado = new JLabel("🔒"); // Usar un emoji como placeholder
        gbc.gridx = 2;
        panelFormulario.add(lblIconoCandado, gbc);

        // Panel de botones
        JPanel panelBotones = new JPanel();
        panelBotones.setLayout(new FlowLayout(FlowLayout.CENTER, 20, 10));

        btnCancelar = new JButton("Cancelar");
        btnCancelar.setBackground(new Color(255, 182, 193)); // Rosa claro
        btnCancelar.setPreferredSize(new Dimension(100, 30));
        panelBotones.add(btnCancelar);

        btnIngresar = new JButton("Ingresar");
        btnIngresar.setBackground(new Color(144, 238, 144)); // Verde claro
        btnIngresar.setPreferredSize(new Dimension(100, 30));
        panelBotones.add(btnIngresar);

        gbc.gridx = 0;
        gbc.gridy = 3;
        gbc.gridwidth = 3;
        gbc.anchor = GridBagConstraints.CENTER;
        panelFormulario.add(panelBotones, gbc);

        add(panelFormulario, BorderLayout.CENTER);

        // Eventos
        btnIngresar.addActionListener(e -> iniciarSesion());
        btnCancelar.addActionListener(e -> cancelar());

    }
    
    public void setTipo(String tipo){
        this.tipo = tipo;
    }
    
//    public ObjectId getVendedor() throws NegocioException{
//        List<VendedorDTO> listaVendedores = vendedorBO.obtenerTodosLosVendedores();
//        for (VendedorDTO listaVendedore : listaVendedores) {
//            if(listaVendedore.getUsuario().getId()==idUsuario){
//                return listaVendedore.getId();
//            }
//        }
//        throw new NegocioException("No se encontraron vendedores");
//    }
    
    public void iniciarSesion() {
        String id = txtId.getText();
        String contrasena = new String(txtContrasena.getPassword());

        try {
            UsuarioDTO usuario = usuarioBO.verificarCredenciales(id, contrasena);
            String rol = usuario.getRol(); // Rol real obtenido de la base de datos

            if (rol.equalsIgnoreCase("Administrador") || rol.equalsIgnoreCase(tipo)) {
                System.out.println("Inicio de sesión exitoso.");

                switch (tipo) {
                    case "Vendedor":
                        setIdUsuario(usuario.getId());
                        ControlNavegacion.getInstance().irACarritoCompra();
                        break;
                    case "Administrador":
                        setIdUsuario(usuario.getId());

                        ControlNavegacion.getInstance().mostrarMenuAdministrador();
                        break;
                    case "Almacen":
                        setIdUsuario(usuario.getId());

                        ControlNavegacion.getInstance().mostrarMenuAlmacen();
                        break;
                    default:
                        JOptionPane.showMessageDialog(this, "Tipo de usuario no reconocido.", "Error", JOptionPane.ERROR_MESSAGE);
                        break;
                }
            } else {
                JOptionPane.showMessageDialog(this, "No tienes permisos para acceder como " + tipo, "Acceso denegado", JOptionPane.ERROR_MESSAGE);
            }

        } catch (NegocioException ex) {
            JOptionPane.showMessageDialog(this, "ID o contraseña incorrectos.", "Error", JOptionPane.ERROR_MESSAGE);
            System.out.println("Error en inicio de sesión: " + ex.getMessage());
        }
    }

    public void cancelar() {
        int confirm = JOptionPane.showConfirmDialog(this, "¿Está seguro de que desea cancelar?", "Confirmar", JOptionPane.YES_NO_OPTION);
        if (confirm == JOptionPane.YES_OPTION) {
            setVisible(false);
            control.ControlNavegacion.getInstance().irAMenuPrincipal();
        }
    }
    
    public void LimpiarCampos(){
        txtId.setText("");
        txtContrasena.setText("");
    }

    public ObjectId getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(ObjectId id) {
        this.idUsuario = id;
    }

    public String getIdCuenta() {
        return idCuenta;
    }

    public void setIdCuenta(String idCuenta) {
        this.idCuenta = idCuenta;
    }

    public String getNombreUsuario() {
        return nombreUsuario;
    }

    public void setNombreUsuario(String nombreUsuario) {
        this.nombreUsuario = nombreUsuario;
    }
    
    public static InicioSesion getInstance() {
        if (instancia == null) {
            instancia = new InicioSesion();
        }
        return instancia;
    }
}
