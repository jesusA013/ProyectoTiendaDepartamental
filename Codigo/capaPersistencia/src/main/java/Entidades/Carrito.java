/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Entidades;

import java.util.List;

/**
 *
 * @author Knocmare
 */
public class Carrito {

    private int idCarrito;
    private List<ProductoVenta> carrito;
    private int cantidadProductos;
    private double subtotal;
    private double total;
    private double impuesto;

    public Carrito(List<ProductoVenta> carrito, int cantidadProductos, double subtotal, double total, double impuesto) {
        this.carrito = carrito;
        this.cantidadProductos = cantidadProductos;
        this.subtotal = subtotal;
        this.total = total;
        this.impuesto = impuesto;
    }

    public int getIdCarrito() {
        return idCarrito;
    }

    public void setIdCarrito(int idCarrito) {
        this.idCarrito = idCarrito;
    }

    public List<ProductoVenta> getCarrito() {
        return carrito;
    }

    public void setCarrito(List<ProductoVenta> carrito) {
        this.carrito = carrito;
    }

    public int getCantidadProductos() {
        return cantidadProductos;
    }

    public void setCantidadProductos(int cantidadProductos) {
        this.cantidadProductos = cantidadProductos;
    }

    public double getSubtotal() {
        return subtotal;
    }

    public void setSubtotal(double subtotal) {
        this.subtotal = subtotal;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public double getImpuesto() {
        return impuesto;
    }

    public void setImpuesto(double impuesto) {
        this.impuesto = impuesto;
    }

    @Override
    public String toString() {
        return "Carrito{" + "idCarrito=" + idCarrito + ", carrito=" + carrito + ", cantidadProductos=" + cantidadProductos + ", subtotal=" + subtotal + ", total=" + total + ", impuesto=" + impuesto + '}';
    }
    
}
