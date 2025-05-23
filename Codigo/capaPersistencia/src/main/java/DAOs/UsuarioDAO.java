package DAOs;

import Entidades.Usuario;
import Exception.PersistenciaException;
import Interfaz.IUsuarioDAO;
import java.util.ArrayList;
import java.util.List;

/**
 * UsuarioDAO.java
 *
 * Implementación en memoria de IUsuarioDAO. Simula la persistencia de datos
 * usando una lista interna.
 *
 * @author Ángel Ruíz García - 00000248171
 */
public class UsuarioDAO implements IUsuarioDAO {

    private final List<Usuario> usuarios = new ArrayList<>();

    /**
     *
     * @param idCuenta
     * @return
     * @throws PersistenciaException
     */
    @Override
    public Usuario obtenerUsuario(String idCuenta) throws PersistenciaException {
        return usuarios.stream()
                .filter(u -> u.getIdCuenta().equals(idCuenta))
                .findFirst()
                .orElseThrow(() -> new PersistenciaException("Usuario no encontrado"));
    }

    /**
     * Registra un usuario en la lista interna.
     *
     * @param usuario Usuaria a registrar
     */
    public void agregarUsuario(Usuario usuario) {
        usuarios.add(usuario);
    }
}
