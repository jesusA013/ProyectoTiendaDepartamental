package DTOs;

import java.util.Calendar;

/**
 * PagoTarjetaDTO.java
 *
 * Esta clase representa el metodo de pago con tarjeta de objecto de
 * transferencia de datos
 *
 * @author
 */
public class PagoTarjetaDTO {

    private String numeroTarjeta;
    private Calendar fechaExpiracion;
    private String cvc;

    /**
     * Constructor por omision
     */
    public PagoTarjetaDTO() {
    }

    /**
     * Constructor del metodo de pago con tarjeta de objecto de transferencia de
     * datos
     *
     * @param numeroTarjeta Número de la tarjeta
     * @param fechaExpiracion Fecha de expiracion de la tarjeta
     * @param cvc CVC de la tarjeta
     */
    public PagoTarjetaDTO(String numeroTarjeta, Calendar fechaExpiracion, String cvc) {
        this.numeroTarjeta = numeroTarjeta;
        this.fechaExpiracion = fechaExpiracion;
        this.cvc = cvc;
    }

    /**
     * Regresa el número de la tarjeta
     *
     * @return Número de la tarjeta
     */
    public String getNumeroTarjeta() {
        return numeroTarjeta;
    }

    /**
     * Establece el número de la tarjeta
     *
     * @param numeroTarjeta Número de la tarjeta
     */
    public void setNumeroTarjeta(String numeroTarjeta) {
        this.numeroTarjeta = numeroTarjeta;
    }

    /**
     * Regresa la fecha de expiracion de la tarjeta
     *
     * @return Fecha de expiracion de la tarjeta
     */
    public Calendar getFechaExpiracion() {
        return fechaExpiracion;
    }

    /**
     * Establece la fecha de expiracion de la tarjeta
     *
     * @param fechaExpiracion Fecha de expiracion de la tarjeta
     */
    public void setFechaExpiracion(Calendar fechaExpiracion) {
        this.fechaExpiracion = fechaExpiracion;
    }

    /**
     * Regresa el CVC de la tarjeta
     *
     * @return CVC de la tarjeta
     */
    public String getCvc() {
        return cvc;
    }

    /**
     * Establece el CVC de la tarjeta
     *
     * @param cvc CVC de la tarjeta
     */
    public void setCvc(String cvc) {
        this.cvc = cvc;
    }

    // ------------------------------------ //
}
