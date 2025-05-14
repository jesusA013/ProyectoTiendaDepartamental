package DTOs;

/**
 * ProveedorInformacionGestionDTO.java
 *
 * Representa un objeto de transferencia de datos (DTO) que contiene la
 * información de historial y gestión de un proveedor.
 *
 * @author Ángel Ruíz García - 00000248171
 */
public class ProveedorInformacionGestionDTO {

    private String fechaAlta;
    private String estado;
    private String comentarios;

    /**
     * Constructor por omision.
     */
    public ProveedorInformacionGestionDTO() {
    }

    /**
     * Constructor de la información de historial y gestión del proveedor de
     * objeto de transferencia de datos.
     *
     * @param fechaAlta Fecha de alta del proveedor
     * @param estado Estado del proveedor
     * @param comentarios Comentarios sobre el proveedor
     */
    public ProveedorInformacionGestionDTO(String fechaAlta, String estado, String comentarios) {
        this.fechaAlta = fechaAlta;
        this.estado = estado;
        this.comentarios = comentarios;
    }

    /**
     * Regresa la fecha de alta del proveedor.
     *
     * @return Fecha de alta del proveedor
     */
    public String getFechaAlta() {
        return fechaAlta;
    }

    /**
     * Establece la fecha de alta del proveedor.
     *
     * @param fechaAlta Fecha de alta del proveedor
     */
    public void setFechaAlta(String fechaAlta) {
        this.fechaAlta = fechaAlta;
    }

    /**
     * Regresa el estado del proveedor.
     *
     * @return Estado del proveedor
     */
    public String getEstado() {
        return estado;
    }

    /**
     * Establece el estado del proveedor.
     *
     * @param estado Estado del proveedor
     */
    public void setEstado(String estado) {
        this.estado = estado;
    }

    /**
     * Regresa los comentarios sobre el proveedor.
     *
     * @return Comentarios sobre el proveedor
     */
    public String getComentarios() {
        return comentarios;
    }

    /**
     * Establece los comentarios sobre el proveedor.
     *
     * @param comentarios Comentarios sobre el proveedor
     */
    public void setComentarios(String comentarios) {
        this.comentarios = comentarios;
    }

    /**
     * Regresa la cadena con todos los datos.
     *
     * @return Cadena con todos los datos
     */
    @Override
    public String toString() {
        return "ProveedorInformacionGestionDTO{" + "fechaAlta=" + fechaAlta + ", estado=" + estado + ", comentarios=" + comentarios + '}';
    }
}
