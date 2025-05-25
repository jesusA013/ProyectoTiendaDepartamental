package Entidades;

import java.time.LocalDateTime;

/**
 *
 * @author melis
 */
public class RegistroVendedor {

    private String nombre;
    private String rfc;
    private String domicilio;
    private LocalDateTime fechaNacimiento;
    private String curp;
    private String ciudad;
    private String municipio;
    private String foto;

    public RegistroVendedor(String nombre, String rfc, String domicilio, LocalDateTime fechaNacimiento, String curp, String ciudad, String municipio, String foto) {
        this.nombre = nombre;
        this.rfc = rfc;
        this.domicilio = domicilio;
        this.fechaNacimiento = fechaNacimiento;
        this.curp = curp;
        this.ciudad = ciudad;
        this.municipio = municipio;
        this.foto = foto;
    }

    public RegistroVendedor() {
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

    public LocalDateTime getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(LocalDateTime fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public String getCurp() {
        return curp;
    }

    public void setCurp(String curp) {
        this.curp = curp;
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

}
