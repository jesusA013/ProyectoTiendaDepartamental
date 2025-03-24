package BOs;

/**
 *
 * @author Knocmare
 */
public class ProductoVentaBO {
    
    private int cantidad;
    private double precio;
    private ProductoBO producto;

    public ProductoVentaBO() {
    }

    public ProductoVentaBO(int cantidad, double precio, ProductoBO producto) {
        this.cantidad = cantidad;
        this.precio = precio;
        this.producto = producto;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public ProductoBO getProducto() {
        return producto;
    }

    public void setProducto(ProductoBO producto) {
        this.producto = producto;
    }
    
    // ------------------------------------ //
    
}
