package DTOs;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * VentaDTO.java
 *
 * Esta clase representa una venta realizada en el sistema de objecto de
 * transferencia de datos
 *
 * @author Ángel Ruíz García - 00000248171
 */
public class VentaDTO {

    private String idVenta;
    private Date fecha;
    private List<ProductoVentaDTO> productos;
    private String idVendedor;
    private FacturaDTO factura;
    private DetallesVentaDTO detallesVenta;

    /**
     * Constructor que inicializa la lista.
     */
    public VentaDTO() {
        this.productos = new ArrayList<>();
    }
    /**
     * Inicializa los atributos al valor de sus parámetros.
     *
     * @param idVenta
     * @param fecha
     * @param productos Lista de productos incluidos en la venta.
     * @param idVendedor
     * @param factura
     * @param detallesVenta
     */
    public VentaDTO(String idVenta, Date fecha, List<ProductoVentaDTO> productos, String idVendedor, FacturaDTO factura, DetallesVentaDTO detallesVenta) {
        this.idVenta = idVenta;
        this.fecha = fecha;
        this.productos = productos;
        this.idVendedor = idVendedor;
        this.factura = factura;
        this.detallesVenta = detallesVenta;
    }

    public String getIdVenta() {
        return idVenta;
    }

    public void setIdVenta(String idVenta) {
        this.idVenta = idVenta;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public List<ProductoVentaDTO> getProductos() {
        return productos;
    }

    public void setProductos(List<ProductoVentaDTO> productos) {
        this.productos = productos;
    }

    public String getIdVendedor() {
        return idVendedor;
    }

    public void setIdVendedor(String idVendedor) {
        this.idVendedor = idVendedor;
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
        return "VentaDTO{" + "idVenta=" + idVenta + ", fecha=" + fecha + ", productos=" + productos + ", idVendedor=" + idVendedor + ", factura=" + factura + ", detallesVenta=" + detallesVenta + '}';
    }


   


}
