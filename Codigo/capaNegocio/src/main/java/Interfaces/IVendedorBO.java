/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Interfaces;

import Entidades.Vendedor;
import java.util.List;

/**
 *
 * @author melis
 */
public interface IVendedorBO {
    void registrarVendedor(Vendedor vendedor);

    Vendedor obtenerVendedorPorId(String id);

    List<Vendedor> obtenerVendedores();

    double calcularPromedioVentas(String idVendedor);

    void actualizarVendedor(Vendedor vendedor);

    void eliminarVendedor(int id);
}
