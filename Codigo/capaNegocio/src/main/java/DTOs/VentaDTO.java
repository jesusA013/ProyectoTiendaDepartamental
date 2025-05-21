package DTOs;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import org.bson.types.ObjectId;

/**
 * VentaDTO.java
 *
 * Esta clase representa una venta realizada en el sistema de objecto de
 * transferencia de datos
 *
 * @author
 */
public class VentaDTO {

    private ObjectId _id;
    private Date fecha;
    private List<ProductoVentaDTO> productos;
    private ObjectId vendedorId;
    private FacturaDTO factura;
    private DetallesVentaDTO detallesVenta;
    
    //idventa, monto de la venta, fecha de la venta????
    
    /**
     * Constructor que inicializa la lista.
     */
    public VentaDTO() {
        this.productos = new ArrayList<>();
    }

    /**
     * Inicializa los atributos al valor de sus parámetros.
     *
     * @param fecha
     * @param productos Lista de productos incluidos en la venta.
     * @param vendedorId
     * @param factura
     * @param detallesVenta
     */
    public VentaDTO(Date fecha, List<ProductoVentaDTO> productos, ObjectId vendedorId, FacturaDTO factura, DetallesVentaDTO detallesVenta) {
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

    public List<ProductoVentaDTO> getProductos() {
        return productos;
    }

    public void setProductos(List<ProductoVentaDTO> productos) {
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

    public FacturaDTO getFactura() {
        return factura;
    }

    public void setFactura(FacturaDTO factura) {
        this.factura = factura;
    }

    public DetallesVentaDTO getDetallesVenta() {
        return detallesVenta;
    }

    public void setDetallesVenta(DetallesVentaDTO detallesVenta) {
        this.detallesVenta = detallesVenta;
    }

    @Override
    public String toString() {
        return "Venta{" + "_id=" + _id + ", fecha=" + fecha + ", productos=" + productos + ", vendedorId=" + vendedorId + ", factura=" + factura + ", detallesVenta=" + detallesVenta + '}';
    }

}
