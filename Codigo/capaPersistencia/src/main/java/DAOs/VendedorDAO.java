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
    private final List<Vendedor> vendedores = new ArrayList<>();

    @Override
    public void insertarVendedor(Vendedor vendedor) {
        if (vendedor == null || vendedor.getIdVendedor() == null || vendedor.getIdVendedor().trim().isEmpty()) {
            throw new IllegalArgumentException("El vendedor y su ID no pueden ser nulos.");
        }
        vendedores.put(vendedor.getIdVendedor(), vendedor);
    }

    @Override
    public Optional<Vendedor> buscarPorCURP(String curp) {
        return vendedores.values().stream().filter(v -> v.getCurp().equals(curp)).findFirst();
        // Asigna un nuevo id
        String nuevoId = UUID.randomUUID().toString();
        vendedor.setIdVendedor(nuevoId);
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
        return new ArrayList<>(vendedores.values());
    }

    @Override
    public Optional<Vendedor> buscarPorId(String idVendedor) {
        return Optional.ofNullable(vendedores.get(idVendedor));
    }

    @Override
    public boolean actualizarVendedor(Vendedor vendedor) {
        if (vendedor == null || vendedor.getIdVendedor() == null || vendedor.getIdVendedor().trim().isEmpty()) {

            throw new IllegalArgumentException("El vendedor y su ID son obligatorios para actualizar.");
        }

        if (!vendedores.containsKey(vendedor.getIdVendedor())) {
            return false;
        }
        vendedores.put(vendedor.getIdVendedor(), vendedor);
        return true;
    }

    public Optional<Vendedor> eliminarVendedorPorID(String idVendedor) {
        if (idVendedor == null || idVendedor.trim().isEmpty()) {
            throw new IllegalArgumentException("El ID del vendedor es obligatorio para eliminar.");
        }
        return Optional.ofNullable(vendedores.remove(idVendedor));
    }

    @Override
    public Optional<Vendedor> eliminarVendedor(String idVendedor) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
        return new ArrayList<>(vendedores);
    }

    @Override
    public Vendedor buscarPorId(String id) {
        return vendedores.stream()
                .filter(v -> v.getIdVendedor().equals(id))
                .findFirst()
                .orElse(null);
    }

    @Override
    public boolean actualizarVendedor(String id, Vendedor vendedor) {
        for (int i = 0; i < vendedores.size(); i++) {
            if (vendedores.get(i).getIdVendedor().equals(id)) {
                vendedor.setIdVendedor(id); // Mantenemos el id
                vendedores.set(i, vendedor);
                return true;
            }
        }
        return false;
    }

    @Override
    public Vendedor actualizarVendedor(Vendedor vendedor) {
        for (int i = 0; i < vendedores.size(); i++) {
            if (vendedores.get(i).getIdVendedor().equals(vendedor.getIdVendedor())) {
                vendedores.set(i, vendedor);
                return vendedor;
            }
        }
        return null;
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
