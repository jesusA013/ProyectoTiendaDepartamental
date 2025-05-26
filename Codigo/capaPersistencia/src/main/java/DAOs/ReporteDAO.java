/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAOs;

import Entidades.ReporteVendedores;
import Interfaz.IReporteDAO;

import Exception.PersistenciaException;
import Interfaz.IReporteDAO;
import com.mongodb.client.MongoDatabase;
import static com.mongodb.client.model.Filters.eq;
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

    private final Map<String, String> reportes;

    //////gv
    public ReporteDAO() {
        this.reportes = new HashMap<>();
    }

    public void generarReporte(String idVendedor, String contenido) {
        if (idVendedor == null || idVendedor.trim().isEmpty()) {
            throw new IllegalArgumentException("El ID del vendedor es obligatorio para generar un reporte.");
        }
        if (contenido == null || contenido.trim().isEmpty()) {
            throw new IllegalArgumentException("El contenido del reporte no puede estar vacío.");
        }
        reportes.put(idVendedor, contenido);
    }

    public Optional<String> obtenerReportePorVendedor(String idVendedor) {
        return Optional.ofNullable(reportes.get(idVendedor));
    }

    public List<String> obtenerTodosLosReportes() {
        return new ArrayList<>(reportes.values());
    }

    public boolean eliminarReporte(String idVendedor) {
        if (idVendedor == null || idVendedor.trim().isEmpty()) {
            throw new IllegalArgumentException("El ID del vendedor es obligatorio para eliminar un reporte.");
        }
        return reportes.remove(idVendedor) != null;

    /**
     * Genera un reporte de stock agregado en un rango de fechas.
     *
     * @param fechaInicio Fecha inicial
     * @param fechaFin Fecha final
     * @return Lista de ReporteStockDTO
     */
//    public List<ReporteStockDTO> generarReporteStockAgregado(Calendar fechaInicio, Calendar fechaFin) {
//        List<EntidadFolio> folios = folioDAO.obtenerFoliosPorRangoFechas(fechaInicio, fechaFin);
//        List<ReporteStockDTO> reporte = new ArrayList<>();
//
//        for (EntidadFolio folio : folios) {
//            List<EntidadProducto> productos = folioDAO.obtenerProductosPorFolio(folio.getIdFolio());
//            int totalProductos = productos.stream().mapToInt(EntidadProducto::getStock).sum();
//
//            ReporteStockDTO dto = new ReporteStockDTO();
//            dto.setNumeroFolio(folio.getNumeroFolio());
//            dto.setFecha(folio.getFecha());
//            dto.setTotalProductos(totalProductos);
//            reporte.add(dto);
//        }
//
//        return reporte;
//    }
    /**
     * Genera un reporte de productos con stock bajo.
     *
     * @param umbral Umbral de stock
     * @return Lista de ReporteBajosDTO
     */
//    public List<ReporteBajosDTO> generarReporteProductosBajos(int umbral) {
//        List<EntidadProducto> productosBajos = productoDAO.obtenerProductosBajos(umbral);
//        List<ReporteBajosDTO> reporte = new ArrayList<>();
//
//        for (EntidadProducto producto : productosBajos) {
//            ReporteBajosDTO dto = new ReporteBajosDTO();
//            dto.setSku(producto.getSku());
//            dto.setNombre(producto.getNombre());
//            dto.setStock(producto.getStock());
//            dto.setUmbral(umbral); 
//            reporte.add(dto);
//        }
//
//        return reporte;
//    }
    // Lista interna simulando la "base de datos"
    private final List<ReporteVendedores> reportes = new ArrayList<>();

    /**
     * Guarda un nuevo reporte en la lista.
     *
     * @param idVendedor
     * @param reporte
     * @throws Exception.PersistenciaException
     */
    @Override
    public void guardarReporte(String idVendedor, ReporteVendedores reporte) throws PersistenciaException {
        reporte.setIdVendedor(idVendedor); // Asigna el ID del vendedor
        reportes.add(reporte);
    }

    /**
     * Obtiene un reporte asociado a un vendedor por su ID.
     *
     * @param idVendedor
     * @return
     * @throws Exception.PersistenciaException
     */
    @Override
    public ReporteVendedores obtenerReportePorVendedor(String idVendedor) throws PersistenciaException {
        return reportes.stream()
                .filter(r -> idVendedor.equals(r.getIdVendedor()))
                .findFirst()
                .orElse(null); // Retorna null si no se encuentra
    }

    /**
     * Obtiene todos los reportes.
     *
     * @return
     * @throws Exception.PersistenciaException
     */
    @Override
    public List<ReporteVendedores> obtenerTodosLosReportes() throws PersistenciaException {
        return new ArrayList<>(reportes); // Retorna copia para evitar modificaciones externas

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
        Optional<ReporteVendedores> existenteOpt = reportes.stream()
                .filter(r -> idVendedor.equals(r.getIdVendedor()))
                .findFirst();

        if (existenteOpt.isPresent()) {
            ReporteVendedores existente = existenteOpt.get();

            // Actualiza todos los campos relevantes
            existente.setPromedioVentasDiaria(nuevoReporte.getPromedioVentasDiaria());
            existente.setPromedioVentaSemanal(nuevoReporte.getPromedioVentaSemanal());
            existente.setPromedioVentaMensual(nuevoReporte.getPromedioVentaMensual());
            existente.setPromedioVentaTrimestral(nuevoReporte.getPromedioVentaTrimestral());
            existente.setFechaReporte(nuevoReporte.getFechaReporte());
            existente.setCiudad(nuevoReporte.getCiudad());
            // Otros campos que quieras actualizar
        } else {
            throw new PersistenciaException("No se encontró el reporte con el ID de vendedor: " + idVendedor);
        }
    }

    /**
     * Elimina un reporte por el ID del vendedor.
     *
     * @param idVendedor
     * @throws Exception.PersistenciaException
     */
    @Override
    public void eliminarReporte(String idVendedor) throws PersistenciaException {
        reportes.removeIf(r -> idVendedor.equals(r.getIdVendedor()));
    }
}
