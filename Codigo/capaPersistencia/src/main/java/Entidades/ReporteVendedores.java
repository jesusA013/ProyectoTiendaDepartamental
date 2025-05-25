package Entidades;

import java.util.Date;

/**
 *
 * @author melis
 */
public class ReporteVendedores {

    private String idReporte;
    private String idVendedor;
    private float promedioVentasDiaria;
    private float promedioVentaSemanal;
    private float promedioVentaMensual;
    private float promedioVentaTrimestral;
    private Date fechaReporte;
    private String ciudad;

    public ReporteVendedores(String idReporte, String idVendedor, float promedioVentasDiaria, float promedioVentaSemanal, float promedioVentaMensual, float promedioVentaTrimestral, Date fechaReporte) {
        this.idReporte = idReporte;
        this.idVendedor = idVendedor;
        this.promedioVentasDiaria = promedioVentasDiaria;
        this.promedioVentaSemanal = promedioVentaSemanal;
        this.promedioVentaMensual = promedioVentaMensual;
        this.promedioVentaTrimestral = promedioVentaTrimestral;
        this.fechaReporte = fechaReporte;
    }

    public ReporteVendedores() {
    }

    public String getIdReporte() {
        return idReporte;
    }

    public void setIdReporte(String idReporte) {
        this.idReporte = idReporte;
    }

    public String getIdVendedor() {
        return idVendedor;
    }

    public void setIdVendedor(String idVendedor) {
        this.idVendedor = idVendedor;
    }

    public float getPromedioVentasDiaria() {
        return promedioVentasDiaria;
    }

    public void setPromedioVentasDiaria(float promedioVentasDiaria) {
        this.promedioVentasDiaria = promedioVentasDiaria;
    }

    public float getPromedioVentaSemanal() {
        return promedioVentaSemanal;
    }

    public void setPromedioVentaSemanal(float promedioVentaSemanal) {
        this.promedioVentaSemanal = promedioVentaSemanal;
    }

    public float getPromedioVentaMensual() {
        return promedioVentaMensual;
    }

    public void setPromedioVentaMensual(float promedioVentaMensual) {
        this.promedioVentaMensual = promedioVentaMensual;
    }

    public float getPromedioVentaTrimestral() {
        return promedioVentaTrimestral;
    }

    public void setPromedioVentaTrimestral(float promedioVentaTrimestral) {
        this.promedioVentaTrimestral = promedioVentaTrimestral;
    }

    public Date getFechaReporte() {
        return fechaReporte;
    }

    public void setFechaReporte(Date fechaReporte) {
        this.fechaReporte = fechaReporte;
    }

    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

}
