package BOs;

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
import Interfaz.IVentasDAO;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * VentaBO.java
 *
 * Esta clase representa una venta realizada en el sistema.
 *
 * @author
 */
public class VentasBO implements IVentasBO {

    private final IVentasDAO ventaDAO;

    /**
     * Inicializa el atributo para usar la DAO.
     */
    public VentasBO() {
        this.ventaDAO = new VentasDAO();
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
    public VentaDTO buscarPorId(String id) throws NegocioException {
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
    public VentaDTO eliminarVenta(String id) throws NegocioException {
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
        ventaDTO.setIdVentaDTO(venta.getIdVenta());
        ventaDTO.setFecha(venta.getFecha());

        List<ProductoVentaDTO> productos = new ArrayList<>();
        for (ProductoVenta productoVenta : venta.getProductos()) {
            Producto producto = productoVenta.getProducto();
            ProductoDTO productoDTO = new ProductoDTO(producto.getNombre(), producto.getSKU(), producto.getMarca(), producto.getColor(), producto.getPrecio());
            int cantidad = productoVenta.getCantidad();
            double precioUnitario = productoVenta.getPrecioUnitario();
            ProductoVentaDTO productoVentaDTO = new ProductoVentaDTO(productoDTO, cantidad, precioUnitario);
            productos.add(productoVentaDTO);
        }
        ventaDTO.setProductos(productos);

        ventaDTO.setIdVendedor(venta.getVendedorId());

        FacturaDTO factura = new FacturaDTO();
        factura.setFolioFactura(venta.getFactura().getFolioFactura());
        factura.setFechaEmision(venta.getFactura().getFechaEmision());
        factura.setRfc(venta.getFactura().getRfc());
        factura.setNombreRazon(venta.getFactura().getNombreRazon());
        factura.setCalle(venta.getFactura().getCalle());
        factura.setNumExt(venta.getFactura().getNumExt());
        factura.setNumInt(venta.getFactura().getNumInt());
        factura.setColonia(venta.getFactura().getColonia());
        factura.setCodigoPostal(venta.getFactura().getCodigoPostal());
        factura.setPais(venta.getFactura().getPais());
        factura.setEstado(venta.getFactura().getEstado());
        factura.setCiudadLocalidad(venta.getFactura().getCiudadLocalidad());
        factura.setDelegacionMunicipio(venta.getFactura().getDelegacionMunicipio());
        factura.setCorreo(venta.getFactura().getCorreo());
        ventaDTO.setFactura(factura);

        DetallesVentaDTO detallesVentaDTO = new DetallesVentaDTO();
        detallesVentaDTO.setSubtotal(venta.getDetallesVenta().getSubtotal());
        detallesVentaDTO.setIva(venta.getDetallesVenta().getIva());
        detallesVentaDTO.setTotal(venta.getDetallesVenta().getTotal());
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
        venta.setIdVenta(ventaDTO.getIdVentaDTO());
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

        venta.setVendedorId(ventaDTO.getIdVendedor());

        Factura factura = new Factura();
        factura.setFolioFactura(ventaDTO.getFactura().getFolioFactura());
        factura.setFechaEmision(ventaDTO.getFactura().getFechaEmision());
        factura.setRfc(ventaDTO.getFactura().getRfc());
        factura.setNombreRazon(ventaDTO.getFactura().getNombreRazon());
        factura.setCalle(ventaDTO.getFactura().getCalle());
        factura.setNumExt(ventaDTO.getFactura().getNumExt());
        factura.setNumInt(ventaDTO.getFactura().getNumInt());
        factura.setColonia(ventaDTO.getFactura().getColonia());
        factura.setCodigoPostal(ventaDTO.getFactura().getCodigoPostal());
        factura.setPais(ventaDTO.getFactura().getPais());
        factura.setEstado(ventaDTO.getFactura().getEstado());
        factura.setCiudadLocalidad(ventaDTO.getFactura().getCiudadLocalidad());
        factura.setDelegacionMunicipio(ventaDTO.getFactura().getDelegacionMunicipio());
        factura.setCorreo(ventaDTO.getFactura().getCorreo());
        venta.setFactura(factura);

        DetallesVenta detallesVenta = new DetallesVenta();
        detallesVenta.setSubtotal(ventaDTO.getDetallesVenta().getSubtotal());
        detallesVenta.setIva(ventaDTO.getDetallesVenta().getIva());
        detallesVenta.setTotal(ventaDTO.getDetallesVenta().getTotal());
        detallesVenta.setMetodoPago(ventaDTO.getDetallesVenta().getMetodoPago());
        venta.setDetallesVenta(detallesVenta);

        return venta;
    }

    @Override
    public List<VentaDTO> obtenerVentas(String idVendedor) throws NegocioException {
        try {
            List<Venta> lista = ventaDAO.buscarVentas(idVendedor);
            if (lista.isEmpty()) {
                throw new NegocioException("No hay ventas registradas.");
            }
            return lista.stream().map(this::convertirDTO).collect(Collectors.toList());
        } catch (PersistenciaException ex) {
            throw new NegocioException("No hay ventas registradas.");
        }
    }
}
