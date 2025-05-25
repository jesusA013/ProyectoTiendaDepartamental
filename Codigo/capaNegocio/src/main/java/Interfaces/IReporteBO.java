package Interfaces;

import Entidades.ReporteVendedores;
import java.util.List;

/**
 *
 * @author melis
 */
public interface IReporteBO {

    ReporteVendedores generarReporteVendedor(String idVendedor);

    ReporteVendedores obtenerReportePorVendedor(String idVendedor);

    List<ReporteVendedores> obtenerTodosLosReportes();

    void actualizarReporte(ReporteVendedores reporte);

    void eliminarReporte(String idVendedor);

}
