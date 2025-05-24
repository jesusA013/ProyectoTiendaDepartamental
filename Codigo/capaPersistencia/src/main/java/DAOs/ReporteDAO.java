/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAOs;

import Entidades.ReporteVendedores;
import Exception.PersistenciaException;
import  Interfaz.IReporteDAO;
import com.mongodb.client.MongoDatabase;
import static com.mongodb.client.model.Filters.eq;
import java.util.*;
import org.bson.conversions.Bson;
import org.bson.types.ObjectId;

/**
 * ReporteDAO.java
 *
 * Esta clase simula un DAO en memoria para manejar operaciones relacionadas
 * con reportes.
 * 
 * @author
 */
public abstract class ReporteDAO implements IReporteDAO {
//
//    private static ReporteDAO instance; // Instancia única
//    private FolioDAO folioDAO;
//    private ProductoDAO productoDAO;
//private final MongoCollection<ReporteVendedores> coleccion;
//
//    /**
//     * Constructor privado para evitar instanciación directa.
//     */
//    private ReporteDAO() {
//        this.folioDAO = FolioDAO.getInstance();
//        this.productoDAO = ProductoDAO.getInstance();
//    }
//
//    /**
//     * Obtiene la instancia única del DAO (Singleton).
//     *
//     * @return Instancia de ReporteDAO
//     */
//    public static synchronized ReporteDAO getInstance() {
//        if (instance == null) {
//            instance = new ReporteDAO();
//        }
//        return instance;
//    }

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
     * @return 
     * @throws Exception.PersistenciaException
     */
    @Override
    public List<ReporteVendedores> obtenerTodosLosReportes() throws PersistenciaException {
        return new ArrayList<>(reportes); // Retorna copia para evitar modificaciones externas
    }

    /**
     * Actualiza un reporte existente por el ID del vendedor.
     * @param idVendedor
     * @param nuevoReporte
     * @throws Exception.PersistenciaException
     */
    @Override
    public void actualizarReporte(String idVendedor, ReporteVendedores nuevoReporte) throws PersistenciaException {
        Optional<ReporteVendedores> existenteOpt = reportes.stream()
                .filter(r -> idVendedor.equals(r.getIdVendedor()))
                .findFirst();

        existenteOpt.ifPresent(existente -> {
            // Puedes ajustar qué campos se actualizan
            existente.setVentas(nuevoReporte.getVentas());
            existente.setFechaReporte(nuevoReporte.getFechaReporte());
            existente.setDescripcion(nuevoReporte.getDescripcion());
            // Otros campos que quieras actualizar
        });
    }

    /**
     * Elimina un reporte por el ID del vendedor.
     * @param idVendedor
     * @throws Exception.PersistenciaException
     */
    @Override
    public void eliminarReporte(String idVendedor) throws PersistenciaException {
        reportes.removeIf(r -> idVendedor.equals(r.getIdVendedor()));
    }
}
