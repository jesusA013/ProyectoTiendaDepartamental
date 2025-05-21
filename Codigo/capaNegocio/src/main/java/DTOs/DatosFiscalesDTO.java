/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DTOs;

/**
 *
 * @author gaspa
 */
public class DatosFiscalesDTO {
    private String rfc;
    private DomicilioDTO domicilioFiscal;
    private String correo;

    public DatosFiscalesDTO() {
    }

    public DatosFiscalesDTO(String rfc, DomicilioDTO domicilioFiscal, String correo) {
        this.rfc = rfc;
        this.domicilioFiscal = domicilioFiscal;
        this.correo = correo;
    }

    public String getRfc() {
        return rfc;
    }

    public void setRfc(String rfc) {
        this.rfc = rfc;
    }

    public DomicilioDTO getDomicilioFiscal() {
        return domicilioFiscal;
    }

    public void setDomicilioFiscal(DomicilioDTO domicilioFiscal) {
        this.domicilioFiscal = domicilioFiscal;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }
    
}
