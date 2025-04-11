/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Entidades;

/**
 *
 * @author Knocmare
 */
public class ProductoVenta {

    private int idProductoVenta;
    private String nombre;
    private int stock;
    private String descripcion;
    private double importe;

    public ProductoVenta(String nombre, int stock, String descripcion, double importe) {
        this.nombre = nombre;
        this.stock = stock;
        this.descripcion = descripcion;
        this.importe = importe;
    }

    public int getIdProductoVenta() {
        return idProductoVenta;
    }

    public void setIdProductoVenta(int idProductoVenta) {
        this.idProductoVenta = idProductoVenta;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public double getImporte() {
        return importe;
    }

    public void setImporte(double importe) {
        this.importe = importe;
    }

    @Override
    public String toString() {
        return "ProductoVenta{" + "idProductoVenta=" + idProductoVenta + ", nombre=" + nombre + ", stock=" + stock + ", descripcion=" + descripcion + ", importe=" + importe + '}';
    }
    
}
