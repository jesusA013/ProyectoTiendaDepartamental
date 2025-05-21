/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Interfaces;

import DTOs.VendedorDTO;
import Entidades.Vendedor;
import Excepciones.NegocioException;
import java.util.List;
import org.bson.types.ObjectId;

/**
 *
 * @author gaspa
 */
public interface IVendedorBO {
    VendedorDTO registrarVendedor(VendedorDTO vendedor) throws NegocioException;
    List<VendedorDTO> obtenerTodosLosVendedores() throws NegocioException;
    VendedorDTO obtenerVendedorPorId(ObjectId id) throws NegocioException;
    VendedorDTO actualizarVendedor(VendedorDTO vendedor) throws NegocioException;
    VendedorDTO eliminarVendedor(ObjectId id) throws NegocioException;
}
