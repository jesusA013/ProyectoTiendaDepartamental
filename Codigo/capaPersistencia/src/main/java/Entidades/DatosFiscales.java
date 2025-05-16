/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Entidades;

/**
 *
 * @author gaspa
 */
public class DatosFiscales {
    private String correo;
    private String rfc;
    private DomicilioFiscal domicilioFiscal;

    public DatosFiscales() {
    }

    public DatosFiscales(String correo, String rfc, DomicilioFiscal domicilioFiscal) {
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

    public DomicilioFiscal getDomicilioFiscal() {
        return domicilioFiscal;
    }

    public void setDomicilioFiscal(DomicilioFiscal domicilioFiscal) {
        this.domicilioFiscal = domicilioFiscal;
    }
    

    @Override
    public String toString() {
        return "DatosFiscales{" + "correo=" + correo + ", rfc=" + rfc + ", domicilioFiscal=" + domicilioFiscal + '}';
    }
    
}
