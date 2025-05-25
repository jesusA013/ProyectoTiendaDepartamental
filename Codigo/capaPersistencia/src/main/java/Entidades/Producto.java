package Entidades;

/**
 * Producto.java
 *
 * Esta clase representa la entidad producto.
 *
 * @author Knocmare
 */
public class Producto {

    private String idProducto;
    private String codigo;
    private String nombre;
    private String SKU;
    private String marca;
    private String color;
    private double precio;
    private int stock;
    private String descripcion;
    private String proveedorId;

    /**
     * Constructor por ausencia
     */
    public Producto() {
    }

    /**
     * Constructor del producto.
     *
     * @param idProducto ID del producto
     * @param nombre Nombre del producto
     * @param stock Stock del producto
     * @param descripcion Descripcion del producto
     */
    public Producto(String idProducto, String nombre, int stock, String descripcion) {
        this.idProducto = idProducto;
        this.nombre = nombre;
        this.stock = stock;
        this.descripcion = descripcion;
    }

    public Producto(String nombre, String SKU, String marca, String color) {
        this.nombre = nombre;
        this.SKU = SKU;
        this.marca = marca;
        this.color = color;
    }

    public Producto(String codigo, String nombre, String SKU, String marca, String color, double precio, int stock, String descripcion, String proveedorId) {
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

    public Producto(String idProducto, String codigo, String nombre, String SKU, String marca, String color, double precio, int stock, String descripcion, String proveedorId) {
        this.idProducto = idProducto;
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
    public String getIdProducto() {
        return idProducto;
    }

    /**
     * Establece el ID del producto.
     *
     * @param id
     */
    public void setIdProducto(String idProducto) {
        this.idProducto = idProducto;
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

    public String getProveedorId() {
        return proveedorId;
    }

    public void setProveedorId(String proveedorId) {
        this.proveedorId = proveedorId;
    }

    /**
     * Regresa una cadena con todos los datos.
     *
     * @return Regresa una cadena con todo los datos del producto.
     */
    @Override
    public String toString() {
        return "Producto{" + "idProducto=" + idProducto + ", codigo=" + codigo + ", nombre=" + nombre + ", SKU=" + SKU + ", marca=" + marca + ", color=" + color + ", precio=" + precio + ", stock=" + stock + ", descripcion=" + descripcion + ", proveedorId=" + proveedorId + '}';
    }
}
