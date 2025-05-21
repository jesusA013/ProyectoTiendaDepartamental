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

    private ObjectId idUsuario;
    private String idCuenta;
    //private String nombreUsuario;
    private String contrasena;
    private String tipo;

    /**
     * Constructor por ausencia
     */
    public Usuario() {
    }

    /**
     * Constructor del usuario.
     *
     * @param idCuenta ID de la cuenta del usuario
     * @param contrasena Contraseña del usuario
     * @param tipo Tipo de usuario
     */
    public Usuario(String idCuenta, String contrasena, String tipo) {
        this.idCuenta = idCuenta;
        this.contrasena = contrasena;
        this.tipo = tipo;
    }

    /**
     * Regresa el ID del usuario.
     *
     * @return ID del usuario
     */
    public ObjectId getIdUsuario() {
        return idUsuario;
    }

    /**
     * Establece el ID del usuario.
     *
     * @param idUsuario ID del usuario
     */
    public void setIdUsuario(ObjectId idUsuario) {
        this.idUsuario = idUsuario;
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
        return "Usuario{" + "idUsuario=" + idUsuario + ", idCuenta=" + idCuenta + ", contrase\u00f1a=" + contrasena + ", tipo=" + tipo + '}';
    }
}
