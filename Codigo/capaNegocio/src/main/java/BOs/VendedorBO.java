package BOs;

import DAOs.VendedorDAO;
import Entidades.Vendedor;
import Excepciones.NegocioException;
import Interfaces.IVendedorBO;
import Interfaz.IVendedorDAO;
import java.util.List;

/**
 *
 * @author melis
 * @version 1.2
 */
public class VendedorBO implements IVendedorBO {

    private final IVendedorDAO vendedorDAO;

    public VendedorBO() {
        this.vendedorDAO = new VendedorDAO();
    }

    @Override
    public Vendedor registrarVendedor(Vendedor vendedor) throws NegocioException {
        validarVendedor(vendedor);
        validarCURPNoDuplicado(vendedor.getCurp());
        vendedorDAO.insertarVendedor(vendedor);
        return vendedor;
    }

    public List<Vendedor> obtenerTodosLosVendedores() throws NegocioException {
        List<Vendedor> vendedores = vendedorDAO.obtenerTodos();
        if (vendedores.isEmpty()) {
            throw new NegocioException("No hay vendedores registrados.");
        }
        return vendedores;
    }

    @Override
    public Vendedor obtenerVendedorPorId(String id) throws NegocioException {
        Vendedor vendedor = vendedorDAO.buscarPorId(id);
        if (vendedor == null) {
            throw new NegocioException("No se encontró el vendedor con el ID proporcionado.");
        }
        return vendedor;
    }

    @Override
    public Vendedor actualizarVendedor(Vendedor vendedor) throws NegocioException {
        validarVendedor(vendedor);
        validarIdPresente(vendedor);

        if (!vendedorDAO.actualizarVendedor(vendedor)) {
            throw new NegocioException("No se pudo actualizar el vendedor. Puede que no exista.");
        }
        return vendedor;
    }

    @Override
    public Vendedor eliminarVendedor(String id) throws NegocioException {
        Vendedor eliminado = vendedorDAO.eliminarVendedor(id);
        if (eliminado == null) {
            throw new NegocioException("No se pudo eliminar el vendedor. Puede que no exista.");
        }
        return eliminado;
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
        if (vendedorDAO.buscarPorCURP(curp) != null) {
            throw new NegocioException("Ya existe un vendedor con el CURP proporcionado.");
        }
    }

    private void validarIdPresente(Vendedor vendedor) throws NegocioException {
        if (vendedor.getIdVendedor() == null || vendedor.getIdVendedor().trim().isEmpty()) {
            throw new NegocioException("El ID del vendedor es obligatorio para la actualización.");
        }
    }

    @Override
    public List<Vendedor> obtenerVendedores() throws NegocioException {
        throw new UnsupportedOperationException("No está implementado aún.");
    }

    @Override
    public double calcularPromedioVentas(String idVendedor) {
        throw new UnsupportedOperationException("No está implementado aún.");
    }
}
