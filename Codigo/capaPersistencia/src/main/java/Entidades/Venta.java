package Entidades;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Venta.java
 *
 * Esta clase representa la entidad de venta.
 *
 * @author Knocmare
 */
public class Venta {

    private String idVenta;
    private Date fecha;
    private List<ProductoVenta> productos;
    private String vendedorId;
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
    public Venta(Date fecha, List<ProductoVenta> productos, String vendedorId, Factura factura, DetallesVenta detallesVenta) {
        this.fecha = fecha;
        this.productos = productos;
        this.vendedorId = vendedorId;
        this.factura = factura;
        this.detallesVenta = detallesVenta;
    }

    public String getIdVenta() {
        return idVenta;
    }

    public void setIdVenta(String idVenta) {
        this.idVenta = idVenta;
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

    public String getVendedorId() {
        return vendedorId;
    }

    public void setVendedorId(String vendedorId) {
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
        return "Venta{" + "idVenta=" + idVenta + ", fecha=" + fecha + ", productos=" + productos + ", vendedorId=" + vendedorId + ", factura=" + factura + ", detallesVenta=" + detallesVenta + '}';
    }

}
