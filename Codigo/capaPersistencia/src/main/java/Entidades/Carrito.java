package Entidades;

import java.util.List;

/**
 * Carrito.java
 *
 * Esta clase representa la entidad de un carrito.
 *
 * @author Knocmare
 */
public class Carrito {

    private int idCarrito;
    private List<ProductoVenta> carrito;
    private int cantidadProductos;
    private double subtotal;
    private double total;
    private double impuesto;

    /**
     * Constructor por ausencia
     */
    public Carrito() {
    }

    /**
     * Constructor de un carrito.
     *
     * @param carrito Lista de productos tipo venta del carrito.
     * @param cantidadProductos Cantidad de productos
     * @param subtotal Subtotal de todos los productos
     * @param total Total de todos los productos
     * @param impuesto Impuesto por todos los productos
     */
    public Carrito(List<ProductoVenta> carrito, int cantidadProductos, double subtotal, double total, double impuesto) {
        this.carrito = carrito;
        this.cantidadProductos = cantidadProductos;
        this.subtotal = subtotal;
        this.total = total;
        this.impuesto = impuesto;
    }

    /**
     * Regresa el ID del carrito.
     *
     * @return ID del carrito
     */
    public int getIdCarrito() {
        return idCarrito;
    }

    /**
     * Establece el ID del carrito.
     *
     * @param idCarrito ID del carrito
     */
    public void setIdCarrito(int idCarrito) {
        this.idCarrito = idCarrito;
    }

    /**
     * Regresa la lista de productos tipo venta del carrito.
     *
     * @return Lista de productos tipo venta del carrito
     */
    public List<ProductoVenta> getCarrito() {
        return carrito;
    }

    /**
     * Establece la lista de productos tipo venta del carrito
     *
     * @param carrito Lista de productos tipo venta del carrito
     */
    public void setCarrito(List<ProductoVenta> carrito) {
        this.carrito = carrito;
    }

    /**
     * Regresa la cantida de productos.
     *
     * @return Cantidad de productos
     */
    public int getCantidadProductos() {
        return cantidadProductos;
    }

    /**
     * Establece la cantidad de productos.
     *
     * @param cantidadProductos Cantidad de productos
     */
    public void setCantidadProductos(int cantidadProductos) {
        this.cantidadProductos = cantidadProductos;
    }

    /**
     * Regresa el subtotal de todos los productos.
     *
     * @return Subtotal de todos los productos
     */
    public double getSubtotal() {
        return subtotal;
    }

    /**
     * Establece el subtotal de todos los productos.
     *
     * @param subtotal Subtotal de todos los productos
     */
    public void setSubtotal(double subtotal) {
        this.subtotal = subtotal;
    }

    /**
     * Regresa el total de todos los productos.
     *
     * @return Total de tods los productos
     */
    public double getTotal() {
        return total;
    }

    /**
     * Establece el total de todos los productos.
     *
     * @param total Total de todos los productos
     */
    public void setTotal(double total) {
        this.total = total;
    }

    /**
     * Regresa el impuesto de todos los productos.
     *
     * @return Impuesto de todos los productos
     */
    public double getImpuesto() {
        return impuesto;
    }

    /**
     * Estable el impuesto de todos los productos.
     *
     * @param impuesto Impuesto de todos los productos
     */
    public void setImpuesto(double impuesto) {
        this.impuesto = impuesto;
    }

    /**
     * Regresa una cadena con todos los datos del carrito.
     *
     * @return Cadena con todos los datos del carrito
     */
    @Override
    public String toString() {
        return "Carrito{" + "idCarrito=" + idCarrito + ", carrito=" + carrito + ", cantidadProductos=" + cantidadProductos + ", subtotal=" + subtotal + ", total=" + total + ", impuesto=" + impuesto + '}';
    }

}
