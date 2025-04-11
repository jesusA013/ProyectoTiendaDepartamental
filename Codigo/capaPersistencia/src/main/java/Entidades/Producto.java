package Entidades;

/**
 * Producto.java
 *
 * Esta clase representa la entidad producto.
 *
 * @author Knocmare
 */
public class Producto {

    private int idProducto;
    private String nombre;
    private int stock;
    private String descripcion;

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
    public Producto(int idProducto, String nombre, int stock, String descripcion) {
        this.idProducto = idProducto;
        this.nombre = nombre;
        this.stock = stock;
        this.descripcion = descripcion;
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

    /**
     * Regresa una cadena con todos los datos.
     *
     * @return Regresa una cadena con todo los datos del producto.
     */
    @Override
    public String toString() {
        return "Producto{" + "idProducto=" + idProducto + ", nombre=" + nombre + ", stock=" + stock + ", descripcion=" + descripcion + '}';
    }

}
