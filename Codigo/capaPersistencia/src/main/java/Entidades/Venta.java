package Entidades;

import java.util.Date;

/**
 * Venta.java
 *
 * Esta clase representa la entidad de venta.
 *
 * @author Knocmare
 */
public class Venta {

    private int idVenta;
    private double subtotal;
    private double impuesto;
    private double total;
    private Date fecha;

    /**
     * Constructor por ausencia
     */
    public Venta() {
    }

    /**
     * Constructor de una venta.
     *
     * @param subtotal Subtotal de la venta
     * @param impuesto Impuesto de la venta
     * @param total Total de la venta
     * @param fecha Fecha de la venta
     */
    public Venta(double subtotal, double impuesto, double total, Date fecha) {
        this.subtotal = subtotal;
        this.impuesto = impuesto;
        this.total = total;
        this.fecha = fecha;
    }

    /**
     * Regresa el ID de la venta.
     *
     * @return ID de la venta
     */
    public int getIdVenta() {
        return idVenta;
    }

    /**
     * Establece el ID de la venta.
     *
     * @param idVenta ID de la venta
     */
    public void setIdVenta(int idVenta) {
        this.idVenta = idVenta;
    }

    /**
     * Regresa el subtotal de la venta.
     *
     * @return Subtotal de la venta
     */
    public double getSubtotal() {
        return subtotal;
    }

    /**
     * Establece el subtotal de la venta
     *
     * @param subtotal Subtotal de la venta
     */
    public void setSubtotal(double subtotal) {
        this.subtotal = subtotal;
    }

    /**
     * Regresa el impuesto de la venta.
     *
     * @return Impuesto de la venta
     */
    public double getImpuesto() {
        return impuesto;
    }

    /**
     * Establece el impuesto de la venta.
     *
     * @param impuesto Impuesto de la venta
     */
    public void setImpuesto(double impuesto) {
        this.impuesto = impuesto;
    }

    /**
     * Regresa el total de la venta.
     *
     * @return Total de la venta
     */
    public double getTotal() {
        return total;
    }

    /**
     * Establece el total de la venta.
     *
     * @param total
     */
    public void setTotal(double total) {
        this.total = total;
    }

    /**
     * Regresa la fecha de la venta.
     *
     * @return Fecha de la venta
     */
    public Date getFecha() {
        return fecha;
    }

    /**
     * Establece la fecha de la venta.
     *
     * @param fecha Fecha de la venta
     */
    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    /**
     * Regresa una cadena con con todos los datos.
     *
     * @return Cadena con todos los datos
     */
    @Override
    public String toString() {
        return "Venta{" + "idVenta=" + idVenta + ", subtotal=" + subtotal + ", impuesto=" + impuesto + ", total=" + total + ", fecha=" + fecha + '}';
    }

}
