/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Interfaces;

import Entidades.Vendedor;
import Excepciones.NegocioException;
import java.util.List;
import org.bson.types.ObjectId;
import java.util.List;

/**
 *
 * @author melis
 */
public interface IVendedorBO {

    void registrarVendedor(Vendedor vendedor) throws NegocioException;
    // Vendedor obtenerVendedorPorId(String id)throws NegocioException;

    List<Vendedor> obtenerVendedores() throws NegocioException;

    double calcularPromedioVentas(String idVendedor);

    void actualizarVendedor(Vendedor vendedor) throws NegocioException;
//    void eliminarVendedor(int id);

    Vendedor obtenerVendedorPorId(ObjectId id) throws NegocioException;

    Vendedor eliminarVendedor(ObjectId id) throws NegocioException;

}
