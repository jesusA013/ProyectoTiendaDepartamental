package DTOs;

import java.time.*;

/**
 *
 * @author melis
 */
public class ReporteVendedoresDTO {

    private String idReporte;
    private String idVendedor;
    private float promedioVentasDiarias;
    private float promedioVnetaSemanal;
    private float promedioVentaMnesual;
    private float promedioVnetaTrimestral;
    private LocalDateTime fechaReporte;

    public ReporteVendedoresDTO(String idReporte, String idVendedor, float promedioVentasDiarias, float promedioVnetaSemanal, float promedioVentaMnesual, float promedioVnetaTrimestral, LocalDateTime fechaReporte) {
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
