package DTOs;

/**
 * ProveedorTablaDTO.java
 *
 * Representa un objeto de transferencia de datos (DTO) que contiene los datos
 * que usaran en la table de proveedores.
 *
 * @author Ángel Ruíz García - 00000248171
 */
public class ProveedorTablaDTO {

    private final int idProveedor;
    private final String nombreProveedor;
    private final String telefono;
    private final String correo;
    private final String estado;

    /**
     * Contructor de la tabla de proveedores
     *
     * @param idProveedor ID del proveedor
     * @param nombreProveedor Nombre del proveedor
     * @param telefono Telefono del proveedor
     * @param correo Correo del proveedor
     * @param estado Estado del proveedor
     */
    public ProveedorTablaDTO(int idProveedor, String nombreProveedor, String telefono, String correo, String estado) {
        this.idProveedor = idProveedor;
        this.nombreProveedor = nombreProveedor;
        this.telefono = telefono;
        this.correo = correo;
        this.estado = estado;
    }

    /**
     * Regresa la identificación del proveedor.
     *
     * @return ID del proveedor
     */
    public int getIdProveedor() {
        return idProveedor;
    }

    /**
     * Regresa el nombre del proveedor
     *
     * @return Nombre del proveedor
     */
    public String getNombreProveedor() {
        return nombreProveedor;
    }

    /**
     * Regresa el telefono del proveedor.
     *
     * @return Telefono del proveedor
     */
    public String getTelefono() {
        return telefono;
    }

    /**
     * Regresa el correo del proveedor.
     *
     * @return Correo del proveedor
     */
    public String getCorreo() {
        return correo;
    }

    /**
     * Regresa el rstado del proveedor.
     *
     * @return Estado del proveedor
     */
    public String getEstado() {
        return estado;
    }
}
