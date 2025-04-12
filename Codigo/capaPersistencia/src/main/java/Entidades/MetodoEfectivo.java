package Entidades;

/**
 * MetodoEfectivo.java
 *
 * Esta clase representa el metodo de pago en efectivo.
 *
 * @author Ángel Ruíz García - 00000248171
 */
public class MetodoEfectivo extends MetodoPago {

    private double efectivoEntregado;
    private double cambio;

    /**
     * Constructor por ausencia
     */
    public MetodoEfectivo() {
    }

    /**
     * Constructor del metodo de pago en efectivo.
     *
     * @param efectivoEntregado Pago de la venta
     * @param cambio Cambio de la venta
     */
    public MetodoEfectivo(double efectivoEntregado, double cambio) {
        this.efectivoEntregado = efectivoEntregado;
        this.cambio = cambio;
    }

    /**
     * Constructor del metodo de pago en efectivo.
     *
     * @param idPago ID de la venta
     * @param total Total de la venta
     * @param efectivoEntregado Pago de la venta
     * @param cambio Cambio de la venta
     */
    public MetodoEfectivo(int idPago, double total, double efectivoEntregado, double cambio) {
        super(idPago, total);
        this.efectivoEntregado = efectivoEntregado;
        this.cambio = cambio;
    }

    /**
     * Regresa el pago de la venta.
     *
     * @return Pago de la venta
     */
    public double getEfectivoEntregado() {
        return efectivoEntregado;
    }

    /**
     * Establece el pago de la venta.
     *
     * @param efectivoEntregado Pago de la venta
     */
    public void setEfectivoEntregado(double efectivoEntregado) {
        this.efectivoEntregado = efectivoEntregado;
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
     * Regresa el ID de la venta.
     *
     * @return ID de la venta
     */
    @Override
    public int getIdPago() {
        return idPago;
    }

    /**
     * Establece el ID de la venta.
     *
     * @param idPago ID de la venta
     */
    @Override
    public void setIdPago(int idPago) {
        this.idPago = idPago;
    }

    /**
     * Regresa el total de la venta
     *
     * @return Total de la venta
     */
    @Override
    public double getTotal() {
        return total;
    }

    /**
     * Establece el total de la venta.
     *
     * @param total Total de la venta
     */
    @Override
    public void setTotal(double total) {
        this.total = total;
    }

    /**
     * Regresa una cadena con los datos del metodo de pago en efectivo.
     *
     * @return Cadena con los datos del metodo de pago en efectivo
     */
    @Override
    public String toString() {
        return "MetodoPagoEfectivo{" + "efectivoEntregado=" + efectivoEntregado + ", cambio=" + cambio + '}';
    }
}
