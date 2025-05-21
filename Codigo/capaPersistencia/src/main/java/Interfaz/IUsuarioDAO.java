/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Interfaz;

import Entidades.Usuario;
import Exception.PersistenciaException;

/**
 *
 * @author Knocmare
 */
public interface IUsuarioDAO {
    Usuario obtenerUsuario(String id) throws PersistenciaException;
}
