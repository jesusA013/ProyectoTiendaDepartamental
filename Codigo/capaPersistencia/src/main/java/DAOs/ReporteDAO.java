/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAOs;

import Entidades.EntidadFolio;
import Entidades.EntidadProducto;
import DTOs.ReporteBajosDTO;
import DTOs.ReporteStockDTO;
import Entidades.ReporteVendedores;
import  Interfaz.IReporteDAO;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import static com.mongodb.client.model.Filters.eq;
import java.util.*;
import org.bson.conversions.Bson;
import org.bson.types.ObjectId;

/**
 * ReporteDAO.java
 *
 * Esta clase simula un DAO para manejar operaciones relacionadas con reportes, usando el patrón Singleton.
 */
public abstract class ReporteDAO implements IReporteDAO {

    private static ReporteDAO instance; // Instancia única
    private FolioDAO folioDAO;
    private ProductoDAO productoDAO;
private final MongoCollection<ReporteVendedores> coleccion;

    /**
     * Constructor privado para evitar instanciación directa.
     */
    private ReporteDAO() {
        this.folioDAO = FolioDAO.getInstance();
        this.productoDAO = ProductoDAO.getInstance();
    }

    /**
     * Obtiene la instancia única del DAO (Singleton).
     *
     * @return Instancia de ReporteDAO
     */
    public static synchronized ReporteDAO getInstance() {
        if (instance == null) {
            instance = new ReporteDAO();
        }
        return instance;
    }

    /**
     * Genera un reporte de stock agregado en un rango de fechas.
     *
     * @param fechaInicio Fecha inicial
     * @param fechaFin Fecha final
     * @return Lista de ReporteStockDTO
     */
    public List<ReporteStockDTO> generarReporteStockAgregado(Calendar fechaInicio, Calendar fechaFin) {
        List<EntidadFolio> folios = folioDAO.obtenerFoliosPorRangoFechas(fechaInicio, fechaFin);
        List<ReporteStockDTO> reporte = new ArrayList<>();

        for (EntidadFolio folio : folios) {
            List<EntidadProducto> productos = folioDAO.obtenerProductosPorFolio(folio.getIdFolio());
            int totalProductos = productos.stream().mapToInt(EntidadProducto::getStock).sum();

            ReporteStockDTO dto = new ReporteStockDTO();
            dto.setNumeroFolio(folio.getNumeroFolio());
            dto.setFecha(folio.getFecha());
            dto.setTotalProductos(totalProductos);
            reporte.add(dto);
        }

        return reporte;
    }

    /**
     * Genera un reporte de productos con stock bajo.
     *
     * @param umbral Umbral de stock
     * @return Lista de ReporteBajosDTO
     */
    public List<ReporteBajosDTO> generarReporteProductosBajos(int umbral) {
        List<EntidadProducto> productosBajos = productoDAO.obtenerProductosBajos(umbral);
        List<ReporteBajosDTO> reporte = new ArrayList<>();

        for (EntidadProducto producto : productosBajos) {
            ReporteBajosDTO dto = new ReporteBajosDTO();
            dto.setSku(producto.getSku());
            dto.setNombre(producto.getNombre());
            dto.setStock(producto.getStock());
            dto.setUmbral(umbral); 
            reporte.add(dto);
        }

        return reporte;
    }
    ////////gv
    public ReporteDAO(MongoDatabase database) {
        this.coleccion = database.getCollection("ReportesVendedores", ReporteVendedores.class);
    }

    public void guardarReporte(String idVendedor, ReporteVendedores reporte) {
        reporte.setIdVendedor(new ObjectId());
        coleccion.insertOne(reporte);
    }

    @Override
    public ReporteVendedores obtenerReportePorVendedor(String idVendedor) {
        return coleccion.find(eq("idVendedor", new ObjectId(idVendedor))).first();
    }
     @Override
    public List<ReporteVendedores> obtenerTodosLosReportes() {
        return coleccion.find().into(new ArrayList<>());
    }

    @Override
    public void actualizarReporte(String idVendedor, ReporteVendedores reporte) {
        coleccion.updateOne(eq("idVendedor", new ObjectId(idVendedor)), (List<? extends Bson>) new com.mongodb.client.model.UpdateOptions().upsert(true));
    }

    @Override
    public void eliminarReporte(String idVendedor) {
        coleccion.deleteOne(eq("idVendedor", new ObjectId(idVendedor)));
    }


///////////
}
