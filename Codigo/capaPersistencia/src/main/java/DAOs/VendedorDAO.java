package DAOs;

import Entidades.Vendedor;
import Interfaz.IVendedorDAO;
import org.bson.Document;
import org.bson.types.ObjectId;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Optional;
import java.util.UUID;

/**
 * VendedorDAO.java
 *
 * Implementación en memoria de IVendedorDAO. Simula persistencia con una lista
 * interna.
 *
 * @author
 */
public class VendedorDAO implements IVendedorDAO {

    private final Map<String, Vendedor> vendedores;

    public VendedorDAO() {
        this.vendedores = new HashMap<>();
    }

    @Override
    public Vendedor insertarVendedor(Vendedor vendedor) {
        if (vendedor == null || vendedor.getIdVendedor() == null || vendedor.getIdVendedor().trim().isEmpty()) {
            throw new IllegalArgumentException("El vendedor y su ID no pueden ser nulos.");
        }
        vendedores.put(vendedor.getIdVendedor(), vendedor);
        return null;
    }


    

    @Override
    public Vendedor buscarPorCURP(String curp) {
        return vendedores.stream()
                .filter(v -> v.getCurp().equals(curp))
                .findFirst()
                .orElse(null);
    }

    @Override
    public List<Vendedor> obtenerTodos() {
        return new ArrayList<>(vendedores.values());
    }

    

    @Override
    public Vendedor actualizarVendedor(Vendedor vendedor) {
        if (vendedor == null || vendedor.getIdVendedor() == null || vendedor.getIdVendedor().trim().isEmpty()) {

            throw new IllegalArgumentException("El vendedor y su ID son obligatorios para actualizar.");
        }

        if (!vendedores.containsKey(vendedor.getIdVendedor())) {
            return false;
        }
        vendedores.put(vendedor.getIdVendedor(), vendedor);
        return true;
    }
  
    @Override
    public Vendedor buscarPorId(String id) {
        return vendedores.stream()
                .filter(v -> v.getIdVendedor().equals(id))
                .findFirst()
                .orElse(null);
    }


    @Override
    public Vendedor eliminarVendedor(String id) {
        Optional<Vendedor> vendedorOpt = vendedores.stream()
                .filter(v -> v.getIdVendedor().equals(id))
                .findFirst();
        if (vendedorOpt.isPresent()) {
            vendedores.remove(vendedorOpt.get());
            return vendedorOpt.get();
        }
        return null;
    }
}
