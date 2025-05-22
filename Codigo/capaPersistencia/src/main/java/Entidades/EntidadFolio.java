package Entidades;

import java.util.Calendar;

/**
 * Folio.java
 *
 * Esta clase representa la entidad de un folio.
 */
public class EntidadFolio {

    private int idFolio;
    private String numeroFolio;
    private Calendar fecha;
    private String nombreProveedor; // nombre o id

    /**
     * Constructor por ausencia
     */
    public EntidadFolio() {
    }

    /**
     * Constructor de un folio.
     *
     * @param idFolio Identificador único del folio
     * @param numeroFolio Número del folio
     * @param fecha Fecha de creación del folio
     * @param nombreProveedor Nombre del proveedor asociado
     */
    public EntidadFolio(int idFolio, String numeroFolio, Calendar fecha, String nombreProveedor) {
        this.idFolio = idFolio;
        this.numeroFolio = numeroFolio;
        this.fecha = fecha;
        this.nombreProveedor = nombreProveedor;
    }

    /**
     * Regresa el ID del folio.
     *
     * @return ID del folio
     */
    public int getIdFolio() {
        return idFolio;
    }

    /**
     * Establece el ID del folio.
     *
     * @param idFolio ID del folio
     */
    public void setIdFolio(int idFolio) {
        this.idFolio = idFolio;
    }

    /**
     * Regresa el número del folio.
     *
     * @return Número del folio
     */
    public String getNumeroFolio() {
        return numeroFolio;
    }

    /**
     * Establece el número del folio.
     *
     * @param numeroFolio Número del folio
     */
    public void setNumeroFolio(String numeroFolio) {
        this.numeroFolio = numeroFolio;
    }

    /**
     * Regresa la fecha de creación del folio.
     *
     * @return Fecha de creación del folio
     */
    public Calendar getFecha() {
        return fecha;
    }

    /**
     * Establece la fecha de creación del folio.
     *
     * @param fecha Fecha de creación del folio
     */
    public void setFecha(Calendar fecha) {
        this.fecha = fecha;
    }

    /**
     * Regresa el nombre del proveedor asociado.
     *
     * @return Nombre del proveedor
     */
    public String getNombreProveedor() {
        return nombreProveedor;
    }

    /**
     * Establece el nombre del proveedor asociado.
     *
     * @param nombreProveedor Nombre del proveedor
     */
    public void setNombreProveedor(String nombreProveedor) {
        this.nombreProveedor = nombreProveedor;
    }

    /**
     * Regresa una cadena con todos los datos del folio.
     *
     * @return Cadena con todos los datos del folio
     */
    @Override
    public String toString() {
        return "Folio{" + "idFolio=" + idFolio + ", numeroFolio='" + numeroFolio + '\'' + 
               ", fecha=" + (fecha != null ? fecha.getTime() : "null") + ", nombreProveedor='" + nombreProveedor + '\'' + '}';
    }
}
