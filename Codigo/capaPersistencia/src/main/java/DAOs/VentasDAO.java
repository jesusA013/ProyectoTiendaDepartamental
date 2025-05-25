package DAOs;

import Entidades.Venta;
import Exception.PersistenciaException;
import Interfaz.IVentasDAO;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

/**
 * VentasDAO.java
 *
 * Implementación en memoria de IVentasDAO. Simula persistencia con una lista
 * interna.
 *
 * @author
 */
public class VentasDAO implements IVentasDAO {

    private final List<Venta> ventas = new ArrayList<>();

    @Override
    public Venta insertarVenta(Venta venta) throws PersistenciaException {
        String nuevoId = UUID.randomUUID().toString();
        venta.setIdVenta(nuevoId);
        // Asignar fecha de venta si no está
        if (venta.getFecha() == null) {
            venta.setFecha(new Date());
        }
        ventas.add(venta);
        return buscarPorId(nuevoId);
    }

    @Override
    public Venta buscarPorId(String id) throws PersistenciaException {
        return ventas.stream()
                .filter(v -> v.getIdVenta().equals(id))
                .findFirst()
                .orElse(null);
    }

    @Override
    public Venta actualizarVenta(Venta venta) throws PersistenciaException {
        for (int i = 0; i < ventas.size(); i++) {
            if (ventas.get(i).getIdVenta().equals(venta.getIdVenta())) {
                ventas.set(i, venta);
                return venta;
            }
        }
        return null;
    }

    @Override
    public Venta eliminarVenta(String id) throws PersistenciaException {
        Optional<Venta> ventaOpt = ventas.stream()
                .filter(v -> v.getIdVenta().equals(id))
                .findFirst();
        if (ventaOpt.isPresent()) {
            ventas.remove(ventaOpt.get());
            return ventaOpt.get();
        }
        return null;
    }

    @Override
    public List<Venta> buscarVentas(String idVendedor) throws PersistenciaException {
        List<Venta> resultado = new ArrayList<>();
        for (Venta venta : ventas) {
            if (venta.getIdVenta().equals(idVendedor)) {
                resultado.add(venta);
            }
        }
        return resultado;
    }
}
