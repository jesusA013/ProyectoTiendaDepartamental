package BOs;

import DAOs.MetodoEfectivoDAO;
import DTOs.MetodoEfectivoDTO;
import DTOs.MetodoPagoDTO;
import Entidades.MetodoEfectivo;
import Entidades.MetodoPago;
import Interfaces.IMetodoPago;
import Interfaz.IMetodoPagoDAO;
import java.util.ArrayList;
import java.util.List;

/**
 * MetodoEfectivoBO.java
 * 
 * Esta clase representa el metodo de pago con efectivo de objectos negocio.
 * 
 * @author Ángel Ruíz García - 00000248171
 */
public class MetodoEfectivoBO implements IMetodoPago {
    
    private final IMetodoPagoDAO metodoPagoDAO;

    /**
     * Contructor del metodo de pago con efectivo de objectos negocio.
     */
    public MetodoEfectivoBO() {
        this.metodoPagoDAO = new MetodoEfectivoDAO();
    }

    /**
     * Guarda un nuevo método de pago en la fuente de datos.
     *
     * @param metodoPagoDTO Método de pago a guardar.
     * @return Método de pago a guardar.
     */
    @Override
    public MetodoPagoDTO guardarMetodoPago(MetodoPagoDTO metodoPagoDTO) {
        MetodoEfectivoDTO efectivoNueva = (MetodoEfectivoDTO) metodoPagoDTO;
        MetodoPago entidad = this.convertirEntidad(efectivoNueva);
        MetodoPago metodoPago = metodoPagoDAO.guardarMetodoPago(entidad);
        return this.convertirDTO(metodoPago);
    }

    /**
     * Obtiene un método de pago por su identificador único.
     *
     * @param id Identificador del método de pago.
     * @return Método de pago correspondiente al ID, o null si no se encuentra.
     */
    @Override
    public MetodoPagoDTO obtenerMetodoPagoPorId(int id) {
        MetodoEfectivo metodoPago = (MetodoEfectivo) metodoPagoDAO.obtenerMetodoPagoPorId(id);
        if (metodoPago != null) {
            return this.convertirDTO(metodoPago);
        } else {
            return null;
        }
    }
    
    /**
     * Convierte método de pago de entidad a DTO
     *
     * @param metodoPago Método de pago a convertir
     * @return Método de pago convertido
     */
    @Override
    public MetodoPagoDTO convertirDTO(MetodoPago metodoPago) {
        MetodoEfectivo entidadNueva = (MetodoEfectivo) metodoPago;
        
        MetodoPagoDTO dto = new MetodoEfectivoDTO(
            entidadNueva.getIdPago(),
            entidadNueva.getTotal(),
            entidadNueva.getEfectivoEntregado(),
            entidadNueva.getCambio()
        );
        return dto;
    }
    
    /**
     * Convierte método de pago de DTO a entidad
     *
     * @param metodoPagoDTO Método de pago a convertir
     * @return Método de pago convertido
     */
    @Override
    public MetodoPago convertirEntidad(MetodoPagoDTO metodoPagoDTO) {
        MetodoEfectivoDTO dtoNueva = (MetodoEfectivoDTO) metodoPagoDTO;
        
        MetodoPago entidad = new MetodoEfectivo(
            dtoNueva.getIdPago(),
            dtoNueva.getTotal(),
            dtoNueva.getEfectivoEntregado(),
            dtoNueva.getCambio()
        );
        return entidad;
    }

    /**
     * Lista todos los métodos de pago almacenados.
     *
     * @return Lista de métodos de pago almacenados.
     */
    @Override
    public List<MetodoPagoDTO> listarTodos() {
        List<MetodoPago> lista = metodoPagoDAO.listarTodos();
        List<MetodoPagoDTO> dtos = new ArrayList<>();
        for (MetodoPago mp : lista) {
            dtos.add(this.convertirDTO(mp));
        }
        return dtos;
    }
     
}
