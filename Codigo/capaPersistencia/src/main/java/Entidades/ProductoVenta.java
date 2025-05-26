package Entidades;

/**
 * ProductoVenta.java
 *
 *
 *
 * @author Angel Ryuiz y Angel Beltran en la 2da Version
 */
public class ProductoVenta {

    private String idProductoVenta;
    private Producto producto;
    private int cantidad;
    private double precioUnitario;

    public ProductoVenta() {
    }

    public ProductoVenta(Producto producto, int cantidad, double precioUnitario) {
        this.producto = producto;
        this.cantidad = cantidad;
        this.precioUnitario = precioUnitario;
    }

    public String getIdProductoVenta() {
        return idProductoVenta;
    }

    public void setIdProductoVenta(String idProductoVenta) {
        this.idProductoVenta = idProductoVenta;
    }

    public Producto getProducto() {
        return producto;
    }

    public void setProducto(Producto producto) {
        this.producto = producto;
    }

    public double getPrecioUnitario() {
        return precioUnitario;
    }

    public void setPrecioUnitario(double precioUnitario) {
        this.precioUnitario = precioUnitario;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    @Override
    public String toString() {
        return "ProductoVenta{" + "idProductoVenta=" + idProductoVenta + ", producto=" + producto + ", cantidad=" + cantidad + ", precioUnitario=" + precioUnitario + '}';
    }

}
