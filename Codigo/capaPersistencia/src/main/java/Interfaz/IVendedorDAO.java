/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Interfaz;

import Entidades.Vendedor;
import java.util.List;

/**
 *
 * @author gaspa
 */
public interface IVendedorDAO {
    void insertarVendedor(Vendedor vendedor);
    Vendedor buscarPorCURP(String curp);
    List<Vendedor> obtenerTodos();
}
