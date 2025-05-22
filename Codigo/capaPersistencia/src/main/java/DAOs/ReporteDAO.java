/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAOs;

import Entidades.EntidadFolio;
import Entidades.EntidadProducto;
import DTOs.ReporteBajosDTO;
import DTOs.ReporteStockDTO;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

/**
 * ReporteDAO.java
 *
 * Esta clase simula un DAO para manejar operaciones relacionadas con reportes, usando el patrón Singleton.
 */
public class ReporteDAO {

    private static ReporteDAO instance; // Instancia única
    private FolioDAO folioDAO;
    private ProductoDAO productoDAO;

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
}
