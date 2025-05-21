/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DTOs;

/**
 *
 * @author gaspa
 */
public class UsuarioDTO {
    private String idCuenta;
    private String contrasena;
    private String rol;

    public UsuarioDTO() {
    }

    public UsuarioDTO(String idCuenta, String contrasena, String rol) {
        this.idCuenta = idCuenta;
        this.contrasena = contrasena;
        this.rol = rol;
    }

    public String getIdCuenta() {
        return idCuenta;
    }

    public void setIdCuenta(String idCuenta) {
        this.idCuenta = idCuenta;
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

    @Override
    public String toString() {
        return "UsuarioDTO{" + "idCuenta=" + idCuenta + ", contrasena=" + contrasena + ", rol=" + rol + '}';
    }
    
    
}
