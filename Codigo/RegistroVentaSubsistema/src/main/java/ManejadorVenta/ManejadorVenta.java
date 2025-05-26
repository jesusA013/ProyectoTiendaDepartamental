package ManejadorVenta;

import BOs.VentasBO;
import DTOs.DetallesVentaDTO;
import DTOs.FacturaDTO;
import DTOs.ProductoDTO;
import DTOs.ProductoVentaDTO;
import DTOs.VentaDTO;
import Excepciones.NegocioException;
import Interface.IRegistroVenta;
import Interfaces.INavegador;
import Interfaces.IProductoBO;
import Interfaces.IVentasBO;
import RegistroVentaException.RegistroException;
import java.util.Date;
import java.util.List;
import java.util.regex.Pattern;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 *
 * @author Ángel Ruíz García - 00000248171
 */
public class ManejadorVenta implements IRegistroVenta {

    private final IVentasBO ventasNegocio = new VentasBO();
    private final IProductoBO productoNegocio;
    private static ManejadorVenta instancia;
    INavegador navegacion;

    public ManejadorVenta(IProductoBO productoNegocio) {
        this.productoNegocio = productoNegocio;
    }

    @Override
    public void setNavegador(INavegador navegador) {
        this.navegacion = navegador;
    }

    public static ManejadorVenta getInstance(IProductoBO productoNegocio) {
        if (instancia == null) {
            instancia = new ManejadorVenta(productoNegocio);
        }
        return instancia;
    }

    @Override
    public String registrarVentaTarjeta(JFrame frame, List<ProductoVentaDTO> productos, String idVendedor, String digitosTarjeta, String fechaExpiracion, String CVC) throws RegistroException {
        double subtotalProductos = 0;
        double impuestosProductos;
        double totalProductos;

        for (ProductoVentaDTO producto : productos) {
            subtotalProductos += producto.getCantidad() * producto.getPrecioUnitario();
        }
        impuestosProductos = subtotalProductos * 0.06;
        totalProductos = subtotalProductos + impuestosProductos;

        VentaDTO ventaDTO = new VentaDTO();
        ventaDTO.setFecha(new Date());
        ventaDTO.setProductos(productos);
        ventaDTO.setIdVendedor(idVendedor);

        FacturaDTO facturaDTO = new FacturaDTO();
        DetallesVentaDTO detallesVentaDTO = new DetallesVentaDTO();
        detallesVentaDTO.setSubtotal(subtotalProductos);
        detallesVentaDTO.setIva(impuestosProductos);
        detallesVentaDTO.setTotal(totalProductos);
        detallesVentaDTO.setFormaPago("Transferencia");
        detallesVentaDTO.setMetodoPago("Tarjeta");

        ventaDTO.setFactura(facturaDTO);
        ventaDTO.setDetallesVenta(detallesVentaDTO);

        try {
            VentaDTO resultado = this.ventasNegocio.insertarVenta(ventaDTO);
            for (ProductoVentaDTO productoVenta : productos) {
                productoVenta.getProducto().setStock(productoVenta.getProducto().getStock() - productoVenta.getCantidad());
                this.productoNegocio.actualizarProducto(productoVenta.getProducto());
            }
            JOptionPane.showMessageDialog(frame, "Venta registrada con éxito con el ID: " + resultado.getIdVenta());
            navegacion.irASeleccionMetodoPago();
            return resultado.getIdVenta();
        } catch (NegocioException ex) {
            JOptionPane.showMessageDialog(frame, "Error al registrar la venta: " + ex.getMessage());
            throw new RegistroException("Error " + ex.getMessage());
        }
    }

    @Override
    public String registrarVentaEfectivo(JFrame frame, List<ProductoVentaDTO> productos, String idVendedor, String efectivoEntregado, String cambio) throws RegistroException {
        double subtotalProductos = 0;
        double impuestosProductos;
        double totalProductos;

        for (ProductoVentaDTO producto : productos) {
            subtotalProductos += producto.getCantidad() * producto.getPrecioUnitario();
        }
        impuestosProductos = subtotalProductos * 0.06;
        totalProductos = subtotalProductos + impuestosProductos;

        VentaDTO ventaDTO = new VentaDTO();
        ventaDTO.setFecha(new Date());
        ventaDTO.setProductos(productos);
        ventaDTO.setIdVendedor(idVendedor);

        FacturaDTO facturaDTO = new FacturaDTO();
        DetallesVentaDTO detallesVentaDTO = new DetallesVentaDTO();
        detallesVentaDTO.setSubtotal(subtotalProductos);
        detallesVentaDTO.setIva(impuestosProductos);
        detallesVentaDTO.setTotal(totalProductos);
        detallesVentaDTO.setFormaPago("En caja");
        detallesVentaDTO.setMetodoPago("Efectivo");

        ventaDTO.setFactura(facturaDTO);
        ventaDTO.setDetallesVenta(detallesVentaDTO);

        try {
            VentaDTO resultado = this.ventasNegocio.insertarVenta(ventaDTO);
            for (ProductoVentaDTO productoVenta : productos) {
                productoVenta.getProducto().setStock(productoVenta.getProducto().getStock() - productoVenta.getCantidad());
                this.productoNegocio.actualizarProducto(productoVenta.getProducto());
            }
            JOptionPane.showMessageDialog(frame, "Venta registrada con éxito con el ID: " + resultado.getIdVenta());
            navegacion.irASeleccionMetodoPago();
            return resultado.getIdVenta();
        } catch (NegocioException ex) {
            JOptionPane.showMessageDialog(frame, "Error al registrar la venta: " + ex.getMessage());
            throw new RegistroException("Error " + ex.getMessage());
        }
    }

