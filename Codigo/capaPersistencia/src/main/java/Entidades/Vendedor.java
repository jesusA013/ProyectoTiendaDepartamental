package Entidades;

import java.util.Date;
import java.util.UUID;

/**
 * Vendedor.java
 *
 *
 *
 * @author
 */
public class Vendedor {

    private String idVendedor;
    private String nombre;
    private String apellidos;
    private String curp;
    private String nombreCompleto;
    private Date fechaNacimientoDia;
    private Date fechaNacimientoMes;
    private Date fechaNacimientoAño;
    private Domicilio domicilio;
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

    public Vendedor(String idVendedor, String nombre, String apellidos, String curp, String nombreCompleto, Date fechaNacimientoDia, Date fechaNacimientoMes, Date fechaNacimientoAño, Domicilio domicilio, Date fechaRegistro, boolean activo, String ciudad, String municipio, String foto, String rfc, double totalventas, int raiting) {
        this.idVendedor = idVendedor;
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.curp = curp;
        this.nombreCompleto = nombreCompleto;
        this.fechaNacimientoDia = fechaNacimientoDia;
        this.fechaNacimientoMes = fechaNacimientoMes;
        this.fechaNacimientoAño = fechaNacimientoAño;
        this.domicilio = domicilio;
        this.fechaRegistro = fechaRegistro;
        this.activo = true;
    }

    /*ete metodo genra un id random
     */
    private String generarId() {
        return UUID.randomUUID().toString();
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

    public String getNombreCompleto() {
        return nombreCompleto;
    }

    public void setNombreCompleto(String nombreCompleto) {
        this.nombreCompleto = nombreCompleto;
    }

    public Date getFechaNacimientoDia() {
        return fechaNacimientoDia;
    }

    public void setFechaNacimientoDia(Date fechaNacimientoDia) {
        this.fechaNacimientoDia = fechaNacimientoDia;
    }

    public Date getFechaNacimientoMes() {
        return fechaNacimientoMes;
    }

    public void setFechaNacimientoMes(Date fechaNacimientoMes) {
        this.fechaNacimientoMes = fechaNacimientoMes;
    }

    public Date getFechaNacimientoAño() {
        return fechaNacimientoAño;
    }

    public void setFechaNacimientoAño(Date fechaNacimientoAño) {
        this.fechaNacimientoAño = fechaNacimientoAño;
    }

    public Domicilio getDomicilio() {
        return domicilio;
    }

    public void setDomicilio(Domicilio domicilio) {
        this.domicilio = domicilio;
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
        return "Vendedor{" + "idVendedor=" + idVendedor + ", nombre=" + nombre + ", apellidos=" + apellidos + ", curp=" + curp + ", nombreCompleto=" + nombreCompleto + ", fechaNacimientoDia=" + fechaNacimientoDia + ", fechaNacimientoMes=" + fechaNacimientoMes + ", fechaNacimientoA\u00f1o=" + fechaNacimientoAño + ", domicilio=" + domicilio + ", fechaRegistro=" + fechaRegistro + ", activo=" + activo + ", ciudad=" + ciudad + ", municipio=" + municipio + ", foto=" + foto + ", rfc=" + rfc + ", totalventas=" + totalventas + ", raiting=" + raiting + '}';
    }

}
