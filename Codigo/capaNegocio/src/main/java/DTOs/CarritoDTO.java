package DTOs;

import java.util.List;

/**
 * CarritoDTO.java
 *
 * Esta clase representa un carrito de compra de objecto de transferencia de
 * datos
 *
 * @author
 */
public class CarritoDTO {

    private List<ProductoCarritoDTO> listaProductos;
    private int cantidadTotalProducots;
    private double subtotal;
    private double impuestos;
    private double total;

    /**
     * Constructor por omision
     */
    public CarritoDTO() {
    }

    /**
     * Constructor de un carrito de objecto de transferencia de datos
     *
     * @param listaProductos Lista de productos del carrito
     * @param cantidadTotalProducots Cantidad total de productos del carrito
     * @param subtotal Subtotal de los productos del carrito
     * @param impuestos Impuestos de los productos del carrito
     * @param total Total de los productos del carrito
     */
    public CarritoDTO(List<ProductoCarritoDTO> listaProductos, int cantidadTotalProducots, double subtotal, double impuestos, double total) {
        this.listaProductos = listaProductos;
        this.cantidadTotalProducots = cantidadTotalProducots;
        this.subtotal = subtotal;
        this.impuestos = impuestos;
        this.total = total;
    }

    /**
     * Regresa la lista de productos del carrito
     *
     * @return Lista de productos
     */
    public List<ProductoCarritoDTO> getListaProductos() {
        return listaProductos;
    }

    /**
     * Establece la lista de productos del carrito
     *
     * @param listaProductos Lista de productos
     */
    public void setListaProductos(List<ProductoCarritoDTO> listaProductos) {
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
