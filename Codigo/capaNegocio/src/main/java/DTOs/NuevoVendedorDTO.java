/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DTOs;

import java.time.LocalDate;

/**
 *
 * @author melis
 */
public class NuevoVendedorDTO {
     public String nombre;
    public String rfc;
    public String domicilio;
    public String curp;
    public LocalDate fechaNacimiento;
    public String ciudad;
    public String municipio;
    public String foto;

    public NuevoVendedorDTO(String nombre, String rfc, String domicilio, String curp, LocalDate fechaNacimiento, String ciudad, String municipio, String rutaFoto) {
        this.nombre = nombre;
        this.rfc = rfc;
        this.domicilio = domicilio;
        this.curp = curp;
        this.fechaNacimiento = fechaNacimiento;
        this.ciudad = ciudad;
        this.municipio = municipio;
        this.foto = rutaFoto;
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

    public LocalDate getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(LocalDate fechaNacimiento) {
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

    public String getRutaFoto() {
        return foto;
    }

    public void setRutaFoto(String rutaFoto) {
        this.foto = rutaFoto;
    }
   
}
