package Interfaz;

import Entidades.Usuario;
import Exception.PersistenciaException;

/**
 *
 * @author Knocmare
 */
public interface IUsuarioDAO {

    Usuario obtenerUsuario(String id) throws PersistenciaException;
}
