package DTOs;

import Interfaces.IDTO;

/**
 * ProductoDTO.java
 *
 * Esta clase representa un objeto de transferencia de datos (DTO) para un producto.
 * Contiene información relevante del producto como nombre, SKU, precio, marca,
 * color y stock disponible.
 *
 * @author 
 */
public class ProductoDTO implements IDTO {
    
    private String nombre;
    private String sku;
    private double precio;
    private String marca;
    private String color;
    private int stock;

    /**
     * Constructor por omisión.
     */
    public ProductoDTO() {
    }

    /**
     * Constructor de un producto de objeto de transferencia de datos
     *
     * @param nombre Nombre del producto.
     * @param sku Código SKU del producto.
     * @param precio Precio del producto.
     * @param marca Marca del producto.
     * @param color Color del producto.
     * @param stock Cantidad disponible en inventario.
     */
    public ProductoDTO(String nombre, String sku, double precio, String marca, String color, int stock) {
        this.nombre = nombre;
        this.sku = sku;
        this.precio = precio;
        this.marca = marca;
        this.color = color;
        this.stock = stock;
    }

    /**
     * Obtiene el nombre del producto.
     *
     * @return Nombre del producto.
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Establece el nombre del producto.
     *
     * @param nombre Nuevo nombre del producto.
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * Obtiene el código SKU del producto.
     *
     * @return Código SKU del producto.
     */
    public String getSku() {
        return sku;
    }

    /**
     * Establece el código SKU del producto.
     *
     * @param sku Nuevo código SKU del producto.
     */
    public void setSku(String sku) {
        this.sku = sku;
    }

    /**
     * Obtiene el precio del producto.
     *
     * @return Precio del producto.
     */
    public double getPrecio() {
        return precio;
    }

    /**
     * Establece el precio del producto.
     *
     * @param precio Nuevo precio del producto.
     */
    public void setPrecio(double precio) {
        this.precio = precio;
    }

    /**
     * Obtiene la marca del producto.
     *
     * @return Marca del producto.
     */
    public String getMarca() {
        return marca;
    }

    /**
     * Establece la marca del producto.
     *
     * @param marca Nueva marca del producto.
     */
    public void setMarca(String marca) {
        this.marca = marca;
    }

    /**
     * Obtiene el color del producto.
     *
     * @return Color del producto.
     */
    public String getColor() {
        return color;
    }

    /**
     * Establece el color del producto.
     *
     * @param color Nuevo color del producto.
     */
    public void setColor(String color) {
        this.color = color;
    }

    /**
     * Obtiene la cantidad disponible en inventario.
     *
     * @return Cantidad de stock disponible.
     */
    public int getStock() {
        return stock;
    }

    /**
     * Establece la cantidad disponible en inventario.
     *
     * @param stock Nueva cantidad de stock disponible.
     */
    public void setStock(int stock) {
        this.stock = stock;
    }
    
    
}
