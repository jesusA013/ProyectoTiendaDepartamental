package Interfaz;

import Entidades.ReporteVendedores;
import Exception.PersistenciaException;
import java.util.List;
import java.util.Optional;

/**
 *
 * @author melis
 */
public interface IReporteDAO {

/*Genera un reporte*/
    void generarReporte(String idVendedor, String contenido);
/*Guarda un reporte*/
    void guardarReporte(String idVendedor, ReporteVendedores reporte) throws PersistenciaException;
/*obtiene el reporte de un vendedor*/
    ReporteVendedores obtenerReportePorVendedor(String idVendedor) throws PersistenciaException;
/*obtiene todos los reportes*/
    List<ReporteVendedores> obtenerTodosLosReportes() throws PersistenciaException;
/*actualiza un reporte*/
    void actualizarReporte(String idVendedor, ReporteVendedores nuevoReporte) throws PersistenciaException;
/*Elimina un reporte*/
    void eliminarReporte(String idVendedor) throws PersistenciaException;

}
