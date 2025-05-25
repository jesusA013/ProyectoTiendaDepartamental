package Interfaces;

import DTOs.VentaDTO;
import Excepciones.NegocioException;
import java.util.List;

/**
 *
 * @author Ángel Ruíz García - 00000248171
 */
public interface IVentasBO {

    VentaDTO insertarVenta(VentaDTO ventaDTO) throws NegocioException;

    VentaDTO buscarPorId(String id) throws NegocioException;

    VentaDTO actualizarVenta(VentaDTO ventaDTO) throws NegocioException;

    VentaDTO eliminarVenta(String id) throws NegocioException;

    List<VentaDTO> obtenerVentas(String idVendedor) throws NegocioException;
}
