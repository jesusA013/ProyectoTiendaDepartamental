package BOs;

import DAOs.Conexion;
import DAOs.MovimientoDAO;
import DTOs.MovimientoDTO;
import DTOs.MovimientoTablaDTO;
import Entidades.Movimiento;
import Excepciones.NegocioException;
import Exception.PersistenciaException;
import Interfaces.IMovimientoBO;
import Interfaz.IConexion;
import Interfaz.IMovimientoDAO;
import java.util.ArrayList;
import java.util.List;
import org.bson.types.ObjectId;

/**
 * MovimientoBO.java
 *
 * Esta clase objectos negocio actua como intermediario con la DAO de
 * Movimientos.
 *
 * @author Ángel Ruíz García - 00000248171
 */
public class MovimientoBO implements IMovimientoBO {

    private final IMovimientoDAO movimientoDAO;
    IConexion Mongo = new Conexion();

    /**
     * Inicializa el atributo para usar la DAO.
     */
    public MovimientoBO() {
        this.movimientoDAO = new MovimientoDAO(Mongo.conexion());
    }

    @Override
    public MovimientoDTO registrarMovimiento(MovimientoDTO movimientoDTO) throws NegocioException {
        try {
            Movimiento movimiento = convertirEntidad(movimientoDTO);
            MovimientoDTO movimientoGuardado = convertirDTO(movimientoDAO.registrarMovimiento(movimiento));

            return movimientoGuardado;
        } catch (PersistenciaException ex) {
            throw new NegocioException("Error " + ex.getMessage());
        }
    }

    @Override
    public MovimientoDTO actualizarMovimiento(MovimientoDTO movimientoDTO) throws NegocioException {
        try {
            Movimiento movimiento = convertirEntidad(movimientoDTO);
            MovimientoDTO movimientoEditado = convertirDTO(movimientoDAO.actualizarMovimiento(movimiento));

            return movimientoEditado;
        } catch (PersistenciaException ex) {
            throw new NegocioException("Error " + ex.getMessage());
        }
    }

    @Override
    public MovimientoDTO obtenerMovimientoPorId(ObjectId idMovimiento) throws NegocioException {
        try {
            MovimientoDTO movimientoEncontrado = convertirDTO(movimientoDAO.obtenerMovimientoPorId(idMovimiento));

            return movimientoEncontrado;
        } catch (PersistenciaException ex) {
            throw new NegocioException("Error " + ex.getMessage());
        }
    }

    @Override
    public List<MovimientoTablaDTO> obtenerListaMovimientos() throws NegocioException {
        try {
            List<Movimiento> listaMovimientos = this.movimientoDAO.listaMovimientos();

            List<MovimientoDTO> dtos = new ArrayList<>();
            for (Movimiento movimiento : listaMovimientos) {
                dtos.add(this.obtenerMovimientoPorId(movimiento.getId()));
            }

            return this.convertirTablaDTO(dtos);
        } catch (PersistenciaException ex) {
            throw new NegocioException("Error " + ex.getMessage());
        }
    }

    /**
     * Convierte la entidad a DTO.
     *
     * @param movimiento Entidad a convertir
     * @return Regresa la DTO creada
     */
    private MovimientoDTO convertirDTO(Movimiento movimiento) {
        MovimientoDTO movimientoDTO = new MovimientoDTO();
        movimientoDTO.setId(movimiento.getId());
        movimientoDTO.setFecha(movimiento.getFecha());
        movimientoDTO.setIdCuenta(movimiento.getIdCuenta());
        movimientoDTO.setUsuarioResponsable(movimiento.getUsuarioResponsable());
        movimientoDTO.setCodigoProducto(movimiento.getCodigoProducto());
        movimientoDTO.setTipoOperacion(movimiento.getTipoOperacion());
        movimientoDTO.setCantidad(movimiento.getCantidad());
        movimientoDTO.setMotivo(movimiento.getMotivo());

        return movimientoDTO;
    }

    /**
     * Convierte la DTO a entidad.
     *
     * @param movimientoDTO DTO a convertir
     * @return Regresa la entidad creada
     */
    private Movimiento convertirEntidad(MovimientoDTO movimientoDTO) {
        Movimiento movimiento = new Movimiento();
        movimiento.setId(movimientoDTO.getId());
        movimiento.setFecha(movimientoDTO.getFecha());
        movimiento.setIdCuenta(movimientoDTO.getIdCuenta());
        movimiento.setUsuarioResponsable(movimientoDTO.getUsuarioResponsable());
        movimiento.setCodigoProducto(movimientoDTO.getCodigoProducto());
        movimiento.setTipoOperacion(movimientoDTO.getTipoOperacion());
        movimiento.setCantidad(movimientoDTO.getCantidad());
        movimiento.setMotivo(movimientoDTO.getMotivo());

        return movimiento;
    }

    /**
     * Convierte la lista MovimientoDTO a MovimientoTablaDTO.
     *
     * @param movimientos Lista a convertir
     * @return Regresa la lista creada
     */
    private List<MovimientoTablaDTO> convertirTablaDTO(List<MovimientoDTO> movimientos) {
        if (movimientos == null) {
            return null;
        }

        List<MovimientoTablaDTO> movimientosDTO = new ArrayList<>();
        for (MovimientoDTO movimiento : movimientos) {
            ObjectId _id = movimiento.getId();
            String codigoProducto = movimiento.getCodigoProducto();
            String tipoMovimiento = movimiento.getTipoOperacion();
            int cantidad = movimiento.getCantidad();
            MovimientoTablaDTO dato = new MovimientoTablaDTO(_id, codigoProducto, tipoMovimiento, cantidad);
            movimientosDTO.add(dato);
        }
        return movimientosDTO;
    }
}
