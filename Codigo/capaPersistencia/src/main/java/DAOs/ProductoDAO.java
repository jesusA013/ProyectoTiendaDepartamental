package DAOs;

import Entidades.Producto;
import Exception.PersistenciaException;
import Interfaz.IProductoDAO;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.regex.Pattern;
import org.bson.types.ObjectId;

/**
 * ProductoDAO.java
 *
 * Implementación en memoria de IProductoDAO. Usa una lista interna para simular
 * persistencia.
 *
 * @author Ángel Ruíz García - 00000248171
 */
public class ProductoDAO implements IProductoDAO {

    private final List<Producto> productos = new ArrayList<>();

    @Override
    public Producto insertarProducto(Producto producto) throws PersistenciaException {
        String nuevoId = UUID.randomUUID().toString();
        producto.setIdProducto(nuevoId);
        productos.add(producto);
        return buscarPorId(nuevoId);
    }

    @Override
    public Producto buscarPorId(String id) throws PersistenciaException {
        return productos.stream()
                .filter(p -> p.getIdProducto().equals(id))
                .findFirst()
                .orElse(null);
    }

    /**
     * Busca productos cuyo nombre contenga el texto especificado, sin
     * distinguir entre mayúsculas y minúsculas. Solo devuelve productos con
     * stock mayor a cero.
     *
     * @param texto El texto a buscar.
     * @return Lista de productos coincidentes.
     * @throws PersistenciaException No se usa en esta implementación.
     */
    @Override
    public List<Producto> buscarProductos(String texto) throws PersistenciaException {
        List<Producto> resultado = new ArrayList<>();
        Pattern patron = Pattern.compile(".*" + Pattern.quote(texto) + ".*", Pattern.CASE_INSENSITIVE);

        for (Producto producto : productos) {
            if (producto.getStock() > 0 && patron.matcher(producto.getNombre()).matches()) {
                resultado.add(producto);
            }
        }
        return resultado;
    }

    @Override
    public Producto actualizarProducto(Producto producto) throws PersistenciaException {
        for (int i = 0; i < productos.size(); i++) {
            if (productos.get(i).getIdProducto().equals(producto.getIdProducto())) {
                productos.set(i, producto);
                return producto;
            }
        }
        return null;
    }

    @Override
    public Producto eliminarProducto(String id) throws PersistenciaException {
        Optional<Producto> productoOpt = productos.stream()
                .filter(p -> p.getIdProducto().equals(id))
                .findFirst();
        if (productoOpt.isPresent()) {
            productos.remove(productoOpt.get());
            return productoOpt.get();
        }
        return null;
    }

    @Override
    public List<Producto> buscarTodos() throws PersistenciaException {
        return new ArrayList<>(productos);
    }
}
