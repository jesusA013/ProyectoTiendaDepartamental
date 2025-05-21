package Entidades;

import java.util.Date;

public class Factura {
    private String folioFactura;
    private Date fechaEmision;

    public Factura(String folioFactura, Date fechaEmision) {
        this.folioFactura = folioFactura;
        this.fechaEmision = fechaEmision;
    }

    public Factura() {
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
