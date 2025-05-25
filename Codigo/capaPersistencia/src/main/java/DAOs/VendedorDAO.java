package DAOs;

import Entidades.Vendedor;
import Interfaz.IVendedorDAO;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
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

    private final List<Vendedor> vendedores = new ArrayList<>();

    @Override
    public Vendedor insertarVendedor(Vendedor vendedor) {
        if (vendedor.getFechaRegistro() == null) {
            vendedor.setFechaRegistro(new Date());
        }
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
