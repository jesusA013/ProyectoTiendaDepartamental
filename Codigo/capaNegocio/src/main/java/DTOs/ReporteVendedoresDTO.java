/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DTOs;

import java.time.*;

/**
 *
 * @author melis
 */
public class ReporteVendedoresDTO {
    private int idReporte;
    private int idVendedor;
    private float promedioVentasDiarias;
    private float promedioVnetaSemanal;
    private float promedioVentaMnesual;
    private float promedioVnetaTrimestral;
    private LocalDateTime fechaReporte;

    public ReporteVendedoresDTO(int idReporte, int idVendedor, float promedioVentasDiarias, float promedioVnetaSemanal, float promedioVentaMnesual, float promedioVnetaTrimestral, LocalDateTime fechaReporte) {
        this.idReporte = idReporte;
        this.idVendedor = idVendedor;
        this.promedioVentasDiarias = promedioVentasDiarias;
        this.promedioVnetaSemanal = promedioVnetaSemanal;
        this.promedioVentaMnesual = promedioVentaMnesual;
        this.promedioVnetaTrimestral = promedioVnetaTrimestral;
        this.fechaReporte = fechaReporte;
    }

    public ReporteVendedoresDTO() {
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

    public float getPromedioVentasDiarias() {
        return promedioVentasDiarias;
    }

    public void setPromedioVentasDiarias(float promedioVentasDiarias) {
        this.promedioVentasDiarias = promedioVentasDiarias;
    }

    public float getPromedioVnetaSemanal() {
        return promedioVnetaSemanal;
    }

    public void setPromedioVnetaSemanal(float promedioVnetaSemanal) {
        this.promedioVnetaSemanal = promedioVnetaSemanal;
    }

    public float getPromedioVentaMnesual() {
        return promedioVentaMnesual;
    }

    public void setPromedioVentaMnesual(float promedioVentaMnesual) {
        this.promedioVentaMnesual = promedioVentaMnesual;
    }

    public float getPromedioVnetaTrimestral() {
        return promedioVnetaTrimestral;
    }

    public void setPromedioVnetaTrimestral(float promedioVnetaTrimestral) {
        this.promedioVnetaTrimestral = promedioVnetaTrimestral;
    }

    public LocalDateTime getFechaReporte() {
        return fechaReporte;
    }

    public void setFechaReporte(LocalDateTime fechaReporte) {
        this.fechaReporte = fechaReporte;
    }
    
    
    



}
