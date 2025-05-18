package Entidades;

import org.bson.codecs.pojo.annotations.BsonId;
import org.bson.types.ObjectId;

/**
 * Proveedor.java
 *
 * Esta clase representa la entidad proveedor con todos los datos del proveedor.
 *
 * @author Ángel Ruíz García - 00000248171
 */
public class Proveedor {

    @BsonId
    private ObjectId idProveedor;
    private ProveedorInformacionBasica basica;
    private ProveedorInformacionContacto contacto;
    private ProveedorInformacionComercial comercial;
    private ProveedorInformacionGestion gestion;

    /**
     * Constructor por omision.
     */
    public Proveedor() {
    }

    /**
     * Inicializa los atributos al valor de sus parámetros.
     *
     * @param idProveedor ID del proveedor
     * @param basica Información básica del proveedor
     * @param contacto Información contacto del proveedor
     * @param comercial Información comercial del proveedor
     * @param gestion Información de historial y gestión del proveedor
     */
    public Proveedor(ObjectId idProveedor, ProveedorInformacionBasica basica, ProveedorInformacionContacto contacto, ProveedorInformacionComercial comercial, ProveedorInformacionGestion gestion) {
        this.idProveedor = idProveedor;
        this.basica = basica;
        this.contacto = contacto;
        this.comercial = comercial;
        this.gestion = gestion;
    }

    /**
     * Inicializa los atributos al valor de sus parámetros sin el ID.
     *
     * @param basica Información básica del proveedor
     * @param contacto Información contacto del proveedor
     * @param comercial Información comercial del proveedor
     * @param gestion Información de historial y gestión del proveedor
     */
    public Proveedor(ProveedorInformacionBasica basica, ProveedorInformacionContacto contacto, ProveedorInformacionComercial comercial, ProveedorInformacionGestion gestion) {
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
    public ProveedorInformacionBasica getBasica() {
        return basica;
    }

    /**
     * Establece la información básica del proveedor.
     *
     * @param basica Información básica del proveedor
     */
    public void setBasica(ProveedorInformacionBasica basica) {
        this.basica = basica;
    }

    /**
     * Regresa la información contacto del proveedor.
     *
     * @return Información contacto del proveedor
     */
    public ProveedorInformacionContacto getContacto() {
        return contacto;
    }

    /**
     * Establece la información contacto del proveedor.
     *
     * @param contacto Información contacto del proveedor
     */
    public void setContacto(ProveedorInformacionContacto contacto) {
        this.contacto = contacto;
    }

    /**
     * Regresa la información comercial del proveedor.
     *
     * @return Información comercial del proveedor
     */
    public ProveedorInformacionComercial getComercial() {
        return comercial;
    }

    /**
     * Establece la información comercial del proveedor.
     *
     * @param comercial Información comercial del proveedor
     */
    public void setComercial(ProveedorInformacionComercial comercial) {
        this.comercial = comercial;
    }

    /**
     * Regresa la unformación de historial y gestión del proveedor.
     *
     * @return Información de historial y gestión del proveedor
     */
    public ProveedorInformacionGestion getGestion() {
        return gestion;
    }

    /**
     * Establece la unformación de historial y gestión del proveedor.
     *
     * @param gestion Información de historial y gestión del proveedor
     */
    public void setGestion(ProveedorInformacionGestion gestion) {
        this.gestion = gestion;
    }

    /**
     * Regresa una cadena con el valor de los atributos.
     *
     * @return Cadena con el valor de los atributos
     */
    @Override
    public String toString() {
        return "Proveedor{" + "idProveedor=" + idProveedor + ", basica=" + basica + ", contacto=" + contacto + ", comercial=" + comercial + ", gestion=" + gestion + '}';
    }
}
