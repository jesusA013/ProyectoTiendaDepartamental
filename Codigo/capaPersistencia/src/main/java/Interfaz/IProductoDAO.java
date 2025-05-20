package Interfaz;

import Entidades.Producto;
import Exception.PersistenciaException;
import java.util.List;
import org.bson.types.ObjectId;

/**
 *
 * @author Knocmare
 */
public interface IProductoDAO {

    Producto insertarProducto(Producto producto) throws PersistenciaException;

    Producto buscarPorId(ObjectId id) throws PersistenciaException;

    List<Producto> buscarProductos(String producto) throws PersistenciaException;

    Producto actualizarProducto(Producto producto) throws PersistenciaException;

    Producto eliminarProducto(ObjectId id) throws PersistenciaException;

}
