/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package DAOs;

import Entidades.Producto;
import Interfaz.IConexion;
import Interfaz.IProductoDAO;
import Interfaz.IVendedorDAO;
import org.bson.types.ObjectId;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;

/**
 *
 * @author gaspa
 */
public class ProductoDAOTest {
    IConexion Mongo = new Conexion();
    IProductoDAO productoDAO = new ProductoDAO(Mongo.conexion());
    public ProductoDAOTest() {
    }
    
    @BeforeEach
    public void setup() {
        Mongo = new Conexion();
        Mongo.conexion().getCollection("Productos").drop();
        productoDAO = new ProductoDAO(Mongo.conexion());
       
    }
    
    @Test
    void testInsertarProducto() {
        Producto producto = crearProductoEjemplo();
        Producto insertado = productoDAO.insertarProducto(producto);

        assertNotNull(insertado);
        assertNotNull(insertado.getId());
        assertEquals("Teclado Gamer RGB", insertado.getNombre());
    }

    @Test
    void testBuscarPorId() {
        Producto producto = productoDAO.insertarProducto(crearProductoEjemplo());
        Producto buscado = productoDAO.buscarPorId(producto.getId());

        assertNotNull(buscado);
        assertEquals(producto.getNombre(), buscado.getNombre());
    }

    @Test
    void testActualizarProducto() {
        Producto producto = productoDAO.insertarProducto(crearProductoEjemplo());
        producto.setNombre("Teclado Mecánico Azul");
        Producto actualizado = productoDAO.actualizarProducto(producto);

        assertNotNull(actualizado);
        assertEquals("Teclado Mecánico Azul", actualizado.getNombre());
    }

    @Test
    void testEliminarProducto() {
        Producto producto = productoDAO.insertarProducto(crearProductoEjemplo());
        Producto eliminado = productoDAO.eliminarProducto(producto.getId());

        assertNotNull(eliminado);
        assertEquals(producto.getId(), eliminado.getId());
        assertNull(productoDAO.buscarPorId(producto.getId()));
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
        producto.setProveedorId(new ObjectId()); 
        return producto;
    }
    
}
