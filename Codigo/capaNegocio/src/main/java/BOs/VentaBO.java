package BOs;

import java.util.List;

/**
 * VentaBO.java
 *
 * Esta clase representa una venta realizada en el sistema. Contiene información
 * sobre los productos vendidos, la cantidad, el subtotal, los impuestos, el
 * IVA, el total de la venta y el vendedor responsable.
 *
 * @author
 */
public class VentaBO {

    private String idVenta;
    private List<ProductoVentaBO> listaProductos;
    private int cantidadProductos;
    private int subtotal;
    private double impuestos;
    private double IVA;
    private int total;

    //private Vendedor vendedor;

//    private Vendedor vendedor;


    /** 
    * Constructor por omision
     */
    public VentaBO() {
    }

    /**
     * Constructor de una venta realizada en el sistema de objecto negocio
     *
     * @param idVenta Identificador único de la venta.
     * @param listaProductos Lista de productos incluidos en la venta.
     * @param cantidadProductos Cantidad total de productos vendidos.
     * @param subtotal Subtotal de la venta antes de impuestos.
     * @param impuestos Total de impuestos aplicados a la venta.
     * @param IVA Valor del IVA aplicado a la venta.
     * @param total Total final de la venta después de impuestos.
     * @param vendedor Vendedor responsable de la venta.
     */


    public VentaBO(String idVenta, List<ProductoVentaBO> listaProductos, int cantidadProductos, int subtotal, double impuestos, double IVA, int total) { // Quitamos vendedor de momento

        this.idVenta = idVenta;
        this.listaProductos = listaProductos;
        this.cantidadProductos = cantidadProductos;
        this.subtotal = subtotal;
        this.impuestos = impuestos;
        this.IVA = IVA;
        this.total = total;

        //this.vendedor = vendedor;

//        this.vendedor = vendedor;

    }

    /**
     * Obtiene el identificador único de la venta.
     *
     * @return ID de la venta.
     */
    public String getIdVenta() {
        return idVenta;
    }

    /**
     * Establece el identificador único de la venta.
     *
     * @param idVenta Nuevo ID de la venta.
     */
    public void setIdVenta(String idVenta) {
        this.idVenta = idVenta;
    }

    /**
     * Obtiene la lista de productos incluidos en la venta.
     *
     * @return Lista de productos de la venta.
     */
    public List<ProductoVentaBO> getListaProductos() {
        return listaProductos;
    }

    /**
     * Establece la lista de productos incluidos en la venta.
     *
     * @param listaProductos Nueva lista de productos.
     */
    public void setListaProductos(List<ProductoVentaBO> listaProductos) {
        this.listaProductos = listaProductos;
    }

    /**
     * Obtiene la cantidad total de productos vendidos.
     *
     * @return Cantidad de productos vendidos.
     */
    public int getCantidadProductos() {
        return cantidadProductos;
    }

    /**
     * Establece la cantidad total de productos vendidos.
     *
     * @param cantidadProductos Nueva cantidad de productos vendidos.
     */
    public void setCantidadProductos(int cantidadProductos) {
        this.cantidadProductos = cantidadProductos;
    }

    /**
     * Obtiene el subtotal de la venta antes de impuestos.
     *
     * @return Subtotal de la venta.
     */
    public int getSubtotal() {
        return subtotal;
    }

    /**
     * Establece el subtotal de la venta antes de impuestos.
     *
     * @param subtotal Nuevo subtotal de la venta.
     */
    public void setSubtotal(int subtotal) {
        this.subtotal = subtotal;
    }

    /**
     * Obtiene el total de impuestos aplicados a la venta.
     *
     * @return Total de impuestos.
     */
    public double getImpuestos() {
        return impuestos;
    }

    /**
     * Establece el total de impuestos aplicados a la venta.
     *
     * @param impuestos Nuevo valor de impuestos.
     */
    public void setImpuestos(double impuestos) {
        this.impuestos = impuestos;
    }

    /**
     * Obtiene el valor del IVA aplicado a la venta.
     *
     * @return Valor del IVA.
     */
    public double getIVA() {
        return IVA;
    }

    /**
     * Establece el valor del IVA aplicado a la venta.
     *
     * @param IVA Nuevo valor del IVA.
     */
    public void setIVA(double IVA) {
        this.IVA = IVA;
    }

    /**
     * Obtiene el total final de la venta después de impuestos.
     *
     * @return Total final de la venta.
     */
    public int getTotal() {
        return total;
    }

    /**
     * Establece el total final de la venta después de impuestos.
     *
     * @param total Nuevo total de la venta.
     */
    public void setTotal(int total) {
        this.total = total;
    }


    /**
     * Obtiene el vendedor responsable de la venta.
     *
     * @return Vendedor que realizó la venta.
     */

//    /**
//     * Obtiene el vendedor responsable de la venta.
//     *
//     * @return Vendedor que realizó la venta.
//     */

//    public Vendedor getVendedor() {
//        return vendedor;
//    }
//
//    /**
//     * Establece el vendedor responsable de la venta.
//     *
//     * @param vendedor Nuevo vendedor responsable.
//     */
//    public void setVendedor(Vendedor vendedor) {
//        this.vendedor = vendedor;
//    }

    // ------------------------------------ //
}
