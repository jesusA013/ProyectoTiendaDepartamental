/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Entidades;

import java.util.Date;
import org.bson.types.ObjectId;

/**
 *
 * @author gaspa
 */
public class Vendedor {
    private ObjectId _id;
    private String curp;
    private DatosFiscales datosFiscales;
    private NombreCompleto nombreCompleto;
    private Date fechaNacimiento;
    private String estadoCivil;
    private Domicilio domicilio;
    private Seguro seguro;
    private Date fechaRegistro;
    private boolean activo;
    private Usuario usuario;

    public Vendedor() {
    }

    public Vendedor(ObjectId _id, String curp, DatosFiscales datosFiscales, NombreCompleto nombreCompleto, Date fechaNacimiento, String estadoCivil, Domicilio domicilio, Seguro seguro, Date fechaRegistro, boolean activo,Usuario usuario) {
        this._id = _id;
        this.curp = curp;
        this.datosFiscales = datosFiscales;
        this.nombreCompleto = nombreCompleto;
        this.fechaNacimiento = fechaNacimiento;
        this.estadoCivil = estadoCivil;
        this.domicilio = domicilio;
        this.seguro = seguro;
        this.fechaRegistro = fechaRegistro;
        this.activo = activo;
        this.usuario = usuario;
    }
    
    public Vendedor(String curp, NombreCompleto nombreCompleto, Date fechaNacimiento, String estadoCivil, Domicilio domicilio, Seguro seguro, Date fechaRegistro) {
        this.curp = curp;
        this.nombreCompleto = nombreCompleto;
        this.fechaNacimiento = fechaNacimiento;
        this.estadoCivil = estadoCivil;
        this.domicilio = domicilio;
        this.seguro = seguro;
        this.fechaRegistro = fechaRegistro;
        this.activo = true;
    }

    public Vendedor(String curp, DatosFiscales datosFiscales, NombreCompleto nombreCompleto, Date fechaNacimiento, String estadoCivil, Domicilio domicilio, Seguro seguro, Date fechaRegistro) {
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

    public ObjectId getId() {
        return _id;
    }

    public void setId(ObjectId _id) {
        this._id = _id;
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

    public NombreCompleto getNombreCompleto() {
        return nombreCompleto;
    }

    public void setNombreCompleto(NombreCompleto nombreCompleto) {
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

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }
    

    @Override
    public String toString() {
        return "Vendedor{" + "_id=" + _id + ", curp=" + curp + ", datosFiscales=" + datosFiscales + ", nombreCompleto=" + nombreCompleto + ", fechaNacimiento=" + fechaNacimiento + ", estadoCivil=" + estadoCivil + ", domicilio=" + domicilio + ", seguro=" + seguro + ", fechaRegistro=" + fechaRegistro + ", activo=" + activo + '}';
    }
    
    
}
