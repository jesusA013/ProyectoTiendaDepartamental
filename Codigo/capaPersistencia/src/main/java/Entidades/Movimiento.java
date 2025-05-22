package Entidades;

import java.util.Date;
import org.bson.types.ObjectId;

/**
 * Movimiento.java
 *
 * Esta clase representa una entidad que son los movimientos en el inventario.
 *
 * @author Ángel Ruíz García - 00000248171
 */
public class Movimiento {

    private ObjectId _id;
    private Date fecha;
    private String idCuenta;
    private String usuarioResponsable;
    private String nombreProducto;
    private String tipoOperacion;
    private int cantidad;
    private String motivo;

    /**
     * Constructor por ausencia
     */
    public Movimiento() {
    }

    public Movimiento(Date fecha, String idCuenta, String usuarioResponsable, String nombreProducto, String tipoOperacion, int cantidad, String motivo) {
        this.fecha = fecha;
        this.idCuenta = idCuenta;
        this.usuarioResponsable = usuarioResponsable;
        this.nombreProducto = nombreProducto;
        this.tipoOperacion = tipoOperacion;
        this.cantidad = cantidad;
        this.motivo = motivo;
    }

    public ObjectId getId() {
        return _id;
    }

    public void setId(ObjectId _id) {
        this._id = _id;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public String getIdCuenta() {
        return idCuenta;
    }

    public void setIdCuenta(String idCuenta) {
        this.idCuenta = idCuenta;
    }

    public String getUsuarioResponsable() {
        return usuarioResponsable;
    }

    public void setUsuarioResponsable(String usuarioResponsable) {
        this.usuarioResponsable = usuarioResponsable;
    }

    public String getNombreProducto() {
        return nombreProducto;
    }

    public void setNombreProducto(String nombreProducto) {
        this.nombreProducto = nombreProducto;
    }

    public String getTipoOperacion() {
        return tipoOperacion;
    }

    public void setTipoOperacion(String tipoOperacion) {
        this.tipoOperacion = tipoOperacion;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public String getMotivo() {
        return motivo;
    }

    public void setMotivo(String motivo) {
        this.motivo = motivo;
    }

    /**
     * Regresa la cadena con todos los datos.
     *
     * @return Cadena con todos los datos
     */
    @Override
    public String toString() {
        return "Movimiento{" + "_id=" + _id + ", fecha=" + fecha + ", idCuenta=" + idCuenta + ", usuarioResponsable=" + usuarioResponsable + ", nombreProducto=" + nombreProducto + ", tipoOperacion=" + tipoOperacion + ", cantidad=" + cantidad + ", motivo=" + motivo + '}';
    }
}
