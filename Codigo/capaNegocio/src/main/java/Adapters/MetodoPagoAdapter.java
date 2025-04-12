package Adapters;

import DTOs.*;       
import Entidades.*;   
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

/**
 * MetodoPagoAdapter.java
 *
 * 
 */
public class MetodoPagoAdapter {

    // DTO -> Entidad

    /**
     * Convierte un MetodoPagoDTO (concreto: MetodoEfectivoDTO o MetodoTarjetaDTO)
     * a su correspondiente entidad MetodoPago concreta.
     *
     * @param dto El DTO concreto a convertir.
     * @return La entidad concreta correspondiente, o {@code null} si el DTO es nulo
     * o de un tipo no soportado por este adaptador.
     */
    public static MetodoPago convertirAEntidad(MetodoPagoDTO dto) {
        if (dto == null) {
            return null;
        }

        // Identificar el tipo concreto de DTO y llamar al método específico
        if (dto instanceof MetodoEfectivoDTO) {
            return convertirEfectivoEntidad((MetodoEfectivoDTO) dto);
        } else if (dto instanceof MetodoTarjetaDTO) {
            return convertirTarjetaEntidad((MetodoTarjetaDTO) dto);
        }
        // Aqui van los demas tipos futuros

        // 
        System.err.println("Error: Tipo de MetodoPagoDTO no soportado para conversión a Entidad: " + dto.getClass().getName());
       
         return null;
    }

    // Métodos ayudantes privados para cada conversión específica DTO -> Entidad
    private static MetodoEfectivo convertirEfectivoEntidad(MetodoEfectivoDTO dto) {
        MetodoEfectivo entidad = new MetodoEfectivo();
      
        entidad.setIdPago(dto.getIdPago());
        entidad.setTotal(dto.getTotal());
        
        entidad.setEfectivoEntregado(dto.getEfectivoEntregado());
        entidad.setCambio(dto.getCambio());
        return entidad;
    }

    private static MetodoTarjeta convertirTarjetaEntidad(MetodoTarjetaDTO dto) {
        MetodoTarjeta entidad = new MetodoTarjeta();
       
        entidad.setIdPago(dto.getIdPago());
        entidad.setTotal(dto.getTotal());
       
        entidad.setTarjeta(dto.getTarjeta()); 
        entidad.setMes(dto.getMes());
        entidad.setAno(dto.getAno());
        entidad.setCvc(dto.getCvc()); 
        return entidad;
    }

    // Entidad -> DTO 

    /**
     *
     * @param entidad La entidad concreta a convertir.
     * @return El DTO concreto correspondiente, o {@code null} si la entidad es nula
     * 
     */
    public static MetodoPagoDTO convertirADTO(MetodoPago entidad) {
        if (entidad == null) {
            return null;
        }

        // Identificar el tipo concreto de Entidad y llamar al método específico
        if (entidad instanceof MetodoEfectivo) {
            return convertirEfectivoDTO((MetodoEfectivo) entidad);
        } else if (entidad instanceof MetodoTarjeta) {
            return convertirTarjetaDTO((MetodoTarjeta) entidad);
        }
         
        /
        System.err.println("Error: Tipo de MetodoPago (Entidad) no soportado para conversión a DTO: " + entidad.getClass().getName());
        
        return null;
    }

    // Métodos ayudantes privados para cada conversión específica Entidad -> DTO
    private static MetodoEfectivoDTO convertirEfectivoDTO(MetodoEfectivo entidad) {
        MetodoEfectivoDTO dto = new MetodoEfectivoDTO();
        // Copiar campos comunes (heredados)
        dto.setIdPago(entidad.getIdPago());
        dto.setTotal(entidad.getTotal());
        // Copiar campos específicos de Efectivo
        dto.setEfectivoEntregado(entidad.getEfectivoEntregado());
        dto.setCambio(entidad.getCambio());
        return dto;
    }

     private static MetodoTarjetaDTO convertirTarjetaDTO(MetodoTarjeta entidad) {
        MetodoTarjetaDTO dto = new MetodoTarjetaDTO();
        // Copiar campos comunes (heredados)
        dto.setIdPago(entidad.getIdPago());
        dto.setTotal(entidad.getTotal());
        // Copiar campos específicos de Tarjeta
        dto.setTarjeta(entidad.getTarjeta());
        dto.setMes(entidad.getMes());
        dto.setAno(entidad.getAno());
        dto.setCvc(entidad.getCvc()); 
        return dto;
    }

    // --- Métodos para convertir listas ---
 

    /**
     * @param listaDTO Lista de DTOs (MetodoEfectivoDTO, MetodoTarjetaDTO).
     * @return Lista de Entidades (MetodoEfectivo, MetodoTarjeta). Lista vacía si entrada es null/vacía.
     */
    public static List<MetodoPago> convertirAEntidad(List<MetodoPagoDTO> listaDTO) {
        if (listaDTO == null || listaDTO.isEmpty()) {
            return new ArrayList<>();
        }
        return listaDTO.stream()
                      .filter(Objects::nonNull)
                      .map(MetodoPagoAdapter::convertirAEntidad) // Llama al método público que detecta tipos
                      .filter(Objects::nonNull) // Filtrar resultados nulos si algún tipo no fue soportado
                      .collect(Collectors.toList());
    }

    /**
     * Convierte una lista de Entidades MetodoPago concretas a una lista de MetodoPagoDTO concretos.
     * @param listaEntidad Lista de Entidades (
     * @return Lista de DTOs 
     */
    public static List<MetodoPagoDTO> convertirADTO(List<MetodoPago> listaEntidad) {
         if (listaEntidad == null || listaEntidad.isEmpty()) {
            return new ArrayList<>();
        }
        return listaEntidad.stream()
                           .filter(Objects::nonNull)
                           .map(MetodoPagoAdapter::convertirADTO) // Llama al método público que detecta tipos
                           .filter(Objects::nonNull) // Filtrar resultados nulos si algún tipo no fue soportado
                           .collect(Collectors.toList());
    }
}
