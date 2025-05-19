package DTOs;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

/**
 * Angel Beltran
 */
public class FolioDTO {

    private String numeroFolio;
    private Calendar fecha;
    private String nombreProveedor; // nombre o id no estoy seguro aun

    /**
     * Constructor por ausencia
     */
    public FolioDTO() {
    }

    /**
     * Constructor completo.
     *
     * @param numeroFolio Número del folio
     * @param fecha Fecha del folio
     * @param nombreProveedor Nombre del proveedor asociado
     */
    public FolioDTO(String numeroFolio, Calendar fecha, String nombreProveedor) {
        this.numeroFolio = numeroFolio;
        this.fecha = fecha;
        this.nombreProveedor = nombreProveedor;
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

    public String getNombreProveedor() {
        return nombreProveedor;
    }

    public void setNombreProveedor(String nombreProveedor) {
        this.nombreProveedor = nombreProveedor;
    }

    // ToString
    @Override
    public String toString() {
        return "FolioDTO{" +
                "numeroFolio='" + numeroFolio + '\'' +
                ", fecha=" + (fecha != null ? fecha.getTime() : "null") +
                ", nombreProveedor='" + nombreProveedor + '\'' +
                '}';
    }
}
