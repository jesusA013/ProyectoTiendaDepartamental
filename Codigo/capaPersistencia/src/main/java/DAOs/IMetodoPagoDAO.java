package DAOs;

import Entidades.MetodoPago;
import java.util.List;

/**
 * Interfaz que define las operaciones básicas para acceder a datos de métodos
 * de pago. Esta interfaz actúa como contrato para cualquier implementación de
 * acceso a datos de diferentes tipos de métodos de pago (efectivo, tarjeta,
 * etc.).
 *
 * @author Ángel Ruíz García - 00000248171
 */
public interface IMetodoPagoDAO {

    /**
     * Guarda un nuevo método de pago en la fuente de datos.
     *
     * @param metodoPago Método de pago a guardar.
     * @return Método de pago a guardar.
     */
    MetodoPago guardarMetodoPago(MetodoPago metodoPago);

    /**
     * Obtiene un método de pago por su identificador único.
     *
     * @param id Identificador del método de pago.
     * @return El método de pago correspondiente al ID, o null si no se
     * encuentra.
     */
    MetodoPago obtenerMetodoPagoPorId(int id);

    /**
     * Lista todos los métodos de pago almacenados.
     *
     * @return Una lista de métodos de pago.
     */
    List<MetodoPago> listarTodos();
}
