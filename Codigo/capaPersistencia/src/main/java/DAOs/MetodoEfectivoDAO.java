package DAOs;

import Interfaz.IMetodoPagoDAO;
import Entidades.MetodoPago;
import java.util.ArrayList;
import java.util.List;

/**
 * Implementación del DAO para métodos de pago en efectivo. Este DAO permite
 * realizar operaciones de persistencia sobre métodos de pago realizados en
 * efectivo.
 *
 * @author Ángel Ruíz García - 00000248171
 */
public class MetodoEfectivoDAO implements IMetodoPagoDAO {

    private List<MetodoPago> pagos = new ArrayList<>();

    /**
     * Guarda un método de pago en efectivo en la base de datos.
     *
     * @param metodoPago Método de pago en efectivo.
     * @return Método de pago en efectivo.
     */
    @Override
    public MetodoPago guardarMetodoPago(MetodoPago metodoPago) {
        pagos.add(metodoPago);
        return metodoPago;
    }

    /**
     * Obtiene un método de pago en efectivo por su ID.
     *
     * @param id Identificador del método de pago.
     * @return Regresa el método de pago en efectivo si lo encuentra, null en
     * caso contrario.
     */
    @Override
    public MetodoPago obtenerMetodoPagoPorId(int id) {
        for (MetodoPago pago : pagos) {
            if (pago.getIdPago() == id) return pago;
        }
        return null;
    }

    /**
     * Lista todos los métodos de pago en efectivo disponibles.
     *
     * @return Lista de los métodos de pago en efectivo.
     */
    @Override
    public List<MetodoPago> listarTodos() {
        return pagos;
    }
}
