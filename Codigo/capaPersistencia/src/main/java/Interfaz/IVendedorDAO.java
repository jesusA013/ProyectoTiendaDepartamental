/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Interfaz;

import Entidades.Vendedor;
import java.util.List;
import java.util.Optional;

/**
 *
 * @author gaspa
 */
public interface IVendedorDAO {
    /*onsetra un vendedor en memoria*/
    void insertarVendedor(Vendedor vendedor);
/*Busca un vendedor por us curp*/
    Optional<Vendedor> buscarPorCURP(String curp);
    /*Obtener a todos los vendedores*/
    List<Vendedor> obtenerTodos();
/*Busca un vendedor or su id*/
    Optional<Vendedor> buscarPorId(String idVendedor);
//    boolean actualizarVendedor(String idVendedor, Vendedor vendedor);
/*actualiza los datos de un vendedor*/
    boolean actualizarVendedor(Vendedor vendedor);
/*Elimina un vendedor por su OD*/
    Optional<Vendedor> eliminarVendedor(String idVendedor);

    Vendedor insertarVendedor(Vendedor vendedor);

    Vendedor buscarPorCURP(String curp);

    List<Vendedor> obtenerTodos();

    Vendedor buscarPorId(String id);

    boolean actualizarVendedor(String id, Vendedor vendedor);

    Vendedor actualizarVendedor(Vendedor vendedor);

    Vendedor eliminarVendedor(String id);
}
