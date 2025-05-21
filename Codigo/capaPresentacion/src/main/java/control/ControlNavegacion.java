package control;

/**
 *
 * @author Jesus
 */
import Excepciones.ProveedorException;
import ModuloVenta.FacturaDatos;
import ModuloVenta.SeleccionMetodoPago;
import ModuloVenta.BusquedaProducto;
import ModuloVenta.CarritoCompra;
import Inicio.InicioSesion;
import Inicio.MenuPrincipal;
import Implementaciones.*;
import Interface.IRegistroVenta;
import Interfaces.INavegador;
import ManejadorVenta.ManejadorVenta;
import ModuloAdministracion.AdministradorMenu;
import ModuloAlmacen.GestionProveedores.*;
import ModuloAlmacen.MenuAlmacen;
import ModuloVenta.VentaFinalizada;
import RegistroVentaException.RegistroException;
import gestionVendedores.*;
import java.awt.BorderLayout;
import javax.swing.*;
import org.bson.types.ObjectId;

public class ControlNavegacion implements INavegador{

    private static ControlNavegacion instancia;

    private JFrame pantallaActual;
    private JPanel panelActual;
    
    //Instancias unicas de cada pantalla
    private InicioSesion pantallaInicioSesion;
    private MenuPrincipal pantallaMenuPrincipal;
    
    // Gestión Venta
    private final IRegistroVenta manejadorVenta;
    private FacturaDatos pantallaFactura;
    private BusquedaProducto pantallaBusquedaProducto;
    private SeleccionMetodoPago pantallaSeleccionMetodoPago;
    private VentaFinalizada pantallaVentaFinalizada;
    // Gestión Proveedores
    private final IManejadorProveedor manejadorProveedor;
    private JPanel panelCambiante;
    private final MenuAlmacen pantallaAlmacen;
    //Gestion Vendedores
    private GenerarInforme pantallaGeneraInforme;
    private InformacionVendedor panatallaInformacionVendedor;
    private ListadoVendedores pantallaListadoVendedores;
    private RegistrarVendedor pantallaRegistraVendedor;
    //productos
    private AdministradorMenu pantallaAdministradorMenu;

    /**
     * 
     */
    public ControlNavegacion() {
        this.pantallaInicioSesion = new InicioSesion();
        this.pantallaMenuPrincipal = new MenuPrincipal();
        // Gestión Venta
        this.manejadorVenta = new ManejadorVenta();
        manejadorVenta.setNavegador(this);
        this.pantallaFactura = new FacturaDatos();
        this.pantallaBusquedaProducto = new BusquedaProducto(manejadorVenta);
        this.pantallaSeleccionMetodoPago = new SeleccionMetodoPago(manejadorVenta);
        this.pantallaVentaFinalizada = new VentaFinalizada(manejadorVenta);
        // Gestión Proveedores
        this.manejadorProveedor = new ManejadorProveedor();
        manejadorProveedor.setNavegador(this);
        this.pantallaAlmacen = new MenuAlmacen();
        //productos
        this.pantallaAdministradorMenu = new AdministradorMenu();
        //Gestion Vendedores
//        this.pantallaRegistraVendedor= new;
//        this.pantallaListadoVendedores;
//        this.panatallaInformacionVendedor;
//        this.pantallaGeneraInforme=;
        
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

    public void irAInicioSesion(String tipo) {
        pantallaInicioSesion.setTipo(tipo);
        pantallaInicioSesion.LimpiarCampos();
        mostrarPantalla(pantallaInicioSesion);
    }

    @Override
    public void irAMenuPrincipal() {
        mostrarPantalla(pantallaMenuPrincipal);
    }

    public void irACarritoCompra() {
        CarritoCompra carrito = CarritoCompra.getInstance(manejadorVenta);
        carrito.cargarCarrito();
        mostrarPantalla(carrito);
    }

    public void irAFacturaDatos() {
        mostrarPantalla(pantallaFactura);
    }

    public void irABusquedaProducto(String busqueda) throws RegistroException {
        mostrarPantalla(pantallaBusquedaProducto);
    }
    
    @Override
    public void irASeleccionMetodoPago() {
        mostrarPantalla(pantallaSeleccionMetodoPago);
    }
    
    @Override
    public void irVentaFinalizada(){
        mostrarPantalla(pantallaVentaFinalizada);
        
    }
    
    ///////////////////////////////////////////////////////
    /**
     * Muestra la pantalla del menu de almacen
     */
    public void mostrarMenuAlmacen() {
        mostrarPantalla(pantallaAlmacen);
    }
    public void mostrarMenuAdministrador() {
        mostrarPantalla(pantallaAdministradorMenu);
    }
    
    // Gestión Proveedores
    /**
     * Muestra la pantalla de proveedores con la lista.
     */
    public void mostrarFormListaProveedores() {
        ProveedoresPantalla pantallaProveedores = ProveedoresPantalla.getInstancia(manejadorProveedor);
        mostrarPanelProveedoresLista();
        mostrarPantalla(pantallaProveedores);
    }

    /**
     * Muestra el panel con la lista de proveedores.
     */
    @Override
    public void mostrarPanelProveedoresLista() {
        // Panel Listado
        panelCambiante = ProveedoresPantalla.getInstancia(manejadorProveedor).getPanelCambiante();
        ProveedoresPanelListado proveedorPanelListado = ProveedoresPanelListado.getInstance(manejadorProveedor);
        proveedorPanelListado.cargarListaProveedores();
        mostrarPanel(panelCambiante, proveedorPanelListado);

    }
    
    /**
     * Muestra el panel para registrar un proveedor.
     */
    public void mostrarPanelProveedorNuevo() {
        panelCambiante = ProveedoresPantalla.getInstancia(manejadorProveedor).getPanelCambiante();
        ProveedoresPanelNuevo proveedorPanelNuevo = ProveedoresPanelNuevo.getInstance(manejadorProveedor);
        mostrarPanel(panelCambiante, proveedorPanelNuevo);
    }
    
    /**
     * Muestra el panel para editar un proveedor ya registrado.
     * @param id
     * @throws Exception.ProveedorException
     */
    @Override
    public void mostrarPanelProveedorEditar(ObjectId id) throws ProveedorException {
        panelCambiante = ProveedoresPantalla.getInstancia(manejadorProveedor).getPanelCambiante();
        ProveedoresPanelEditar proveedorPanelEditar = ProveedoresPanelEditar.getInstance(manejadorProveedor);
        proveedorPanelEditar.actualizarDatos(id);
        mostrarPanel(panelCambiante, proveedorPanelEditar);
    }
    
    /**
     * Muestra el panel para ver los detalles un proveedor ya registrado.
     * @param id
     * @throws Exception.ProveedorException
     */
    @Override
    public void mostrarPanelProveedorDetalles(ObjectId id) throws ProveedorException {
        panelCambiante = ProveedoresPantalla.getInstancia(manejadorProveedor).getPanelCambiante();
        ProveedoresPanelDetalles proveedorPanelDetalles = ProveedoresPanelDetalles.getInstance(manejadorProveedor);
        proveedorPanelDetalles.actualizarDatos(id);
        mostrarPanel(panelCambiante, proveedorPanelDetalles);
    }
//GestionVendedores
    public void mostrarListadoVendedores(){}
    public void mostrarInformacionVendedor(){}
    public void mostrarGenerarInoforme(){}
    public void mostrarRegistroVendedor(){}
    

}
