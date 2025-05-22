package Interfaces;

import DTOs.MovimientoDTO;
import DTOs.MovimientoTablaDTO;
import Excepciones.NegocioException;
import java.util.List;
import org.bson.types.ObjectId;

/**
 * IMovimientoBO.java
 * 
 * Esta clase objectos negocio actua como intermediario con la DAO de
 * Movimientos.
 * 
 * @author Ángel Ruíz García - 00000248171
 */
public interface IMovimientoBO {
    
    MovimientoDTO registrarMovimiento(MovimientoDTO movimientoDTO) throws NegocioException;
    
    MovimientoDTO actualizarMovimiento(MovimientoDTO movimientoDTO) throws NegocioException;
    
    MovimientoDTO obtenerMovimientoPorId(ObjectId idMovimiento) throws NegocioException;
    
    List<MovimientoDTO> obtenerListaMovimientos() throws NegocioException;
    
    List<MovimientoTablaDTO> obtenerTablaMovimientos() throws NegocioException;
    
}
