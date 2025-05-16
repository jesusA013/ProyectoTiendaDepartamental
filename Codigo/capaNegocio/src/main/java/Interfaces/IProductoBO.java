/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Interfaces;

import DTOs.ProductoDTO;
import org.bson.types.ObjectId;

/**
 * IProductoBO.java
 * 
 * Esta clase implementa los metodos de intermediario para la gestión de proveedores.
 * 
 * @author 
 */
public interface IProductoBO {
    ProductoDTO insertarProducto(ProductoDTO productoDTO);
    
    ProductoDTO buscarProductoPorId(ObjectId id);
    
    ProductoDTO actualizarProducto(ProductoDTO productoDTO);
    
    ProductoDTO eliminarProducto(ObjectId id);
    
}
