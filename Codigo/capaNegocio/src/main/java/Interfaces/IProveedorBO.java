package Interfaces;

import DTOs.ProveedorDTO;
import DTOs.ProveedorTablaDTO;
import Excepciones.NegocioException;
import java.util.List;

/**
 * IProveedorDAO.java
 * 
 * Esta clase implementa los metodos que usa ProveedorBO.
 *
 * @author Ángel Ruíz García - 00000248171
 */
public interface IProveedorBO {
    
    /**
     * Se encarga de llamar a la DAO para guardar el proveedor.
     *
     * @param proveedorDTO Proveedor a guardar
     * @return Regresa el proveedor guardado
     * @throws NegocioException Si ocurre algun error en el proceso
     */
    ProveedorDTO guardarProveedor(ProveedorDTO proveedorDTO) throws NegocioException;
    
    /**
     * Se encarga de llamar a la DAO para modificar el proveedor.
     *
     * @param proveedorDTO Proveedor a modificar
     * @return Regresa el proveedor modificado
     * @throws NegocioException Si ocurre algun error en el proceso
     */
    ProveedorDTO editarProveedor(ProveedorDTO proveedorDTO) throws NegocioException;
    
    /**
     * Se encarga de llamar a la DAO para buscar un proveedor por su ID.
     *
     * @param idProveedor ID del proveedor a buscar
     * @return Regresa el proveedor encontrado
     * @throws NegocioException Excepcion si ocurre un error en el proceso
     */
    ProveedorDTO obtenerProveedorPorId(String idProveedor) throws NegocioException;
    
    /**
     * Se encarga de llamar a la DAO para buscar a todos los proveedores.
     *
     * @return Regresa la lista de todos los proveedores
     * @throws NegocioException Excepcion si ocurre un error en el proceso
     */
    List<ProveedorTablaDTO> obtenerListaProveedores() throws NegocioException;
    
}
