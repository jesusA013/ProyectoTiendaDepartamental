package Interfaz;

import Entidades.Movimiento;
import Exception.PersistenciaException;
import java.util.List;
import org.bson.types.ObjectId;

/**
 * IMovimientoDAO.java
 *
 * Interfaz que define las operaciones para registrar los movimientos de la
 * gestión de inventario.
 *
 * @author Ángel Ruíz García - 00000248171
 */
public interface IMovimientoDAO {
    
    Movimiento registrarMovimiento(Movimiento movimiento) throws PersistenciaException;
    
    Movimiento actualizarMovimiento(Movimiento movimiento) throws PersistenciaException;
    
    Movimiento obtenerMovimientoPorId(ObjectId idMovimiento) throws PersistenciaException;
    
    List<Movimiento> listaMovimientos() throws PersistenciaException;
    
}
