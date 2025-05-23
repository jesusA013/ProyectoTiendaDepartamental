package Implementaciones;

import DTOs.ProveedorDTO;
import DTOs.ProveedorTablaDTO;
import Excepciones.ProveedorException;
import Interfaces.INavegador;
import java.util.Date;
import java.util.List;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Ángel Ruíz García - 00000248171
 */
public interface IManejadorProveedor {
    
    void setNavegador(INavegador navegador);
    
    DefaultTableModel obtenerModeloTablaProveedores(List<ProveedorTablaDTO> listaProveedores);
    
    List<ProveedorTablaDTO> obtenerDatosParaTabla();
    
    void registrarProveedor(JPanel panel, String nombreProveedor, 
            String contacto, String telefono, String correo, String direccion, 
            String paginaWeb, String rfc, String formaPago, String terminoPago, 
            String moneda, String estado, String comentarios) throws ProveedorException;
    
    ProveedorDTO obtenerProveedor(String id) throws ProveedorException;
    
    void editarProveedor(JPanel panel, String id, String nombreProveedor,
            String contacto, String telefono, String correo, String direccion,
            String paginaWeb, String rfc, String formaPago, String terminoPago,
            String moneda, Date fecha, String estado, String comentarios) throws ProveedorException;
    
//    void limpiarCamposProveedor();
    
//    void restaurarCamposEditar(ObjectId id);
    
//    void restaurarCamposDetalles(ObjectId id);
    
}
