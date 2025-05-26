package Implementaciones;

import BOs.UsuarioBO;
import DTOs.UsuarioDTO;
import Excepcion.LoginExcepcion;
import Excepciones.NegocioException;
import Interfaces.IUsuarioBO;

/**
 * AccesoUsuario.java
 *
 * Esta clase implementa todas las funciones relacionas con el inicio de sesión.
 *
 * @author Ángel Ruíz García - 00000248171
 */
public class AccesoUsuario implements IAccesoUsuario {

    private final IUsuarioBO usuarioBO = new UsuarioBO();

    @Override
    public UsuarioDTO obtenerUsuario() throws LoginExcepcion {
        throw new UnsupportedOperationException("Método aún no implementado");
    }

    @Override
    public UsuarioDTO verificarCredenciales(String idCuenta, String contrasena) throws LoginExcepcion {
        try {
            UsuarioDTO usuario = usuarioBO.obtenerUsuario(idCuenta);
            validarCredenciales(usuario, contrasena);

            return usuario;
        } catch (LoginExcepcion | NegocioException e) {
            throw new LoginExcepcion("Error al verificar credenciales: " + e.getMessage());
        }
    }

    /**
     * Valida que las credenciales sean correctas.
     */
    private void validarCredenciales(UsuarioDTO usuario, String contrasena) throws LoginExcepcion {
        if (usuario == null || !usuario.getContrasena().equals(contrasena)) {
            throw new LoginExcepcion("Credenciales inválidas");
        }
    }
}
