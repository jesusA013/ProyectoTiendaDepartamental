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
import java.util.ArrayList;
import java.util.List;
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

    /**
     * Se encarga de llamar a la DAO para guardar el proveedor.
     *
     * @param proveedorDTO Proveedor a guardar
     * @return Regresa el proveedor guardado
     * @throws NegocioException Si ocurre algun error en el proceso
     */
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

    /**
     * Se encarga de llamar a la DAO para modificar el proveedor.
     *
     * @param proveedorDTO Proveedor a modificar
     * @return Regresa el proveedor modificado
     * @throws NegocioException Si ocurre algun error en el proceso
     */
    @Override
    public ProveedorDTO editarProveedor(ProveedorDTO proveedorDTO) throws NegocioException {
        try {
            Proveedor proveedor = convertirEntidad(proveedorDTO);
            ProveedorDTO proveedorEditado = convertirDTO(proveedorDAO.editarProveedor(proveedor));

            return proveedorEditado;
        } catch (PersistenciaException ex) {
            throw new NegocioException("Error " + ex.getMessage());
        }
    }

    /**
     * Se encarga de llamar a la DAO para buscar un proveedor por su ID.
     *
     * @param idProveedor ID del proveedor a buscar
     * @return Regresa el proveedor encontrado
     * @throws NegocioException Excepcion si ocurre un error en el proceso
     */
    @Override
    public ProveedorDTO obtenerProveedorPorId(ObjectId idProveedor) throws NegocioException {
        try {
            ProveedorDTO proveedorEncontrado = convertirDTO(proveedorDAO.obtenerProveedorPorId(idProveedor));

            return proveedorEncontrado;
        } catch (PersistenciaException ex) {
            throw new NegocioException("Error " + ex.getMessage());
        }
    }

    /**
     * Se encarga de llamar a la DAO para buscar a todos los proveedores.
     *
     * @return Regresa la lista de todos los proveedores
     * @throws NegocioException Excepcion si ocurre un error en el proceso
     */
    @Override
    public List<ProveedorTablaDTO> obtenerListaProveedores() throws NegocioException {
        try {
            List<Proveedor> listaProveedores = this.proveedorDAO.listaProveedores();

            List<ProveedorDTO> dtos = new ArrayList<>();
            for (Proveedor proveedor : listaProveedores) {
                dtos.add(this.obtenerProveedorPorId(proveedor.getIdProveedor()));
            }

            return this.convertirTablaDTO(dtos);
        } catch (PersistenciaException ex) {
            throw new NegocioException("Error " + ex.getMessage());
        }
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
                proveedorDTO.getBasica().getNombreProveedor());

        ProveedorInformacionContacto contacto = new ProveedorInformacionContacto(
                proveedorDTO.getContacto().getContacto(),
                proveedorDTO.getContacto().getTelefono(),
                proveedorDTO.getContacto().getCorreo(),
                proveedorDTO.getContacto().getDireccion(),
                proveedorDTO.getContacto().getPaginaWeb());

        ProveedorInformacionComercial comercial = new ProveedorInformacionComercial(
                proveedorDTO.getComercial().getRfc(),
                proveedorDTO.getComercial().getFormaPago(),
                proveedorDTO.getComercial().getTerminoPago(),
                proveedorDTO.getComercial().getMoneda());

        ProveedorInformacionGestion gestion = new ProveedorInformacionGestion(
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

    /**
     * Convierte la lista ProveedorDTO a ProveedorTablaDTO.
     *
     * @param proveedores Lista a convertir
     * @return Regresa la lista creada
     */
    private List<ProveedorTablaDTO> convertirTablaDTO(List<ProveedorDTO> proveedores) {
        if (proveedores == null) {
            return null;
        }

        List<ProveedorTablaDTO> proveedoresDTO = new ArrayList<>();
        for (ProveedorDTO proveedor : proveedores) {
            String nombreProveedor = proveedor.getBasica().getNombreProveedor();
            String telefono = proveedor.getContacto().getTelefono();
            String correo = proveedor.getContacto().getCorreo();
            String estado = proveedor.getGestion().getEstado();
            ProveedorTablaDTO dato = new ProveedorTablaDTO(proveedor.getIdProveedor(), nombreProveedor, telefono, correo, estado);
            proveedoresDTO.add(dato);
        }
        return proveedoresDTO;
    }
}
