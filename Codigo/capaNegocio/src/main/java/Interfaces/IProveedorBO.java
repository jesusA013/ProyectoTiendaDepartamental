package Interfaces;

import DTOs.ProveedorDTO;
import DTOs.ProveedorTablaDTO;
import Excepciones.NegocioException;
import java.util.List;
import org.bson.types.ObjectId;

/**
 * IProveedorDAO.java
 * 
 * Esta clase implementa los metodos que usa ProveedorBO.
 *
 * @author Ángel Ruíz García - 00000248171
 */
public interface IProveedorBO {
    
    ProveedorDTO guardarProveedor(ProveedorDTO proveedorDTO) throws NegocioException;
    
    ProveedorDTO editarProveedor(ProveedorDTO proveedorDTO) throws NegocioException;
    
    ProveedorDTO obtenerProveedorPorId(ObjectId idProveedor) throws NegocioException;
    
    List<ProveedorTablaDTO> obtenerListaProveedores() throws NegocioException;
    
}
