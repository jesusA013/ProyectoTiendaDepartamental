/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

import Excepciones.NegocioException;
import org.bson.types.ObjectId;

import java.util.Date;
import java.util.Optional;

import DAOs.*;
import DTOs.NuevoVendedorDTO;
import DTOs.VendedorDTO;
import Entidades.Vendedor;
import Interfaz.IVendedorDAO;
import java.util.UUID;

public class NuevoVendedorBO {

    private final VendedorDAO vendedorDAO;

    public NuevoVendedorBO(IVendedorDAO vendedorDAO) {
        this.vendedorDAO = new VendedorDAO();
    }

    //   Registrar un nuevo vendedor con conversión interna
    public Vendedor registrarVendedor(NuevoVendedorDTO dto) throws NegocioException {
        validarNuevoVendedor(dto);
        String idGenerado = UUID.randomUUID().toString();

        Vendedor vendedor = new Vendedor(
                idGenerado,
                dto.getNombre(),
                dto.getApellido(),
                dto.getRfc(),
                dto.getCurp(),
                dto.getDomicilio(),
                dto.getFechaNacimientoDia(),
                dto.getFechaNacimientoMes(),
                dto.getFechaNacimientoAño(),
                dto.getCiudad(),
                dto.getMunicipio(),
                dto.getFoto(),
                dto.isActivo()
        );
vendedorDAO.insertarVendedor(vendedor);
        return vendedor;

        

    }

private Vendedor convertirNuevoVendedorAVendedor(NuevoVendedor nuevoVendedor, String idGenerado) {
        return new Vendedor(
                idGenerado,
                nuevoVendedor.getNombre(),
                nuevoVendedor.getApellidos(),
                nuevoVendedor.getRfc(),
                nuevoVendedor.getCurp(),
                nuevoVendedor.getDomicilio(),
                nuevoVendedor.getFechaNacimientoDia(),
                nuevoVendedor.getFechaNacimientoMes(),
                nuevoVendedor.getFechaNacimientoAño(),
                nuevoVendedor.getCiudad(),
                nuevoVendedor.getMunicipio(),
                nuevoVendedor.getRutaFoto(),
                true // 🔹 Se registra como activo por defecto
        );
    }


    //  Validaciones antes de la conversión
    private void validarNuevoVendedor(NuevoVendedorDTO dto) throws NegocioException {
        if (dto == null) {
            throw new NegocioException("Los datos del vendedor no pueden ser nulos.");
        }
        if (vendedorDAO.buscarPorCURP(dto.getCurp()).isPresent()) {
            throw new NegocioException("Ya existe un vendedor con el CURP proporcionado.");
        }
    }

}
