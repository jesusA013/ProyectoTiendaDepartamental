package Entidades;

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

    private ObjectId id;
    private Date fecha;
    private List<ProductoVendido> productos;
    private ObjectId vendedorId;
    private Factura factura;
    private DetallesVenta detallesVenta;

    public Venta() {
    }

    public Venta(Date fecha, List<ProductoVendido> productos, ObjectId vendedorId, Factura factura, DetallesVenta detallesVenta) {
        this.fecha = fecha;
        this.productos = productos;
        this.vendedorId = vendedorId;
        this.factura = factura;
        this.detallesVenta = detallesVenta;
    }

    public Venta(Date fecha, List<ProductoVendido> productos, ObjectId vendedorId, DetallesVenta detallesVenta) {
        this.fecha = fecha;
        this.productos = productos;
        this.vendedorId = vendedorId;
        this.detallesVenta = detallesVenta;
    }

    public ObjectId getId() {
        return id;
    }

    public void setId(ObjectId id) {
        this.id = id;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public List<ProductoVendido> getProductos() {
        return productos;
    }

    public void setProductos(List<ProductoVendido> productos) {
        this.productos = productos;
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
        return "Venta{" + "id=" + id + ", fecha=" + fecha + ", productos=" + productos + ", vendedorId=" + vendedorId + ", factura=" + factura + ", detallesVenta=" + detallesVenta + '}';
    }

    

}
