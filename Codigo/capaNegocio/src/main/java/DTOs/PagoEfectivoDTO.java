package DTOs;

/**
 * PagoEfectivoDTO.java
 *
 * Esta clase representa el metodo de pago en efectivo de objecto de
 * transferencia de datos
 *
 * @author
 */
public class PagoEfectivoDTO {

    private double efectivoEntregado;
    private double cambio;

    /**
     * Constructor por omision
     */
    public PagoEfectivoDTO() {
    }

    /**
     * Constructor del metodo de pago en efectivo de objecto de transferencia de
     * datos
     *
     * @param efectivoEntregado Cantidad pagada en efectivo
     * @param cambio Cambio del pago
     */
    public PagoEfectivoDTO(double efectivoEntregado, double cambio) {
        this.efectivoEntregado = efectivoEntregado;
        this.cambio = cambio;
    }

    /**
     * Regresa la cantidad pagada en efectivo
     *
     * @return Cantidad pagada en efectivo
     */
    public double getEfectivoEntregado() {
        return efectivoEntregado;
    }

    /**
     * Establece la cantidad pagada en efectivo
     *
     * @param efectivoEntregado Cantidad pagada en efectivo
     */
    public void setEfectivoEntregado(double efectivoEntregado) {
        this.efectivoEntregado = efectivoEntregado;
    }

    /**
     * Regresa el cambio del pago
     *
     * @return Cambio del pago
     */
    public double getCambio() {
        return cambio;
    }

    /**
     * Establece el cambio del pago
     *
     * @param cambio Cambio del pago
     */
    public void setCambio(double cambio) {
        this.cambio = cambio;
    }

    // ------------------------------------ //
}
