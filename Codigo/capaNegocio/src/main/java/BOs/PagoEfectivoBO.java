package BOs;

/**
 *
 * @author Knocmare
 */
public class PagoEfectivoBO {
    
    private double efectivoEntrgado;
    private double cambio;

    public PagoEfectivoBO() {
    }

    public PagoEfectivoBO(double efectivoEntrgado, double cambio) {
        this.efectivoEntrgado = efectivoEntrgado;
        this.cambio = cambio;
    }

    public double getEfectivoEntrgado() {
        return efectivoEntrgado;
    }

    public void setEfectivoEntrgado(double efectivoEntrgado) {
        this.efectivoEntrgado = efectivoEntrgado;
    }

    public double getCambio() {
        return cambio;
    }

    public void setCambio(double cambio) {
        this.cambio = cambio;
    }
    
    // ------------------------------------ //
    
    
    
}
