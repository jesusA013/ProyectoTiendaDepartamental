package Interfaces;

import DTOs.UsuarioDTO;
import Excepciones.NegocioException;

/**
 * IUsuarioBO.java
 *
 * Esta interfaz declara los metodos que debe implementar la clase de UsuarioBO.
 *
 * @author Ángel Ruíz García - 00000248171
 */
public interface IUsuarioBO {

    UsuarioDTO obtenerUsuario(String idCuenta) throws NegocioException;
}
