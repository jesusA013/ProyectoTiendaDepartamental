package Implementaciones;

import DTOs.UsuarioDTO;
import Excepcion.LoginExcepcion;

/**
 * IAccesoUsuario.java
 *
 * Esta interfaz declara los metodos que debe implementar la clase de
 * InicioSesion.
 *
 * @author Ángel Ruíz García - 00000248171
 */
public interface IAccesoUsuario {

    UsuarioDTO obtenerUsuario() throws LoginExcepcion;

    UsuarioDTO verificarCredenciales(String idCuenta, String contrasena) throws LoginExcepcion;
}
