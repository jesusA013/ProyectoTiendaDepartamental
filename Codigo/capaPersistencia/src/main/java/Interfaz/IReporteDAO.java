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


    void generarReporte(String idVendedor, String contenido);

    Optional<String> obtenerReportePorVendedor(String idVendedor);

    List<String> obtenerTodosLosReportes();

    boolean eliminarReporte(String idVendedor);

    void guardarReporte(String idVendedor, ReporteVendedores reporte) throws PersistenciaException;

    ReporteVendedores obtenerReportePorVendedor(String idVendedor) throws PersistenciaException;

    List<ReporteVendedores> obtenerTodosLosReportes() throws PersistenciaException;

    void actualizarReporte(String idVendedor, ReporteVendedores nuevoReporte) throws PersistenciaException;

    void eliminarReporte(String idVendedor) throws PersistenciaException;

}
