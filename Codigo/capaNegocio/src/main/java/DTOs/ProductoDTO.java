package DTOs;

import org.bson.types.ObjectId;

/**
 * ProductoDTO.java
 *
 * Esta clase representa un objeto de transferencia de datos (DTO) para un producto.
 * Contiene información relevante del producto como nombre, SKU, precio, marca,
 * color y stock disponible.
 *
 * @author 
 */
public class ProductoDTO {
    
    private ObjectId id; 
    private String codigo;
    private String nombre;
    private String SKU;
    private String marca;
    private String color;
    private double precio;
    private int stock;
    private String descripcion;
    private ObjectId proveedorId; 

    /**
     * Constructor por omisión.
     */
    public ProductoDTO() {
    }

    /**
     * Constructor del producto.
     *
     * @param idProducto ID del producto
     * @param nombre Nombre del producto
     * @param stock Stock del producto
     * @param descripcion Descripcion del producto
     */
    public ProductoDTO(ObjectId idProducto, String nombre, int stock, String descripcion) {
        this.id = idProducto;
        this.nombre = nombre;
        this.stock = stock;
        this.descripcion = descripcion;
    }

    /**
     * Contructor que usa ProductoVenta para guardar productos.
     * @param nombre Nombre del producto
     * @param SKU
     * @param marca
     * @param color 
     * @param precio 
     */
    public ProductoDTO(String nombre, String SKU, String marca, String color, double precio) {
        this.nombre = nombre;
        this.SKU = SKU;
        this.marca = marca;
        this.color = color;
        this.precio = precio;
    }

    public ProductoDTO(String codigo, String nombre, String SKU, String marca, String color, double precio, int stock, String descripcion, ObjectId proveedorId) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.SKU = SKU;
        this.marca = marca;
        this.color = color;
        this.precio = precio;
        this.stock = stock;
        this.descripcion = descripcion;
        this.proveedorId = proveedorId;
    }

    /**
     * Regresa el ID del producto.
     *
     * @return ID del producto
     */
    public ObjectId getId() {
        return id;
    }

    /**
     * Establece el ID del producto.
     *
     * @param id
     */
    public void setId(ObjectId id) {
        this.id = id;
    }

    /**
     * Regresa el nombre del producto.
     *
     * @return Nombre del producto
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Establece el nombre del producto.
     *
     * @param nombre Nombre del producto
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * Regresa el stock del producto.
     *
     * @return Stock del producto
     */
    public int getStock() {
        return stock;
    }

    /**
     * Establece el stock del producto.
     *
     * @param stock Stock del producto
     */
    public void setStock(int stock) {
        this.stock = stock;
    }

    /**
     * Regresa la descripcion del producto.
     *
     * @return Descripcion del producto
     */
    public String getDescripcion() {
        return descripcion;
    }

    /**
     * Establece la descripcion del producto.
     *
     * @param descripcion Descripcion del producto
     */
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getSKU() {
        return SKU;
    }

    public void setSKU(String SKU) {
        this.SKU = SKU;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public ObjectId getProveedorId() {
        return proveedorId;
    }

    public void setProveedorId(ObjectId proveedorId) {
        this.proveedorId = proveedorId;
    }

    /**
     * Regresa una cadena con todos los datos.
     *
     * @return Regresa una cadena con todo los datos del producto.
     */
    @Override
    public String toString() {
        return "ProductoDTO{" + "id=" + id + ", codigo=" + codigo + ", nombre=" + nombre + ", SKU=" + SKU + ", marca=" + marca + ", color=" + color + ", precio=" + precio + ", stock=" + stock + ", descripcion=" + descripcion + ", proveedorId=" + proveedorId + '}';
    }
}
