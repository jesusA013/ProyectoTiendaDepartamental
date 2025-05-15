package DAOs;

import Interfaz.IMetodoPagoDAO;
import Entidades.MetodoPago;
import java.util.ArrayList;
import java.util.List;

/**
 * Implementación del DAO para métodos de pago con tarjeta. Este DAO permite
 * realizar operaciones de persistencia sobre métodos de pago que utilizan
 * tarjetas (crédito o débito).
 *
 * @author Ángel Ruíz García - 00000248171
 */
public class MetodoTarjetaDAO implements IMetodoPagoDAO {

    private List<MetodoPago> pagos = new ArrayList<>();

    /**
     * Guarda un método de pago con tarjeta en la base de datos.
     *
     * @param metodoPago Método de pago con tarjeta.
     * @return Método de pago con tarjeta.
     */
    @Override
    public MetodoPago guardarMetodoPago(MetodoPago metodoPago) {
        pagos.add(metodoPago);
        return metodoPago;
    }

    /**
     * Obtiene un método de pago con tarjeta por su ID.
     *
     * @param id Identificador del método de pago.
     * @return Regresa el método de pago con tarjeta si lo encuentra, no en caso
     * contrario.
     */
    @Override
    public MetodoPago obtenerMetodoPagoPorId(int id) {
        for (MetodoPago pago : pagos) {
            if (pago.getIdPago() == id) return pago;
        }
        return null;
    }

    /**
     * Lista todos los métodos de pago con tarjeta disponibles.
     *
     * @return Lista de los métodos de pago con tarjeta.
     */
    @Override
    public List<MetodoPago> listarTodos() {
        return pagos;
    }
}
