/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BOs;

import DAOs.Conexion;
import DAOs.VendedorDAO;
import DTOs.DatosFiscalesDTO;
import DTOs.DomicilioDTO;
import DTOs.NombreCompletoDTO;
import DTOs.SeguroDTO;
import DTOs.VendedorDTO;
import Entidades.DatosFiscales;
import Entidades.Domicilio;
import Entidades.NombreCompleto;
import Entidades.Seguro;
import Entidades.Vendedor;
import Excepciones.NegocioException;
import Interfaces.IVendedorBO;
import Interfaz.IConexion;
import Interfaz.IVendedorDAO;
import java.util.List;
import java.util.stream.Collectors;
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
    public VendedorDTO registrarVendedor(VendedorDTO dto) throws NegocioException {
        validarVendedorNoNulo(dto);
        validarCURP(dto.getCurp());
        validarCURPUnico(dto.getCurp());

        Vendedor entidad = aEntidad(dto);
        Vendedor resultado = vendedorDAO.insertarVendedor(entidad);
        return aDTO(resultado);
    }

    @Override
    public List<VendedorDTO> obtenerTodosLosVendedores() throws NegocioException {
        List<Vendedor> lista = vendedorDAO.obtenerTodos();
        if (lista.isEmpty()) {
            throw new NegocioException("No hay vendedores registrados.");
        }
        return lista.stream().map(this::aDTO).collect(Collectors.toList());
    }

    @Override
    public VendedorDTO obtenerVendedorPorId(ObjectId id) throws NegocioException {
        Vendedor vendedor = vendedorDAO.buscarPorId(id);
        if (vendedor == null) {
            throw new NegocioException("No se encontró el vendedor con el ID proporcionado.");
        }
        return aDTO(vendedor);
    }

    @Override
    public VendedorDTO actualizarVendedor(VendedorDTO dto) throws NegocioException {
        validarVendedorNoNulo(dto);
        if (dto.getId()== null) {
            throw new NegocioException("El ID del vendedor es obligatorio para la actualización.");
        }

        Vendedor actualizado = vendedorDAO.actualizarVendedor(aEntidad(dto));
        return aDTO(actualizado);
    }

    @Override
    public VendedorDTO eliminarVendedor(ObjectId id) throws NegocioException {
        Vendedor eliminado = vendedorDAO.eliminarVendedor(id);
        if (eliminado == null) {
            throw new NegocioException("No se pudo eliminar el vendedor. Puede que no exista.");
        }
        return aDTO(eliminado);
    }

    // ==== Validaciones ====
    private void validarVendedorNoNulo(VendedorDTO vendedor) throws NegocioException {
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

    private Vendedor aEntidad(VendedorDTO dto) {
        return new Vendedor(
                dto.getId(),
            dto.getCurp(),
            aEntidad(dto.getDatosFiscales()),
            aEntidad(dto.getNombreCompleto()),
            dto.getFechaNacimiento(),
            dto.getEstadoCivil(),
            aEntidad(dto.getDomicilio()),
            aEntidad(dto.getSeguro()),
            dto.getFechaRegistro(),
                dto.isActivo()
        );
    }
    private VendedorDTO aDTO(Vendedor v) {
        return new VendedorDTO(
                v.getId(),
            v.getCurp(),
            aDTO(v.getNombreCompleto()),
            v.getFechaNacimiento(),
                v.getEstadoCivil(),
                aDTO(v.getDomicilio()),
            aDTO(v.getDatosFiscales()),
            aDTO(v.getSeguro()),
            v.getFechaRegistro(),
                v.isActivo()
        );
    }
    private NombreCompleto aEntidad(NombreCompletoDTO nombre){
        return new NombreCompleto(
                nombre.getNombres(), 
                nombre.getApellidoPaterno(),
                nombre.getApellidoMaterno()
        );
    }
    private NombreCompletoDTO aDTO(NombreCompleto nombre){
        return new NombreCompletoDTO(
                nombre.getNombres(), 
                nombre.getApellidoPaterno(),
                nombre.getApellidoMaterno()
        );
    }
    private DatosFiscales aEntidad(DatosFiscalesDTO dto) {
        return new DatosFiscales(
            dto.getCorreo(),
            dto.getRfc(),
            aEntidad(dto.getDomicilioFiscal())
            
        );
    }

    private DatosFiscalesDTO aDTO(DatosFiscales entidad) {
        return new DatosFiscalesDTO(
            entidad.getRfc(),
            aDTO(entidad.getDomicilioFiscal()),
            entidad.getCorreo()
        );
    }

    private Domicilio aEntidad(DomicilioDTO dto) {
        return new Domicilio(
                dto.getCalle(),
                dto.getDelegacionMunicipio(),
                dto.getCiudadLocalidad(),
                dto.getCodigoPostal()
        );
    }

    private DomicilioDTO aDTO(Domicilio entidad) {
        return new DomicilioDTO(
            entidad.getCalle(),
            entidad.getDelegacionMunicipio(),
            entidad.getCiudadLocalidad(),
            entidad.getCodigoPostal()
        );
    }

    private Seguro aEntidad(SeguroDTO dto) {
        return new Seguro(
            dto.getNumeroSeguro(),
            dto.getTipo()
        );
    }

    private SeguroDTO aDTO(Seguro entidad) {
        return new SeguroDTO(
            entidad.getNumeroSeguro(),
            entidad.getTipo()
        );
    }
}
