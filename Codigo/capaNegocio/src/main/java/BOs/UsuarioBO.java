package BOs;

import DAOs.UsuarioDAO;
import DTOs.UsuarioDTO;
import Entidades.Usuario;
import Excepciones.NegocioException;
import Exception.PersistenciaException;
import Interfaces.IUsuarioBO;
import Interfaz.IUsuarioDAO;

/**
 * UsuarioBO.java
 *
 * Esta clase objectos negocio actua como intermediario con la DAO de Usuario.
 *
 * @author Ángel Ruíz García - 00000248171
 */
public class UsuarioBO implements IUsuarioBO {

    private final IUsuarioDAO usuarioDAO;

    public UsuarioBO() {
        this.usuarioDAO = new UsuarioDAO();
    }

    /**
     * Obtiene el usuario por su ID de cuenta.
     *
     * @param idCuenta
     * @return
     * @throws NegocioException
     */
    @Override
    public UsuarioDTO obtenerUsuario(String idCuenta) throws NegocioException {
        try {
            Usuario usuario = usuarioDAO.obtenerUsuario(idCuenta);
            return convertirAUsuarioDTO(usuario);
        } catch (PersistenciaException e) {
            throw new NegocioException("Error al acceder a los datos: " + e.getMessage());
        }
    }

    /**
     * Convierte un Usuario en un UsuarioDTO.
     *
     * @param usuario
     * @return
     */
    private UsuarioDTO convertirAUsuarioDTO(Usuario usuario) {
        return new UsuarioDTO(
                usuario.getIdCuenta(),
                usuario.getNombreUsuario(),
                usuario.getContrasena(),
                usuario.getTipo()
        );
    }
}
