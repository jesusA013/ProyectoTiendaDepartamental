package Interfaz;

import Entidades.Proveedor;
import Exception.PersistenciaException;
import java.util.List;
import org.bson.types.ObjectId;

/**
 * IProveedorDAO.java
 * 
 * Interfaz que define las operaciones básicas para la gestión de proveedores.
 *
 * @author Ángel Ruíz García - 00000248171
 */
public interface IProveedorDAO {
    
    Proveedor guardarProveedor(Proveedor proveedor) throws PersistenciaException;
    
    Proveedor editarProveedor(Proveedor proveedor) throws PersistenciaException;
    
    Proveedor obtenerProveedorPorId(ObjectId idProveedor) throws PersistenciaException;
    
    List<Proveedor> listaProveedores() throws PersistenciaException;
    
}
