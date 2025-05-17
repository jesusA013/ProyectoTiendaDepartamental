/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Interfaz;

import Entidades.Venta;
import java.util.List;
import org.bson.types.ObjectId;

/**
 *
 * @author Ilian Gastelum
 */
public interface IVentasDAO {
    Venta insertarVenta(Venta venta);
    Venta buscarPorId(ObjectId id);
    Venta actualizarVenta(Venta venta);
    Venta eliminarVenta(ObjectId id);
}
