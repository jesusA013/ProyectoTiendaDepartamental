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
    
    private String nombre;
    private String sku;
    private double precio;
    private String marca;
    private String color;
    private int cantidad;

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getSku() {
        return sku;
    }

    public void setSku(String sku) {
        this.sku = sku;
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
     * @param cantidad del producto en el carrito
     * @param precio Precio del producto en el carrito
     * @param importe Importe del producto en el carrito
     * @param impuesto Impuesto del producto en el carrito
     * @param color color del producto en el carrito
     * @param marca marca del producto en el carrito
     * @param nombre marca del producto en el carrito
     * @param sku marca del producto en el carrito
     */
    public ProductoCarritoDTO(String nombre, String sku, double precio, String marca, String color) {
        this.nombre = nombre;
        this.sku = sku;
        this.precio = precio;
        this.marca = marca;
        this.color = color;
        this.cantidad = 1;
        this.importe = cantidad*precio;
        this.impuesto = importe*1.16;
    }

    /**
     * Regresa el cantidad del producto en el carrito
     *
     * @return cantidad del producto en el carrito
     */
    public int getCantidad() {
        return cantidad;
    }

    /**
     * Establece el cantidad del producto en el carrito
     *
     * @param cantidad del producto en el carrito
     */
    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
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
