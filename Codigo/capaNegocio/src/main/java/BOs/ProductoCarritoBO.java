package BOs;

import Interfaces.IBO;

/**
 * ProductoCarritoBO.java
 *
 * Esta clase representa los productos del carrito de objecto negocio
 *actua como un intermediario entre los productos seleccionados y el proceso de compra
 * @author 
 */
public class ProductoCarritoBO implements IBO {

    private ProductoBO producto;
    private int cantidad;
    private double importe;
    private double precio;

    /**
     * Constructor por omision
     */
    public ProductoCarritoBO() {
    }

    /**
     * Constructor de los productos del carrito de objecto negocio
     *
     * @param producto Producto del carrito
     * @param cantidad Cantidad del mismo producto
     * @param importe Importe del producto
     * @param precio el precio del producto
     */
    public ProductoCarritoBO(ProductoBO producto, int cantidad, double importe, double precio) {
        this.producto = producto;
        this.cantidad = cantidad;
        this.importe = cantidad*producto.getPrecio();
        this.precio= precio;
    }

    /**
     * Regresa el producto del carrito
     *
     * @return Producto del carrito
     */
    public ProductoBO getProducto() {
        return producto;
    }

    /**
     * Establece el producto del carrito
     *
     * @param producto Producto del carrito
     */
    public void setProducto(ProductoBO producto) {
        this.producto = producto;
    }

    /**
     * Regresa la cantidad del mismo producto
     *
     * @return Cantidad del mismo producto
     */
    public int getCantidad() {
        return cantidad;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    /**
     * Establece la cantidad del mismo producto
     *
     * @param cantidad Cantidad del mismo producto
     */
    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    /**
     * Regresa el importe del producto
     *
     * @return Importe del producto
     */
    public double getImporte() {
        return importe;
    }

    /**
     * Establece el importe del producto
     *
     * @param importe Importe del producto
     */
    public void setImporte(double importe) {
        this.importe = importe;
    }
public void actualizarCantidad(int nuevaCantidad) {
    if (nuevaCantidad <= 0) {
        throw new IllegalArgumentException("La cantidad debe ser mayor que cero.");
    }
    this.cantidad = nuevaCantidad;
    this.importe = nuevaCantidad * this.producto.getPrecio();
}
    // ------------------------------------ //
}
