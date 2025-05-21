package Interface;

import DTOs.ProductoDTO;
import DTOs.ProductoVentaDTO;
import DTOs.VentaDTO;
import Interfaces.INavegador;
import RegistroVentaException.RegistroException;
import java.util.List;
import javax.swing.JFrame;
import org.bson.types.ObjectId;

/**
 *
 * @author Ángel Ruíz García - 00000248171
 */
public interface IRegistroVenta {

    ObjectId registrarVentaTarjeta(JFrame frame, List<ProductoVentaDTO> productos, ObjectId idVendedor, String digitosTarjeta, String fechaExpiracion, String CVC) throws RegistroException;
    
    ObjectId registrarVentaEfectivo(JFrame frame, List<ProductoVentaDTO> productos, ObjectId idVendedor, String efectivoEntregado, String cambio) throws RegistroException;
    
    List<ProductoDTO> buscarProductos(String busqueda) throws RegistroException;
    
    void facturarVenta(JFrame frame, ObjectId id, String rfc, 
            String nombeRazonSocial, String calle, String numeroExt, 
            String numeroInt, String colonia, String codPostal, String pais, 
            String estado, String ciudadLocalidad, String delegacionMunicipio, 
            String correo) throws RegistroException;
    
    VentaDTO buscarVenta(ObjectId id) throws RegistroException;
    
    void setNavegador(INavegador navegador);
    
}