    @Override
    public List<ProductoDTO> buscarProductos(String busqueda) throws RegistroException {
        try {
            return this.productoNegocio.buscarProductos(busqueda);
        } catch (NegocioException ex) {
            throw new RegistroException("Error al buscar productos: " + ex.getMessage());
        }
    }

    @Override
    public void facturarVenta(JFrame frame, String id, String rfc,
            String nombeRazonSocial, String calle, String numeroExt,
            String numeroInt, String colonia, String codPostal, String pais,
            String estado, String ciudadLocalidad, String delegacionMunicipio,
            String email) throws RegistroException {
        VentaDTO ventaDTO = buscarVenta(id);

        FacturaDTO facturaDTO = new FacturaDTO();
        if (!validarRFC(rfc)) {
            JOptionPane.showMessageDialog(null, "El RFC no puede estar vacio ni tener el formato incorrecto, ejemplo: GOCJ800101AAA", "RFC", JOptionPane.ERROR_MESSAGE);
            return;
        } else {
            facturaDTO.setRfc(rfc);
        }
        facturaDTO.setNombreRazon(nombeRazonSocial);
        facturaDTO.setCalle(calle);
        facturaDTO.setNumExt(numeroExt);
        facturaDTO.setNumInt(numeroInt);
        facturaDTO.setColonia(colonia);
        facturaDTO.setCodigoPostal(codPostal);
        if (!validarPais(pais)) {
            JOptionPane.showMessageDialog(null, "El pais no puede estar vacio", "RFC", JOptionPane.ERROR_MESSAGE);
            return;
        } else {
            facturaDTO.setPais(pais);
        }
        facturaDTO.setEstado(estado);
        facturaDTO.setCiudadLocalidad(ciudadLocalidad);
        facturaDTO.setDelegacionMunicipio(delegacionMunicipio);
        if (!validarEmailFactura(email)) {
            JOptionPane.showMessageDialog(null, "El correo no puede estar vacio ni tener el formato incorrecto, efemplo: nombre.apellido@dominio.mx", "Correo", JOptionPane.ERROR_MESSAGE);
            return;
        } else {
            facturaDTO.setCorreo(email);
        }

        ventaDTO.setFactura(facturaDTO);

        try {
            VentaDTO resultado = this.ventasNegocio.actualizarVenta(ventaDTO);
            JOptionPane.showMessageDialog(frame, "Venta facturada con éxito con el ID: " + resultado.getIdVenta());
            navegacion.irFacturaFinalizada(id);
        } catch (NegocioException ex) {
            JOptionPane.showMessageDialog(frame, "Error al facturar la venta: " + ex.getMessage());
            throw new RegistroException("Error " + ex.getMessage());
        }
    }

    @Override
    public VentaDTO buscarVenta(String id) throws RegistroException {
        try {
            return this.ventasNegocio.buscarPorId(id);
        } catch (NegocioException ex) {
            throw new RegistroException("Error al buscar venta: " + ex.getMessage());
        }
    }

    private boolean validarRFC(String RFC) throws RegistroException {
        if (RFC == null || RFC.isEmpty()) {
            throw new RegistroException("El RFC no puede estar vacío.");
        }
        Pattern longitudPattern = Pattern.compile("^.{12,13}$");

        if (!longitudPattern.matcher(RFC).matches()) {
            throw new RegistroException("El RFC debe tener 12 o 13 caracteres.");
        }

        return true;
    }

    private boolean validarPais(String pais) throws RegistroException {
        if (pais == null || pais.isEmpty()) {
            throw new RegistroException("El país no puede estar vacío.");
        }
        return true;
    }

    private boolean validarEmail(String email) throws RegistroException {
        // Expresión regular simple para validar formato de correo electrónico
        return email.matches("^[\\w.-]+@[\\w.-]+\\.[a-zA-Z]{2,}$");
    }
    
    private boolean validarEmailFactura(String email) throws RegistroException {
        // Expresión regular simple para validar formato de correo electrónico
        return email.matches("^(|[\\w.-]+@[\\w.-]+\\.[a-zA-Z]{2,})$");
    }
}
