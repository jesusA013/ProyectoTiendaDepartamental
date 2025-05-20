/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Interfaces;

import DTOs.ProductoDTO;
import DTOs.ProductoTablaDTO;
import Excepciones.NegocioException;
import java.util.List;
import org.bson.types.ObjectId;

/**
 * IProductoBO.java
 * 
 * Esta clase implementa los metodos de intermediario para la gestión de proveedores.
 * 
 * @author 
 */
public interface IProductoBO {
    ProductoDTO insertarProducto(ProductoDTO productoDTO) throws NegocioException;
    
    ProductoDTO buscarProductoPorId(ObjectId id) throws NegocioException;
    
    List<ProductoDTO> buscarProductos(String producto) throws NegocioException;
    
    ProductoDTO actualizarProducto(ProductoDTO productoDTO) throws NegocioException;
    
    ProductoDTO eliminarProducto(ObjectId id) throws NegocioException;
    
    List<ProductoTablaDTO> obtenerTodosParaTabla()throws NegocioException;
    
}
