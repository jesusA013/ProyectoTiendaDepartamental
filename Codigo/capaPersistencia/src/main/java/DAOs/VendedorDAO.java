/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAOs;

import Entidades.Vendedor;
import Interfaz.IUsuarioDAO;
import Interfaz.IVendedorDAO;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import static com.mongodb.client.model.Filters.eq;
import org.bson.Document;
import org.bson.types.ObjectId;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
/**
 *
 * @author Knocmare
 */
public class VendedorDAO implements IVendedorDAO {
    private final MongoCollection<Vendedor> coleccion;

    public VendedorDAO(MongoDatabase database) {
        this.coleccion = database.getCollection("Vendedores", Vendedor.class);
    }

    @Override
    public Vendedor insertarVendedor(Vendedor vendedor) {
        if (vendedor.getFechaRegistro() == null) {
            vendedor.setFechaRegistro(new Date());
        }
        ObjectId nuevoId = new ObjectId();
        vendedor.setId(nuevoId); 
        coleccion.insertOne(vendedor); 
        return vendedor; 
    }

    @Override
    public Vendedor buscarPorCURP(String curp) {
        return coleccion.find(eq("curp", curp)).first();
    }

    @Override
    public List<Vendedor> obtenerTodos() {
        return coleccion.find().into(new ArrayList<>());
    }
    @Override
    public Vendedor buscarPorId(ObjectId id) {
        return coleccion.find(eq("_id", id)).first();
    }
    /**
     * Metodo que recibe un id en el caso de que se facilite mas usar solamente
     * el id seleccionado de un vendedor
     * @param id id seleccionado de una tabla
     * @param vendedor datos nuevos del vendedor
     * @return true si se pudo actualizar, false en caso contrario
     */
    @Override
    public boolean actualizarVendedor(String id, Vendedor vendedor) {
        return coleccion.updateOne(
                eq("_id", new ObjectId(id)),
                new Document("$set", vendedor)
        ).getModifiedCount() > 0;
    }
    /**
     * Este metoddo se usa en caso de que se seleccione un objeto de vendedor 
     * con su id ya registrado
     * @param vendedor Vendedor seleccionado y modificado
     * @return Objeto de vendedor actualizado
     */
    @Override
    public Vendedor actualizarVendedor(Vendedor vendedor) {
        coleccion.replaceOne(eq("_id", vendedor.getId()), vendedor);
        return buscarPorId(vendedor.getId());
    }
    @Override
    public Vendedor eliminarVendedor(ObjectId id) {
        Vendedor vendedor = buscarPorId(id);
        if (vendedor != null) {
            coleccion.deleteOne(eq("_id", id));
        }
        return vendedor;
    }
}
