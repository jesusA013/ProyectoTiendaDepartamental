package DAOs;

import Entidades.Proveedor;
import Exception.PersistenciaException;
import Interfaz.IProveedorDAO;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

/**
 * ProveedorDAO.java
 *
 * Implementación en memoria de IProveedorDAO. Simula la persistencia de datos
 * usando una lista interna.
 *
 * @author Ángel Ruíz García - 00000248171
 */
public class ProveedorDAO implements IProveedorDAO {

    // Lista que simula la base de datos
    private final List<Proveedor> proveedores = new ArrayList<>();

    @Override
    public Proveedor guardarProveedor(Proveedor proveedor) throws PersistenciaException {
        if (proveedor.getGestion().getFechaAlta() == null) {
            proveedor.getGestion().setFechaAlta(new Date());
        }
        proveedor.setIdProveedor(UUID.randomUUID().toString());
        proveedores.add(proveedor);
        return proveedor;
    }

    @Override
    public Proveedor editarProveedor(Proveedor proveedor) throws PersistenciaException {
        // Buscamos el proveedor existente por su ID
        Optional<Proveedor> existente = proveedores.stream()
                .filter(p -> p.getIdProveedor().equals(proveedor.getIdProveedor()))
                .findFirst();

        if (existente.isPresent()) {
            // Reemplazamos los datos
            int index = proveedores.indexOf(existente.get());
            proveedores.set(index, proveedor);
            return proveedor;
        } else {
            throw new PersistenciaException("Proveedor no encontrado para editar");
        }
    }

    @Override
    public Proveedor obtenerProveedorPorId(String idProveedor) throws PersistenciaException {
        return proveedores.stream()
                .filter(p -> p.getIdProveedor().equals(idProveedor))
                .findFirst()
                .orElseThrow(() -> new PersistenciaException("Proveedor no encontrado"));
    }

    @Override
    public List<Proveedor> listaProveedores() throws PersistenciaException {
        // Devuelve una copia para evitar modificaciones externas
        return new ArrayList<>(proveedores);
    }
}
