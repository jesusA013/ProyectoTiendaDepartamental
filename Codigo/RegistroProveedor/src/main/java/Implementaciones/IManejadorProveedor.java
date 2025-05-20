package Implementaciones;

import DTOs.ProveedorDTO;
import Excepciones.ProveedorException;
import Interfaces.INavegador;
import java.util.Date;
import javax.swing.JPanel;
import javax.swing.JTable;
import org.bson.types.ObjectId;

/**
 *
 * @author Ángel Ruíz García - 00000248171
 */
public interface IManejadorProveedor {
    void setNavegador(INavegador navegador);
    
    void configuracionInicialTabla(JTable tablaProveedores);
    
    ObjectId getIdSeleccionadoTabla(JTable tablaProveedores);
    
    void buscarTabla(JTable tablaProveedores);
    
    void registrarProveedor(JPanel panel, String nombreProveedor, 
            String contacto, String telefono, String correo, String direccion, 
            String paginaWeb, String rfc, String formaPago, String terminoPago, 
            String moneda, String estado, String comentarios) throws ProveedorException;
    
    ProveedorDTO obtenerProveedor(ObjectId id) throws ProveedorException;
    
    void editarProveedor(JPanel panel, ObjectId id, String nombreProveedor,
            String contacto, String telefono, String correo, String direccion,
            String paginaWeb, String rfc, String formaPago, String terminoPago,
            String moneda, Date fecha, String estado, String comentarios) throws ProveedorException;
    
//    void limpiarCamposProveedor();
    
    void restaurarCamposEditar(ObjectId id);
    
    void restaurarCamposDetalles(ObjectId id);
    
}
