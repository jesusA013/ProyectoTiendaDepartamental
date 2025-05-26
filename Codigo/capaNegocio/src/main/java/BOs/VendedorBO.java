/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BOs;

import java.util.*;

import DAOs.Conexion;
import DAOs.VendedorDAO;
import Entidades.Vendedor;
import Excepciones.NegocioException;
import Interfaces.IVendedorBO;
import Interfaz.IVendedorDAO;
import java.util.List;

/**
 *
 * @author melis
 * @author Ilian Gastelum
 * @version 1.2
 */
public class VendedorBO {

    private final IVendedorDAO vendedorDAO;

    public VendedorBO(IVendedorDAO vendedorDAO) {
        this.vendedorDAO = vendedorDAO;
    }

    /*Registra un vendedor con validaciones*/
    public Vendedor registrarVendedor(Vendedor vendedor) throws NegocioException {
        validarVendedor(vendedor);
        validarCURPNoDuplicado(vendedor.getCurp());
        vendedorDAO.insertarVendedor(vendedor);
        return vendedor;

    }

    /*Este metodo obtiene a todos los vendedores**/
    public List<Vendedor> obtenerTodosLosVendedores() throws NegocioException {
        List<Vendedor> vendedores = vendedorDAO.obtenerTodos();
        if (vendedores.isEmpty()) {
            throw new NegocioException("No hay vendedores registrados.");
        }
        return vendedores;
    }

    /*Obtiene un vendedor por id*/
    public Optional<Vendedor> obtenerVendedorPorID(String idVendedor) throws NegocioException {
        Optional<Vendedor> vendedor = vendedorDAO.buscarPorId(idVendedor);
        if (vendedor.isEmpty()) {
            throw new NegocioException("No se encuentro el vendedor");
        }
        return vendedor;
    }

    /*Actualiza lod datos de un vendedor*/
    public Vendedor actualizarVendedor(Vendedor vendedor) throws NegocioException {
        validarVendedor(vendedor);
        validarIdPresente(vendedor);

        if (!vendedorDAO.actualizarVendedor(vendedor)) {
            throw new NegocioException("No se pudo actualizar el vendedor. Puede que no exista.");
        }
        return vendedor;

    }

    public Vendedor eliminarVendedor(String id) throws NegocioException {
        Optional<Vendedor> eliminado = vendedorDAO.eliminarVendedor(id);
        if (eliminado.isEmpty()) {
            throw new NegocioException("No se pudo eliminar el vendedor. Puede que no exista.");
        }
        return eliminado.get();
    }

    private void validarVendedor(Vendedor vendedor) throws NegocioException {
        if (vendedor == null) {
            throw new NegocioException("El vendedor no puede ser nulo.");
        }
        if (vendedor.getCurp() == null || vendedor.getCurp().trim().isEmpty()) {
            throw new NegocioException("El CURP del vendedor es obligatorio.");
        }
        if (vendedor.getNombreCompleto() == null || vendedor.getNombreCompleto().trim().isEmpty()) {
            throw new NegocioException("El nombre del vendedor es obligatorio.");
        }
    }

    private void validarCURPNoDuplicado(String curp) throws NegocioException {
        if (vendedorDAO.buscarPorCURP(curp).isPresent()) {
            throw new NegocioException("Ya existe un vendedor con el CURP proporcionado.");
        }
    }

    private void validarIdPresente(Vendedor vendedor) throws NegocioException {
        if (vendedor.getIdVendedor()== null || vendedor.getIdVendedor().trim().isEmpty()) {
            throw new NegocioException("El ID del vendedor es obligatorio para la actualización.");
        }
    }
}
