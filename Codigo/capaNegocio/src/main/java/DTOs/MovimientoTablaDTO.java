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
    private final String nombreProducto;
    private final String tipoMovimiento;
    private final int cantidad;

    public MovimientoTablaDTO(ObjectId _id, String nombreProducto, String tipoMovimiento, int cantidad) {
        this._id = _id;
        this.nombreProducto = nombreProducto;
        this.tipoMovimiento = tipoMovimiento;
        this.cantidad = cantidad;
    }

    public ObjectId getId() {
        return _id;
    }

    public String getNombreProducto() {
        return nombreProducto;
    }

    public String getTipoMovimiento() {
        return tipoMovimiento;
    }

    public int getCantidad() {
        return cantidad;
    }
}
