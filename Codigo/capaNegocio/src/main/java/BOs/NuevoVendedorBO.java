package BOs;

import Excepciones.NegocioException;

import DAOs.*;
import DTOs.NuevoVendedorDTO;
import Entidades.Domicilio;
import Entidades.Vendedor;
import java.util.Date;
import java.util.UUID;

public class NuevoVendedorBO {

    private final VendedorDAO vendedorDAO;

    public NuevoVendedorBO() {
        this.vendedorDAO = new VendedorDAO();
    }

    public Vendedor registrarVendedor(NuevoVendedorDTO dto) throws NegocioException {
        validarNuevoVendedor(dto);
        String idGenerado = UUID.randomUUID().toString();

        Vendedor vendedor = new Vendedor(
                idGenerado,
                dto.getNombre(),
                dto.getApellido(),
                dto.getCurp(),
                dto.getNombre() + " " + dto.getApellido(),
                dto.getFechaNacimientoDia(),
                dto.getFechaNacimientoMes(),
                dto.getFechaNacimientoAño(),
                new Domicilio(),
                new Date(),
                true,
                dto.getCiudad(),
                dto.getMunicipio(),
                dto.getFoto(),
                dto.getRfc(),
                0,
                0
        );
        vendedorDAO.insertarVendedor(vendedor);
        return vendedor;
    }

    private void validarNuevoVendedor(NuevoVendedorDTO dto) throws NegocioException {
        if (dto == null) {
            throw new NegocioException("Los datos del vendedor no pueden ser nulos.");
        }
        if (dto.getCurp() == null || dto.getCurp().trim().isEmpty()) {
            throw new NegocioException("El CURP es obligatorio.");
        }
        if (dto.getNombre() == null || dto.getNombre().trim().isEmpty()) {
            throw new NegocioException("El nombre es obligatorio.");
        }
        if (vendedorDAO.buscarPorCURP(dto.getCurp()) != null) {
            throw new NegocioException("Ya existe un vendedor con el CURP proporcionado.");
        }
    }
}
