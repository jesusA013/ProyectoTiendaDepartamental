package BOs;

/**
 * ProductoVentaBO.java
 *
 * Esta clase representa los productos que se están vendiendo como parte de una
 * transacción de venta en el objeto de negocio (BO).
 *
 * @author
 */
public class ProductoVentaBO {

    private int cantidad;
    private double precio;
    private ProductoBO producto;

    /**
     * Constructor por omision
     */
    public ProductoVentaBO() {
    }

    /**
     * Constructor del producto que se está vendiendo de objecto negocio
     *
     * @param cantidad Cantidad de productos vendidos.
     * @param precio Precio unitario del producto.
     * @param producto Producto asociado a la venta.
     */
    public ProductoVentaBO(int cantidad, double precio, ProductoBO producto) {
        this.cantidad = cantidad;
        this.precio = precio;
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
     * @param cantidad Nueva cantidad de productos vendidos.
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
     * @param precio Nuevo precio unitario del producto.
     */
    public void setPrecio(double precio) {
        this.precio = precio;
    }

    /**
     * Obtiene el producto asociado a la venta.
     *
     * @return Producto asociado a la venta.
     */
    public ProductoBO getProducto() {
        return producto;
    }

    /**
     * Establece el producto asociado a la venta.
     *
     * @param producto Nuevo producto asociado a la venta.
     */
    public void setProducto(ProductoBO producto) {
        this.producto = producto;
    }

    // ------------------------------------ //
}
