package DTOs;

/**
 * ProveedorInformacionContactoDTO.java
 *
 * Representa un objeto de transferencia de datos (DTO) que contiene la
 * información de contacto de un proveedor.
 *
 * @author Ángel Ruíz García - 00000248171
 */
public class ProveedorInformacionContactoDTO {

    private String contacto;
    private String telefono;
    private String correo;
    private String direccion;
    private String paginaWeb;

    /**
     * Constructor por omision.
     */
    public ProveedorInformacionContactoDTO() {
    }

    /**
     * Constructor de la información de contacto del proveedor de objeto de
     * transferencia de datos.
     *
     * @param contacto Contacto del proveedor
     * @param telefono Telefono del proveedor
     * @param correo Correo del proveedor
     * @param direccion Direccion del proveedor
     * @param paginaWeb Pagina web del proveedor
     */
    public ProveedorInformacionContactoDTO(String contacto, String telefono, String correo, String direccion, String paginaWeb) {
        this.contacto = contacto;
        this.telefono = telefono;
        this.correo = correo;
        this.direccion = direccion;
        this.paginaWeb = paginaWeb;
    }

    /**
     * Regresa el contacto del proveedor.
     *
     * @return Contacto del proveedor
     */
    public String getContacto() {
        return contacto;
    }

    /**
     * Establece el contacto del proveedor.
     *
     * @param contacto Contacto del proveedor
     */
    public void setContacto(String contacto) {
        this.contacto = contacto;
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
     * Establece el telefono del proveedor.
     *
     * @param telefono Telefono del proveedor
     */
    public void setTelefono(String telefono) {
        this.telefono = telefono;
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
     * Establece el correo del proveedor.
     *
     * @param correo Correo del proveedor
     */
    public void setCorreo(String correo) {
        this.correo = correo;
    }

    /**
     * Regresa la direccion del proveedor.
     *
     * @return Direccion del proveedor
     */
    public String getDireccion() {
        return direccion;
    }

    /**
     * Establece la direccion del proveedor.
     *
     * @param direccion Direccion del proveedor
     */
    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    /**
     * Regresa la pagina web del proveedor.
     *
     * @return Pagina web del proveedor
     */
    public String getPaginaWeb() {
        return paginaWeb;
    }

    /**
     * Establece la pagina web del proveedor.
     *
     * @param paginaWeb Pagina web del proveedor
     */
    public void setPaginaWeb(String paginaWeb) {
        this.paginaWeb = paginaWeb;
    }

    /**
     * Regresa una cadena con el valor de los atributos.
     *
     * @return Cadena con el valor de los atributos
     */
    @Override
    public String toString() {
        return "ProveedorInformacionContacto{" + "contacto=" + contacto + ", telefono=" + telefono + ", correo=" + correo + ", direccion=" + direccion + ", paginaWeb=" + paginaWeb + '}';
    }
}
