package DAOs;

import Entidades.Producto;
import Exception.PersistenciaException;
import Interfaz.IProductoDAO;
import java.util.UUID;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author Ángel Ruíz García - 00000248171
 */
public class ProductoDAOTest {

    private IProductoDAO productoDAO;

    @BeforeEach
    public void setup() {
        // Usa la versión en memoria de ProductoDAO
        productoDAO = new ProductoDAO(); // Sin pasar conexión
    }

    @Test
    void testInsertarProducto() throws PersistenciaException {
        Producto producto = crearProductoEjemplo();
        Producto insertado = productoDAO.insertarProducto(producto);

        assertNotNull(insertado);
        assertNotNull(insertado.getIdProducto());
        assertEquals("Teclado Gamer RGB", insertado.getNombre());
    }

    @Test
    void testBuscarPorId() throws PersistenciaException {
        Producto producto = productoDAO.insertarProducto(crearProductoEjemplo());
        Producto buscado = productoDAO.buscarPorId(producto.getIdProducto());

        assertNotNull(buscado);
        assertEquals(producto.getNombre(), buscado.getNombre());
    }

    @Test
    void testActualizarProducto() throws PersistenciaException {
        Producto producto = productoDAO.insertarProducto(crearProductoEjemplo());
        producto.setNombre("Teclado Mecánico Azul");
        Producto actualizado = productoDAO.actualizarProducto(producto);

        assertNotNull(actualizado);
        assertEquals("Teclado Mecánico Azul", actualizado.getNombre());
    }

    @Test
    void testEliminarProducto() throws PersistenciaException {
        Producto producto = productoDAO.insertarProducto(crearProductoEjemplo());
        Producto eliminado = productoDAO.eliminarProducto(producto.getIdProducto());

        assertNotNull(eliminado);
        assertEquals(producto.getIdProducto(), eliminado.getIdProducto());
        assertNull(productoDAO.buscarPorId(producto.getIdProducto()));
    }

    private Producto crearProductoEjemplo() {
        Producto producto = new Producto();
        producto.setCodigo("PROD001");
        producto.setNombre("Teclado Gamer RGB");
        producto.setSKU("066236");
        producto.setMarca("Asus");
        producto.setColor("Rojo");
        producto.setPrecio(750.00);
        producto.setStock(10);
        producto.setDescripcion("Teclado diseñado para videojuegos");
        producto.setProveedorId(UUID.randomUUID().toString()); // Simula proveedor
        return producto;
    }

}
