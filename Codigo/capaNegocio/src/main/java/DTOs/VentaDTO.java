package DTOs;

import java.util.Calendar;
import java.util.List;

/**
 * VentaDTO.java
 *
 * Esta clase representa una venta realizada en el sistema de objecto de
 * transferencia de datos
 *
 * @author
 */
public class VentaDTO {

    private String idVenta;
    private List<ProductoVentaDTO> listaProductos;
    private int cantidadProductos;
    private int subtotal;
    private double impuestos;
    private double IVA;
    private int total;
//    private Vendedor vendedor;
    private Calendar fecha;

    /**
     * Constructor por omision
     */
    public VentaDTO() {
    }

    /**
     * Constructor de una venta realizada en el sistema de objecto de
     * transferencia de datos
     *
     * @param idVenta Identificador único de la venta.
     * @param listaProductos Lista de productos incluidos en la venta.
     * @param cantidadProductos Cantidad total de productos vendidos.
     * @param subtotal Subtotal de la venta antes de impuestos.
     * @param impuestos Total de impuestos aplicados a la venta.
     * @param IVA Valor del IVA aplicado a la venta.
     * @param total Total final de la venta después de impuestos.
     * @param vendedor Vendedor responsable de la venta.
     * @param fecha Fecha de la venta
     */
    public VentaDTO(String idVenta, List<ProductoVentaDTO> listaProductos, int cantidadProductos, int subtotal, double impuestos, double IVA, int total, Calendar fecha) { // Quitamos vendedor de momento
        this.idVenta = idVenta;
        this.listaProductos = listaProductos;
        this.cantidadProductos = cantidadProductos;
        this.subtotal = subtotal;
        this.impuestos = impuestos;
        this.IVA = IVA;
        this.total = total;
//        this.vendedor = vendedor;
        this.fecha = fecha;
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
    public List<ProductoVentaDTO> getListaProductos() {
        return listaProductos;
    }

    /**
     * Establece la lista de productos incluidos en la venta.
     *
     * @param listaProductos Nueva lista de productos.
     */
    public void setListaProductos(List<ProductoVentaDTO> listaProductos) {
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
    /**
     * Obtiene la fecha de la venta
     *
     * @return Fecha de la venta
     */
    public Calendar getFecha() {
        return fecha;
    }

    /**
     * Establece la fecha de la venta
     *
     * @param fecha Fecha de la venta
     */
    public void setFecha(Calendar fecha) {
        this.fecha = fecha;
    }

}
