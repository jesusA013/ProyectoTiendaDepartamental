/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAOs;

import Entidades.Producto;
import Exception.PersistenciaException;
import Interfaz.IProductoDAO;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Filters;
import static com.mongodb.client.model.Filters.eq;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;
import org.bson.conversions.Bson;
import org.bson.types.ObjectId;

/**
 *
 * @author Knocmare
 */
public class ProductoDAO implements IProductoDAO {

    private final MongoCollection<Producto> coleccion;

    public ProductoDAO(MongoDatabase database) {
        this.coleccion = database.getCollection("Productos", Producto.class);
    }

    @Override
    public Producto insertarProducto(Producto producto) throws PersistenciaException {
        ObjectId nuevoId = new ObjectId();
        producto.setId(nuevoId);
        coleccion.insertOne(producto);
        return buscarPorId(producto.getId());
    }

    @Override
    public Producto buscarPorId(ObjectId id) throws PersistenciaException {
        return coleccion.find(eq("_id", id)).first();
    }

    /**
     * Busca productos cuyo nombre contenga el texto especificado, sin
     * distinguir entre mayúsculas y minúsculas. La búsqueda se realiza
     * utilizando coincidencia parcial (similar a "contiene"). Solo se devuelven
     * productos que tengan stock mayor a cero.
     *
     * @param producto El texto que se desea buscar dentro del nombre de los
     * productos.
     * @return Regresa una lista de productos cuyo nombre coincide parcialmente
     * con el texto proporcionado.
     * @throws PersistenciaException Si ocurre un error durante la consulta a la
     * base de datos.
     */
    @Override
    public List<Producto> buscarProductos(String producto) throws PersistenciaException {
        Bson filtroNombre = Filters.regex("nombre", ".*" + Pattern.quote(producto) + ".*", "i");
        Bson filtroStock = Filters.gt("stock", 0);
        Bson filtroCompuesto = Filters.and(filtroNombre, filtroStock);

        return coleccion.find(filtroCompuesto).into(new ArrayList<>());
    }

    @Override
    public Producto actualizarProducto(Producto producto) throws PersistenciaException {
        coleccion.replaceOne(eq("_id", producto.getId()), producto);
        return buscarPorId(producto.getId());
    }

    @Override
    public Producto eliminarProducto(ObjectId id) throws PersistenciaException {
        return coleccion.findOneAndDelete(eq("_id", id));
    }

    @Override
    public List<Producto> buscarTodos() throws PersistenciaException{
        return coleccion.find().into(new ArrayList<>());
    }
}
