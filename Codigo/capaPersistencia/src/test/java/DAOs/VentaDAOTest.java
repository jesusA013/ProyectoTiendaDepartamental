package DAOs;

import Entidades.DetallesVenta;
import Entidades.Factura;
import Entidades.Producto;
import Entidades.ProductoVenta;
import Entidades.Venta;
import Exception.PersistenciaException;
import Interfaz.IVentasDAO;
import java.util.Arrays;
import java.util.Date;
import java.util.UUID;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;

/**
 *
 * @author gaspa
 */
public class VentaDAOTest {

    private IVentasDAO ventaDAO;

    @BeforeEach
    public void setup() {
        ventaDAO = new VentasDAO();
    }

    @Test
    public void testInsertarVenta() throws PersistenciaException {
        Producto p = new Producto("Lentes de Sol", "23SAD23", "WER", "Verde");
        ProductoVenta pv = new ProductoVenta(p, 2, 750);
        Factura factura = new Factura("FAC-001", new Date(), "ASDW123987A2S", "Mexico");
        DetallesVenta detalles = new DetallesVenta(1500, 40, 1540, "Tarjeta");

        Venta venta = new Venta();
        venta.setFecha(new Date());
        venta.setProductos(Arrays.asList(pv));
        venta.setVendedorId(UUID.randomUUID().toString());
        venta.setFactura(factura);
        venta.setDetallesVenta(detalles);

        Venta result = ventaDAO.insertarVenta(venta);
        assertNotNull(result);
        assertEquals("FAC-001", result.getFactura().getFolioFactura());
    }

    @Test
    public void testBuscarPorId() throws PersistenciaException {
        Venta venta = crearVentaEjemplo();
        Venta insertada = ventaDAO.insertarVenta(venta);
        Venta encontrada = ventaDAO.buscarPorId(insertada.getIdVenta());

        assertNotNull(encontrada);
        assertEquals(insertada.getIdVenta(), encontrada.getIdVenta());
    }

    @Test
    public void testActualizarVenta() throws PersistenciaException {
        Venta venta = crearVentaEjemplo();
        Venta insertada = ventaDAO.insertarVenta(venta);

        insertada.getFactura().setFolioFactura("FAC-999");
        Venta actualizada = ventaDAO.actualizarVenta(insertada);

        assertEquals("FAC-999", actualizada.getFactura().getFolioFactura());
    }

    @Test
    public void testEliminarVenta() throws PersistenciaException {
        Venta venta = crearVentaEjemplo();
        Venta insertada = ventaDAO.insertarVenta(venta);
        Venta eliminada = ventaDAO.eliminarVenta(insertada.getIdVenta());

        assertNotNull(eliminada);
        assertEquals(insertada.getIdVenta(), eliminada.getIdVenta());

        Venta buscada = ventaDAO.buscarPorId(insertada.getIdVenta());
        assertNull(buscada);
    }

    private Venta crearVentaEjemplo() {
        Producto p = new Producto("Casa de Campaña", "AD3V23", "KULE", "Azul");
        ProductoVenta pv = new ProductoVenta(p, 1, 500);
        Factura factura = new Factura("FAC-123", new Date(), "DCDE573287V4Z", "Argentina");
        DetallesVenta detalles = new DetallesVenta(500, 80, 580, "Efectivo");

        Venta venta = new Venta();
        venta.setFecha(new Date());
        venta.setProductos(Arrays.asList(pv));
        venta.setVendedorId(UUID.randomUUID().toString());
        venta.setFactura(factura);
        venta.setDetallesVenta(detalles);
        return venta;
    }
}
