package Interface;

import DTOs.ProductoDTO;
import DTOs.ProductoVentaDTO;
import DTOs.VentaDTO;
import Interfaces.INavegador;
import RegistroVentaException.RegistroException;
import java.util.List;
import javax.swing.JFrame;

/**
 *
 * @author Ángel Ruíz García - 00000248171
 */
public interface IRegistroVenta {

    String registrarVentaTarjeta(JFrame frame, List<ProductoVentaDTO> productos, String idVendedor, String digitosTarjeta, String fechaExpiracion, String CVC) throws RegistroException;

    String registrarVentaEfectivo(JFrame frame, List<ProductoVentaDTO> productos, String idVendedor, String efectivoEntregado, String cambio) throws RegistroException;

    List<ProductoDTO> buscarProductos(String busqueda) throws RegistroException;

    void facturarVenta(JFrame frame, String id, String rfc,
            String nombeRazonSocial, String calle, String numeroExt,
            String numeroInt, String colonia, String codPostal, String pais,
            String estado, String ciudadLocalidad, String delegacionMunicipio,
            String correo) throws RegistroException;

    VentaDTO buscarVenta(String id) throws RegistroException;

    void setNavegador(INavegador navegador);

}
