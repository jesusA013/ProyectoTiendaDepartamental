package Interfaces;

import DTOs.ProveedorDTO;
import Entidades.Proveedor;
import java.util.List;

/**
 * Esta clase implementa los metodos que usa ProveedorBO.
 *
 * @author Ángel Ruíz García - 00000248171
 */
public interface IProveedorBO {
    
    ProveedorDTO guardarProveedor(ProveedorDTO proveedorDTO);
    
    ProveedorDTO editarProveedor(ProveedorDTO proveedorDTO);
    
    //ProveedorDTO obtenerProveedorPorId(ObjectId idProveedor);
    
    List<ProveedorDTO> listaProveedor();
    
}
