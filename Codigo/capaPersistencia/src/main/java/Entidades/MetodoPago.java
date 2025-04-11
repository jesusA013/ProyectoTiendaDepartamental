package Entidades;

/**
 * MetodoPago.java
 *
 * Esta clase abstracta regresenta el metodo de pago.
 *
 * @author Knocmare
 */
public abstract class MetodoPago {

    private double pago;
    private double cambio;

    /**
     * Constructor por ausencia
     */
    public MetodoPago() {
    }

    /**
     * Constructor del metodo de pago.
     *
     * @param pago Pago de la venta
     * @param cambio Cambio de la venta
     */
    public MetodoPago(double pago, double cambio) {
        this.pago = pago;
        this.cambio = cambio;
    }

    /**
     * Regresa el pago de la venta.
     *
     * @return Pago de la venta
     */
    public double getPago() {
        return pago;
    }

    /**
     * Establece el pago de la venta.
     *
     * @param pago Pago de la venta
     */
    public void setPago(double pago) {
        this.pago = pago;
    }

    /**
     * Regresa el cambio de la venta.
     *
     * @return Cambio de la venta
     */
    public double getCambio() {
        return cambio;
    }

    /**
     * Establece el cambio de la venta.
     *
     * @param cambio Cambio de la venta
     */
    public void setCambio(double cambio) {
        this.cambio = cambio;
    }

    /**
     * Regresa una cadena con todos los datos del metodo de pago.
     *
     * @return Cadena con todos los datos del metodo de pago
     */
    @Override
    public String toString() {
        return "MetodoPago{" + "pago=" + pago + ", cambio=" + cambio + '}';
    }

}
