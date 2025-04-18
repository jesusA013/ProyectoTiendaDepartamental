package BOs;

import java.util.List;
import Interface.inventarioObservador;
import java.util.LinkedList;

/**
 * ProductoBO.java
 *
 * Esta clase representa los productos de objecto negocio Representa un producto
 * en el nivel del negocio y gestiona atributos como stock y precio
 *
 * @author
 */
public class ProductoBO implements inventarioObservador {

    private String nombre;
    private String sku;
    private double precio;
    private String marca;
    private String color;
    private int stock;

    /**
     * Constructor por omision
     */
    public ProductoBO() {
    }

    /**
     * Constructor de los productos de objecto negocio
     *
     * @param nombre Nombre del producto
     * @param sku SKU del producto
     * @param precio Precio del producto
     * @param marca Marca del producto
     * @param color Color del producto
     * @param stock Stock del producto
     */
    public ProductoBO(String nombre, String sku, double precio, String marca, String color, int stock) {
        this.nombre = nombre;
        this.sku = sku;
        this.precio = precio;
        this.marca = marca;
        this.color = color;
        this.stock = stock;
    }

    /**
     * Regresa el nombre del producto
     *
     * @return Nombre del producto
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Establece el nombre del producto
     *
     * @param nombre Nombre del producto
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * Regresa el SKU del producto
     *
     * @return SKU del producto
     */
    public String getSku() {
        return sku;
    }

    /**
     * Establece el SKU del producto
     *
     * @param sku SKU del producto
     */
    public void setSku(String sku) {
        this.sku = sku;
    }

    /**
     * Regresa el precio del producto
     *
     * @return Precio del producto
     */
    public double getPrecio() {
        return precio;
    }

    /**
     * Establece el precio del producto
     *
     * @param precio Precio del producto
     */
    public void setPrecio(double precio) {
        this.precio = precio;
    }

    /**
     * Regresa la marca del producto
     *
     * @return Marca del producto
     */
    public String getMarca() {
        return marca;
    }

    /**
     * Establece la marca del producto
     *
     * @param marca Marca del producto
     */
    public void setMarca(String marca) {
        this.marca = marca;
    }

    /**
     * Regresa el color del producto
     *
     * @return Color del producto
     */
    public String getColor() {
        return color;
    }

    /**
     * Establece el color del producto
     *
     * @param color Color del producto
     */
    public void setColor(String color) {
        this.color = color;
    }

    /**
     * Regresa el stock del producto
     *
     * @return Stock del producto
     */
    public int getStock() {
        return stock;
    }

    /**
     * Establece el stock del producto
     *
     * @param stock Stock del producto
     */
    public void setStock(int stock) {
        this.stock = stock;
    }

    // ------------------------------------ //
    /**
     * Valida la existencia del SKU
     */
    private void validarExistenciaSKU() {

    }

    /**
     * Valida el precio
     */
    public void validarPrecio() {

    }

    /**
     * Valida el nombre del producto
     */
    public void validarNombre() {

    }
    /*Metodos de implementacion para patron observador*/
    private LinkedList<inventarioObservador> observadores = new LinkedList<>();

    public void agregarObservador(inventarioObservador observador) {
        observadores.add(observador);
    }

    public void eliminarObservador(inventarioObservador observador) {
        observadores.remove(observador);
    }

    public void actualizarStock(int nuevoStock) {
        this.stock = nuevoStock;
        notificarObservadores();
    }

    private void notificarObservadores() {
        for (inventarioObservador observador : observadores) {
            observador.actualizar(nombre, stock);
        }
    }

    public void reducirStock(int cantidadVendida) {
        if (cantidadVendida > this.stock) {
            throw new IllegalArgumentException("Stock insuficiente.");
        }
        this.stock -= cantidadVendida;
    }

    @Override
    public void actualizar(String producto, int nuevoStock) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
