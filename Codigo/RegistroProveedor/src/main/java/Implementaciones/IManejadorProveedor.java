package Implementaciones;

import DTOs.ProveedorDTO;
import Exception.ProveedorException;
import javax.swing.JTable;
import org.bson.types.ObjectId;

/**
 *
 * @author Ángel Ruíz García - 00000248171
 */
public interface IManejadorProveedor {
    
    void configuracionInicialTabla(JTable tablaProveedores);
    
    ObjectId getIdSeleccionadoTabla(JTable tablaProveedores);
    
    void buscarTabla(JTable tablaProveedores);
    
    ProveedorDTO registrarProveedor(ProveedorDTO proveedorDTO) throws ProveedorException;
    
    ProveedorDTO obtenerProveedor(ObjectId id) throws ProveedorException;
    
    ProveedorDTO editarProveedor(ProveedorDTO proveedorDTO) throws ProveedorException;
    
    void restaurarCampos();
    
}
