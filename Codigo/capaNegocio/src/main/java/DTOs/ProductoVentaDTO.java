package DTOs;

import org.bson.types.ObjectId;

/**
 * ProductoVentaDTO.java
 *
 * Esta clase representa los productos que se están vendiendo como parte de una
 * transacción de venta en el objeto de transferencia (DTO).
 *
 * @author
 */
public class ProductoVentaDTO {

    private ObjectId _id;
    private ProductoDTO producto;
    private int cantidad;
    private double precioUnitario;

    /**
     * Constructor por omision
     */
    public ProductoVentaDTO() {
    }

    /**
     * Inicializa los atributos al valor de sus parámetros.
     *
     * @param producto
     * @param cantidad Cantidad de productos vendidos
     * @param precioUnitario
     */
    public ProductoVentaDTO(ProductoDTO producto, int cantidad, double precioUnitario) {
        this.producto = producto;
        this.cantidad = cantidad;
        this.precioUnitario = precioUnitario;
    }

    public ObjectId getId() {
        return _id;
    }

    public void setId(ObjectId _id) {
        this._id = _id;
    }

    public ProductoDTO getProducto() {
        return producto;
    }

    public void setProducto(ProductoDTO producto) {
        this.producto = producto;
    }

    public double getPrecioUnitario() {
        return precioUnitario;
    }

    public void setPrecioUnitario(double precioUnitario) {
        this.precioUnitario = precioUnitario;
    }

    /**
     * Obtiene la cantidad de productos vendidos.
     *
     * @return Cantidad de productos vendidos.
     */
    public int getCantidad() {
        return cantidad;
    }

    /**
     * Establece la cantidad de productos vendidos.
     *
     * @param cantidad Cantidad de productos vendidos.
     */
    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    @Override
    public String toString() {
        return "ProductoVenta{" + "_id=" + _id + ", cantidad=" + cantidad + ", precioUnitario=" + precioUnitario + '}';
    }

}
