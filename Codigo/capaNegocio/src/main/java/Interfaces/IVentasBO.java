package Interfaces;

import DTOs.VentaDTO;
import Excepciones.NegocioException;
import java.util.List;
import org.bson.types.ObjectId;

/**
 *
 * @author Knocmare
 */
public interface IVentasBO {

    VentaDTO insertarVenta(VentaDTO ventaDTO) throws NegocioException;

    VentaDTO buscarPorId(ObjectId id) throws NegocioException;

    VentaDTO actualizarVenta(VentaDTO ventaDTO) throws NegocioException;

    VentaDTO eliminarVenta(ObjectId id) throws NegocioException;
    
    List<VentaDTO> obtenerVentas(ObjectId idVendedor) throws NegocioException;
}
