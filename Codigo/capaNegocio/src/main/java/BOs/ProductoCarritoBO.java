package BOs;

/**
 *
 * @author Knocmare
 */
public class ProductoCarritoBO {
    
    private ProductoBO producto;
    public int cantidad;
    public double importe;

    public ProductoCarritoBO() {
    }

    public ProductoCarritoBO(ProductoBO producto, int cantidad, double importe) {
        this.producto = producto;
        this.cantidad = cantidad;
        this.importe = importe;
    }

    public ProductoBO getProducto() {
        return producto;
    }

    public void setProducto(ProductoBO producto) {
        this.producto = producto;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public double getImporte() {
        return importe;
    }

    public void setImporte(double importe) {
        this.importe = importe;
    }
    
    // ------------------------------------ //
    
    
}
