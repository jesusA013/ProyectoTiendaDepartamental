package DAOs;

import Entidades.Proveedor;
import Exception.PersistenciaException;
import Interfaz.IProveedorDAO;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import static com.mongodb.client.model.Filters.eq;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import org.bson.types.ObjectId;

/**
 * ProveedorDAO.java
 *
 * Esta clase implementa las operaciones básicas para la gestión de proveedores.
 *
 * @author Ángel Ruíz García - 00000248171
 */
public class ProveedorDAO implements IProveedorDAO {

    private final MongoCollection<Proveedor> coleccion;

    /**
     * Inicializa la coleccion para usar la base de datos.
     *
     * @param database Base de datos
     */
    public ProveedorDAO(MongoDatabase database) {
        this.coleccion = database.getCollection("Proveedores", Proveedor.class);
    }

    @Override
    public Proveedor guardarProveedor(Proveedor proveedor) throws PersistenciaException {
        if (proveedor.getGestion().getFechaAlta() == null) {
            proveedor.getGestion().setFechaAlta(new Date());
        }
        ObjectId nuevoId = new ObjectId();
        proveedor.setIdProveedor(nuevoId);
        coleccion.insertOne(proveedor);
        return proveedor;
    }

    @Override
    public Proveedor editarProveedor(Proveedor proveedor) throws PersistenciaException {
        coleccion.replaceOne(eq("_id", proveedor.getIdProveedor()), proveedor);
        return obtenerProveedorPorId(proveedor.getIdProveedor());
    }

    @Override
    public Proveedor obtenerProveedorPorId(ObjectId idProveedor) throws PersistenciaException {
        return coleccion.find(eq("_id", idProveedor)).first();
    }

    @Override
    public List<Proveedor> listaProveedores() throws PersistenciaException {
        return coleccion.find().into(new ArrayList<>());
    }

}
