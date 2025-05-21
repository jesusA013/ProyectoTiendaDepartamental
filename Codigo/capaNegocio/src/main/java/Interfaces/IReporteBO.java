/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
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
