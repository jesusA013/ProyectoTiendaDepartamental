package BOs;

import java.util.List;

/**
 *
 * @author Knocmare
 */
public class VentaBO {
    
    private String idVenta;
    private List<ProductoVentaBO> listaProductos;
    private int cantidadProductos;
    private int subtotal;
    private double impuestos;
    private double IVA;
    public int total;
    public Vendedor vendedor;

    public VentaBO() {
    }

    public VentaBO(String idVenta, List<ProductoVentaBO> listaProductos, int cantidadProductos, int subtotal, double impuestos, double IVA, int total, Vendedor vendedor) {
        this.idVenta = idVenta;
        this.listaProductos = listaProductos;
        this.cantidadProductos = cantidadProductos;
        this.subtotal = subtotal;
        this.impuestos = impuestos;
        this.IVA = IVA;
        this.total = total;
        this.vendedor = vendedor;
    }

    public String getIdVenta() {
        return idVenta;
    }

    public void setIdVenta(String idVenta) {
        this.idVenta = idVenta;
    }

    public List<ProductoVentaBO> getListaProductos() {
        return listaProductos;
    }

    public void setListaProductos(List<ProductoVentaBO> listaProductos) {
        this.listaProductos = listaProductos;
    }

    public int getCantidadProductos() {
        return cantidadProductos;
    }

    public void setCantidadProductos(int cantidadProductos) {
        this.cantidadProductos = cantidadProductos;
    }

    public int getSubtotal() {
        return subtotal;
    }

    public void setSubtotal(int subtotal) {
        this.subtotal = subtotal;
    }

    public double getImpuestos() {
        return impuestos;
    }

    public void setImpuestos(double impuestos) {
        this.impuestos = impuestos;
    }

    public double getIVA() {
        return IVA;
    }

    public void setIVA(double IVA) {
        this.IVA = IVA;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public Vendedor getVendedor() {
        return vendedor;
    }

    public void setVendedor(Vendedor vendedor) {
        this.vendedor = vendedor;
    }
    
    // ------------------------------------ //
    
    
}
