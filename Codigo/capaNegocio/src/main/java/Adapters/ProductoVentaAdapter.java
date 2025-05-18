package Adapters;

import DTOs.ProductoDTO;
import DTOs.ProductoVentaDTO;
import Entidades.Producto; 
import Entidades.ProductoVenta; 
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

/**
 * ProductoVentaAdapter.java
 *
 * Adaptador para convertir entre ProductoVentaDTO y la entidad ProductoVenta.
 * 
 */
public class ProductoVentaAdapter {

    // DTO -> Entidad 

    /**
     * Convierte un ProductoVentaDTO a una entidad ProductoVenta.
     * Requiere el ID del carrito al que pertenecerá esta línea, ya que el DTO no lo contiene.
     *
     * @param dto El objeto ProductoVentaDTO a convertir.
     * @param idCarrito El ID del Carrito al que pertenece/pertenecerá esta línea de venta.
     * @return La entidad ProductoVenta mapeada y lista para ser usada o persistida.
     * @throws IllegalArgumentException si el dto es nulo, si el ProductoDTO anidado es nulo,
     * o si no se puede convertir el ProductoDTO anidado a entidad Producto.
     */
//    public static ProductoVenta convertirAEntidad(ProductoVentaDTO dto, int idCarrito) {
//        if (dto == null) {
//            throw new IllegalArgumentException("El ProductoVentaDTO no puede ser nulo para la conversión.");
//        }
//        if (dto.getProducto() == null) {
//            throw new IllegalArgumentException("El ProductoDTO anidado en ProductoVentaDTO no puede ser nulo.");
//        }
//
//        //Convertir el ProductoDTO anidado a la entidad.
//       
//        Producto productoBase = ProductoAdapter.convertirAEntidad(dto.getProducto());
//        if (productoBase == null) {
//            
//            throw new IllegalArgumentException("No se pudo convertir/obtener la entidad Producto base desde el ProductoDTO anidado.");
//        }
//
//        // 2. Crear la nueva entidad ProductoVenta usando su constructor.
//       
//        ProductoVenta entidad = new ProductoVenta(
//                idCarrito,
//                productoBase,
//                dto.getCantidad(),
//                dto.getPrecio() // precio del DTO se convierte en precioUnitarioVenta de la entidad
//        );
//
//        // El importe es calculado por el constructor de ProductoVenta.
//        // El idProductoVenta será asignado por la base de datos (o manualmente si es necesario antes de persistir).
//
//        return entidad;
//    }

   

    /**
     * Convierte una entidad ProductoVenta (rediseñada) a un ProductoVentaDTO.
     *
     * @param entidad La entidad ProductoVenta a convertir.
     * @return El ProductoVentaDTO mapeado. Null si la entidad es null.
     */
//    public static ProductoVentaDTO convertirADTO(ProductoVenta entidad) {
//        if (entidad == null) {
//            return null;
//        }
//
//        ProductoVentaDTO dto = new ProductoVentaDTO();
//
//        // 1. Mapear campos directos desde la entidad al DTO
//        dto.setCantidad(entidad.getCantidad());
//        dto.setPrecio(entidad.getPrecioUnitarioVenta()); // precioUnitarioVenta de la entidad -> precio del DTO
//        dto.setImporte(entidad.getImporte());
//
//        // 2. Mapear la entidad Producto base referenciada a ProductoDTO
//        Producto productoBase = entidad.getProducto();
//        if (productoBase != null) {
//            // ¡Dependencia clave de ProductoAdapter!
//            ProductoDTO productoDTO = ProductoAdapter.convertirADTO(productoBase);
//            dto.setProducto(productoDTO);
//        } else {
//            // Esto no debería ocurrir si la entidad está bien construida, pero se maneja por si acaso.
//            dto.setProducto(null);
//            System.err.println("Advertencia: La entidad ProductoVenta con ID " + entidad.getIdProductoVenta() + " tiene una referencia a Producto nula.");
//        }
//
//        // Los IDs (idProductoVenta, idCarrito) no se mapean al DTO por defecto.
//        // Si los necesitaras en el DTO, deberías añadir los campos correspondientes a ProductoVentaDTO.
//
//        return dto;
//    }

    // --- Métodos para convertir listas ---

    /**
     * Convierte una lista de ProductoVentaDTO a una lista de entidades ProductoVenta.
     * Se asume que todos los DTOs en la lista pertenecen al mismo carrito.
     *
     * @param listaDTO La lista de DTOs a convertir.
     * @param idCarrito El ID del Carrito al que pertenecen todas las líneas en la lista.
     * @return Una nueva lista conteniendo las entidades ProductoVenta mapeadas. Lista vacía si la entrada es nula o vacía.
     * @throws IllegalArgumentException si alguna de las conversiones individuales falla.
     */
//    public static List<ProductoVenta> convertirAEntidad(List<ProductoVentaDTO> listaDTO, int idCarrito) {
//        if (listaDTO == null || listaDTO.isEmpty()) {
//            return new ArrayList<>(); // Devuelve lista vacía en lugar de null para evitar NullPointerExceptions
//        }
//        return listaDTO.stream()
//                      .map(dto -> convertirAEntidad(dto, idCarrito)) // Llama al método de conversión individual
//                      .filter(Objects::nonNull) // Asegura que no haya nulos si la conversión pudiera fallar y retornar null
//                      .collect(Collectors.toList());
//    }

    /**
     * Convierte una lista de entidades ProductoVenta a una lista de ProductoVentaDTO.
     *
     * @param listaEntidad La lista de entidades a convertir.
     * @return Una nueva lista conteniendo los DTOs mapeados. Lista vacía si la entrada es nula o vacía.
     */
//    public static List<ProductoVentaDTO> convertirADTO(List<ProductoVenta> listaEntidad) {
//         if (listaEntidad == null || listaEntidad.isEmpty()) {
//            return new ArrayList<>(); // Devuelve lista vacía
//        }
//        return listaEntidad.stream()
//                           .map(ProductoVentaAdapter::convertirADTO) // Llama al método de conversión individual
//                           .filter(Objects::nonNull) // Por si acaso la conversión individual pudiera retornar null
//                           .collect(Collectors.toList());
//    }
}
