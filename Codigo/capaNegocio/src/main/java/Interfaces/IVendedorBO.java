package Interfaces;

import Entidades.Vendedor;
import Excepciones.NegocioException;
import java.util.List;

/**
 *
 * @author melis
 */
public interface IVendedorBO {

    Vendedor registrarVendedor(Vendedor vendedor) throws NegocioException;

    List<Vendedor> obtenerVendedores() throws NegocioException;

    double calcularPromedioVentas(String idVendedor);

    Vendedor obtenerVendedorPorId(String id) throws NegocioException;

    Vendedor actualizarVendedor(Vendedor vendedor) throws NegocioException;

    Vendedor eliminarVendedor(String id) throws NegocioException;

}
