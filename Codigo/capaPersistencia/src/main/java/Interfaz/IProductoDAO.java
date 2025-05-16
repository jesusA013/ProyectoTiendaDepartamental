/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Interfaz;

import Entidades.Producto;
import org.bson.types.ObjectId;

/**
 *
 * @author Knocmare
 */
public interface IProductoDAO {
    Producto insertarProducto(Producto producto);
    Producto buscarPorId(ObjectId id);
    Producto actualizarProducto(Producto producto);
    Producto eliminarProducto(ObjectId id);
}
