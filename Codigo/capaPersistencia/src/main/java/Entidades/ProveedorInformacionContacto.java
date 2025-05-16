package Entidades;

import org.bson.types.ObjectId;

/**
 * ProveedorInformacionContacto.java
 *
 * Esta clase representa la entidad de la información de contacto del proveedor.
 *
 * @author Ángel Ruíz García - 00000248171
 */
public class ProveedorInformacionContacto {

    private ObjectId idContacto;
    private String contacto;
    private String telefono;
    private String correo;
    private String direccion;
    private String paginaWeb;

    /**
     * Constructor por omision.
     */
    public ProveedorInformacionContacto() {
    }

    /**
     * Inicializa los atributos al valor de sus parámetros.
     *
     * @param contacto Contacto del proveedor
     * @param telefono Teléfono del proveedor
     * @param correo Correo del proveedor
     * @param direccion Dirección del proveedor
     * @param paginaWeb Página web del proveedor
     */
    public ProveedorInformacionContacto(String contacto, String telefono, String correo, String direccion, String paginaWeb) {
        this.contacto = contacto;
        this.telefono = telefono;
        this.correo = correo;
        this.direccion = direccion;
        this.paginaWeb = paginaWeb;
    }

    /**
     * Regresa el ID de la información de contacto.
     *
     * @return ID de la información de contacto
     */
    public ObjectId getIdContacto() {
        return idContacto;
    }

    /**
     * Establece el ID de la información de contacto.
     *
     * @param idContacto ID de la información de contacto
     */
    public void setIdContacto(ObjectId idContacto) {
        this.idContacto = idContacto;
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
     * Regresa el teléfono del proveedor.
     *
     * @return Teléfono del proveedor
     */
    public String getTelefono() {
        return telefono;
    }

    /**
     * Establece el teléfono del proveedor.
     *
     * @param telefono Teléfono del proveedor
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
     * Regresa la dirección del proveedor.
     *
     * @return Dirección del proveedor
     */
    public String getDireccion() {
        return direccion;
    }

    /**
     * Establece la dirección del proveedor.
     *
     * @param direccion Dirección del proveedor
     */
    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    /**
     * Regresa la página web del proveedor.
     *
     * @return Página web del proveedor
     */
    public String getPaginaWeb() {
        return paginaWeb;
    }

    /**
     * Establece la página web del proveedor.
     *
     * @param paginaWeb Página web del proveedor
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
        return "ProveedorInformacionContacto{" + "idContacto=" + idContacto + ", contacto=" + contacto + ", telefono=" + telefono + ", correo=" + correo + ", direccion=" + direccion + ", paginaWeb=" + paginaWeb + '}';
    }
}
