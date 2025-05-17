package control;

/**
 *
 * @author Jesus
 */
import ModuloVenta.FacturaDatos;
import ModuloVenta.GraciasPorSuCompra;
import ModuloVenta.SeleccionMetodoPago;
import ModuloVenta.BusquedaProducto;
import ModuloVenta.CarritoCompra;
import Inicio.InicioSesion;
import Inicio.MenuPrincipal;
import Implementaciones.*;
import ModuloAlmacen.GestionProveedores.*;
import ModuloAlmacen.MenuAlmacen;
import java.awt.BorderLayout;
import javax.swing.*;

public class ControlNavegacion {

    private static ControlNavegacion instancia;

    private JFrame pantallaActual;
    private JPanel panelActual;

    //Instancias unicas de cada pantalla
    private InicioSesion pantallaInicioSesion;
    private MenuPrincipal pantallaMenuPrincipal;
    private CarritoCompra pantallaCarritoCompra;
    private FacturaDatos pantallaFactura;
    private BusquedaProducto pantallaBusquedaProducto;
    private SeleccionMetodoPago pantallaSeleccionMetodoPago;
    private GraciasPorSuCompra pantallaGraciasCompra;
    // Gestión Proveedores
    private final IManejadorProveedor manejadorProveedor;
    private JPanel panelCambiante;
    private final ProveedoresPantalla pantallaProveedores;
    private final ProveedoresPanelListado panelListaProveedores;
    private final MenuAlmacen pantallaAlmacen;
    private final ProveedoresPanelNuevo panelNuevoProveedor;
    private final ProveedoresPanelEditar panelEditarProveedor;
    private final ProveedoresPanelDetalles panelDetallesProveedor;

    //Creacion de cada pantalla
    public ControlNavegacion() {
        this.pantallaInicioSesion = new InicioSesion();
        this.pantallaMenuPrincipal = new MenuPrincipal();
        this.pantallaCarritoCompra = new CarritoCompra();
        this.pantallaFactura = new FacturaDatos();
        this.pantallaBusquedaProducto = new BusquedaProducto();
        this.pantallaSeleccionMetodoPago = new SeleccionMetodoPago();
        this.pantallaGraciasCompra= new GraciasPorSuCompra();
        // Gestión Proveedores
        this.manejadorProveedor = new ManejadorProveedor();
        this.pantallaProveedores = ProveedoresPantalla.getInstancia(manejadorProveedor);
        this.pantallaAlmacen = new MenuAlmacen();
        this.panelListaProveedores = new ProveedoresPanelListado(manejadorProveedor);
        this.panelNuevoProveedor = new ProveedoresPanelNuevo(manejadorProveedor);
        this.panelEditarProveedor = new ProveedoresPanelEditar(manejadorProveedor);
        this.panelDetallesProveedor = new ProveedoresPanelDetalles(manejadorProveedor);
    }

    public static ControlNavegacion getInstance() {
        if (instancia == null) {
            instancia = new ControlNavegacion();
        }
        return instancia;
    }

    /**
     * Este metodo
     *
     * @param nuevaPantalla pantalla que posteriormente se quiere mostrar
     */
    public void mostrarPantalla(JFrame nuevaPantalla) {
        if (pantallaActual != null) {
            pantallaActual.setVisible(false);
        }
        pantallaActual = nuevaPantalla;
        pantallaActual.setLocationRelativeTo(null);
        pantallaActual.setVisible(true);
    }
    
    public void mostrarPanel(JPanel panelCambiante, JPanel panelNuevo) {
        panelActual = panelCambiante;
        panelActual.setLayout(new BorderLayout());
        panelActual.removeAll();
        panelActual.add(panelNuevo, BorderLayout.CENTER);
        panelActual.revalidate();
        panelActual.repaint();
    }

    public void irAInicioSesion() {
        pantallaInicioSesion.LimpiarCampos();
        mostrarPantalla(pantallaInicioSesion);
    }

    public void irAMenuPrincipal() {
        mostrarPantalla(pantallaMenuPrincipal);
    }

    public void irACarritoCompra() {
        mostrarPantalla(pantallaCarritoCompra);
    }

    public void irAFacturaDatos() {
        mostrarPantalla(pantallaFactura);
    }

    public void irABusquedaProducto(String busqueda) {
        pantallaBusquedaProducto.setBusqueda(busqueda);
        mostrarPantalla(pantallaBusquedaProducto);
    }
    
    public void irASeleccionMetodoPago() {
        mostrarPantalla(pantallaSeleccionMetodoPago);
    }
    
    public void irAGraciasPorSuCompra(){
        mostrarPantalla(pantallaGraciasCompra);
        
    }
    
    ///////////////////////////////////////////////////////
    /**
     * Muestra la pantalla del menu de almacen
     */
    public void mostrarMenuAlmacen() {
        mostrarPantalla(pantallaAlmacen);
    }
    
    // Gestión Proveedores
    /**
     * Muestra la pantalla de proveedores con la lista.
     */
    public void mostrarFormListaProveedores() {
        // Panel Listado
        panelCambiante = ProveedoresPantalla.getInstancia(manejadorProveedor).getPanelCambiante();
        mostrarPanel(panelCambiante, panelListaProveedores);
        mostrarPantalla(pantallaProveedores);
    }

    /**
     * Muestra el panel con la lista de proveedores.
     */
    public void mostrarPanelProveedoresLista() {
        // Panel Listado
        panelCambiante = ProveedoresPantalla.getInstancia(manejadorProveedor).getPanelCambiante();
        mostrarPanel(panelCambiante, new ProveedoresPanelListado(manejadorProveedor));

    }
    
    /**
     * Muestra el panel para registrar un proveedor.
     */
    public void mostrarPanelProveedorNuevo() {
        panelCambiante = ProveedoresPantalla.getInstancia(manejadorProveedor).getPanelCambiante();
        mostrarPanel(panelCambiante, panelNuevoProveedor);
    }
    
    /**
     * Muestra el panel para editar un proveedor ya registrado.
     */
    public void mostrarPanelProveedorEditar() {
        panelCambiante = ProveedoresPantalla.getInstancia(manejadorProveedor).getPanelCambiante();
        mostrarPanel(panelCambiante, panelEditarProveedor);
    }
    
    /**
     * Muestra el panel para ver los detalles un proveedor ya registrado.
     */
    public void mostrarPanelProveedorDetalles() {
        panelCambiante = ProveedoresPantalla.getInstancia(manejadorProveedor).getPanelCambiante();
        mostrarPanel(panelCambiante, panelDetallesProveedor);
    }
    /////////////////////////////////////////////////////////////////
}
