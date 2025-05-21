/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Interfaces;

import Entidades.Vendedor;
import Excepciones.NegocioException;
import java.util.List;
import org.bson.types.ObjectId;

/**
 *
 * @author gaspa
 */
public interface IVendedorBO {
    Vendedor registrarVendedor(Vendedor vendedor) throws NegocioException;
    List<Vendedor> obtenerTodosLosVendedores() throws NegocioException;
    Vendedor obtenerVendedorPorId(ObjectId id) throws NegocioException;
    Vendedor actualizarVendedor(Vendedor vendedor) throws NegocioException;
    Vendedor eliminarVendedor(ObjectId id) throws NegocioException;
}
