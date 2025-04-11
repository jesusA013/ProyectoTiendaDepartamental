package Entidades;

/**
 * ProductoVenta.java
 *
 * Esta clase representa la entidad del producto tipo venta.
 *
 * @author Knocmare
 */
public class ProductoVenta {

    private int idProductoVenta;
    private String nombre;
    private int stock;
    private String descripcion;
    private double importe;

    /**
     * Constructor por ausencia
     */
    public ProductoVenta() {
    }

    /**
     * Constructor producto qtipo venta.
     *
     * @param nombre Nombre del producto tipo venta
     * @param stock Stock del producto tipo venta
     * @param descripcion Descripcion tipo venta
     * @param importe Importe del producto tipo venta
     */
    public ProductoVenta(String nombre, int stock, String descripcion, double importe) {
        this.nombre = nombre;
        this.stock = stock;
        this.descripcion = descripcion;
        this.importe = importe;
    }

    /**
     * Regresa el ID del producto tipo venta.
     *
     * @return ID del producto qtipo venta
     */
    public int getIdProductoVenta() {
        return idProductoVenta;
    }

    /**
     * Establece el ID del producto tipo venta.
     *
     * @param idProductoVenta ID del producto tipo venta
     */
    public void setIdProductoVenta(int idProductoVenta) {
        this.idProductoVenta = idProductoVenta;
    }

    /**
     * Regresa el nombre del producto tipo venta.
     *
     * @return Nombre del producto tipo venta
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Establece el nombre del producto tipo venta.
     *
     * @param nombre Nombre del producto tipo venta
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * Regresa el stock del producto tipo venta.
     *
     * @return Stock del producto tipo venta
     */
    public int getStock() {
        return stock;
    }

    /**
     * Establece el stock del producto tipo venta.
     *
     * @param stock Stock del producto tipo venta
     */
    public void setStock(int stock) {
        this.stock = stock;
    }

    /**
     * Regresa la descripcion del producto tipo venta.
     *
     * @return Descripcion del producto tipo venta
     */
    public String getDescripcion() {
        return descripcion;
    }

    /**
     * Establece la descripcion del producto tipo venta.
     *
     * @param descripcion Descripcion del producto tipo venta
     */
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    /**
     * Regresa el importe del producto tipo venta.
     *
     * @return Importe del producto tipo venta
     */
    public double getImporte() {
        return importe;
    }

    /**
     * Establece el importe del producto tipo venta.
     *
     * @param importe Importe del producto tipo venta
     */
    public void setImporte(double importe) {
        this.importe = importe;
    }

    /**
     * Regresa una cadena con todos los datos.
     *
     * @return Cadena con todos los datos
     */
    @Override
    public String toString() {
        return "ProductoVenta{" + "idProductoVenta=" + idProductoVenta + ", nombre=" + nombre + ", stock=" + stock + ", descripcion=" + descripcion + ", importe=" + importe + '}';
    }

}
