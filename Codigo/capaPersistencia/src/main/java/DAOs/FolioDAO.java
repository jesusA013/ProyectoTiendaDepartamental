package DAOs;

import Entidades.Folio;
import Exception.PersistenciaException;
import Interfaz.IFolioDAO;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import static com.mongodb.client.model.Filters.eq;
import java.util.ArrayList;
import java.util.List;
import org.bson.types.ObjectId;

/**
 *
 * @author Ángel Ruíz García - 00000248171
 */
public class FolioDAO implements IFolioDAO {

    private final MongoCollection<Folio> coleccion;

    public FolioDAO(MongoDatabase database) {
        this.coleccion = database.getCollection("Folios", Folio.class);
    }

    @Override
    public Folio insertarFolio(Folio folio) throws PersistenciaException {
        ObjectId nuevoId = new ObjectId();
        folio.setId(nuevoId);
        coleccion.insertOne(folio);
        return buscarPorId(folio.getId());
    }
    
    @Override
    public Folio actualizarFolio(Folio folio) throws PersistenciaException {
        coleccion.replaceOne(eq("_id", folio.getId()), folio);
        return buscarPorId(folio.getId());
    }

    @Override
    public Folio eliminarFolio(ObjectId id) throws PersistenciaException {
        return coleccion.findOneAndDelete(eq("_id", id));
    }
    
    @Override
    public Folio buscarPorId(ObjectId id) throws PersistenciaException {
        return coleccion.find(eq("_id", id)).first();
    }
    
    @Override
    public List<Folio> buscarTodos() throws PersistenciaException {
        return coleccion.find().into(new ArrayList<>());
    }
}
