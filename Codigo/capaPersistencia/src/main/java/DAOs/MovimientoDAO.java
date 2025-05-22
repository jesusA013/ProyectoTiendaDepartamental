package DAOs;

import Entidades.Movimiento;
import Exception.PersistenciaException;
import Interfaz.IMovimientoDAO;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import static com.mongodb.client.model.Filters.eq;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import org.bson.types.ObjectId;

/**
 * MovimientoDAO.java
 *
 * Esta clase implementa las operaciones para registrar los movimientos de la
 * gestión de inventario.
 *
 * @author Ángel Ruíz García - 00000248171
 */
public class MovimientoDAO implements IMovimientoDAO {
    
    private final MongoCollection<Movimiento> coleccion;
    
    /**
     * Inicializa la coleccion para usar la base de datos.
     *
     * @param database Base de datos
     */
    public MovimientoDAO(MongoDatabase database) {
        this.coleccion = database.getCollection("Movimientos", Movimiento.class);
    }

    /**
     * Registra un movimiento en la base de datos.
     *
     * @param movimiento Movimiento a registrar
     * @return Regresa el movimiento registrado
     * @throws PersistenciaException Excepcion si ocurre un error en el proceso
     */
    @Override
    public Movimiento registrarMovimiento(Movimiento movimiento) throws PersistenciaException {
        if (movimiento.getFecha() == null) {
            movimiento.setFecha(new Date());
        }
        ObjectId nuevoId = new ObjectId();
        movimiento.setId(nuevoId);
        coleccion.insertOne(movimiento);
        return movimiento;
    }

    /**
     * Modifica un movimiento de la base de datos.
     *
     * @param movimiento Movimiento a modificar
     * @return Regresa el movimiento modificado
     * @throws PersistenciaException Excepcion si ocurre un error en el proceso
     */
    @Override
    public Movimiento actualizarMovimiento(Movimiento movimiento) throws PersistenciaException {
        coleccion.replaceOne(eq("_id", movimiento.getId()), movimiento);
        return obtenerMovimientoPorId(movimiento.getId());
    }

    /**
     * Obtiene un movimiento de la base de datos usando el ID.
     *
     * @param idMovimiento ID del movimiento a buscar
     * @return Regresa el movimiento encontrado
     * @throws PersistenciaException Excepcion si ocurre un error en el proceso
     */
    @Override
    public Movimiento obtenerMovimientoPorId(ObjectId idMovimiento) throws PersistenciaException {
        return coleccion.find(eq("_id", idMovimiento)).first();
    }

    /**
     * Obtiene una lista con todos los movimientos de la base de datos.
     *
     * @return Regresa la lista de movimientos encontrada
     * @throws PersistenciaException Excepcion si ocurre un error en el proceso
     */
    @Override
    public List<Movimiento> listaMovimientos() throws PersistenciaException {
        return coleccion.find().into(new ArrayList<>());
    }
}
