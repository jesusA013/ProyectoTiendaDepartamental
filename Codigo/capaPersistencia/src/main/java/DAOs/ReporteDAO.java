package DAOs;

import Entidades.ReporteVendedores;
import Exception.PersistenciaException;
import Interfaz.IReporteDAO;
import java.util.*;

/**
 * ReporteDAO.java
 *
 * Esta clase simula un DAO en memoria para manejar operaciones relacionadas con
 * reportes.
 *
 * @author
 */
public class ReporteDAO implements IReporteDAO {

    // Ahora usamos un HashMap: clave = idVendedor, valor = ReporteVendedores
    private final Map<String, ReporteVendedores> reportes;

    public ReporteDAO() {
        this.reportes = new HashMap<>();
    }

//    @Override
//    public void generarReporte(String idVendedor, String contenido) {
//        if (idVendedor == null || idVendedor.trim().isEmpty()) {
//            throw new IllegalArgumentException("El ID del vendedor es obligatorio para generar un reporte.");
//        }
//        if (contenido == null || contenido.trim().isEmpty()) {
//            throw new IllegalArgumentException("El contenido del reporte no puede estar vacío.");
//        }
//        // Supongamos que quieres guardar el reporte como texto, solo por ID:
//        reportes.put(idVendedor, contenido);
//    }

    /**
     * Guarda un nuevo reporte en el mapa.
     *
     * @param idVendedor
     * @param reporte
     * @throws PersistenciaException
     */
    @Override
    public void guardarReporte(String idVendedor, ReporteVendedores reporte) throws PersistenciaException {
        if (idVendedor == null || idVendedor.trim().isEmpty()) {
            throw new IllegalArgumentException("El ID del vendedor es obligatorio para guardar el reporte.");
        }
        if (reporte == null) {
            throw new IllegalArgumentException("El reporte no puede ser nulo.");
        }
        reporte.setIdVendedor(idVendedor);
        reportes.put(idVendedor, reporte);
    }

    /**
     * Obtiene un reporte asociado a un vendedor por su ID.
     *
     * @param idVendedor
     * @return
     * @throws PersistenciaException
     */
    @Override
    public ReporteVendedores obtenerReportePorVendedor(String idVendedor) throws PersistenciaException {
        return reportes.get(idVendedor);
    }

    /**
     * Obtiene todos los reportes.
     *
     * @return
     * @throws PersistenciaException
     */
    @Override
    public List<ReporteVendedores> obtenerTodosLosReportes() throws PersistenciaException {
        return new ArrayList<>(reportes.values());
    }

    /**
     * Actualiza un reporte existente por el ID del vendedor.
     *
     * @param idVendedor El ID del vendedor cuyo reporte se actualizará.
     * @param nuevoReporte El nuevo reporte con los datos actualizados.
     * @throws PersistenciaException Si no se encuentra el reporte
     * correspondiente.
     */
    @Override
    public void actualizarReporte(String idVendedor, ReporteVendedores nuevoReporte) throws PersistenciaException {
        if (!reportes.containsKey(idVendedor)) {
            throw new PersistenciaException("No se encontró el reporte con el ID de vendedor: " + idVendedor);
        }
        // Se asegura de mantener el mismo ID de vendedor
        nuevoReporte.setIdVendedor(idVendedor);
        reportes.put(idVendedor, nuevoReporte);
    }

    /**
     * Elimina un reporte por el ID del vendedor.
     *
     * @param idVendedor
     * @throws PersistenciaException
     */
    @Override
    public void eliminarReporte(String idVendedor) throws PersistenciaException {
        if (reportes.remove(idVendedor) == null) {
            throw new PersistenciaException("No se encontró el reporte con el ID de vendedor: " + idVendedor);
        }
    }
}
