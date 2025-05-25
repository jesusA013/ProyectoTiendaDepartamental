/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Interfaz;

import Entidades.Vendedor;
import java.util.List;
import org.bson.types.ObjectId;

/**
 *
 * @author gaspa
 */
public interface IVendedorDAO {

    Vendedor insertarVendedor(Vendedor vendedor);

    Vendedor buscarPorCURP(String curp);

    List<Vendedor> obtenerTodos();

    Vendedor buscarPorId(String id);

    boolean actualizarVendedor(String id, Vendedor vendedor);

    Vendedor actualizarVendedor(Vendedor vendedor);

    Vendedor eliminarVendedor(String id);
}
