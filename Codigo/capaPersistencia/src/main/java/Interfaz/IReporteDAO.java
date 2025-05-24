package Interfaz;

import Entidades.ReporteVendedores;
import Exception.PersistenciaException;
import java.util.List;

/**
 *
 * @author melis
 */
public interface IReporteDAO {

    void guardarReporte(String idVendedor, ReporteVendedores reporte) throws PersistenciaException;

    ReporteVendedores obtenerReportePorVendedor(String idVendedor) throws PersistenciaException;

    List<ReporteVendedores> obtenerTodosLosReportes() throws PersistenciaException;

    void actualizarReporte(String idVendedor, ReporteVendedores nuevoReporte) throws PersistenciaException;

    void eliminarReporte(String idVendedor) throws PersistenciaException;

}
