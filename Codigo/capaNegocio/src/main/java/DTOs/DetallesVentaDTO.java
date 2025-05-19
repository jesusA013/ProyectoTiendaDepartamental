package DTOs;

/**
 *
 * @author Knocmare
 */
public class DetallesVentaDTO {
    private double subtotal;
    private double iva;
    private double total;
    private String formaPago;
    private String metodoPago;

    public DetallesVentaDTO() {
    }

    public DetallesVentaDTO(double subtotal, double iva, double total, String formaPago, String metodoPago) {
        this.subtotal = subtotal;
        this.iva = iva;
        this.total = total;
        this.formaPago = formaPago;
        this.metodoPago = metodoPago;
    }

    public double getSubtotal() {
        return subtotal;
    }

    public void setSubtotal(double subtotal) {
        this.subtotal = subtotal;
    }

    public double getIva() {
        return iva;
    }

    public void setIva(double iva) {
        this.iva = iva;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public String getFormaPago() {
        return formaPago;
    }

    public void setFormaPago(String formaPago) {
        this.formaPago = formaPago;
    }

    public String getMetodoPago() {
        return metodoPago;
    }

    public void setMetodoPago(String metodoPago) {
        this.metodoPago = metodoPago;
    }

    @Override
    public String toString() {
        return "DetallesVenta{" + "subtotal=" + subtotal + ", iva=" + iva + ", total=" + total + ", formaPago=" + formaPago + ", metodoPago=" + metodoPago + '}';
    }
    
}