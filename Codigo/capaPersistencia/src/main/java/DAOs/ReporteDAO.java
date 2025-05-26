/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAOs;

import Entidades.ReporteVendedores;
import Interfaz.IReporteDAO;

import java.util.*;

/**
 * ReporteDAO.java
 *
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
    }


///////////
}
