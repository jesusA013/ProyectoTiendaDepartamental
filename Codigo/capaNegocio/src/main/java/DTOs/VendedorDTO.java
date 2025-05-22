/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DTOs;

import java.util.Date;
import org.bson.types.ObjectId;

/**
 *
 * @author gaspa
 */
public class VendedorDTO {
    private ObjectId id;
    private String curp;
    private NombreCompletoDTO nombreCompleto;
    private Date fechaNacimiento;
    private String estadoCivil;
    private DomicilioDTO domicilio;
    private DatosFiscalesDTO datosFiscales;
    private SeguroDTO seguro;
    private Date fechaRegistro;
    private boolean activo;
    private UsuarioDTO usuario;
    public VendedorDTO() {
    }

    public VendedorDTO(ObjectId id,String curp, NombreCompletoDTO nombreCompleto, Date fechaNacimiento, String estadoCivil, DomicilioDTO domicilio, DatosFiscalesDTO datosFiscales, SeguroDTO seguro, Date fechaRegistro, boolean activo,UsuarioDTO usuario) {
        this.id = id;
        this.curp = curp;
        this.nombreCompleto = nombreCompleto;
        this.fechaNacimiento = fechaNacimiento;
        this.estadoCivil = estadoCivil;
        this.domicilio = domicilio;
        this.datosFiscales = datosFiscales;
        this.seguro = seguro;
        this.fechaRegistro = fechaRegistro;
        this.activo = activo;
        this.usuario = usuario;
    }

    public ObjectId getId() {
        return id;
    }

    public void setId(ObjectId id) {
        this.id = id;
    }

    public void setUsuario(UsuarioDTO usuario) {
        this.usuario = usuario;
    }

    public UsuarioDTO getUsuario() {
        return usuario;
    }

    public String getCurp() {
        return curp;
    }

    public void setCurp(String curp) {
        this.curp = curp;
    }

    public NombreCompletoDTO getNombreCompleto() {
        return nombreCompleto;
    }

    public void setNombreCompleto(NombreCompletoDTO nombreCompleto) {
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

    public DomicilioDTO getDomicilio() {
        return domicilio;
    }

    public void setDomicilio(DomicilioDTO domicilio) {
        this.domicilio = domicilio;
    }

    public DatosFiscalesDTO getDatosFiscales() {
        return datosFiscales;
    }

    public void setDatosFiscales(DatosFiscalesDTO datosFiscales) {
        this.datosFiscales = datosFiscales;
    }

    public SeguroDTO getSeguro() {
        return seguro;
    }

    public void setSeguro(SeguroDTO seguro) {
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
    
}
