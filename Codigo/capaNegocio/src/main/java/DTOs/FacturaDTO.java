package DTOs;

import java.util.Date;

/**
 * FacturaDTO.java
 *
 * Esta clase representa una factura de objeto de transferencia de datos
 *
 * @author
 */
public class FacturaDTO {

    private String folioFactura;
    private Date fechaEmision;

    /**
     * Constructor por omision
     */
    public FacturaDTO() {
    }
    
    /**
     * Inicializa los atributos al valor de sus parámetros.
     * @param folioFactura
     * @param fechaEmision 
     */
    public FacturaDTO(String folioFactura, Date fechaEmision) {
        this.folioFactura = folioFactura;
        this.fechaEmision = fechaEmision;
    }

    public String getFolioFactura() {
        return folioFactura;
    }

    public void setFolioFactura(String folioFactura) {
        this.folioFactura = folioFactura;
    }

    public Date getFechaEmision() {
        return fechaEmision;
    }

    public void setFechaEmision(Date fechaEmision) {
        this.fechaEmision = fechaEmision;
    }

    @Override
    public String toString() {
        return "Factura{" + "folioFactura=" + folioFactura + ", fechaEmision=" + fechaEmision + '}';
    }

}
