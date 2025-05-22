package DAOs;

import Entidades.Producto;
import Exception.PersistenciaException;
import org.bson.types.ObjectId;
import java.util.List;

/**
 * IProductoDAO.java
 *
 * Interfaz para las operaciones de acceso a datos de productos.
 */
public interface IProductoDAO {

    Producto insertarProducto(Producto producto) throws PersistenciaException;

    Producto buscarPorId(ObjectId id) throws PersistenciaException;

    List<Producto> buscarProductos(String producto) throws PersistenciaException;

    Producto actualizarProducto(Producto producto) throws PersistenciaException;

    Producto eliminarProducto(ObjectId id) throws PersistenciaException;

    List<Producto> buscarTodos() throws PersistenciaException;
}
