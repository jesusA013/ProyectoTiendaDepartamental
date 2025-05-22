package Entidades;

import org.bson.types.ObjectId;

/**
 * Usuario.java
 *
 * Esta clase representa un usuario.
 *
 * @author Ángel Ruíz García - 00000248171
 */
public class Usuario {

    private ObjectId id;
    private String idCuenta;
    private String nombreUsuario;
    private String contrasena;
    private String tipo;

    /**
     * Constructor por ausencia
     */
    public Usuario() {
    }

    public Usuario(ObjectId idUsuario, String idCuenta, String nombreUsuario, String contrasena, String tipo) {
        this.id = idUsuario;
        this.idCuenta = idCuenta;
        this.nombreUsuario = nombreUsuario;
        this.contrasena = contrasena;
        this.tipo = tipo;
    }

    /**
     * Constructor del usuario.
     *
     * @param idCuenta ID de la cuenta del usuario
     * @param nombreUsuario Nombre del usuario
     * @param contrasena Contraseña del usuario
     * @param tipo Tipo de usuario
     */
    public Usuario(String idCuenta, String nombreUsuario, String contrasena, String tipo) {
        this.idCuenta = idCuenta;
        this.nombreUsuario = nombreUsuario;
        this.contrasena = contrasena;
        this.tipo = tipo;
    }

    /**
     * Regresa el ID del usuario.
     *
     * @return ID del usuario
     */
    public ObjectId getId() {
        return id;
    }

    public void setId(ObjectId id) {
        this.id = id;
    }

    /**
     * Regresa el ID de la cuenta del usuario.
     *
     * @return ID de la cuenta del usuario
     */
    public String getIdCuenta() {
        return idCuenta;
    }

    /**
     * Estable el ID de la cuenta del usuario.
     *
     * @param idCuenta ID de la cuenta del usuario
     */
    public void setIdCuenta(String idCuenta) {
        this.idCuenta = idCuenta;
    }

    public String getNombreUsuario() {
        return nombreUsuario;
    }

    public void setNombreUsuario(String nombreUsuario) {
        this.nombreUsuario = nombreUsuario;
    }

    /**
     * Regresa la contraseña del usuario.
     *
     * @return Contrasena del usuario
     */
    public String getContrasena() {
        return contrasena;
    }

    /**
     * Establece la contraseña del usuario.
     *
     * @param contrasena
     */
    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }

    /**
     * Regresa el tipo de usuario.
     *
     * @return Tipo de usuario
     */
    public String getTipo() {
        return tipo;
    }

    /**
     * Establece el tipo de usuario.
     *
     * @param tipo Tipo de usuario
     */
    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
    
    /**
     * Regresa una cadena con los datos del usuario.
     *
     * @return Cadena con los datos del usuario
     */
    @Override
    public String toString() {
        return "Usuario{" + "id=" + id + ", idCuenta=" + idCuenta + ", nombreUsuario=" + nombreUsuario + ", contrasena=" + contrasena + ", tipo=" + tipo + '}';
    }
}
