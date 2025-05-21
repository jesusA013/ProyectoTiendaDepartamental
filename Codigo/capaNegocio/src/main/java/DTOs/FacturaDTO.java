package DTOs;

import java.util.Date;

/**
 * FacturaDTO.java
 *
 * Esta clase representa una factura de objeto de transferencia de datos
 *
 * @author
 */
public class FacturaDTO {

    private String folioFactura;
    private Date fechaEmision;
    private String rfc;
    private String nombreRazon;
    private String calle;
    private String numExt;
    private String numInt;
    private String colonia;
    private String codigoPostal;
    private String delegacionMunicipio;
    private String ciudadLocalidad;
    private String estado;
    private String pais;
    private String correo;

    /**
     * Constructor por omision
     */
    public FacturaDTO() {
    }

    /**
     * Inicializa los atributos al valor de sus parámetros.
     *
     * @param folioFactura
     * @param fechaEmision
     * @param rfc
     * @param pais
     */
    public FacturaDTO(String folioFactura, Date fechaEmision, String rfc, String pais) {
        this.folioFactura = folioFactura;
        this.fechaEmision = fechaEmision;
        this.rfc = rfc;
        this.pais = pais;
    }

    /**
     * Inicializa los atributos al valor de sus parámetros.
     *
     * @param folioFactura
     * @param fechaEmision
     * @param rfc
     * @param nombreRazon
     * @param calle
     * @param numExt
     * @param numInt
     * @param colonia
     * @param codigoPostal
     * @param delegacionMunicipio
     * @param ciudadLocalidad
     * @param estado
     * @param pais
     * @param correo
     */
    public FacturaDTO(String folioFactura, Date fechaEmision, String rfc, String nombreRazon, String calle, String numExt, String numInt, String colonia, String codigoPostal, String delegacionMunicipio, String ciudadLocalidad, String estado, String pais, String correo) {
        this.folioFactura = folioFactura;
        this.fechaEmision = fechaEmision;
        this.rfc = rfc;
        this.nombreRazon = nombreRazon;
        this.calle = calle;
        this.numExt = numExt;
        this.numInt = numInt;
        this.colonia = colonia;
        this.codigoPostal = codigoPostal;
        this.delegacionMunicipio = delegacionMunicipio;
        this.ciudadLocalidad = ciudadLocalidad;
        this.estado = estado;
        this.pais = pais;
        this.correo = correo;
    }

    public String getFolioFactura() {
        return folioFactura;
    }

    public void setFolioFactura(String folioFactura) {
        this.folioFactura = folioFactura;
    }

    public Date getFechaEmision() {
        return fechaEmision;
    }

    public void setFechaEmision(Date fechaEmision) {
        this.fechaEmision = fechaEmision;
    }

    public String getRfc() {
        return rfc;
    }

    public void setRfc(String rfc) {
        this.rfc = rfc;
    }

    public String getNombreRazon() {
        return nombreRazon;
    }

    public void setNombreRazon(String nombreRazon) {
        this.nombreRazon = nombreRazon;
    }

    public String getCalle() {
        return calle;
    }

    public void setCalle(String calle) {
        this.calle = calle;
    }

    public String getNumExt() {
        return numExt;
    }

    public void setNumExt(String numExt) {
        this.numExt = numExt;
    }

    public String getNumInt() {
        return numInt;
    }

    public void setNumInt(String numInt) {
        this.numInt = numInt;
    }

    public String getColonia() {
        return colonia;
    }

    public void setColonia(String colonia) {
        this.colonia = colonia;
    }

    public String getCodigoPostal() {
        return codigoPostal;
    }

    public void setCodigoPostal(String codigoPostal) {
        this.codigoPostal = codigoPostal;
    }

    public String getDelegacionMunicipio() {
        return delegacionMunicipio;
    }

    public void setDelegacionMunicipio(String delegacionMunicipio) {
        this.delegacionMunicipio = delegacionMunicipio;
    }

    public String getCiudadLocalidad() {
        return ciudadLocalidad;
    }

    public void setCiudadLocalidad(String ciudadLocalidad) {
        this.ciudadLocalidad = ciudadLocalidad;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getPais() {
        return pais;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    @Override
    public String toString() {
        return "FacturaDTO{" + "folioFactura=" + folioFactura + ", fechaEmision=" + fechaEmision + ", rfc=" + rfc + ", nombreRazon=" + nombreRazon + ", calle=" + calle + ", numExt=" + numExt + ", numInt=" + numInt + ", colonia=" + colonia + ", codigoPostal=" + codigoPostal + ", delegacionMunicipio=" + delegacionMunicipio + ", ciudadLocalidad=" + ciudadLocalidad + ", estado=" + estado + ", pais=" + pais + ", correo=" + correo + '}';
    }
}
