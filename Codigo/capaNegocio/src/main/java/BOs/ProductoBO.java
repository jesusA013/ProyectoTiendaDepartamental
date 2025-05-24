package BOs;

import static Adapters.ProductoAdapter.convertirATablaDTO;
import DAOs.Conexion;
import DAOs.ProductoDAO;
import DTOs.ProductoDTO;
import DTOs.ProductoTablaDTO;
import Entidades.Producto;
import Excepciones.NegocioException;
import Exception.PersistenciaException;
import Interfaces.IProductoBO;
import Interfaz.IConexion;
import Interfaz.IProductoDAO;
import java.util.ArrayList;
import java.util.List;
import org.bson.types.ObjectId;

/**
 * ProductoBO.java
 *
 * Esta clase objectos negocio actua como intermediario con la DAO de
 * Productos.
 *
 * @author
 */
public class ProductoBO implements IProductoBO {

    private final IProductoDAO productoDAO;

    /**
     * Inicializa el atributo para usar la DAO.
     */
    public ProductoBO() {
        this.productoDAO = new ProductoDAO();
    }

    @Override
    public ProductoDTO insertarProducto(ProductoDTO productoDTO) throws NegocioException {
        try {
            Producto producto = convertirEntidad(productoDTO);
            ProductoDTO productoGuardado = convertirDTO(productoDAO.insertarProducto(producto));

            return productoGuardado;
        } catch (PersistenciaException ex) {
            throw new NegocioException("Error " + ex.getMessage());
        }
    }

    @Override
    public ProductoDTO buscarProductoPorId(ObjectId id) throws NegocioException {
        try {
            ProductoDTO productoEncontrado = convertirDTO(productoDAO.buscarPorId(id));

            return productoEncontrado;
        } catch (PersistenciaException ex) {
            throw new NegocioException("Error " + ex.getMessage());
        }
    }
    
    @Override
    public List<ProductoDTO> buscarProductos(String productoBuscar) throws NegocioException {
        try {
            List<Producto> listaProductos = this.productoDAO.buscarProductos(productoBuscar);

            List<ProductoDTO> dtos = new ArrayList<>();
            for (Producto producto : listaProductos) {
                dtos.add(this.buscarProductoPorId(producto.getId()));
            }

            return dtos;
        } catch (PersistenciaException ex) {
            throw new NegocioException("Error " + ex.getMessage());
        }
    }

    @Override
    public ProductoDTO actualizarProducto(ProductoDTO productoDTO) throws NegocioException {
        try {
            Producto producto = convertirEntidad(productoDTO);
            ProductoDTO productoActualizado = convertirDTO(productoDAO.actualizarProducto(producto));

            return productoActualizado;
        } catch (PersistenciaException ex) {
            throw new NegocioException("Error " + ex.getMessage());
        }
    }

    @Override
    public ProductoDTO eliminarProducto(ObjectId id) throws NegocioException {
        try {
            ProductoDTO productoEliminado = convertirDTO(productoDAO.eliminarProducto(id));

            return productoEliminado;
        } catch (PersistenciaException ex) {
            throw new NegocioException("Error " + ex.getMessage());
        }
    }
    @Override
    public List<ProductoTablaDTO> obtenerTodosParaTabla()throws NegocioException {
        try {
            List<Producto> productos = productoDAO.buscarTodos();
            return convertirATablaDTO(productos);
        } catch (PersistenciaException ex) {
            throw new NegocioException(ex.getMessage());
        }
    }
    
    /**
     * Convierte la entidad a DTO.
     *
     * @param producto Entidad a convertir
     * @return Regresa la DTO creada
     */
    private ProductoDTO convertirDTO(Producto producto) {
        ProductoDTO productoDTO = new ProductoDTO();
        productoDTO.setId(producto.getId());
        productoDTO.setNombre(producto.getNombre());
        productoDTO.setStock(producto.getStock());
        productoDTO.setDescripcion(producto.getDescripcion());
        productoDTO.setCodigo(producto.getCodigo());
        productoDTO.setSKU(producto.getSKU());
        productoDTO.setMarca(producto.getMarca());
        productoDTO.setColor(producto.getColor());
        productoDTO.setPrecio(producto.getPrecio());
        productoDTO.setProveedorId(producto.getProveedorId());
        
        return productoDTO;
    }

    /**
     * Convierte la DTO a entidad.
     *
     * @param productoDTO DTO a convertir
     * @return Regresa la entidad creada
     */
    private Producto convertirEntidad(ProductoDTO productoDTO) {
        Producto producto = new Producto();
        producto.setId(productoDTO.getId());
        producto.setNombre(productoDTO.getNombre());
        producto.setStock(productoDTO.getStock());
        producto.setDescripcion(productoDTO.getDescripcion());
        producto.setCodigo(productoDTO.getCodigo());
        producto.setSKU(productoDTO.getSKU());
        producto.setMarca(productoDTO.getMarca());
        producto.setColor(productoDTO.getColor());
        producto.setPrecio(productoDTO.getPrecio());
        producto.setProveedorId(productoDTO.getProveedorId());
        
        return producto;
    }
}
