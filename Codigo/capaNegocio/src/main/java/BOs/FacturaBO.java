package BOs;

/**
 *
 * @author Knocmare
 */
public class FacturaBO {
    
    public String RFC;
    private String codigoPostal;
    private String calle;
    private String nombre;
    private String numeroExterior;
    private String numeroInterior;
    private String colonia;
    private String estado;
    private String pais;
    private String correo;

    public FacturaBO() {
    }

    public FacturaBO(String RFC, String codigoPostal, String calle, String nombre, String numeroExterior, String numeroInterior, String colonia, String estado, String pais, String correo) {
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

    public String getRFC() {
        return RFC;
    }

    public void setRFC(String RFC) {
        this.RFC = RFC;
    }

    public String getCodigoPostal() {
        return codigoPostal;
    }

    public void setCodigoPostal(String codigoPostal) {
        this.codigoPostal = codigoPostal;
    }

    public String getCalle() {
        return calle;
    }

    public void setCalle(String calle) {
        this.calle = calle;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getNumeroExterior() {
        return numeroExterior;
    }

    public void setNumeroExterior(String numeroExterior) {
        this.numeroExterior = numeroExterior;
    }

    public String getNumeroInterior() {
        return numeroInterior;
    }

    public void setNumeroInterior(String numeroInterior) {
        this.numeroInterior = numeroInterior;
    }

    public String getColonia() {
        return colonia;
    }

    public void setColonia(String colonia) {
        this.colonia = colonia;
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
    
    // ------------------------------------ //
    
    
    
    
    
}
