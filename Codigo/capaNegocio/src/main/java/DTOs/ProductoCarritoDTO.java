package DTOs;

/**
 * ProductoCarritoDTO.java
 *
 * Esta clase representa los productos del carrito de objeto de transferencia de
 * datos
 *
 * @author
 */
public class ProductoCarritoDTO {

    private int stock;
    private double precio;
    private double importe;
    private double impuesto;

    /**
     * Constructor por omision
     */
    public ProductoCarritoDTO() {
    }

    /**
     * Constructor de los productos del carrito de objeto de transferencia de
     * datos
     *
     * @param stock Stock del producto en el carrito
     * @param precio Precio del producto en el carrito
     * @param importe Importe del producto en el carrito
     * @param impuesto Impuesto del producto en el carrito
     */
    public ProductoCarritoDTO(int stock, double precio, double importe, double impuesto) {
        this.stock = stock;
        this.precio = precio;
        this.importe = importe;
        this.impuesto = impuesto;
    }

    /**
     * Regresa el stock del producto en el carrito
     *
     * @return Stock del producto en el carrito
     */
    public int getStock() {
        return stock;
    }

    /**
     * Establece el stock del producto en el carrito
     *
     * @param stock Stock del producto en el carrito
     */
    public void setStock(int stock) {
        this.stock = stock;
    }

    /**
     * Regresa el precio del producto en el carrito
     *
     * @return Precio del producto en el carrito
     */
    public double getPrecio() {
        return precio;
    }

    /**
     * Estable el precio del producto en el carrito
     *
     * @param precio Precio del producto en el carrito
     */
    public void setPrecio(double precio) {
        this.precio = precio;
    }

    /**
     * Regresa el importe del producto en el carrito
     *
     * @return Importe del producto en el carrito
     */
    public double getImporte() {
        return importe;
    }

    /**
     * Establece el importe del producto en el carrito
     *
     * @param importe Importe del producto en el carrito
     */
    public void setImporte(double importe) {
        this.importe = importe;
    }

    /**
     * Regresa el impuesto del producto en el carrito
     *
     * @return Impuesto del producto en el carrito
     */
    public double getImpuesto() {
        return impuesto;
    }

    /**
     * Establece el impuesto del producto en el carrito
     *
     * @param impuesto Impuesto del producto en el carrito
     */
    public void setImpuesto(double impuesto) {
        this.impuesto = impuesto;
    }

}
