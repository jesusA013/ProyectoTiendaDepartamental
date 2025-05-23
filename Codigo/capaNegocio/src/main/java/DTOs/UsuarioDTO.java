package DTOs;

/**
 *
 * @author gaspa
 */
public class UsuarioDTO {

    private String idUsuarioDTO;
    private String idCuenta;
    private String nombreUsuario;
    private String contrasena;
    private String rol;

    /**
     * Constructor por ausencia
     */
    public UsuarioDTO() {
    }

    /**
     * Constructor del usuario.
     *
     * @param idCuenta ID de la cuenta del usuario
     * @param nombreUsuario Nombre del usuario
     * @param contrasena Contraseña del usuario
     * @param rol Tipo de usuario
     */
    public UsuarioDTO(String idCuenta, String nombreUsuario, String contrasena, String rol) {
        this.idCuenta = idCuenta;
        this.nombreUsuario = nombreUsuario;
        this.contrasena = contrasena;
        this.rol = rol;
    }

    public String getIdUsuarioDTO() {
        return idUsuarioDTO;
    }

    public void setIdUsuarioDTO(String idUsuarioDTO) {
        this.idUsuarioDTO = idUsuarioDTO;
    }

    public String getIdCuenta() {
        return idCuenta;
    }

    public void setIdCuenta(String idCuenta) {
        this.idCuenta = idCuenta;
    }

    /**
     * Regresa el nombre del usuario.
     *
     * @return Nombre del usuario
     */
    public String getNombreUsuario() {
        return nombreUsuario;
    }

    /**
     * Establece el nombre del usuario.
     *
     * @param nombreUsuario Nombre del usuario
     */
    public void setNombreUsuario(String nombreUsuario) {
        this.nombreUsuario = nombreUsuario;
    }

    public String getContrasena() {
        return contrasena;
    }

    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }

    public String getRol() {
        return rol;
    }

    public void setRol(String rol) {
        this.rol = rol;
    }

    /**
     * Regresa una cadena con los datos del usuario.
     *
     * @return Cadena con los datos del usuario
     */
    @Override
    public String toString() {
        return "UsuarioDTO{" + "idCuenta=" + idCuenta + ", nombreUsuario=" + nombreUsuario + ", contrasena=" + contrasena + ", rol=" + rol + '}';
    }
}
