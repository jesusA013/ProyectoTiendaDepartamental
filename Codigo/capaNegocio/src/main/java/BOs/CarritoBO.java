package BOs;

import java.util.List;

/**
 * CarritoBO.java
 *
 * Esta clase representa un carrito de compra de objecto negocio
 *
 * @author
 */
public class CarritoBO {

    private List<ProductoCarritoBO> listaProductos;
    private int cantidadTotalProducots;
    private double subtotal;
    private double impuestos = subtotal * .16;
    private double total = subtotal + impuestos;

    /**
     * Constructor por omision
     */
    public CarritoBO() {
    }

    /**
     * Constructor de un carrito de objecto negocio
     *
     * @param listaProductos Lista de productos del carrito
     * @param cantidadTotalProducots Cantidad total de productos del carrito
     *
     *
     *
     */
    public CarritoBO(List<ProductoCarritoBO> listaProductos, int cantidadTotalProducots) {
        this.listaProductos = listaProductos;
        this.cantidadTotalProducots = cantidadTotalProducots;
        for (int i = 0; i < 10; i++) {
            subtotal += listaProductos.get(i).getImporte();
        }
        impuestos = subtotal * .16;
        total = subtotal + impuestos;
    }

    /**
     * Regresa la lista de productos del carrito
     *
     * @return Lista de productos
     */
    public List<ProductoCarritoBO> getListaProductos() {
        return listaProductos;
    }

    /**
     * Establece la lista de productos del carrito
     *
     * @param listaProductos Lista de productos
     */
    public void setListaProductos(List<ProductoCarritoBO> listaProductos) {
        this.listaProductos = listaProductos;
    }

    /**
     * Regresa la cantidad total de productos del carrito
     *
     * @return Cantidad total de productos del carrito
     */
    public int getCantidadTotalProducots() {
        return cantidadTotalProducots;
    }

    /**
     * Establece la cantidad total de productos del carrito
     *
     * @param cantidadTotalProducots
     */
    public void setCantidadTotalProducots(int cantidadTotalProducots) {
        this.cantidadTotalProducots = cantidadTotalProducots;
    }

    /**
     * Regresa el subtotal de los productos del carrito
     *
     * @return Subtotal de los productos del carrito
     */
    public double getSubtotal() {
        return subtotal;
    }

    /**
     * Establece el subtotal de los productos del carrito
     *
     * @param subtotal Subtotal de los productos del carrito
     */
    public void setSubtotal(double subtotal) {
        this.subtotal = subtotal;
    }

    /**
     * Establece los impuestos de los productos del carrito
     *
     * @return Impuestos de los productos del carrito
     */
    public double getImpuestos() {
        return impuestos;
    }

    /**
     * Regresa los impuestos de los productos del carrito
     *
     * @param impuestos Impuestos de los productos del carrito
     */
    public void setImpuestos(double impuestos) {
        this.impuestos = impuestos;
    }

    /**
     * Establece el total de los productos del carrito
     *
     * @return Total de los productos del carrito
     */
    public double getTotal() {
        return total;
    }

    /**
     * Regresa el total de los productos del carrito
     *
     * @param total Total de los productos del carrito
     */
    public void setTotal(double total) {
        this.total = total;
    }

    // ------------------------------------ //
}
