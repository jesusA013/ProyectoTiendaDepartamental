/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DTOs;

import java.util.Date;

/**
 *
 * @author melis
 */
public class NuevoVendedorDTO {
     private String nombre;
    private String rfc;
    private String domicilio;
    private String curp;
    private Date fechaNacimiento;
    private String ciudad;
    private String municipio;
    private String foto;

    public NuevoVendedorDTO(String nombre, String rfc, String domicilio, String curp, Date fechaNacimiento, String ciudad, String municipio, String foto) {
        this.nombre = nombre;
        this.rfc = rfc;
        this.domicilio = domicilio;
        this.curp = curp;
        this.fechaNacimiento = fechaNacimiento;
        this.ciudad = ciudad;
        this.municipio = municipio;
        this.foto = foto;
    }

    public NuevoVendedorDTO() {
    }
    
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getRfc() {
        return rfc;
    }

    public void setRfc(String rfc) {
        this.rfc = rfc;
    }

    public String getDomicilio() {
        return domicilio;
    }

    public void setDomicilio(String domicilio) {
        this.domicilio = domicilio;
    }

    public String getCurp() {
        return curp;
    }

    public void setCurp(String curp) {
        this.curp = curp;
    }

    public Date getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(Date fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    public String getMunicipio() {
        return municipio;
    }

    public void setMunicipio(String municipio) {
        this.municipio = municipio;
    }

    public String getFoto() {
        return foto;
    }

    public void setFoto(String foto) {
        this.foto = foto;
    }

    @Override
    public String toString() {
        return "NuevoVendedorDTO{" + "nombre=" + nombre + ", rfc=" + rfc + ", domicilio=" + domicilio + ", curp=" + curp + ", fechaNacimiento=" + fechaNacimiento + ", ciudad=" + ciudad + ", municipio=" + municipio + ", foto=" + foto + '}';
    }
   //metodo para validacoines de datos no vacios
}
