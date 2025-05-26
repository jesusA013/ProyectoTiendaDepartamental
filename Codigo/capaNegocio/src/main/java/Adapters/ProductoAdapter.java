package Adapters;

import DTOs.ProductoDTO;
import DTOs.ProductoTablaDTO;
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
    public static Producto convertirAEntidad(ProductoDTO dto) {
        if (dto == null) {
            return null;
        }

        Producto entidad = new Producto();

        entidad.setIdProducto(dto.getIdProductoDTO()); // si es null no pasa nada
        entidad.setCodigo(dto.getCodigo());
        entidad.setNombre(dto.getNombre());
        entidad.setSKU(dto.getSKU());
        entidad.setMarca(dto.getMarca());
        entidad.setColor(dto.getColor());
        entidad.setPrecio(dto.getPrecio());
        entidad.setStock(dto.getStock());
        entidad.setDescripcion(dto.getDescripcion());
        entidad.setProveedorId(dto.getIdProveedor());

        return entidad;
    }

    // Entidad -> DTO
    public static ProductoDTO convertirADTO(Producto entidad) {
        if (entidad == null) {
            return null;
        }

        ProductoDTO dto = new ProductoDTO();

        dto.setIdProductoDTO(entidad.getIdProducto());
        dto.setCodigo(entidad.getCodigo());
        dto.setNombre(entidad.getNombre());
        dto.setSKU(entidad.getSKU());
        dto.setMarca(entidad.getMarca());
        dto.setColor(entidad.getColor());
        dto.setPrecio(entidad.getPrecio());
        dto.setStock(entidad.getStock());
        dto.setDescripcion(entidad.getDescripcion());
        dto.setIdProveedor(entidad.getProveedorId());

        return dto;
    }

    // --- Métodos para convertir listas ---
    public static List<Producto> convertirAEntidad(List<ProductoDTO> listaDTO) {
        if (listaDTO == null || listaDTO.isEmpty()) {
            return new ArrayList<>();
        }
        return listaDTO.stream()
                .filter(Objects::nonNull)
                .map(ProductoAdapter::convertirAEntidad)
                .collect(Collectors.toList());
    }

    public static List<ProductoDTO> convertirADTO(List<Producto> listaEntidad) {
        if (listaEntidad == null || listaEntidad.isEmpty()) {
            return new ArrayList<>();
        }
        return listaEntidad.stream()
                .filter(Objects::nonNull)
                .map(ProductoAdapter::convertirADTO)
                .collect(Collectors.toList());
    }

    public static ProductoTablaDTO convertirATablaDTO(Producto entidad) {
        if (entidad == null) {
            return null;
        }

        ProductoTablaDTO dto = new ProductoTablaDTO();
        dto.setIdProducto(entidad.getIdProducto());
        dto.setCodigo(entidad.getCodigo());
        dto.setNombre(entidad.getNombre());
        dto.setMarca(entidad.getMarca());
        dto.setColor(entidad.getColor());
        dto.setPrecio(entidad.getPrecio());
        dto.setStock(entidad.getStock());

        return dto;
    }

    public static List<ProductoTablaDTO> convertirATablaDTO(List<Producto> listaEntidad) {
        if (listaEntidad == null || listaEntidad.isEmpty()) {
            return new ArrayList<>();
        }

        return listaEntidad.stream()
                .filter(Objects::nonNull)
                .map(ProductoAdapter::convertirATablaDTO)
                .collect(Collectors.toList());
    }
}
