/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BOs;

import java.util.*;

/**
 *
 * @author melis
 */
public class ReporteBO {

    private int idReporte;
    private String fechaGeneracion;
    private List<VendedorBO> vendedores;

    public ReporteBO(int idReporte, String fechaGeneracion) {
        this.idReporte = idReporte;
        this.fechaGeneracion = fechaGeneracion;
    }

    public double calcularTotalVentas() {
        return 00; // cambiar a regreso de un map to double(??
    }

    

}
