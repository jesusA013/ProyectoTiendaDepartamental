package Interfaz;

import Entidades.Producto;
import Exception.PersistenciaException;
import java.util.List;

/**
 *
 * @author Knocmare
 */
public interface IProductoDAO {

    Producto insertarProducto(Producto producto) throws PersistenciaException;

    Producto buscarPorId(String id) throws PersistenciaException;

    List<Producto> buscarProductos(String producto) throws PersistenciaException;

    Producto actualizarProducto(Producto producto) throws PersistenciaException;

    Producto eliminarProducto(String id) throws PersistenciaException;

    List<Producto> buscarTodos() throws PersistenciaException;

}
