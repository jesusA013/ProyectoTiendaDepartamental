/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BOs;

import DAOs.Conexion;
import DAOs.VendedorDAO;
import Entidades.Vendedor;
import Excepciones.NegocioException;
import Interfaces.IVendedorBO;
import Interfaz.IConexion;
import Interfaz.IVendedorDAO;
import java.util.List;
import org.bson.types.ObjectId;

/**
 *
 * @author melis
 * @author Ilian Gastelum
 * @version 1.2
 */
public class VendedorBO implements IVendedorBO{
    private final IVendedorDAO vendedorDAO;
    private final IConexion mongo = new Conexion();
    public VendedorBO(){
        this.vendedorDAO=new VendedorDAO(mongo.conexion());
    }
    @Override
    public Vendedor registrarVendedor(Vendedor vendedor) throws NegocioException {
        validarVendedorNoNulo(vendedor);
        validarCURP(vendedor.getCurp());
        validarCURPUnico(vendedor.getCurp());

        return vendedorDAO.insertarVendedor(vendedor);
    }

    @Override
    public List<Vendedor> obtenerTodosLosVendedores() throws NegocioException {
        List<Vendedor> lista = vendedorDAO.obtenerTodos();
        if (lista.isEmpty()) {
            throw new NegocioException("No hay vendedores registrados.");
        }
        return lista;
    }

    @Override
    public Vendedor obtenerVendedorPorId(ObjectId id) throws NegocioException {
        Vendedor vendedor = vendedorDAO.buscarPorId(id);
        if (vendedor == null) {
            throw new NegocioException("No se encontró el vendedor con el ID proporcionado.");
        }
        return vendedor;
    }

    @Override
    public Vendedor actualizarVendedor(Vendedor vendedor) throws NegocioException {
        validarVendedorNoNulo(vendedor);
        validarIdPresente(vendedor);

        return vendedorDAO.actualizarVendedor(vendedor);
    }

    @Override
    public Vendedor eliminarVendedor(ObjectId id) throws NegocioException {
        Vendedor eliminado = vendedorDAO.eliminarVendedor(id);
        if (eliminado == null) {
            throw new NegocioException("No se pudo eliminar el vendedor. Puede que no exista.");
        }
        return eliminado;
    }

   
    private void validarVendedorNoNulo(Vendedor vendedor) throws NegocioException {
        if (vendedor == null) {
            throw new NegocioException("El vendedor no puede ser nulo.");
        }
    }

    private void validarCURP(String curp) throws NegocioException {
        if (curp == null || curp.trim().isEmpty()) {
            throw new NegocioException("El CURP del vendedor es obligatorio.");
        }
    }

    private void validarCURPUnico(String curp) throws NegocioException {
        Vendedor existente = vendedorDAO.buscarPorCURP(curp);
        if (existente != null) {
            throw new NegocioException("Ya existe un vendedor con el CURP proporcionado.");
        }
    }

    private void validarIdPresente(Vendedor vendedor) throws NegocioException {
        if (vendedor.getId() == null) {
            throw new NegocioException("El ID del vendedor es obligatorio para la actualización.");
        }
    }
}
