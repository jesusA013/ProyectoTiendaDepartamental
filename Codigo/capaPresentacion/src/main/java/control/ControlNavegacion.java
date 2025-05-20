package control;

/**
 *
 * @author Jesus
 */
import Excepciones.ProveedorException;
import ModuloVenta.FacturaDatos;
import ModuloVenta.GraciasPorSuCompra;
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
    private CarritoCompra pantallaCarritoCompra;
    private FacturaDatos pantallaFactura;
    private BusquedaProducto pantallaBusquedaProducto;
    private SeleccionMetodoPago pantallaSeleccionMetodoPago;
    private GraciasPorSuCompra pantallaGraciasCompra;
    // Gestión Proveedores
    private final IManejadorProveedor manejadorProveedor;
    private JPanel panelCambiante;
    private final ProveedoresPantalla pantallaProveedores;
    private final MenuAlmacen pantallaAlmacen;
    //Gestion Vendedores
    private GenerarInforme pantallaGeneraInforme;
    private InformacionVendedor panatallaInformacionVendedor;
    private ListadoVendedores pantallaListadoVendedores;
    private RegistrarVendedor pantallaRegistraVendedor;
    private final ProveedoresPanelListado proveedorPanelListado;
    private final ProveedoresPanelNuevo proveedorPanelNuevo;
    private final ProveedoresPanelEditar proveedorPanelEditar;
    private final ProveedoresPanelDetalles proveedorPanelDetalles;
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
        this.pantallaCarritoCompra = new CarritoCompra(manejadorVenta);
        this.pantallaFactura = new FacturaDatos();
        this.pantallaBusquedaProducto = new BusquedaProducto(manejadorVenta);
        this.pantallaSeleccionMetodoPago = new SeleccionMetodoPago(manejadorVenta);
        this.pantallaGraciasCompra= new GraciasPorSuCompra(manejadorVenta);
        // Gestión Proveedores
        this.manejadorProveedor = new ManejadorProveedor();
        this.pantallaProveedores = ProveedoresPantalla.getInstancia(manejadorProveedor);
        manejadorProveedor.setNavegador(this);
        this.pantallaAlmacen = new MenuAlmacen();
        this.proveedorPanelListado = ProveedoresPanelListado.getInstance(manejadorProveedor);
        this.proveedorPanelNuevo = ProveedoresPanelNuevo.getInstance(manejadorProveedor);
        this.proveedorPanelEditar = ProveedoresPanelEditar.getInstance(manejadorProveedor);
        this.proveedorPanelDetalles = ProveedoresPanelDetalles.getInstance(manejadorProveedor);
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
        mostrarPantalla(pantallaCarritoCompra);
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
    public void mostrarMenuAdministrador() {
        mostrarPantalla(pantallaAdministradorMenu);
    }
    
    // Gestión Proveedores
    /**
     * Muestra la pantalla de proveedores con la lista.
     */
    public void mostrarFormListaProveedores() {
        // Panel Listado
        mostrarPanelProveedoresLista();
        mostrarPantalla(pantallaProveedores);
    }

    /**
     * Muestra el panel con la lista de proveedores.
     */
    public void mostrarPanelProveedoresLista() {
        // Panel Listado
        panelCambiante = ProveedoresPantalla.getInstancia(manejadorProveedor).getPanelCambiante();
        JTable tablaProveedores = proveedorPanelListado.getTablaProveedores();
        manejadorProveedor.configuracionInicialTabla(tablaProveedores);
        manejadorProveedor.buscarTabla(tablaProveedores);
        mostrarPanel(panelCambiante, proveedorPanelListado);

    }
    
    /**
     * Muestra el panel para registrar un proveedor.
     */
    public void mostrarPanelProveedorNuevo() {
        panelCambiante = ProveedoresPantalla.getInstancia(manejadorProveedor).getPanelCambiante();
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
        proveedorPanelDetalles.actualizarDatos(id);
        mostrarPanel(panelCambiante, proveedorPanelDetalles);
    }
//GestionVendedores
    public void mostrarListadoVendedores(){}
    public void mostrarInformacionVendedor(){}
    public void mostrarGenerarInoforme(){}
    public void mostrarRegistroVendedor(){}
    

}
