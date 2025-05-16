package Interfaz;

import Entidades.Proveedor;
import java.util.List;
import org.bson.types.ObjectId;

/**
 * Interfaz que define las operaciones básicas para la gestión de proveedores.
 *
 * @author Ángel Ruíz García - 00000248171
 */
public interface IProveedorDAO {
    
    Proveedor guardarProveedor(Proveedor proveedor);
    
    Proveedor editarProveedor(Proveedor proveedor);
    
    Proveedor obtenerProveedorPorId(ObjectId idProveedor);
    
    List<Proveedor> listaProveedor();
    
}
