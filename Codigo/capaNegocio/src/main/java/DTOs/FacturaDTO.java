package DTOs;

/**
 * FacturaDTO.java
 *
 * Esta clase representa una factura de objeto de transferencia de datos
 *
 * @author
 */
public class FacturaDTO {

    private String RFC;
    private String codigoPostal;
    private String calle;
    private String nombre;
    private String numeroExterior;
    private String numeroInterior;
    private String colonia;
    private String estado;
    private String pais;
    private String correo;

    /**
     * Constructor por omision
     */
    public FacturaDTO() {
    }

    /**
     * Constructor de una factura de objeto de transferencia de datos
     *
     * @param RFC RFC del vendedor
     * @param codigoPostal Codigo postal del vendedor
     * @param calle Calle del domicilio
     * @param nombre Nombre o razon social del vendedor
     * @param numeroExterior Número exterior del domicilio
     * @param numeroInterior Número interior del domicilio
     * @param colonia Colonia del domicilio
     * @param estado Estado donde recide el vendedor
     * @param pais Pais donde recide el vendedor
     * @param correo Correo electronico del vendedor
     */
    public FacturaDTO(String RFC, String codigoPostal, String calle, String nombre, String numeroExterior, String numeroInterior, String colonia, String estado, String pais, String correo) {
        this.RFC = RFC;
        this.codigoPostal = codigoPostal;
        this.calle = calle;
        this.nombre = nombre;
        this.numeroExterior = numeroExterior;
        this.numeroInterior = numeroInterior;
        this.colonia = colonia;
        this.estado = estado;
        this.pais = pais;
        this.correo = correo;
    }

    @Override
public String toString() {
    return "FacturaDTO{" +
           "RFC='" + RFC + '\'' +
           ", codigoPostal='" + codigoPostal + '\'' +
           ", calle='" + calle + '\'' +
           ", nombre='" + nombre + '\'' +
           ", numeroExterior='" + numeroExterior + '\'' +
           ", numeroInterior='" + numeroInterior + '\'' +
           ", colonia='" + colonia + '\'' +
           ", estado='" + estado + '\'' +
           ", pais='" + pais + '\'' +
           ", correo='" + correo + '\'' +
           '}';
}

    /**
     * Regresa el RFC del vendedor
     *
     * @return RFC del vendedor
     */
    public String getRFC() {
        return RFC;
    }

    /**
     * Establece el RFC del vendedor
     *
     * @param RFC RFC del vendedor
     */
    public void setRFC(String RFC) {
        this.RFC = RFC;
    }

    /**
     * Regresa el codigo postal del vendedor
     *
     * @return Codigo postal del vendedor
     */
    public String getCodigoPostal() {
        return codigoPostal;
    }

    /**
     * Establece el codigo postal del vendedor
     *
     * @param codigoPostal Codigo postal del vendedor
     */
    public void setCodigoPostal(String codigoPostal) {
        this.codigoPostal = codigoPostal;
    }

    /**
     * Regresa la calle del domicilio
     *
     * @return Calle del domicilio
     */
    public String getCalle() {
        return calle;
    }

    /**
     * Establece la calle del domicilio
     *
     * @param calle Calle del domicilio
     */
    public void setCalle(String calle) {
        this.calle = calle;
    }

    /**
     * Regresa el nombre o razon social del vendedor
     *
     * @return Nombre o razon social del vendedor
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Establece el nombre o razon social del vendedor
     *
     * @param nombre Nombre o razon social del vendedor
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * Regresa el número exterior del domicilio
     *
     * @return Número exterior del domicilio
     */
    public String getNumeroExterior() {
        return numeroExterior;
    }

    /**
     * Establece el número exterior del domicilio
     *
     * @param numeroExterior Número exterior del domicilio
     */
    public void setNumeroExterior(String numeroExterior) {
        this.numeroExterior = numeroExterior;
    }

    /**
     * Regresa el número interior del domicilio
     *
     * @return Número interior del domicilio
     */
    public String getNumeroInterior() {
        return numeroInterior;
    }

    /**
     * Establece el número interior del domicilio
     *
     * @param numeroInterior Número interior del domicilio
     */
    public void setNumeroInterior(String numeroInterior) {
        this.numeroInterior = numeroInterior;
    }

    /**
     * Regresa la colonia del domicilio
     *
     * @return Colonia del domicilio
     */
    public String getColonia() {
        return colonia;
    }

    /**
     * Establece la colonia del domicilio
     *
     * @param colonia Colonia del domicilio
     */
    public void setColonia(String colonia) {
        this.colonia = colonia;
    }

    /**
     * Regresa el estado donde reside el vendedor
     *
     * @return Estado donde reside el vendedor
     */
    public String getEstado() {
        return estado;
    }

    /**
     * Establece el estado donde reside el vendedor
     *
     * @param estado Estado donde reside el vendedor
     */
    public void setEstado(String estado) {
        this.estado = estado;
    }

    /**
     * Regresa el pais donde reside el vendedor
     *
     * @return Pais donde reside el vendedor
     */
    public String getPais() {
        return pais;
    }

    /**
     * Establece el pais donde reside el vendedor
     *
     * @param pais Pais donde reside el vendedor
     */
    public void setPais(String pais) {
        this.pais = pais;
    }

    /**
     * Regresa el correo electronico del vendedor
     *
     * @return Correo electronico del vendedor
     */
    public String getCorreo() {
        return correo;
    }

    /**
     * Establece el correo electronico del vendedor
     *
     * @param correo Correo electronico del vendedor
     */
    public void setCorreo(String correo) {
        this.correo = correo;
    }

}
