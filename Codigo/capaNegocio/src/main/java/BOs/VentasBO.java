package BOs;

import DAOs.Conexion;
import DAOs.VentasDAO;
import DTOs.DetallesVentaDTO;
import DTOs.FacturaDTO;
import DTOs.ProductoDTO;
import DTOs.ProductoVentaDTO;
import DTOs.VentaDTO;
import Entidades.DetallesVenta;
import Entidades.Factura;
import Entidades.Producto;
import Entidades.ProductoVenta;
import Entidades.Venta;
import Excepciones.NegocioException;
import Exception.PersistenciaException;
import Interfaces.IVentasBO;
import Interfaz.IConexion;
import Interfaz.IVentasDAO;
import java.util.ArrayList;
import java.util.List;
import org.bson.types.ObjectId;

/**
 * VentaBO.java
 *
 * Esta clase representa una venta realizada en el sistema.
 *
 * @author
 */
public class VentasBO implements IVentasBO {
    
    private final IVentasDAO ventaDAO;
    IConexion Mongo = new Conexion();

    /**
     * Inicializa el atributo para usar la DAO.
     */
    public VentasBO() {
        this.ventaDAO = new VentasDAO(Mongo.conexion());
    }
    
    @Override
    public VentaDTO insertarVenta(VentaDTO ventaDTO) throws NegocioException {
        try {
            Venta venta = convertirEntidad(ventaDTO);
            VentaDTO ventaGuardada = convertirDTO(ventaDAO.insertarVenta(venta));

            return ventaGuardada;
        } catch (PersistenciaException ex) {
            throw new NegocioException("Error " + ex.getMessage());
        }
    }

    @Override
    public VentaDTO buscarPorId(ObjectId id) throws NegocioException {
        try {
            VentaDTO ventaEncontrada = convertirDTO(ventaDAO.buscarPorId(id));

            return ventaEncontrada;
        } catch (PersistenciaException ex) {
            throw new NegocioException("Error " + ex.getMessage());
        }
    }

    @Override
    public VentaDTO actualizarVenta(VentaDTO ventaDTO) throws NegocioException {
        try {
            Venta venta = convertirEntidad(ventaDTO);
            VentaDTO ventaActualizada = convertirDTO(ventaDAO.actualizarVenta(venta));

            return ventaActualizada;
        } catch (PersistenciaException ex) {
            throw new NegocioException("Error " + ex.getMessage());
        }
    }

    @Override
    public VentaDTO eliminarVenta(ObjectId id) throws NegocioException {
        try {
            VentaDTO ventaEliminada = convertirDTO(ventaDAO.eliminarVenta(id));

            return ventaEliminada;
        } catch (PersistenciaException ex) {
            throw new NegocioException("Error " + ex.getMessage());
        }
    }
    
    /**
     * Convierte la entidad a DTO.
     *
     * @param venta Entidad a convertir
     * @return Regresa la DTO creada
     */
    private VentaDTO convertirDTO(Venta venta) {
        VentaDTO ventaDTO = new VentaDTO();
        ventaDTO.setId(venta.getId());
        ventaDTO.setFecha(venta.getFecha());
        
        List<ProductoVentaDTO> productos = new ArrayList<>();
        for (ProductoVenta productoVenta : venta.getProductos()) {
            Producto producto = productoVenta.getProducto();
            ProductoDTO productoDTO = new ProductoDTO(producto.getNombre(), producto.getSKU(), producto.getMarca(), producto.getColor());
            int cantidad = productoVenta.getCantidad();
            double precioUnitario = productoVenta.getPrecioUnitario();
            ProductoVentaDTO productoVentaDTO = new ProductoVentaDTO(productoDTO, cantidad, precioUnitario);
            productos.add(productoVentaDTO);
        }
        ventaDTO.setProductos(productos);
        
        ventaDTO.setVendedorId(venta.getVendedorId());
        
        FacturaDTO factura = new FacturaDTO();
        factura.setFolioFactura(venta.getFactura().getFolioFactura());
        factura.setFechaEmision(venta.getFactura().getFechaEmision());
        ventaDTO.setFactura(factura);
        
        DetallesVentaDTO detallesVentaDTO = new DetallesVentaDTO();
        detallesVentaDTO.setSubtotal(venta.getDetallesVenta().getSubtotal());
        detallesVentaDTO.setIva(venta.getDetallesVenta().getIva());
        detallesVentaDTO.setTotal(venta.getDetallesVenta().getTotal());
        detallesVentaDTO.setFormaPago(venta.getDetallesVenta().getFormaPago());
        detallesVentaDTO.setMetodoPago(venta.getDetallesVenta().getMetodoPago());
        ventaDTO.setDetallesVenta(detallesVentaDTO);
        
        return ventaDTO;
    }
    
    /**
     * Convierte la DTO a entidad.
     *
     * @param ventaDTO DTO a convertir
     * @return Regresa la entidad creada
     */
    private Venta convertirEntidad(VentaDTO ventaDTO) {
        Venta venta = new Venta();
        venta.setId(ventaDTO.getId());
        venta.setFecha(ventaDTO.getFecha());
        
        List<ProductoVenta> productos = new ArrayList<>();
        for (ProductoVentaDTO productoVentaDTO : ventaDTO.getProductos()) {
            ProductoDTO productoDTO = productoVentaDTO.getProducto();
            Producto producto = new Producto(productoDTO.getNombre(), productoDTO.getSKU(), productoDTO.getMarca(), productoDTO.getColor());
            int cantidad = productoVentaDTO.getCantidad();
            double precioUnitario = productoVentaDTO.getPrecioUnitario();
            ProductoVenta productoVenta = new ProductoVenta(producto, cantidad, precioUnitario);
            productos.add(productoVenta);
        }
        venta.setProductos(productos);
        
        venta.setVendedorId(ventaDTO.getVendedorId());
        
        Factura factura = new Factura();
        factura.setFolioFactura(ventaDTO.getFactura().getFolioFactura());
        factura.setFechaEmision(ventaDTO.getFactura().getFechaEmision());
        venta.setFactura(factura);
        
        DetallesVenta detallesVenta = new DetallesVenta();
        detallesVenta.setSubtotal(ventaDTO.getDetallesVenta().getSubtotal());
        detallesVenta.setIva(ventaDTO.getDetallesVenta().getIva());
        detallesVenta.setTotal(ventaDTO.getDetallesVenta().getTotal());
        detallesVenta.setFormaPago(ventaDTO.getDetallesVenta().getFormaPago());
        detallesVenta.setMetodoPago(ventaDTO.getDetallesVenta().getMetodoPago());
        venta.setDetallesVenta(detallesVenta);
        
        return venta;
    }
}
