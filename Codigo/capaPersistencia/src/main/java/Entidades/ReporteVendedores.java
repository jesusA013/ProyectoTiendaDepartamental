/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Entidades;

import java.util.Date;

/**
 *
 * @author melis
 */
public class ReporteVendedores {
    private int idReporte;
    private int idVendedor;
   private float promedioVentasDiaria;
    private float promedioVentaSemanal;
    private float promedioVentaMensual;
    private float promedioVentaTrimestral;
    private Date fechaReporte;
    private String ciudad;

    public ReporteVendedores(int idReporte, int idVendedor, float promedioVentasDiaria, float promedioVentaSemanal, float promedioVentaMensual, float promedioVentaTrimestral, Date fechaReporte) {
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

    public int getIdReporte() {
        return idReporte;
    }

    public void setIdReporte(int idReporte) {
        this.idReporte = idReporte;
    }

    public int getIdVendedor() {
        return idVendedor;
    }

    public void setIdVendedor(int idVendedor) {
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



}
