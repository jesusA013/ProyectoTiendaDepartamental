package DTOs;

/**
 * ProductoVentaDTO.java
 *
 * Esta clase representa los productos que se están vendiendo como parte de una
 * transacción de venta en el objeto de transferencia (DTO).
 * 
 * @author
 */
public class ProductoVentaDTO {

    private int cantidad;
    private double precio;
    private double importe;
    private ProductoDTO producto;

    /**
     * Constructor por omision
     */
    public ProductoVentaDTO() {
    }

    /**
     * Constructor del producto que se está vendiendo de objeto de transferencia
     * de datos
     *
     * @param cantidad Cantidad de productos vendidos
     * @param precio Precio unitario del producto
     * @param importe Importe del producto
     * @param producto Producto asociado a la venta
     */
    public ProductoVentaDTO(int cantidad, double precio, double importe, ProductoDTO producto) {
        this.cantidad = cantidad;
        this.precio = precio;
        this.importe = importe;
        this.producto = producto;
    }
    
    /**
     * Obtiene la cantidad de productos vendidos.
     *
     * @return Cantidad de productos vendidos.
     */
    public int getCantidad() {
        return cantidad;
    }

    /**
     * Establece la cantidad de productos vendidos.
     *
     * @param cantidad Cantidad de productos vendidos.
     */
    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    /**
     * Obtiene el precio unitario del producto.
     *
     * @return Precio unitario del producto.
     */
    public double getPrecio() {
        return precio;
    }

    /**
     * Establece el precio unitario del producto.
     *
     * @param precio Precio unitario del producto.
     */
    public void setPrecio(double precio) {
        this.precio = precio;
    }

    /**
     * Obtiene el importe total del producto.
     *
     * @return Importe total del producto (cantidad * precio).
     */
    public double getImporte() {
        return importe;
    }

    /**
     * Establece el importe total del producto.
     *
     * @param importe Importe total del producto (cantidad * precio).
     */
    public void setImporte(double importe) {
        this.importe = importe;
    }

    /**
     * Obtiene el producto asociado a la venta.
     *
     * @return Producto asociado a la venta.
     */
    public ProductoDTO getProducto() {
        return producto;
    }

    /**
     * Establece el producto asociado a la venta.
     *
     * @param producto Producto asociado a la venta.
     */
    public void setProducto(ProductoDTO producto) {
        this.producto = producto;
    }
    
    
    
}
