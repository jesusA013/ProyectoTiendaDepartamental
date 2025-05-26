package DAOs;

import Entidades.Vendedor;
import Interfaz.IVendedorDAO;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * VendedorDAO.java
 *
 * Implementación en memoria de IVendedorDAO. Simula persistencia con un
 * HashMap.
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
        // Se inserta o actualiza el vendedor
        vendedores.put(vendedor.getIdVendedor(), vendedor);
        return vendedor;
    }

    @Override
    public Vendedor buscarPorCURP(String curp) {
        if (curp == null || curp.trim().isEmpty()) {
            throw new IllegalArgumentException("El CURP no puede ser nulo o vacío.");
        }

        // Busca en todos los vendedores
        for (Vendedor v : vendedores.values()) {
            if (curp.equals(v.getCurp())) {
                return v;
            }
        }
        return null;
    }

    @Override
    public List<Vendedor> obtenerTodos() {
        return new ArrayList<>(vendedores.values());
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

    @Override
    public Vendedor buscarPorId(String id) {
        if (id == null || id.trim().isEmpty()) {
            throw new IllegalArgumentException("El ID no puede ser nulo o vacío.");
        }
        return vendedores.get(id);
    }

    @Override
    public Vendedor eliminarVendedor(String id) {
        if (id == null || id.trim().isEmpty()) {
            throw new IllegalArgumentException("El ID no puede ser nulo o vacío.");
        }
        return vendedores.remove(id);
    }
}
