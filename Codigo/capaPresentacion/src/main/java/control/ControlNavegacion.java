package control;

/**
 *
 * @author Jesus
 */
import Implementaciones.*;
import ModuloAlmacen.GestionProveedores.*;
import interfaces.*;
import javax.swing.*;

public class ControlNavegacion {

    private static ControlNavegacion instancia;

    private JFrame pantallaActual;

    //Instancias unicas de cada pantalla
    private InicioSesion pantallaInicioSesion;
    private MenuPrincipal pantallaMenuPrincipal;
    private CarritoCompra pantallaCarritoCompra;
    private FacturaDatos pantallaFactura;
    private BusquedaProducto pantallaBusquedaProducto;
    private SeleccionMetodoPago pantallaSeleccionMetodoPago;
    private GraciasPorSuCompra pantallaGraciasCompra;
    // Gestion Proveedores
    private final IManejadorProveedor manejadorProveedor;
    private ListaProveedores pantallaListaProveedores;

    //Creacion de cada pantalla
    public ControlNavegacion() {
        this.pantallaInicioSesion = new InicioSesion();
        this.pantallaMenuPrincipal = new MenuPrincipal();
        this.pantallaCarritoCompra = new CarritoCompra();
        this.pantallaFactura = new FacturaDatos();
        this.pantallaBusquedaProducto = new BusquedaProducto();
        this.pantallaSeleccionMetodoPago = new SeleccionMetodoPago();
        this.pantallaGraciasCompra= new GraciasPorSuCompra();
        //
        this.pantallaListaProveedores = ListaProveedores.getInstancia();
        this.manejadorProveedor = new ManejadorProveedor();
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
    public void mostrarFormListaProveedores() {
        if (manejadorProveedor != null) {
            // Configuras la tabla (botones)
            manejadorProveedor.configuracionInicialTabla();

            // Actualizas los datos
            manejadorProveedor.buscarTabla();
        }

        mostrarPantalla(pantallaListaProveedores);
    }

}
