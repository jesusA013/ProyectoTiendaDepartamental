/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Interfaz;

import Entidades.ReporteVendedores;
import java.util.List;

/**
 *
 * @author melis
 */
public interface IReporteDAO {

    void guardarReporte(int idVendedor, ReporteVendedores reporte);

    ReporteVendedores obtenerReportePorVendedor(String idVendedor);

    List<ReporteVendedores> obtenerTodosLosReportes();

    void actualizarReporte(String idVendedor, ReporteVendedores reporte);

    void eliminarReporte(String idVendedor);

}
