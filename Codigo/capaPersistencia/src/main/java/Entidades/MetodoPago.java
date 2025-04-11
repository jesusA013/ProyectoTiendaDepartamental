package Entidades;

/**
 * MetodoPago.java
 *
 * Esta clase abstracta regresenta el metodo de pago.
 *
 * @author Knocmare
 */
public abstract class MetodoPago {

    protected int idPago;
    protected double total;

    /**
     * Constructor por ausencia
     */
    public MetodoPago() {
    }

    /**
     * Constructor del metodo de pago
     *
     * @param idPago ID de la venta
     * @param total Total de la venta
     */
    public MetodoPago(int idPago, double total) {
        this.idPago = idPago;
        this.total = total;
    }

    /**
     * Regresa el ID de la venta.
     *
     * @return ID de la venta
     */
    public int getIdPago() {
        return idPago;
    }

    /**
     * Establece el ID de la venta.
     *
     * @param idPago ID de la venta
     */
    public void setIdPago(int idPago) {
        this.idPago = idPago;
    }

    /**
     * Regresa el total de la venta
     *
     * @return Total de la venta
     */
    public double getTotal() {
        return total;
    }

    /**
     * Establece el total de la venta.
     *
     * @param total Total de la venta
     */
    public void setTotal(double total) {
        this.total = total;
    }

    /**
     * Regresa una cadena con todos los datos del metodo de pago.
     *
     * @return Cadena con todos los datos del metodo de pago
     */
    @Override
    public String toString() {
        return "MetodoPago{" + "idPago=" + idPago + ", total=" + total + '}';
    }
}
