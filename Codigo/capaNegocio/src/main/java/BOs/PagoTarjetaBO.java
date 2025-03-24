package BOs;

import java.util.Calendar;

/**
 *
 * @author Knocmare
 */
public class PagoTarjetaBO {
    
    private String numeroTarjeta;
    public Calendar fechaExpiracion;
    private String cvc;

    public PagoTarjetaBO() {
    }

    public PagoTarjetaBO(String numeroTarjeta, Calendar fechaExpiracion, String cvc) {
        this.numeroTarjeta = numeroTarjeta;
        this.fechaExpiracion = fechaExpiracion;
        this.cvc = cvc;
    }

    public String getNumeroTarjeta() {
        return numeroTarjeta;
    }

    public void setNumeroTarjeta(String numeroTarjeta) {
        this.numeroTarjeta = numeroTarjeta;
    }

    public Calendar getFechaExpiracion() {
        return fechaExpiracion;
    }

    public void setFechaExpiracion(Calendar fechaExpiracion) {
        this.fechaExpiracion = fechaExpiracion;
    }

    public String getCvc() {
        return cvc;
    }

    public void setCvc(String cvc) {
        this.cvc = cvc;
    }
    
    // ------------------------------------ //
    
    
    
    
}
