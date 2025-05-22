package DAOs;

import Entidades.Venta;
import Exception.PersistenciaException;
import Interfaz.IVentasDAO;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import static com.mongodb.client.model.Filters.eq;
import java.util.ArrayList;
import java.util.List;
import org.bson.types.ObjectId;

/**
 *
 * @author Knocmare
 */
public class VentasDAO implements IVentasDAO {
    private final MongoCollection<Venta> coleccion;

    public VentasDAO(MongoDatabase database) {
        this.coleccion = database.getCollection("Ventas",Venta.class);
    }

    @Override
    public Venta insertarVenta(Venta venta) throws PersistenciaException {
        ObjectId nuevoId = new ObjectId();
        venta.setId(nuevoId);
        coleccion.insertOne(venta);
        return buscarPorId(nuevoId);
    }
    @Override
    public Venta buscarPorId(ObjectId id) throws PersistenciaException {
        return coleccion.find(eq("_id", id)).first();
    }

    @Override
    public Venta actualizarVenta(Venta venta) throws PersistenciaException {
        coleccion.replaceOne(eq("_id", venta.getId()), venta);
        return buscarPorId(venta.getId());
    }

    @Override
    public Venta eliminarVenta(ObjectId id) throws PersistenciaException {
        return coleccion.findOneAndDelete(eq("_id", id));
    }
    @Override
    public List<Venta> obtenerVentas()throws PersistenciaException{
        return coleccion.find().into(new ArrayList<>());
    }
    
}
