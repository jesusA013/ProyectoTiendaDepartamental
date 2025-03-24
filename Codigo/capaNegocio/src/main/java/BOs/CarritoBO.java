package BOs;

import java.util.List;

/**
 *
 * @author Knocmare
 */
public class CarritoBO {
    
    private List<ProductoCarritoBO> listaProductos;
    private int cantidadTotalProducots;
    private double subtotal;
    private double impuestos;
    private double total;

    public CarritoBO() {
    }

    public CarritoBO(List<ProductoCarritoBO> listaProductos, int cantidadTotalProducots, double subtotal, double impuestos, double total) {
        this.listaProductos = listaProductos;
        this.cantidadTotalProducots = cantidadTotalProducots;
        this.subtotal = subtotal;
        this.impuestos = impuestos;
        this.total = total;
    }

    public List<ProductoCarritoBO> getListaProductos() {
        return listaProductos;
    }

    public void setListaProductos(List<ProductoCarritoBO> listaProductos) {
        this.listaProductos = listaProductos;
    }

    public int getCantidadTotalProducots() {
        return cantidadTotalProducots;
    }

    public void setCantidadTotalProducots(int cantidadTotalProducots) {
        this.cantidadTotalProducots = cantidadTotalProducots;
    }

    public double getSubtotal() {
        return subtotal;
    }

    public void setSubtotal(double subtotal) {
        this.subtotal = subtotal;
    }

    public double getImpuestos() {
        return impuestos;
    }

    public void setImpuestos(double impuestos) {
        this.impuestos = impuestos;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }
    
    // ------------------------------------ //
    
}
