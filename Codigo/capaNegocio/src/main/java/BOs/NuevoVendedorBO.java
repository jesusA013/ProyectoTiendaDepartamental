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
import Entidades.Vendedor;



public class NuevoVendedorBO {
//    private final VendedorDAO vendedorDAO;
//
//    public NuevoVendedorBO() {
//        this.vendedorDAO = new VendedorDAO();
//    }
//
//    //  Registrar un nuevo vendedor con conversión interna
//    public NuevoVendedorDTO registrarVendedor(NuevoVendedorDTO dto) throws NegocioException {
//        validarDTO(dto);
//
//        // Verificar si el CURP ya existe en la BD
//        if (vendedorDAO.buscarPorCURP(dto.getCurp()).isPresent()) {
//            throw new NegocioException("El CURP ya está registrado. No se puede duplicar el vendedor.");
//        }
//
//        // Convertir DTO a Entidad directamente
//        Vendedor vendedor = new Vendedor(
//                new ObjectId(),
//                dto.getCurp(),
//                dto.getDatosFiscales(),
//                dto.getNombre(),
//                dto.getFechaNacimiento(),
//                dto.getEstadoCivil(),
//                dto.getDomicilio(),
//                null, // Seguro aún no está en `NuevoVendedorDTO`
//                new Date(), // Fecha de registro automática
//                dto.isActivo(),
//                dto.getCiudad(),
//                dto.getMunicipio(),
//                dto.getFoto(),
//                dto.getRfc(),
//                0.0, // Ventas inicializadas en 0
//                5 // Rating inicial por defecto
//        );
//
//        vendedorDAO.insertarVendedor(vendedor);
//
//        // Convertir la Entidad a DTO para retorno
//        return convertirEntidadADTO(vendedor);
//    }
//
//    // btener un vendedor por ID
//    public NuevoVendedorDTO obtenerVendedorPorId(ObjectId id) throws NegocioException {
//        Vendedor vendedor = vendedorDAO.buscarPorId(id);
//        if (vendedor.isEmpty()) {
//            throw new NegocioException("No se encontró el vendedor con ID: " + id);
//        }
//        return convertirEntidadADTO(vendedor.get());
//    }
//
//    //  Conversión de Entidad a DTO
//    private NuevoVendedorDTO convertirEntidadADTO(Vendedor vendedor) {
//        return new NuevoVendedorDTO(
//                vendedor.getNombreCompleto(),
//                vendedor.getRfc(),
//                vendedor.getDomicilio(),
//                vendedor.getCurp(),
//                vendedor.getFechaNacimiento(),
//                vendedor.getEstadoCivil(),
//                vendedor.getCiudad(),
//                vendedor.getMunicipio(),
//                vendedor.getFoto(),
//                vendedor.getTelefono(),
//                vendedor.getEmail(),
//                vendedor.getDatosFiscales(),
//                vendedor.getFechaRegistro(),
//                vendedor.isActivo()
//        );
//    }
//
//    // 🔹 Validaciones antes de la conversión
//    private void validarDTO(NuevoVendedorDTO dto) throws NegocioException {
//        if (dto == null) {
//            throw new NegocioException("El DTO no puede ser nulo.");
//        }
//        if (dto.getCurp() == null || dto.getCurp().trim().isEmpty()) {
//            throw new NegocioException("El CURP es obligatorio.");
//        }
//        if (dto.getNombre() == null || dto.getNombre().trim().isEmpty()) {
//            throw new NegocioException("El nombre no puede estar vacío.");
//        }
//        if (dto.getFechaNacimiento() == null) {
//            throw new NegocioException("La fecha de nacimiento es obligatoria.");
//        }
//        if (dto.getTelefono() == null || dto.getTelefono().trim().isEmpty()) {
//            throw new NegocioException("El teléfono es obligatorio.");
//        }
//        if (dto.getEmail() == null || dto.getEmail().trim().isEmpty()) {
//            throw new NegocioException("El email es obligatorio.");
//        }
//        if (dto.getDatosFiscales() == null || dto.getDatosFiscales().trim().isEmpty()) {
//            throw new NegocioException("Los datos fiscales son obligatorios.");
//        }
//    }
//
}
