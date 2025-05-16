package BOs;

import DAOs.MetodoTarjetaDAO;
import DTOs.MetodoPagoDTO;
import DTOs.MetodoTarjetaDTO;
import Entidades.MetodoPago;
import Entidades.MetodoTarjeta;
import Interfaces.IMetodoPago;
import Interfaz.IMetodoPagoDAO;
import java.util.ArrayList;
import java.util.List;

/**
 * MetodoTarjetaBO.java
 * 
 * Esta clase representa el metodo de pago con efectivo de objectos negocio.
 * 
 * @author Ángel Ruíz García - 00000248171
 */
public class MetodoTarjetaBO implements IMetodoPago {
    
    private final IMetodoPagoDAO metodoPagoDAO;

    /**
     * Contructor del metodo de pago con efectivo de objectos negocio.
     */
    public MetodoTarjetaBO() {
        this.metodoPagoDAO = new MetodoTarjetaDAO();
    }

    /**
     * Guarda un nuevo método de pago en la fuente de datos.
     *
     * @param metodoPagoDTO Método de pago a guardar.
     * @return Método de pago a guardar.
     */
    @Override
    public MetodoPagoDTO guardarMetodoPago(MetodoPagoDTO metodoPagoDTO) {
        MetodoTarjetaDTO tarjetaNueva = (MetodoTarjetaDTO) metodoPagoDTO;
        MetodoPago entidad = this.convertirEntidad(tarjetaNueva);
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
        MetodoTarjeta metodoPago = (MetodoTarjeta) metodoPagoDAO.obtenerMetodoPagoPorId(id);
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
        MetodoTarjeta entidadNueva = (MetodoTarjeta) metodoPago;
        
        MetodoPagoDTO dto = new MetodoTarjetaDTO(
            entidadNueva.getIdPago(),
            entidadNueva.getTotal(),
            entidadNueva.getTarjeta(),
            entidadNueva.getMes(),
            entidadNueva.getAno(),
            entidadNueva.getCvc()
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
        MetodoTarjetaDTO dtoNueva = (MetodoTarjetaDTO) metodoPagoDTO;
        
        MetodoPago entidad = new MetodoTarjeta(
            dtoNueva.getIdPago(),
            dtoNueva.getTotal(),
            dtoNueva.getTarjeta(),
            dtoNueva.getMes(),
            dtoNueva.getAno(),
            dtoNueva.getCvc()
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
