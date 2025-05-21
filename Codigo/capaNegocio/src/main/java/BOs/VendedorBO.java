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
public class VendedorBO {
    private int id;
    private String nombre;
    private double totalVentas;
    private List<VentasBO>ventas; // clase venta realizada para modulo venta

    public VendedorBO(int id, String nombre, double totalVentas) {
        this.id = id;
        this.nombre = nombre;
        this.totalVentas = totalVentas;
    }

    public VendedorBO() {
    }
   //gestion v
     public void agregarVneta(VentasBO venta){
    ventas.add(venta);
    totalVentas +=venta.getMonto();
    }
    
    public double calcularPromedioVentas(){
    return ventas.isEmpty()?0:totalVentas/ventas.size();
    }
    
    /////
    
    
}
