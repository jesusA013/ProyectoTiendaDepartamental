/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAOs;

import Entidades.Producto;
import Entidades.Vendedor;
import Interfaz.IProductoDAO;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import static com.mongodb.client.model.Filters.eq;
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
    public Producto insertarProducto(Producto producto) {
        ObjectId nuevoId = new ObjectId();
        producto.setId(nuevoId);
        coleccion.insertOne(producto);
        return buscarPorId(producto.getId());
    }

    @Override
    public Producto buscarPorId(ObjectId id) {
        return coleccion.find(eq("_id", id)).first();
    }

    @Override
    public Producto actualizarProducto(Producto producto) {
        coleccion.replaceOne(eq("_id", producto.getId()), producto);
        return buscarPorId(producto.getId());
    }

    @Override
    public Producto eliminarProducto(ObjectId id) {
        return coleccion.findOneAndDelete(eq("_id", id));
    }
}
