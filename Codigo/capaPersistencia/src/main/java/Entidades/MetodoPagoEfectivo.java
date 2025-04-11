package Entidades;

/**
 * MetodoPagoEfectivo.java
 *
 * Esta clase representa el metodo de pago en efectivo.
 *
 * @author Knocmare
 */
public class MetodoPagoEfectivo extends MetodoPago {

    private double monto;

    /**
     * Constructor por ausencia
     */
    public MetodoPagoEfectivo() {
    }

    /**
     * Constructor del metodo de pago en efectivo.
     *
     * @param monto Monto del pago
     */
    public MetodoPagoEfectivo(double monto) {
        this.monto = monto;
    }

    /**
     * Constructor del metodo de pago en efectivo completo.
     *
     * @param monto Monto del pago
     * @param pago Pago de la venta
     * @param cambio Cambio de la venta
     */
    public MetodoPagoEfectivo(double monto, double pago, double cambio) {
        super(pago, cambio);
        this.monto = monto;
    }

    /**
     * Regresa el monto del pago.
     *
     * @return Monto del pago
     */
    public double getMonto() {
        return monto;
    }

    /**
     * Establece el Monto del pago.
     *
     * @param monto Monto del pago
     */
    public void setMonto(double monto) {
        this.monto = monto;
    }

    /**
     * Regresa una cadena con los datos del metodo de pago en efectivo.
     *
     * @return Cadena con los datos del metodo de pago en efectivo
     */
    @Override
    public String toString() {
        return "MetodoPagoEfectivo{" + "monto=" + monto + '}';
    }

}
