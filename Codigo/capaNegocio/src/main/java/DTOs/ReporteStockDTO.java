package DTOs;

import java.util.Calendar;

/**
 * ReporteStockDTO.java
 *
 * Data Transfer Object para transferir datos de un reporte de stock agregado.
 */
public class ReporteStockDTO {

    private String numeroFolio;
    private Calendar fecha;
    private int totalProductos;

    /**
     * Constructor por ausencia
     */
    public ReporteStockDTO() {
    }

    /**
     * Constructor completo.
     *
     * @param numeroFolio Número del folio
     * @param fecha Fecha del folio
     * @param totalProductos Total de productos agregados
     */
    public ReporteStockDTO(String numeroFolio, Calendar fecha, int totalProductos) {
        this.numeroFolio = numeroFolio;
        this.fecha = fecha;
        this.totalProductos = totalProductos;
    }

    // Getters y Setters
    public String getNumeroFolio() {
        return numeroFolio;
    }

    public void setNumeroFolio(String numeroFolio) {
        this.numeroFolio = numeroFolio;
    }

    public Calendar getFecha() {
        return fecha;
    }

    public void setFecha(Calendar fecha) {
        this.fecha = fecha;
    }

    public int getTotalProductos() {
        return totalProductos;
    }

    public void setTotalProductos(int totalProductos) {
        this.totalProductos = totalProductos;
    }

    /**
     * Regresa una cadena con todos los datos del reporte.
     *
     * @return Cadena con todos los datos del reporte
     */
    @Override
    public String toString() {
        return "ReporteStockDTO{"
                + "numeroFolio='" + numeroFolio + '\''
                + ", fecha=" + (fecha != null ? fecha.getTime() : "null")
                + ", totalProductos=" + totalProductos
                + '}';
    }
}
