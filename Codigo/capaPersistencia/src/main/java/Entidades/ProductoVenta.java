package Entidades;

import org.bson.types.ObjectId;



/**
 * ProductoVenta.java
 *
 *
 *
 * @author Knocmare y Angel Beltran en la 2da Version
 */

public class ProductoVenta {

    private ObjectId _id;
    private int cantidad;
    private double precioUnitario;

   
    public ProductoVenta() {
    }

    public ProductoVenta(int cantidad, double precioUnitario) {
        this.cantidad = cantidad;
        this.precioUnitario = precioUnitario;
    }

    public ObjectId getId() {
        return _id;
    }

    public void setId(ObjectId _id) {
        this._id = _id;
    }

    public double getPrecioUnitario() {
        return precioUnitario;
    }

    public void setPrecioUnitario(double precioUnitario) {
        this.precioUnitario = precioUnitario;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    @Override
    public String toString() {
        return "ProductoVenta{" + "_id=" + _id + ", cantidad=" + cantidad + ", precioUnitario=" + precioUnitario + '}';
    }

    

    

   
}
