package Adapters;

import DTOs.ProductoDTO;
import Entidades.Producto; // La entidad Producto
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

/**
 * ProductoAdapter.java
 *
 * Adaptador para convertir entre ProductoDTO y la entidad Producto.
 *
 */
public class ProductoAdapter {

    // DTO -> Entidad 

    /**
     * Convierte un ProductoDTO a una entidad Producto.
     *
     *
     * @param dto El objeto ProductoDTO a convertir. Si es {@code null}, retorna {@code null}.
     * @return La entidad {@code Producto} mapeada (con los campos disponibles).
     */
    public static Producto convertirAEntidad(ProductoDTO dto) {
        if (dto == null) {
            return null;
        }

        Producto entidad = new Producto();

        // Mapear campos coincidentes
        entidad.setNombre(dto.getNombre());
        entidad.setStock(dto.getStock());

       

        return entidad;
    }

    // Entidad -> DTO 

    /**
     *
     * @param entidad La entidad Producto a convertir. Si es {@code null}, retorna {@code null}.
     * @return El {@code ProductoDTO} mapeado (con los campos disponibles).
     */
    public static ProductoDTO convertirADTO(Producto entidad) {
        if (entidad == null) {
            return null;
        }

        ProductoDTO dto = new ProductoDTO();

        // Mapear campos coincidentes
        dto.setNombre(entidad.getNombre());
        dto.setStock(entidad.getStock());

        return dto;
    }

    // --- Métodos para convertir listas ---

    /**
     * Convierte una lista de ProductoDTO a una lista de entidades Producto.
     
     */
    public static List<Producto> convertirAEntidad(List<ProductoDTO> listaDTO) {
        if (listaDTO == null || listaDTO.isEmpty()) {
            return new ArrayList<>(); // Es mejor devolver lista vacía que null
        }
        return listaDTO.stream()
                      .filter(Objects::nonNull) 
                      .map(ProductoAdapter::convertirAEntidad) 
                      .collect(Collectors.toList());
    }

    /**
     * Convierte una lista de entidades Producto a una lista de ProductoDTO.
     *
     * 
     */
    public static List<ProductoDTO> convertirADTO(List<Producto> listaEntidad) {
         if (listaEntidad == null || listaEntidad.isEmpty()) {
            return new ArrayList<>(); 
        }
        return listaEntidad.stream()
                           .filter(Objects::nonNull) 
                           .map(ProductoAdapter::convertirADTO) 
                           .collect(Collectors.toList());
    }
}
