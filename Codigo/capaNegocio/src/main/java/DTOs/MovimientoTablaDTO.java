package DTOs;

import org.bson.types.ObjectId;

/**
 * MovimientoTablaDTO.java
 *
 * Representa un objeto de transferencia de datos (DTO) que contiene los datos
 * que usaran en la table de movimientos.
 *
 * @author Ángel Ruíz García - 00000248171
 */
public class MovimientoTablaDTO {

    private final ObjectId _id;
    private final String codigoProducto;
    private final String tipoMovimiento;
    private final int cantidad;

    public MovimientoTablaDTO(ObjectId _id, String codigoProducto, String tipoMovimiento, int cantidad) {
        this._id = _id;
        this.codigoProducto = codigoProducto;
        this.tipoMovimiento = tipoMovimiento;
        this.cantidad = cantidad;
    }

    public ObjectId getId() {
        return _id;
    }

    public String getCodigoProducto() {
        return codigoProducto;
    }

    public String getTipoMovimiento() {
        return tipoMovimiento;
    }

    public int getCantidad() {
        return cantidad;
    }
}
