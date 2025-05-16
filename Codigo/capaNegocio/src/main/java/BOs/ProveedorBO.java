package BOs;

import DAOs.Conexion;
import DAOs.ProveedorDAO;
import DTOs.ProveedorDTO;
import DTOs.ProveedorInformacionBasicaDTO;
import DTOs.ProveedorInformacionComercialDTO;
import DTOs.ProveedorInformacionContactoDTO;
import DTOs.ProveedorInformacionGestionDTO;
import DTOs.ProveedorTablaDTO;
import Entidades.Proveedor;
import Entidades.ProveedorInformacionBasica;
import Entidades.ProveedorInformacionComercial;
import Entidades.ProveedorInformacionContacto;
import Entidades.ProveedorInformacionGestion;
import Excepciones.NegocioException;
import Exception.PersistenciaException;
import Interfaces.IProveedorBO;
import Interfaz.IConexion;
import Interfaz.IProveedorDAO;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.bson.types.ObjectId;

/**
 * ProveedorBO.java
 *
 * Esta clase objectos negocio actua como intermediario con la DAO de
 * Proveedores.
 *
 * @author Ángel Ruíz García - 00000248171
 */
public class ProveedorBO implements IProveedorBO {

    private final IProveedorDAO proveedorDAO;
    IConexion Mongo = new Conexion();

    /**
     * Inicializa el atributo para usar la DAO.
     */
    public ProveedorBO() {
        this.proveedorDAO = new ProveedorDAO(Mongo.conexion());
    }

    @Override
    public ProveedorDTO guardarProveedor(ProveedorDTO proveedorDTO) throws NegocioException {
        try {
            Proveedor proveedor = convertirEntidad(proveedorDTO);
            ProveedorDTO proveedorGuardado = convertirDTO(proveedorDAO.guardarProveedor(proveedor));
            
            return proveedorGuardado;
        } catch (PersistenciaException ex) {
            throw new NegocioException("Error " + ex.getMessage());
        }
    }

    @Override
    public ProveedorDTO editarProveedor(ProveedorDTO proveedorDTO) throws NegocioException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    public ProveedorDTO obtenerProveedorPorId(ObjectId idProveedor) throws NegocioException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public List<ProveedorTablaDTO> obtenerListaProveedores() throws NegocioException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    /**
     * Convierte la entidad a DTO.
     *
     * @param proveedor Entidad a convertir
     * @return Regresa la DTO creada
     */
    private ProveedorDTO convertirDTO(Proveedor proveedor) {
        ProveedorInformacionBasicaDTO basicaDTO = new ProveedorInformacionBasicaDTO(
                proveedor.getBasica().getIdBasica(),
                proveedor.getBasica().getNombreProveedor());

        ProveedorInformacionContactoDTO contactoDTO = new ProveedorInformacionContactoDTO(
                proveedor.getContacto().getIdContacto(),
                proveedor.getContacto().getContacto(),
                proveedor.getContacto().getTelefono(),
                proveedor.getContacto().getCorreo(),
                proveedor.getContacto().getDireccion(),
                proveedor.getContacto().getPaginaWeb());

        ProveedorInformacionComercialDTO comercialDTO = new ProveedorInformacionComercialDTO(
                proveedor.getComercial().getIdComercial(),
                proveedor.getComercial().getRfc(),
                proveedor.getComercial().getFormaPago(),
                proveedor.getComercial().getTerminoPago(),
                proveedor.getComercial().getMoneda());

        ProveedorInformacionGestionDTO gestionDTO = new ProveedorInformacionGestionDTO(
                proveedor.getGestion().getIdGestion(),
                proveedor.getGestion().getFechaAlta(),
                proveedor.getGestion().getEstado(),
                proveedor.getGestion().getComentarios());

        ProveedorDTO proveedorDTO = new ProveedorDTO(
                proveedor.getIdProveedor(),
                basicaDTO,
                contactoDTO,
                comercialDTO,
                gestionDTO);

        return proveedorDTO;
    }

    /**
     * Convierte la DTO a entidad.
     *
     * @param proveedorDTO DTO a convertir
     * @return Regresa la entidad creada
     */
    private Proveedor convertirEntidad(ProveedorDTO proveedorDTO) {
        ProveedorInformacionBasica basica = new ProveedorInformacionBasica(
                proveedorDTO.getBasica().getIdBasica(),
                proveedorDTO.getBasica().getNombreProveedor());

        ProveedorInformacionContacto contacto = new ProveedorInformacionContacto(
                proveedorDTO.getContacto().getIdContacto(),
                proveedorDTO.getContacto().getContacto(),
                proveedorDTO.getContacto().getTelefono(),
                proveedorDTO.getContacto().getCorreo(),
                proveedorDTO.getContacto().getDireccion(),
                proveedorDTO.getContacto().getPaginaWeb());

        ProveedorInformacionComercial comercial = new ProveedorInformacionComercial(
                proveedorDTO.getComercial().getIdComercial(),
                proveedorDTO.getComercial().getRfc(),
                proveedorDTO.getComercial().getFormaPago(),
                proveedorDTO.getComercial().getTerminoPago(),
                proveedorDTO.getComercial().getMoneda());

        ProveedorInformacionGestion gestion = new ProveedorInformacionGestion(
                proveedorDTO.getGestion().getIdGestion(),
                proveedorDTO.getGestion().getFechaAlta(),
                proveedorDTO.getGestion().getEstado(),
                proveedorDTO.getGestion().getComentarios());

        Proveedor proveedor = new Proveedor(
                proveedorDTO.getIdProveedor(),
                basica,
                contacto,
                comercial,
                gestion);

        return proveedor;
    }

}
