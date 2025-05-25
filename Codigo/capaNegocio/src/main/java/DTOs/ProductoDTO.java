package DTOs;

/**
 * ProductoDTO.java
 *
 * Esta clase representa un objeto de transferencia de datos (DTO) para un
 * producto. Contiene información relevante del producto como nombre, SKU,
 * precio, marca, color y stock disponible.
 *
 * @author
 */
public class ProductoDTO {

    private String idProductoDTO;
    private String codigo;
    private String nombre;
    private String SKU;
    private String marca;
    private String color;
    private double precio;
    private int stock;
    private String descripcion;
    private String idProveedor;

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
    public ProductoDTO(String idProducto, String nombre, int stock, String descripcion) {
        this.idProductoDTO = idProducto;
        this.nombre = nombre;
        this.stock = stock;
        this.descripcion = descripcion;
    }

    /**
     * Contructor que usa ProductoVenta para guardar productos.
     *
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

    public ProductoDTO(String codigo, String nombre, String SKU, String marca, String color, double precio, int stock, String descripcion, String idProveedor) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.SKU = SKU;
        this.marca = marca;
        this.color = color;
        this.precio = precio;
        this.stock = stock;
        this.descripcion = descripcion;
        this.idProveedor = idProveedor;
    }

    public ProductoDTO(String idProductoDTO, String codigo, String nombre, String SKU, String marca, String color, double precio, int stock, String descripcion, String idProveedor) {
        this.idProductoDTO = idProductoDTO;
        this.codigo = codigo;
        this.nombre = nombre;
        this.SKU = SKU;
        this.marca = marca;
        this.color = color;
        this.precio = precio;
        this.stock = stock;
        this.descripcion = descripcion;
        this.idProveedor = idProveedor;
    }

    /**
     * Regresa el ID del producto.
     *
     * @return ID del producto
     */
    public String getIdProductoDTO() {
        return idProductoDTO;
    }

    /**
     * Establece el ID del producto.
     *
     * @param idProductoDTO ID del producto
     */
    public void setIdProductoDTO(String idProductoDTO) {
        this.idProductoDTO = idProductoDTO;
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

    public String getIdProveedor() {
        return idProveedor;
    }

    public void setIdProveedor(String idProveedor) {
        this.idProveedor = idProveedor;
    }

    /**
     * Regresa una cadena con todos los datos.
     *
     * @return Regresa una cadena con todo los datos del producto.
     */
    @Override
    public String toString() {
        return "ProductoDTO{" + "idProductoDTO=" + idProductoDTO + ", codigo=" + codigo + ", nombre=" + nombre + ", SKU=" + SKU + ", marca=" + marca + ", color=" + color + ", precio=" + precio + ", stock=" + stock + ", descripcion=" + descripcion + ", idProveedor=" + idProveedor + '}';
    }
}
