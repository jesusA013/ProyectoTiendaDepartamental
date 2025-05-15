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
    public void insertarVendedor(Vendedor vendedor) {
        if (vendedor.getFechaRegistro() == null) {
            vendedor.setFechaRegistro(new Date());
        }
        vendedor.setActivo(true);
        coleccion.insertOne(vendedor);
    }

    @Override
    public Vendedor buscarPorCURP(String curp) {
        return coleccion.find(eq("curp", curp)).first();
    }

    @Override
    public List<Vendedor> obtenerTodos() {
        return coleccion.find().into(new ArrayList<>());
    }
}
