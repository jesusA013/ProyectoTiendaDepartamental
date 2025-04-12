package DTOs;

/**
 * MetodoTarjetaDTO.java
 * 
 * Esta clase representa el metodo de pago con tarjeta de objecto de
 * transferencia de datos.
 * 
 * @author Ángel Ruíz García - 00000248171
 */
public class MetodoTarjetaDTO extends MetodoPagoDTO {
    private String tarjeta;
    private int mes;
    private int ano;
    private int cvc;

    /**
     * Constructor por ausencia
     */
    public MetodoTarjetaDTO() {
    }

    /**
     * Constructor del metodo de pago con tarjeta.
     *
     * @param tarjeta Tarjeta de credito/debito
     * @param mes Mes de la caducidad
     * @param ano Año de la caducidad
     * @param cvc CVC de la tarjeta
     */
    public MetodoTarjetaDTO(String tarjeta, int mes, int ano, int cvc) {
        this.tarjeta = tarjeta;
        this.mes = mes;
        this.ano = ano;
        this.cvc = cvc;
    }

    /**
     * Constructor del metodo de pago con tarjeta completo.
     *
     * @param idPago ID de la venta
     * @param total Total de la venta
     * @param tarjeta Tarjeta de credito/debito
     * @param mes Mes de la caducidad
     * @param ano Año de la caducidad
     * @param cvc CVC de la tarjeta
     */
    public MetodoTarjetaDTO(int idPago, double total, String tarjeta, int mes, int ano, int cvc) {
        super(idPago, total);
        this.tarjeta = tarjeta;
        this.mes = mes;
        this.ano = ano;
        this.cvc = cvc;
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
