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

    /**
     * Registra un proveedor en la base de datos.
     *
     * @param proveedor Proveedor a registrar
     * @return Regresa el proveedor registrado
     * @throws PersistenciaException Excepcion si ocurre un error en el proceso
     */
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

    /**
     * Modifica un proveedor de la base de datos.
     *
     * @param proveedor Proveedor a modificar
     * @return Regresa el proveedor modificado
     * @throws PersistenciaException Excepcion si ocurre un error en el proceso
     */
    @Override
    public Proveedor editarProveedor(Proveedor proveedor) throws PersistenciaException {
        coleccion.replaceOne(eq("_id", proveedor.getIdProveedor()), proveedor);
        return obtenerProveedorPorId(proveedor.getIdProveedor());
    }

    /**
     * Obtiene un proveedor de la base de datos usando el ID.
     *
     * @param idProveedor ID del proveedor a buscar
     * @return Regresa el proveedor encontrado
     * @throws PersistenciaException Excepcion si ocurre un error en el proceso
     */
    @Override
    public Proveedor obtenerProveedorPorId(ObjectId idProveedor) throws PersistenciaException {
        return coleccion.find(eq("_id", idProveedor)).first();
    }

    /**
     * Obtiene una lista con todos los proveedores de la base de datos.
     *
     * @return Regresa la lista de proveedores encontrada
     * @throws PersistenciaException Excepcion si ocurre un error en el proceso
     */
    @Override
    public List<Proveedor> listaProveedores() throws PersistenciaException {
        return coleccion.find().into(new ArrayList<>());
    }

}
