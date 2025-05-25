package Entidades;

import java.util.Date;

/**
 * Vendedor.java
 *
 *
 *
 * @author
 */
public class Vendedor {

    private String idVendedor;
    private String curp;
    private DatosFiscales datosFiscales;
    private String nombreCompleto;
    private Date fechaNacimiento;
    private String estadoCivil;
    private Domicilio domicilio;
    private Seguro seguro;
    private Date fechaRegistro;
    private boolean activo;
    private String ciudad;
    private String municipio;
    private String foto;
    private String rfc;
    private double totalventas;
    private int raiting;

    public Vendedor() {
    }

    public Vendedor(String curp, String nombreCompleto, Date fechaNacimiento, String estadoCivil, Domicilio domicilio, Seguro seguro, Date fechaRegistro) {
        this.curp = curp;
        this.nombreCompleto = nombreCompleto;
        this.fechaNacimiento = fechaNacimiento;
        this.estadoCivil = estadoCivil;
        this.domicilio = domicilio;
        this.seguro = seguro;
        this.fechaRegistro = fechaRegistro;
        this.activo = true;
    }

    public Vendedor(String curp, String nombreCompleto, Date fechaNacimiento, Domicilio domicilio, boolean activo, String ciudad, String municipio, String foto, String rfc, double totalventas, int raiting) {
        this.curp = curp;
        this.nombreCompleto = nombreCompleto;
        this.fechaNacimiento = fechaNacimiento;
        this.domicilio = domicilio;
        this.activo = activo;
        this.ciudad = ciudad;
        this.municipio = municipio;
        this.foto = foto;
        this.rfc = rfc;
        this.totalventas = totalventas;
        this.raiting = raiting;
    }

    public Vendedor(String curp, DatosFiscales datosFiscales, String nombreCompleto, Date fechaNacimiento, String estadoCivil, Domicilio domicilio, Seguro seguro, Date fechaRegistro) {
        this.curp = curp;
        this.datosFiscales = datosFiscales;
        this.nombreCompleto = nombreCompleto;
        this.fechaNacimiento = fechaNacimiento;
        this.estadoCivil = estadoCivil;
        this.domicilio = domicilio;
        this.seguro = seguro;
        this.fechaRegistro = fechaRegistro;
        this.activo = true;
    }

    public String getIdVendedor() {
        return idVendedor;
    }

    public void setIdVendedor(String idVendedor) {
        this.idVendedor = idVendedor;
    }

    public String getCurp() {
        return curp;
    }

    public void setCurp(String curp) {

        this.curp = curp;
    }

    public DatosFiscales getDatosFiscales() {
        return datosFiscales;
    }

    public void setDatosFiscales(DatosFiscales datosFiscales) {
        this.datosFiscales = datosFiscales;
    }

    public String getNombreCompleto() {
        return nombreCompleto;
    }

    public void setNombreCompleto(String nombreCompleto) {
        this.nombreCompleto = nombreCompleto;
    }

    public Date getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(Date fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public String getEstadoCivil() {
        return estadoCivil;
    }

    public void setEstadoCivil(String estadoCivil) {
        this.estadoCivil = estadoCivil;
    }

    public Domicilio getDomicilio() {
        return domicilio;
    }

    public void setDomicilio(Domicilio domicilio) {
        this.domicilio = domicilio;
    }

    public Seguro getSeguro() {
        return seguro;
    }

    public void setSeguro(Seguro seguro) {
        this.seguro = seguro;
    }

    public Date getFechaRegistro() {
        return fechaRegistro;
    }

    public void setFechaRegistro(Date fechaRegistro) {
        this.fechaRegistro = fechaRegistro;
    }

    public boolean isActivo() {
        return activo;
    }

    public void setActivo(boolean activo) {
        this.activo = activo;
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

    public String getRfc() {
        return rfc;
    }

    public void setRfc(String rfc) {
        this.rfc = rfc;
    }

    public double getTotalventas() {
        return totalventas;
    }

    public void setTotalventas(double totalventas) {
        if (totalventas < 0) {
            throw new IllegalArgumentException("la venta no puede ser negatuva");
        }
        this.totalventas = totalventas;
    }

    public int getRaiting() {
        return raiting;
    }

    public void setRaiting(int raiting) {
        this.raiting = raiting;
    }

    @Override
    public String toString() {
        return "Vendedor{" + "idVendedor=" + idVendedor + ", curp=" + curp + ", datosFiscales=" + datosFiscales + ", nombreCompleto=" + nombreCompleto + ", fechaNacimiento=" + fechaNacimiento + ", estadoCivil=" + estadoCivil + ", domicilio=" + domicilio + ", seguro=" + seguro + ", fechaRegistro=" + fechaRegistro + ", activo=" + activo + '}';
    }

}
