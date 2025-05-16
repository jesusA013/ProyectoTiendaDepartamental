package DTOs;

import org.bson.types.ObjectId;

/**
 * ProveedorDTO.java
 *
 * Representa un objeto de transferencia de datos (DTO) que contiene la
 * información de un proveedor.
 *
 * @author Ángel Ruíz García - 00000248171
 */
public class ProveedorDTO {

    private ObjectId idProveedor;
    private ProveedorInformacionBasicaDTO basica;
    private ProveedorInformacionContactoDTO contacto;
    private ProveedorInformacionComercialDTO comercial;
    private ProveedorInformacionGestionDTO gestion;

    /**
     * Constructor por omision.
     */
    public ProveedorDTO() {
    }

    /**
     * Constructor de la información de del proveedor de objeto de transferencia
     * de datos.
     *
     * @param idProveedor ID del proveedor
     * @param basica Información básica del proveedor
     * @param contacto Información contacto del proveedor
     * @param comercial Información comercial del proveedor
     * @param gestion Información de historial y gestión del proveedor
     */
    public ProveedorDTO(ObjectId idProveedor, ProveedorInformacionBasicaDTO basica, ProveedorInformacionContactoDTO contacto, ProveedorInformacionComercialDTO comercial, ProveedorInformacionGestionDTO gestion) {
        this.idProveedor = idProveedor;
        this.basica = basica;
        this.contacto = contacto;
        this.comercial = comercial;
        this.gestion = gestion;
    }

    /**
     * Regresa el ID del proveedor.
     *
     * @return ID del proveedor
     */
    public ObjectId getIdProveedor() {
        return idProveedor;
    }

    /**
     * Establece el ID del proveedor.
     *
     * @param idProveedor ID del proveedor
     */
    public void setIdProveedor(ObjectId idProveedor) {
        this.idProveedor = idProveedor;
    }

    /**
     * Regresa la información básica del proveedor.
     *
     * @return Información básica del proveedor
     */
    public ProveedorInformacionBasicaDTO getBasica() {
        return basica;
    }

    /**
     * Establece la información básica del proveedor.
     *
     * @param basica Información básica del proveedor
     */
    public void setBasica(ProveedorInformacionBasicaDTO basica) {
        this.basica = basica;
    }

    /**
     * Regresa la información contacto del proveedor.
     *
     * @return Información contacto del proveedor
     */
    public ProveedorInformacionContactoDTO getContacto() {
        return contacto;
    }

    /**
     * Establece la información contacto del proveedor.
     *
     * @param contacto Información contacto del proveedor
     */
    public void setContacto(ProveedorInformacionContactoDTO contacto) {
        this.contacto = contacto;
    }

    /**
     * Regresa la información comercial del proveedor.
     *
     * @return Información comercial del proveedor
     */
    public ProveedorInformacionComercialDTO getComercial() {
        return comercial;
    }

    /**
     * Establece la información comercial del proveedor.
     *
     * @param comercial Información comercial del proveedor
     */
    public void setComercial(ProveedorInformacionComercialDTO comercial) {
        this.comercial = comercial;
    }

    /**
     * Regresa la información de historial y gestión del proveedor.
     *
     * @return Información de historial y gestión del proveedor
     */
    public ProveedorInformacionGestionDTO getGestion() {
        return gestion;
    }

    /**
     * Establece la información de historial y gestión del proveedor.
     *
     * @param gestion Información de historial y gestión del proveedor
     */
    public void setGestion(ProveedorInformacionGestionDTO gestion) {
        this.gestion = gestion;
    }

    /**
     * Regresa la cadena con todos los datos.
     *
     * @return Cadena con todos los datos
     */
    @Override
    public String toString() {
        return "ProveedorDTO{" + "idProveedor=" + idProveedor + ", basica=" + basica + ", contacto=" + contacto + ", comercial=" + comercial + ", gestion=" + gestion + '}';
    }
}
