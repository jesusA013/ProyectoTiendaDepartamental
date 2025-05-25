package Entidades;

/**
 * Producto.java
 *
 * Esta clase representa la entidad de un producto.
 */
public class EntidadProducto {

    private int idProducto;
    private String sku;
    private String nombre;
    private int stock;

    /**
     * Constructor por ausencia
     */
    public EntidadProducto() {
    }

    /**
     * Constructor de un producto.
     *
     * @param idProducto Identificador único del producto
     * @param sku SKU del producto
     * @param nombre Nombre del producto
     * @param stock Stock del producto
     */
    public EntidadProducto(int idProducto, String sku, String nombre, int stock) {
        this.idProducto = idProducto;
        this.sku = sku;
        this.nombre = nombre;
        this.stock = stock;
    }

    /**
     * Regresa el ID del producto.
     *
     * @return ID del producto
     */
    public int getIdProducto() {
        return idProducto;
    }

    /**
     * Establece el ID del producto.
     *
     * @param idProducto ID del producto
     */
    public void setIdProducto(int idProducto) {
        this.idProducto = idProducto;
    }

    /**
     * Regresa el SKU del producto.
     *
     * @return SKU del producto
     */
    public String getSku() {
        return sku;
    }

    /**
     * Establece el SKU del producto.
     *
     * @param sku SKU del producto
     */
    public void setSku(String sku) {
        this.sku = sku;
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
     * Regresa una cadena con todos los datos del producto.
     *
     * @return Cadena con todos los datos del producto
     */
    @Override
    public String toString() {
        return "Producto{"
                + "idProducto=" + idProducto
                + ", sku='" + sku + '\''
                + ", nombre='" + nombre + '\''
                + ", stock=" + stock
                + '}';
    }
}
