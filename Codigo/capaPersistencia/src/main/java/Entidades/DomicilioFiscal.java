/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Entidades;

/**
 *
 * @author gaspa
 */
public class DomicilioFiscal {
    private String calle;
    private String delegacionMunicipio;
    private String ciudadLocalidad;
    private String codigoPostal;
    

    public DomicilioFiscal() {
    }

    public DomicilioFiscal(String calle, String delegacionMunicipio, String ciudadLocalidad, String codigoPostal) {
        this.calle = calle;
        this.delegacionMunicipio = delegacionMunicipio;
        this.ciudadLocalidad = ciudadLocalidad;
        this.codigoPostal = codigoPostal;
    }

    public String getCalle() {
        return calle;
    }

    public void setCalle(String calle) {
        this.calle = calle;
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

    public String getCodigoPostal() {
        return codigoPostal;
    }

    public void setCodigoPostal(String codigoPostal) {
        this.codigoPostal = codigoPostal;
    }

    

    @Override
    public String toString() {
        return "DomicilioFiscal{" + "calle=" + calle + ", delegacionMunicipio=" + delegacionMunicipio + ", ciudadLocalidad=" + ciudadLocalidad + ", codigoPostal=" + codigoPostal + ", correo=" + '}';
    }
}
