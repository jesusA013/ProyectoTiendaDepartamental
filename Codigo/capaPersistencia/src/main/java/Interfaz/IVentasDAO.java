/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Interfaz;

import Entidades.Venta;
import Exception.PersistenciaException;
import java.util.List;
import org.bson.types.ObjectId;

/**
 *
 * @author Ilian Gastelum
 */
public interface IVentasDAO {

    Venta insertarVenta(Venta venta) throws PersistenciaException;

    Venta buscarPorId(String id) throws PersistenciaException;

    Venta actualizarVenta(Venta venta) throws PersistenciaException;

    Venta eliminarVenta(String id) throws PersistenciaException;

    List<Venta> buscarVentas(String idVendedor) throws PersistenciaException;
}
