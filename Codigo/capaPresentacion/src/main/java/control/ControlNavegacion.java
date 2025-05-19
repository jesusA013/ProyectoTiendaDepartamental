package control;

/**
 *
 * @author Jesus
 */
import Exception.ProveedorException;
import ModuloVenta.FacturaDatos;
import ModuloVenta.GraciasPorSuCompra;
import ModuloVenta.SeleccionMetodoPago;
import ModuloVenta.BusquedaProducto;
import ModuloVenta.CarritoCompra;
import Inicio.InicioSesion;
import Inicio.MenuPrincipal;
import Implementaciones.*;
import Interface.IRegistroVenta;
import ManejadorVenta.ManejadorVenta;
import ModuloAlmacen.GestionProveedores.*;
import ModuloAlmacen.MenuAlmacen;
import gestionVendedores.*;
import java.awt.BorderLayout;
import javax.swing.*;
import org.bson.types.ObjectId;

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
    // Gestión Venta
    private final IRegistroVenta manejadorVenta;
    

    //Creacion de cada pantalla
    public ControlNavegacion() {
        this.pantallaInicioSesion = new InicioSesion();
        this.pantallaMenuPrincipal = new MenuPrincipal();
        // Gestión Venta
        this.manejadorVenta = new ManejadorVenta();
        this.pantallaCarritoCompra = new CarritoCompra(manejadorVenta);
        this.pantallaFactura = new FacturaDatos();
        this.pantallaBusquedaProducto = new BusquedaProducto();
        this.pantallaSeleccionMetodoPago = new SeleccionMetodoPago();
        this.pantallaGraciasCompra= new GraciasPorSuCompra();
        // Gestión Proveedores
        this.manejadorProveedor = new ManejadorProveedor();
        this.pantallaProveedores = ProveedoresPantalla.getInstancia(manejadorProveedor);
        this.pantallaAlmacen = new MenuAlmacen();
        //Gestion Vendedores
//        this.pantallaRegistraVendedor= new;
//        this.pantallaListadoVendedores;
//        this.panatallaInformacionVendedor;
//        this.pantallaGeneraInforme=;
        this.proveedorPanelListado = ProveedoresPanelListado.getInstance(manejadorProveedor);
        this.proveedorPanelNuevo = ProveedoresPanelNuevo.getInstance(manejadorProveedor);
        this.proveedorPanelEditar = ProveedoresPanelEditar.getInstance(manejadorProveedor);
        this.proveedorPanelDetalles = ProveedoresPanelDetalles.getInstance(manejadorProveedor);
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
        mostrarPanel(panelCambiante, new ProveedoresPanelListado(manejadorProveedor));

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
