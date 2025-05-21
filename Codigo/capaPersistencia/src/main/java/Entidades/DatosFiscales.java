package Entidades;

/**
 *
 * @author gaspa
 */
public class DatosFiscales {

    private String correo;
    private String rfc;
    private Domicilio domicilioFiscal;

    public DatosFiscales() {
    }

    public DatosFiscales(String correo, String rfc, Domicilio domicilioFiscal) {
        this.correo = correo;
        this.rfc = rfc;
        this.domicilioFiscal = domicilioFiscal;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getRfc() {
        return rfc;
    }

    public void setRfc(String rfc) {
        this.rfc = rfc;
    }

    public Domicilio getDomicilioFiscal() {
        return domicilioFiscal;
    }

    public void setDomicilioFiscal(Domicilio domicilioFiscal) {
        this.domicilioFiscal = domicilioFiscal;
    }

    @Override
    public String toString() {
        return "DatosFiscales{" + "correo=" + correo + ", rfc=" + rfc + ", domicilioFiscal=" + domicilioFiscal + '}';
    }

}
