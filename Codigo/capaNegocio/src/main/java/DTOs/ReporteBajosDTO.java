package DTOs;

/**
 * ReporteBajosDTO.java
 *
 * Data Transfer Object para transferir datos de un reporte de productos bajos.
 */
public class ReporteBajosDTO {

    private String sku;
    private String nombre;
    private int stock;
    private int umbral; // Atributo añadido

    /**
     * Constructor por ausencia
     */
    public ReporteBajosDTO() {
    }

    /**
     * Constructor completo.
     *
     * @param sku SKU del producto
     * @param nombre Nombre del producto
     * @param stock Stock del producto
     * @param umbral Umbral usado para el reporte
     */
    public ReporteBajosDTO(String sku, String nombre, int stock, int umbral) {
        this.sku = sku;
        this.nombre = nombre;
        this.stock = stock;
        this.umbral = umbral;
    }

    // Getters y Setters
    public String getSku() {
        return sku;
    }

    public void setSku(String sku) {
        this.sku = sku;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public int getUmbral() {
        return umbral;
    }

    public void setUmbral(int umbral) {
        this.umbral = umbral;
    }

    /**
     * Regresa una cadena con todos los datos del reporte.
     *
     * @return Cadena con todos los datos del reporte
     */
    @Override
    public String toString() {
        return "ReporteBajosDTO{"
                + "sku='" + sku + '\''
                + ", nombre='" + nombre + '\''
                + ", stock=" + stock
                + ", umbral=" + umbral
                + '}';
    }
}
