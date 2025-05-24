package DAOs;

import Entidades.Vendedor;
import Interfaz.IVendedorDAO;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import org.bson.types.ObjectId;

/**
 * VendedorDAO.java
 *
 * Implementación en memoria de IVendedorDAO. Simula persistencia con una lista
 * interna.
 *
 * @author
 */
public class VendedorDAO implements IVendedorDAO {

    private final List<Vendedor> vendedores = new ArrayList<>();

    @Override
    public Vendedor insertarVendedor(Vendedor vendedor) {
        if (vendedor.getFechaRegistro() == null) {
            vendedor.setFechaRegistro(new Date());
        }
        // Asigna un nuevo id
        ObjectId nuevoId = new ObjectId();
        vendedor.setId(nuevoId);
        vendedores.add(vendedor);
        return vendedor;
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
        return new ArrayList<>(vendedores);
    }

    @Override
    public Vendedor buscarPorId(ObjectId id) {
        return vendedores.stream()
                .filter(v -> v.getId().equals(id))
                .findFirst()
                .orElse(null);
    }

    @Override
    public boolean actualizarVendedor(String id, Vendedor vendedor) {
        ObjectId objectId = new ObjectId(id);
        for (int i = 0; i < vendedores.size(); i++) {
            if (vendedores.get(i).getId().equals(objectId)) {
                vendedor.setId(objectId); // Mantenemos el id
                vendedores.set(i, vendedor);
                return true;
            }
        }
        return false;
    }

    @Override
    public Vendedor actualizarVendedor(Vendedor vendedor) {
        for (int i = 0; i < vendedores.size(); i++) {
            if (vendedores.get(i).getId().equals(vendedor.getId())) {
                vendedores.set(i, vendedor);
                return vendedor;
            }
        }
        return null;
    }

    @Override
    public Vendedor eliminarVendedor(ObjectId id) {
        Optional<Vendedor> vendedorOpt = vendedores.stream()
                .filter(v -> v.getId().equals(id))
                .findFirst();
        if (vendedorOpt.isPresent()) {
            vendedores.remove(vendedorOpt.get());
            return vendedorOpt.get();
        }
        return null;
    }
}
