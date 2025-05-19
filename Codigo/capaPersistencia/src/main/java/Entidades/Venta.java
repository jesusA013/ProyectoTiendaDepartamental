package Entidades;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import org.bson.types.ObjectId;

/**
 * Venta.java
 *
 * Esta clase representa la entidad de venta.
 *
 * @author Knocmare
 */
public class Venta {

    private ObjectId _id;
    private Date fecha;
    private List<ProductoVenta> productos;
    private ObjectId vendedorId;
    private Factura factura;
    private DetallesVenta detallesVenta;

    public Venta() {
        this.productos = new ArrayList<>();
    }

    /**
     * Inicializa los atributos al valor de sus parámetros.
     *
     * @param fecha
     * @param productos
     * @param vendedorId
     * @param factura
     * @param detallesVenta
     */
    public Venta(Date fecha, List<ProductoVenta> productos, ObjectId vendedorId, Factura factura, DetallesVenta detallesVenta) {
        this.fecha = fecha;
        this.productos = productos;
        this.vendedorId = vendedorId;
        this.factura = factura;
        this.detallesVenta = detallesVenta;
    }

    public ObjectId getId() {
        return _id;
    }

    public void setId(ObjectId _id) {
        this._id = _id;
    }

    public List<ProductoVenta> getProductos() {
        return productos;
    }

    public void setProductos(List<ProductoVenta> productos) {
        this.productos = productos;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public ObjectId getVendedorId() {
        return vendedorId;
    }

    public void setVendedorId(ObjectId vendedorId) {
        this.vendedorId = vendedorId;
    }

    public Factura getFactura() {
        return factura;
    }

    public void setFactura(Factura factura) {
        this.factura = factura;
    }

    public DetallesVenta getDetallesVenta() {
        return detallesVenta;
    }

    public void setDetallesVenta(DetallesVenta detallesVenta) {
        this.detallesVenta = detallesVenta;
    }

    @Override
    public String toString() {
        return "Venta{" + "_id=" + _id + ", fecha=" + fecha + ", productos=" + productos + ", vendedorId=" + vendedorId + ", factura=" + factura + ", detallesVenta=" + detallesVenta + '}';
    }

}
