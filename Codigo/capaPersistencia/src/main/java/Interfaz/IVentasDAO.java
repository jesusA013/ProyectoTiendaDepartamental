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
    void insertarVenta(Venta venta);
    List<Venta> consultarVentas();
    Venta buscarVentaPorId(ObjectId id);
    List<Venta> buscarVentasPorVendedor(ObjectId vendedorId);
}
