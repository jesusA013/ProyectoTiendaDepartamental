/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAOs;

import java.util.*;
import Entidades.ReporteVendedores;

/**
 *
 * @author melis
 */
public class ReporteVendedorDAO {

    private Map<Integer, ReporteVendedores> reportes = new HashMap<>();

    //guardadr un nuevo reporte
    public void guardarReporte(int idVendedor, ReporteVendedores reporte) {
        reportes.put(idVendedor, reporte);
    }

    //obtener el reporte por le vendedor
    public ReporteVendedores obtenerReportePorVendedor(int idVendedor) {
        return reportes.get(idVendedor);
    }

    public void eliminarReporte(int idVendedor) {
        reportes.remove(idVendedor);
    }

}
