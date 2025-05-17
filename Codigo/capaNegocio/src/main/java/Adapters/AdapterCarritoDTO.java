package Adapters; 

import DTOs.CarritoDTO;
import DTOs.ProductoCarritoDTO;
import Entidades.Carrito; 
import Entidades.ProductoVenta; 
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class AdapterCarritoDTO {

    /**
     * 
     *
     * @param carritoDTO El objeto de transferencia de datos a convertir.
     * @return 
     */
    public static Carrito convertirAEntidad(CarritoDTO carritoDTO) {
        if (carritoDTO == null) {
            return null;
        }

        Carrito carritoEntidad = new Carrito();

        // Mapeo de atributos (DTO -> Entidad)
        carritoEntidad.setCantidadProductos(carritoDTO.getCantidadTotalProducots()); // DTO (typo) -> Entidad
        carritoEntidad.setSubtotal(carritoDTO.getSubtotal());
        carritoEntidad.setImpuesto(carritoDTO.getImpuestos()); // DTO (plural) -> Entidad (singular)
        carritoEntidad.setTotal(carritoDTO.getTotal());

        // El ID (idCarrito) generalmente NO se establece desde el DTO al crear.
        // Si el DTO *sí* contiene un ID para actualizaciones, lo mapearías aquí:
        // if (carritoDTO.getId() != null) { // Suponiendo que añades getId() al DTO
        //     carritoEntidad.setIdCarrito(carritoDTO.getId());
        // }

        // Mapeo de la lista de productos (ProductoCarritoDTO -> ProductoVenta)
        if (carritoDTO.getListaProductos() != null) {
            // Usamos el NUEVO adaptador: ProductoVentaAdapter
//            List<ProductoVenta> listaProductosEntidad = carritoDTO.getListaProductos()
//                .stream()
//                .map(ProductoVentaAdapter::convertirAEntidad) // Llama al adaptador correcto
//                .collect(Collectors.toList());
//            carritoEntidad.setCarrito(listaProductosEntidad); // Usa el setter de la entidad: setCarrito
        } else {
            carritoEntidad.setCarrito(new ArrayList<>()); // O null
        }

        return carritoEntidad;
    }

    /**
     * Convierte un objeto Carrito (Entidad) a un objeto CarritoDTO.
     *
     * @param carritoEntidad El objeto entidad Carrito a convertir.
     * @return El objeto de transferencia de datos CarritoDTO correspondiente, o null si la entrada es null.
     */
    public static CarritoDTO convertirADTO(Carrito carritoEntidad) {
        if (carritoEntidad == null) {
            return null;
        }

        // Mapeo de la lista de productos primero (ProductoVenta -> ProductoCarritoDTO)
        List<ProductoCarritoDTO> listaProductosDTO = null;
        if (carritoEntidad.getCarrito() != null) { // Usa el getter: getCarrito()
            // Usamos el NUEVO adaptador: ProductoVentaAdapter
//             listaProductosDTO = carritoEntidad.getCarrito()
//                .stream()
//                .map(ProductoVentaAdapter::convertirADTO) // Llama al adaptador correcto
//                .collect(Collectors.toList());
        } else {
            listaProductosDTO = new ArrayList<>(); // O null
        }

        // Creamos el DTO. Podemos usar el constructor o setters.
        // Usando constructor del DTO:
        CarritoDTO carritoDTO = new CarritoDTO(
                listaProductosDTO,                             // list<ProductoCarritoDTO>
                carritoEntidad.getCantidadProductos(),         // int cantidadTotalProducots (nombre DTO)
                carritoEntidad.getSubtotal(),                  // double subtotal
                carritoEntidad.getImpuesto(),                  // double impuestos (nombre DTO)
                carritoEntidad.getTotal()                      // double total
        );

        
        return carritoDTO;
    }

    // Metodos para convertir en Listas

//    public static List<Carrito> convertirAEntidad(List<CarritoDTO> listaDTO) {
//        if (listaDTO == null) {
//            return null;
//        }
//        return listaDTO.stream()
//                      .map(CarritoAdapter::convertirAEntidad)
//                      .collect(Collectors.toList());
//    }

//    public static List<CarritoDTO> convertirADTO(List<Carrito> listaEntidad) {
//         if (listaEntidad == null) {
//            return null;
//        }
//        return listaEntidad.stream()
//                           .map(CarritoAdapter::convertirADTO)
//                           .collect(Collectors.toList());
//    }
}
