package BOs;

import DTOs.ProductoDTO;
import Interfaces.IProductoBO;
import java.util.List;
import Interfaz.IProductoDAO;
import java.util.LinkedList;
import org.bson.types.ObjectId;

/**
 * ProductoBO.java
 *
 * Esta clase objectos negocio actua como intermediario con la DAO de
 * Productos.
 *
 * @author
 */
public class ProductoBO implements IProductoBO {

    private IProductoDAO productoDAO;

    public ProductoBO(IProductoDAO productoDAO) {
        //this.productoDAO = new ProductoDAO();
    }
    
    @Override
    public ProductoDTO insertarProducto(ProductoDTO productoDTO) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public ProductoDTO buscarProductoPorId(ObjectId id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public ProductoDTO actualizarProducto(ProductoDTO productoDTO) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public ProductoDTO eliminarProducto(ObjectId id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    // ------------------------------------ //
    /**
     * Valida la existencia del SKU
     */
    private void validarExistenciaSKU() {

    }

    /**
     * Valida el precio
     */
    public void validarPrecio() {

    }

    /**
     * Valida el nombre del producto
     */
    public void validarNombre() {

    }
//    /*Metodos de implementacion para patron observador*/
//    private LinkedList<inventarioObservador> observadores = new LinkedList<>();
//
//    public void agregarObservador(inventarioObservador observador) {
//        observadores.add(observador);
//    }
//
//    public void eliminarObservador(inventarioObservador observador) {
//        observadores.remove(observador);
//    }
//
//    public void actualizarStock(int nuevoStock) {
//        this.stock = nuevoStock;
//        notificarObservadores();
//    }
//
//    private void notificarObservadores() {
//        for (inventarioObservador observador : observadores) {
//            observador.actualizar(nombre, stock);
//        }
//    }
//
//    public void reducirStock(int cantidadVendida) {
//        if (cantidadVendida > this.stock) {
//            throw new IllegalArgumentException("Stock insuficiente.");
//        }
//        this.stock -= cantidadVendida;
//    }
//
//    @Override
//    public void actualizar(String producto, int nuevoStock) {
//        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
//    }
}
