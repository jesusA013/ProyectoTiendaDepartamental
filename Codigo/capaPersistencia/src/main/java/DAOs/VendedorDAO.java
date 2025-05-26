/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
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

/**
 *
 * @author Knocmare
 */
public class VendedorDAO implements IVendedorDAO {

    private final Map<String, Vendedor> vendedores;

    public VendedorDAO() {
        this.vendedores = new HashMap<>();
    }

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
    }
}
