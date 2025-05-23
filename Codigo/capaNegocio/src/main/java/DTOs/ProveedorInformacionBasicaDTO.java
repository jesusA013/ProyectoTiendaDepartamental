package DTOs;

/**
 * ProveedorInformacionBasicaDTO.java
 *
 * Representa un objeto de transferencia de datos (DTO) que contiene la
 * información básica de un proveedor.
 *
 * @author Ángel Ruíz García - 00000248171
 */
public class ProveedorInformacionBasicaDTO {

    private String nombreProveedor;

    /**
     * Constructor por omision.
     */
    public ProveedorInformacionBasicaDTO() {
    }

    /**
     * Constructor de la informacion basica del proveedor de objeto de
     * transferencia de datos.
     *
     * @param nombreProveedor Nombre del proveedor
     */
    public ProveedorInformacionBasicaDTO(String nombreProveedor) {
        this.nombreProveedor = nombreProveedor;
    }

    /**
     * Regresa el nombre del proveedor.
     *
     * @return Nombre del proveedor
     */
    public String getNombreProveedor() {
        return nombreProveedor;
    }

    /**
     * Establece el nombre del proveedor.
     *
     * @param nombreProveedor Nombre del proveedor
     */
    public void setNombreProveedor(String nombreProveedor) {
        this.nombreProveedor = nombreProveedor;
    }

    /**
     * Regresa una cadena con el valor de los atributos.
     *
     * @return Cadena con el valor de los atributos
     */
    @Override
    public String toString() {
        return "ProveedorInformacionBasica{" + "nombreProveedor=" + nombreProveedor + '}';
    }
}
