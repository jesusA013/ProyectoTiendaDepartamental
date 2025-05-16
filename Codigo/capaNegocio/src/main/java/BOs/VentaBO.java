package BOs;

import java.util.LinkedList;
import java.util.List;

/**
 * VentaBO.java
 *
 * Esta clase representa una venta realizada en el sistema. Contiene información
 * sobre los productos vendidos, la cantidad, el subtotal, los impuestos, el
 * IVA, el total de la venta y el vendedor responsable. Registra la venta,
 * calcula totales, y actualiza el inventario.
 *
 * @author
 */
public class VentaBO {
    

//    public void registrarVenta(LinkedList<ProductoCarritoBO> carritoProductoCarritoBOs) {
//        LinkedList<ProductoVentaBO> productosVendidos = new LinkedList<>();
//        for (ProductoCarritoBO productoCarrito : carritoProductoCarritoBOs) {
//            productosVendidos.add(new ProductoVentaBO(
//                    productoCarrito.getProducto(),
//                     productoCarrito.getCantidad(),
//                    productoCarrito.getPrecio()));
//        }
//        double subtotal = calcularSubtotal(productosVendidos);
//        double impuestos = calcularImpuestos(subtotal);
//        double total = calcularTotal(subtotal, impuestos);
//
//        // Asignar valores a los atributos de la venta
//        this.idVenta = "VENTA" + System.currentTimeMillis(); // Generar un ID único
//        this.listaProductos = productosVendidos;
//        this.cantidadProductos = productosVendidos.size();
//        this.subtotal = (int) subtotal;
//        this.impuestos = impuestos;
//        this.IVA = 16;
//        this.total = (int) total;
//
//        //actualizamos el inventario
//        //verifica producto bo no se que mande mal la verdad
//        for (ProductoVentaBO productoVenta : productosVendidos) {
//        ProductoBO producto = productoVenta.getProducto();
//        producto.setStock(producto.getStock() - productoVenta.getCantidad());
////        guardarVentaArchivo(venta);//falta desarrollar el metodo
//
//        actualizarInventario(productosVendidos);
//        }
//        
//    }
//
//    public double calcularSubtotal(LinkedList<ProductoVentaBO> productosVendidos) {
//        return productosVendidos.stream().mapToDouble(p -> p.getCantidad() * p.getPrecio()).sum();
//    }
//
//    public double calcularImpuestos(double subtotal) {
//        return subtotal * 0.16; // IVA del 16%
//    }
//
//    public double calcularTotal(double subtotal, double impuestos) {
//        return subtotal + impuestos;
//    }

//    VentaBO venta = new VentaBO("VENTA001", productosVendidos., productosVendidos.size(),
//            (int) subtotal, impuestos, 16, (int) total);//corregir los datos que guardara la venta y hacer los llamados correspondientes

//    public void registrarVenta(LinkedList<ProductoCarritoBO> carritoProductos) {
//        // Convertir los productos del carrito en productos vendidos
//        LinkedList<ProductoVentaBO> productosVendidos = new LinkedList<>();
//        for (ProductoCarritoBO productoCarrito : carritoProductos) {
//            productosVendidos.add(new ProductoVentaBO(
//            productoCarrito.getCantidad(),
//            productoCarrito.getProducto(), productoCarrito.getPrecio()));
//        }
//
//    }

    /*Este metodo no esta desarrollado a falta de claridad
    +sobre cmo sera el guardado de la venta
     */
//    public void guardarVentaArchivo() {
//
//    }
//
//    /*
//    *Este metodo busca actualizar el inventario general de la tienda
//     */
//    public void actualizarInventario(LinkedList<ProductoVentaBO> productosVendidos) {
//        if (listaProductos != null) {
//            for (ProductoVentaBO productoVenta : listaProductos) {
//                ProductoBO producto = productoVenta.getProducto();
//                int nuevoStock = producto.getStock() - productoVenta.getCantidad();
//                if (nuevoStock >= 0) {
//                    producto.setStock(nuevoStock);
//                    System.out.println("Stock actualizado para " + producto.getNombre() + ": " + nuevoStock);
//                } else {
//                    System.err.println("Error: No hay suficiente stock para el producto " + producto.getNombre());
//                }
//            }
//        } else {
//            System.err.println("Error: La lista de productos está vacía o no inicializada.");
//        }
//    }

    /**
     * Obtiene el vendedor responsable de la venta.
     *
     * @return Vendedor que realizó la venta.
     */
//    /**
//     * Obtiene el vendedor responsable de la venta.
//     *
//     * @return Vendedor que realizó la venta.
//     */
//    public Vendedor getVendedor() {
//        return vendedor;
//    }
//
//    /**
//     * Establece el vendedor responsable de la venta.
//     *
//     * @param vendedor Nuevo vendedor responsable.
//     */
//    public void setVendedor(Vendedor vendedor) {
//        this.vendedor = vendedor;
//    }
    // ------------------------------------ //
}
