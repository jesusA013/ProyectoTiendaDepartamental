package Entidades;

/**
 * MetodoPagoTarjeta.java
 *
 * Esta clase representa el metodo de pago con tarjeta.
 *
 * @author Knocmare
 */
public class MetodoPagoTarjeta extends MetodoPago {

    private String tarjeta;
    private int mes;
    private int ano;
    private int cvc;

    /**
     * Constructor por ausencia
     */
    public MetodoPagoTarjeta() {
    }

    /**
     * Constructor del metodo de pago con tarjeta.
     *
     * @param tarjeta Tarjeta de credito/debito
     * @param mes Mes de la caducidad
     * @param ano Año de la caducidad
     * @param cvc CVC de la tarjeta
     */
    public MetodoPagoTarjeta(String tarjeta, int mes, int ano, int cvc) {
        this.tarjeta = tarjeta;
        this.mes = mes;
        this.ano = ano;
        this.cvc = cvc;
    }

    /**
     * Constructor del metodo de pago con tarjeta completo.
     *
     * @param pago Pago de la venta
     * @param cambio Cambio de la venta
     * @param tarjeta Tarjeta de credito/debito
     * @param mes Mes de la caducidad
     * @param ano Año de la caducidad
     * @param cvc CVC de la tarjeta
     */
    public MetodoPagoTarjeta(double pago, double cambio, String tarjeta, int mes, int ano, int cvc) {
        super(pago, cambio);
        this.tarjeta = tarjeta;
        this.mes = mes;
        this.ano = ano;
        this.cvc = cvc;
    }

    /**
     * Regresa la tarjeta de credito/debito
     *
     * @return Tarjeta de credito/debito
     */
    public String getTarjeta() {
        return tarjeta;
    }

    /**
     * Establece la tarjeta de credito/debito
     *
     * @param tarjeta Tarjeta de credito/debito
     */
    public void setTarjeta(String tarjeta) {
        this.tarjeta = tarjeta;
    }

    /**
     * Regresa el mes de la caducidad.
     *
     * @return Mes de la caducidad
     */
    public int getMes() {
        return mes;
    }

    /**
     * Establece el mes de la caducidad.
     *
     * @param mes Mes de la caducidad
     */
    public void setMes(int mes) {
        this.mes = mes;
    }

    /**
     * Regresa el año de la caducidad.
     *
     * @return Año de la caducidad
     */
    public int getAno() {
        return ano;
    }

    /**
     * Establece el año de la caducidad.
     *
     * @param ano Año de la caducidad
     */
    public void setAno(int ano) {
        this.ano = ano;
    }

    /**
     * Regresa el CVC de la tarjeta.
     *
     * @return CVC de la tarjeta
     */
    public int getCvc() {
        return cvc;
    }

    /**
     * Establece el CVC de la tarjeta.
     *
     * @param cvc CVC de la tarjeta
     */
    public void setCvc(int cvc) {
        this.cvc = cvc;
    }

    /**
     * Regresa la cadena con todos los datos.
     *
     * @return Cadena con todos los datos
     */
    @Override
    public String toString() {
        return "MetodoPagoTarjeta{" + "tarjeta=" + tarjeta + ", mes=" + mes + ", ano=" + ano + ", cvc=" + cvc + '}';
    }

}
