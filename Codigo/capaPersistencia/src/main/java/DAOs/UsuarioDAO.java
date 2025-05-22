package DAOs;

import Entidades.Usuario;
import Exception.PersistenciaException;
import Interfaz.IUsuarioDAO;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import static com.mongodb.client.model.Filters.eq;

/**
 *
 * @author gaspa
 */
public class UsuarioDAO implements IUsuarioDAO {

    private final MongoCollection<Usuario> coleccion;

    public UsuarioDAO(MongoDatabase database) {
        this.coleccion = database.getCollection("Usuarios", Usuario.class);
    }

    @Override
    public Usuario obtenerUsuario(String id) throws PersistenciaException {
        return coleccion.find(eq("idCuenta", id)).first();
    }

}
