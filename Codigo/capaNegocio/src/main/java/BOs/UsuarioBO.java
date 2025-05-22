/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BOs;

import DAOs.Conexion;
import DAOs.UsuarioDAO;
import DTOs.UsuarioDTO;
import Entidades.Usuario;
import Excepciones.NegocioException;
import Exception.PersistenciaException;
import Interfaces.IUsuarioBO;
import Interfaz.IConexion;
import Interfaz.IUsuarioDAO;

/**
 *
 * @author gaspa
 */
public class UsuarioBO implements IUsuarioBO {

    private final IUsuarioDAO usuarioDAO;
    IConexion Mongo = new Conexion();

    public UsuarioBO() {
        this.usuarioDAO = new UsuarioDAO(Mongo.conexion());
    }

    @Override
    public UsuarioDTO verificarCredenciales(String idCuenta, String contrasena) throws NegocioException {
        try {
            Usuario usuario = usuarioDAO.obtenerUsuario(idCuenta);
            if (usuario == null || !usuario.getContrasena().equals(contrasena)) {
                throw new NegocioException("Credenciales inválidas");
            }
            return new UsuarioDTO(usuario.getIdCuenta(), usuario.getNombreUsuario(), usuario.getContrasena(), usuario.getTipo());
        } catch (PersistenciaException e) {
            throw new NegocioException("Error al acceder a los datos: " + e.getMessage());
        }
    }

    @Override
    public UsuarioDTO registrarUsuario(UsuarioDTO dto) throws NegocioException {

        try {
            Usuario entidad = aEntidad(dto);
            Usuario resultado = usuarioDAO.insertarUsuario(entidad);
            return aDTO(resultado);
        } catch (PersistenciaException ex) {
            throw new NegocioException("Error " + ex.getMessage());
        }
    }

    private Usuario aEntidad(UsuarioDTO dto) {
        return new Usuario(
                dto.getIdCuenta(),
                dto.getNombreUsuario(),
                dto.getContrasena(),
                dto.getRol()
        );
    }

    private UsuarioDTO aDTO(Usuario entidad) {
        return new UsuarioDTO(
                entidad.getIdCuenta(),
                entidad.getNombreUsuario(),
                entidad.getContrasena(),
                entidad.getTipo()
        );
    }

}
