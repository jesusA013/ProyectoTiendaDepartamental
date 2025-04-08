package BOs;

import Interfaces.IBO;

/**
 * PagoEfectivoBO.java
 *
 * Esta clase representa el metodo de pago en efectivo de objecto negocio
 *
 * @author 
 */
public class PagoEfectivoBO implements IBO {

    private double efectivoEntregado;
    private double cambio;

    /**
     * Constructor por omision
     */
    public PagoEfectivoBO() {
    }

    /**
     * Constructor del metodo de pago en efectivo de objecto negocio
     *
     * @param efectivoEntregado Cantidad pagada en efectivo
     * @param cambio Cambio del pago
     */
    public PagoEfectivoBO(double efectivoEntregado, double cambio) {
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
