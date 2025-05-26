package DAOs;

import Entidades.Usuario;
import Exception.PersistenciaException;
import Interfaz.IUsuarioDAO;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

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

    public UsuarioDAO() {
        Usuario vendedor = new Usuario("1234", "Ángel", "password", "Vendedor");
        Usuario administrador = new Usuario("2234", "Ricardo", "password", "Administrador");
        Usuario almacen = new Usuario("3334", "Felipe", "password", "Almacen");
        agregarUsuario(vendedor);
        agregarUsuario(administrador);
        agregarUsuario(almacen);
        System.out.println("Usuarios agregados");
    }
    
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
    private void agregarUsuario(Usuario usuario) {
        usuarios.add(usuario);
    }
}
