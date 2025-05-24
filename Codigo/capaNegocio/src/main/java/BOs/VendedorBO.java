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
public abstract class VendedorBO implements IVendedorBO {
    private int id;
    private String nombre;
    private double totalVentas;
    private List<VentasBO> ventas; // lista inicializada
    
     private  IVendedorDAO vendedorDAO;// se necesita inicializar
    private final IConexion mongo = new Conexion();

    public VendedorBO(int id, String nombre, double totalVentas, List<VentasBO> ventas, IVendedorDAO vendedorDAO) {
        this.id = id;
        this.nombre = nombre;
        this.totalVentas = totalVentas;
        this.ventas = new ArrayList<>();// inicializacion de la lista
        this.vendedorDAO = vendedorDAO;
    }

   

    public VendedorBO(List<VentasBO> ventas) {
        this.ventas = new ArrayList<>();// evita un nullPointer en caso de usar constructor vacio 
    }

//    public VendedorBO() {
//    }
    //gestion v

    public void agregarVneta(VentasBO venta) {
        ventas.add(venta);
        totalVentas += venta.getMonto();
    }

    public double calcularPromedioVentas() {
        return ventas.isEmpty() ? 0 : totalVentas / ventas.size();
    }

    /////
   

//    private final IVendedorDAO vendedorDAO;
//    private final IConexion mongo = new Conexion();
    public VendedorBO(){
        this.vendedorDAO = new VendedorDAO();
    }

    
    public Vendedor registrarVendedor(Vendedor vendedor) throws NegocioException {
        validarVendedorNoNulo(vendedor);
        validarCURP(vendedor.getCurp());
        validarCURPUnico(vendedor.getCurp());

        return vendedorDAO.insertarVendedor(vendedor);
    }

    public List<Vendedor> obtenerTodosLosVendedores() throws NegocioException {
        List<Vendedor> lista = vendedorDAO.obtenerTodos();
        if (lista.isEmpty()) {
            throw new NegocioException("No hay vendedores registrados.");
        }
        return lista;
    }

    public Vendedor obtenerVendedorPorId(ObjectId id) throws NegocioException {
        Vendedor vendedor = vendedorDAO.buscarPorId(id);
        if (vendedor == null) {
            throw new NegocioException("No se encontró el vendedor con el ID proporcionado.");
        }
        return vendedor;
    }

    
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
