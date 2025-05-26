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
    
    /**
     * Registra un proveedor en la base de datos.
     *
     * @param proveedor Proveedor a registrar
     * @return Regresa el proveedor registrado
     * @throws PersistenciaException Excepcion si ocurre un error en el proceso
     */
    Proveedor guardarProveedor(Proveedor proveedor) throws PersistenciaException;
    
    /**
     * Modifica un proveedor de la base de datos.
     *
     * @param proveedor Proveedor a modificar
     * @return Regresa el proveedor modificado
     * @throws PersistenciaException Excepcion si ocurre un error en el proceso
     */
    Proveedor editarProveedor(Proveedor proveedor) throws PersistenciaException;
    
    /**
     * Obtiene un proveedor de la base de datos usando el ID.
     *
     * @param idProveedor ID del proveedor a buscar
     * @return Regresa el proveedor encontrado
     * @throws PersistenciaException Excepcion si ocurre un error en el proceso
     */
    Proveedor obtenerProveedorPorId(String idProveedor) throws PersistenciaException;
    
    /**
     * Obtiene una lista con todos los proveedores de la base de datos.
     *
     * @return Regresa la lista de proveedores encontrada
     * @throws PersistenciaException Excepcion si ocurre un error en el proceso
     */
    List<Proveedor> listaProveedores() throws PersistenciaException;
    
}
