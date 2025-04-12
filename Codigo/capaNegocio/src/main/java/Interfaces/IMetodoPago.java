/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Interfaces;

import DTOs.MetodoPagoDTO;
import Entidades.MetodoPago;
import java.util.List;

/**
 *
 * @author Ángel Ruíz García - 00000248171
 */
public interface IMetodoPago {

    /**
     * Guarda un nuevo método de pago en la fuente de datos.
     *
     * @param metodoPagoDTO Método de pago a guardar.
     * @return Método de pago a guardar.
     */
    MetodoPagoDTO guardarMetodoPago(MetodoPagoDTO metodoPagoDTO);

    /**
     * Obtiene un método de pago por su identificador único.
     *
     * @param id Identificador del método de pago.
     * @return Método de pago correspondiente al ID, o null si no se encuentra.
     */
    MetodoPagoDTO obtenerMetodoPagoPorId(int id);

    /**
     * Convierte método de pago de entidad a DTO
     *
     * @param metodoPago Método de pago a convertir
     * @return Método de pago convertido
     */
    MetodoPagoDTO convertirDTO(MetodoPago metodoPago);

    /**
     * Convierte método de pago de DTO a entidad
     *
     * @param metodoPagoDTO Método de pago a convertir
     * @return Método de pago convertido
     */
    MetodoPago convertirEntidad(MetodoPagoDTO metodoPagoDTO);

    /**
     * Lista todos los métodos de pago almacenados.
     *
     * @return Lista de métodos de pago almacenados.
     */
    List<MetodoPagoDTO> listarTodos();
}
