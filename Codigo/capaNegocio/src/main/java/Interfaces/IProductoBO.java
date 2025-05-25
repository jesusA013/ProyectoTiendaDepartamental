package Interfaces;

import DTOs.ProductoDTO;
import DTOs.ProductoTablaDTO;
import Excepciones.NegocioException;
import java.util.List;

/**
 * IProductoBO.java
 *
 * Esta clase implementa los metodos de intermediario para la gestión de
 * proveedores.
 *
 * @author
 */
public interface IProductoBO {

    ProductoDTO insertarProducto(ProductoDTO productoDTO) throws NegocioException;

    ProductoDTO buscarProductoPorId(String id) throws NegocioException;

    List<ProductoDTO> buscarProductos(String producto) throws NegocioException;

    ProductoDTO actualizarProducto(ProductoDTO productoDTO) throws NegocioException;

    ProductoDTO eliminarProducto(String id) throws NegocioException;

    List<ProductoTablaDTO> obtenerTodosParaTabla() throws NegocioException;

}
