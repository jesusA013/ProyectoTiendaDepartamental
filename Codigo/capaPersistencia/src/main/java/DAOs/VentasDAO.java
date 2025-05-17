/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAOs;

import Entidades.Venta;
import Interfaz.IVentasDAO;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import static com.mongodb.client.model.Filters.eq;
import java.util.List;
import java.util.stream.Collectors;
import org.bson.Document;
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
    public Venta insertarVenta(Venta venta) {
        ObjectId nuevoId = new ObjectId();
        venta.setId(nuevoId);
        coleccion.insertOne(venta);
        return buscarPorId(nuevoId);
    }
    @Override
    public Venta buscarPorId(ObjectId id) {
        return coleccion.find(eq("_id", id)).first();
    }

    @Override
    public Venta actualizarVenta(Venta venta) {
        coleccion.replaceOne(eq("_id", venta.getId()), venta);
        return buscarPorId(venta.getId());
    }

    @Override
    public Venta eliminarVenta(ObjectId id) {
        return coleccion.findOneAndDelete(eq("_id", id));
    }
    
}
