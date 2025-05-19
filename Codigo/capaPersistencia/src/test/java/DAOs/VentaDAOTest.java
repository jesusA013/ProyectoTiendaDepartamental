/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package DAOs;

import Entidades.DetallesVenta;
import Entidades.Factura;
import Entidades.Producto;
import Entidades.ProductoVenta;
import Entidades.Venta;
import Exception.PersistenciaException;
import Interfaz.IConexion;
import Interfaz.IVentasDAO;
import java.util.Arrays;
import java.util.Date;
import org.bson.types.ObjectId;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;

/**
 *
 * @author gaspa
 */
public class VentaDAOTest {
    IConexion Mongo = new Conexion();
    IVentasDAO ventaDAO = new VentasDAO(Mongo.conexion());
    public VentaDAOTest() {
    }
    
    @BeforeEach
    public void setup() {
        Mongo = new Conexion();
        Mongo.conexion().getCollection("Ventas").drop();
        ventaDAO = new VentasDAO(Mongo.conexion());
       
    }
    
    @Test
    public void testInsertarVenta() throws PersistenciaException {
        Producto p = new Producto("Lentes de Sol", "23SAD23", "WER", "Verde");
        ProductoVenta pv = new ProductoVenta(p, 2, 750);
        Factura factura = new Factura("FAC-001", new Date());
        DetallesVenta detalles = new DetallesVenta(1500, 40, 1540, "Transferencia", "Pago en una sola exhibición");

        Venta venta = new Venta();
        venta.setFecha(new Date());
        venta.setProductos(Arrays.asList(pv));
        venta.setVendedorId(new ObjectId());
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
        Venta encontrada = ventaDAO.buscarPorId(insertada.getId());

        assertNotNull(encontrada);
        assertEquals(insertada.getId(), encontrada.getId());
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
        Venta eliminada = ventaDAO.eliminarVenta(insertada.getId());

        assertNotNull(eliminada);
        assertEquals(insertada.getId(), eliminada.getId());

        Venta buscada = ventaDAO.buscarPorId(insertada.getId());
        assertNull(buscada);
    }

    private Venta crearVentaEjemplo() {
        Producto p = new Producto("Casa de Campaña", "AD3V23", "KULE", "Azul");
        ProductoVenta pv = new ProductoVenta(p, 1, 500);
        Factura factura = new Factura("FAC-123", new Date());
        DetallesVenta detalles = new DetallesVenta(500, 80, 580, "Efectivo", "Pago único");

        Venta venta = new Venta();
        venta.setFecha(new Date());
        venta.setProductos(Arrays.asList(pv));
        venta.setVendedorId(new ObjectId());
        venta.setFactura(factura);
        venta.setDetallesVenta(detalles);
        return venta;
    }
    
}
