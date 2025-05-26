/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Interfaz;

import Entidades.ReporteVendedores;
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

}
