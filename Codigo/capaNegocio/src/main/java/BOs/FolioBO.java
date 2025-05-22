package BOs;

import DAOs.*;
import DAOs.*;
import DTOs.FolioDTO;
import DTOs.ProductoDTO;
import Entidades.EntidadFolio;
import Entidades.EntidadProducto;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * FolioBO.java
 *
 * Esta clase maneja la lógica de negocio para operaciones relacionadas con folios.
 */
public class FolioBO {

    private FolioDAO folioDAO;
    private ProductoDAO productoDAO;

    /**
     * Constructor de FolioBO.
     */
    public FolioBO() {
        this.folioDAO = FolioDAO.getInstance();
        this.productoDAO = ProductoDAO.getInstance();
    }

    /**
     * Crea un nuevo folio y lo guarda en la base de datos.
     *
     * @param folioDTO DTO con los datos del folio
     * @throws IllegalArgumentException si el número de folio ya existe
     */
    public void crearFolio(FolioDTO folioDTO) {
        // Validar que el número de folio no exista
        if (folioDAO.buscarPorNumero(folioDTO.getNumeroFolio()) != null) {
            throw new IllegalArgumentException("El número de folio ya existe.");
        }

        // Convertir DTO a Entidad
        EntidadFolio folio = new EntidadFolio();
        folio.setIdFolio(generarIdFolio()); // Generamos un ID único
        folio.setNumeroFolio(folioDTO.getNumeroFolio());
        folio.setFecha(folioDTO.getFecha());
        folio.setNombreProveedor(folioDTO.getNombreProveedor());

        // Guardar el folio
        folioDAO.guardar(folio);
    }

    /**
     * Asocia una lista de productos a un folio y actualiza el stock de los productos.
     *
     * @param numeroFolio Número del folio
     * @param productosDTO Lista de DTOs de productos a asociar
     * @throws IllegalArgumentException si el folio no existe o si el stock es inválido
     */
    public void asociarProductos(String numeroFolio, List<ProductoDTO> productosDTO) {
        // Buscar el folio
        EntidadFolio folio = folioDAO.buscarPorNumero(numeroFolio);
        if (folio == null) {
            throw new IllegalArgumentException("El folio no existe.");
        }

        // Convertir DTOs a Entidades y actualizar stock
        List<EntidadProducto> productos = new ArrayList<>();
        for (ProductoDTO dto : productosDTO) {
            EntidadProducto producto = productoDAO.buscarPorSku(dto.getSku());
            if (producto == null) {
                
                producto = new EntidadProducto(generarIdProducto(), dto.getSku(), dto.getNombre(), 0);
                productoDAO.guardar(producto);
            }

            // Calcular nuevo stock
            int nuevoStock = producto.getStock() + dto.getStock();
            if (nuevoStock < 0) {
                throw new IllegalArgumentException("El stock del producto " + dto.getNombre() + " no puede ser negativo.");
            }

            // Actualizar stock en la base de datos
            productoDAO.actualizarStock(dto.getSku(), nuevoStock);

            // Crear una copia del producto para asociar al folio (solo con la cantidad añadida)
            EntidadProducto productoAsociado = new EntidadProducto(0, dto.getSku(), dto.getNombre(), dto.getStock());
            productos.add(productoAsociado);
        }

        // Asociar los productos al folio
        folioDAO.asociarProductos(folio.getIdFolio(), productos);
    }

    /**
     * Obtiene todos los folios.
     *
     * @return Lista de FolioDTO
     */
    public List<FolioDTO> obtenerTodosFolios() {
        return folioDAO.obtenerTodos().stream()
                .map(this::convertirAFolioDTO)
                .collect(Collectors.toList());
    }

    /**
     * Genera un ID único para un folio.
     *
     * @return ID generado
     */
    private int generarIdFolio() {
        List<EntidadFolio> folios = folioDAO.obtenerTodos();
        return folios.isEmpty() ? 1 : folios.get(folios.size() - 1).getIdFolio() + 1;
    }

    /**
     * Genera un ID único para un producto.
     *
     * @return ID generado
     */
    private int generarIdProducto() {
        List<EntidadProducto> productos = productoDAO.obtenerTodos();
        return productos.isEmpty() ? 1 : productos.get(productos.size() - 1).getIdProducto() + 1;
    }

    /**
     * Convierte una entidad Folio a un FolioDTO.
     *
     * @param folio Entidad Folio
     * @return FolioDTO
     */
    private FolioDTO convertirAFolioDTO(EntidadFolio folio) {
        FolioDTO dto = new FolioDTO();
        dto.setNumeroFolio(folio.getNumeroFolio());
        dto.setFecha(folio.getFecha());
        dto.setNombreProveedor(folio.getNombreProveedor());
        return dto;
    }
}

