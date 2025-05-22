/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Interfaces;

import DTOs.UsuarioDTO;
import Excepciones.NegocioException;

/**
 *
 * @author gaspa
 */
public interface IUsuarioBO {
    UsuarioDTO verificarCredenciales(String idCuenta, String contrasena) throws NegocioException;
    UsuarioDTO registrarUsuario(UsuarioDTO dto) throws NegocioException;
}
