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
    Vendedor insertarVendedor(Vendedor vendedor);

    /*Busca un vendedor por us curp*/
    Vendedor buscarPorCURP(String curp);

    /*Obtener a todos los vendedores*/
    List<Vendedor> obtenerTodos();

    /*Busca un vendedor or su id*/
    Vendedor buscarPorId(String id);
/*actualiza los datos de un vendedor*/
    Vendedor actualizarVendedor(Vendedor vendedor);

    /*Elimina un vendedor por su OD*/
    Vendedor eliminarVendedor(String id);

}
