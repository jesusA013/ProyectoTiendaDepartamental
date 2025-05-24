/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAOs;

import Entidades.DatosFiscales;
import Entidades.DetallesVenta;
import Entidades.Domicilio;
import Entidades.DomicilioFiscal;
import Entidades.Factura;
import Entidades.NombreCompleto;
import Entidades.Producto;
import Entidades.ProductoVenta;
import Entidades.Proveedor;
import Entidades.ProveedorInformacionBasica;
import Entidades.ProveedorInformacionComercial;
import Entidades.ProveedorInformacionContacto;
import Entidades.ProveedorInformacionGestion;
import Entidades.Vendedor;
import Entidades.Venta;
import Exception.PersistenciaException;
import Interfaz.IProveedorDAO;
import Interfaz.IVendedorDAO;
import Interfaz.IVentasDAO;
import java.util.Date;
import org.bson.types.ObjectId;

/**
 *
 * @author gaspa CLASE TEMPORAL PARA REALIZAR PRUEBAS
 */
public class DAOPruebas {

    IVentasDAO ventasDAO = new VentasDAO();
    IVendedorDAO vendedorDAO = new VendedorDAO();
    IProveedorDAO proveedorDAO = new ProveedorDAO();

    public void insertarVenta() throws PersistenciaException {
        Producto producto1 = new Producto("Lentes de Sol", "23SAD23", "WER", "Verde");
        Producto producto2 = new Producto("Pantuflas", "F2F24", "FW", "Negro");

        ProductoVenta productoVenta1 = new ProductoVenta();
        productoVenta1.setProducto(producto1);
        productoVenta1.setCantidad(2);
        productoVenta1.setPrecioUnitario(150);

        ProductoVenta productoVenta2 = new ProductoVenta();
        productoVenta2.setProducto(producto2);
        productoVenta2.setCantidad(1);
        productoVenta2.setPrecioUnitario(370);

        Factura factura = new Factura();
        factura.setFolioFactura("FAC-001");
        factura.setFechaEmision(new Date());

        DetallesVenta detalles = new DetallesVenta();
        detalles.setSubtotal(1500);
        detalles.setIva(40);
        detalles.setTotal(1540);
        detalles.setMetodoPago("Pago en una sola exhibición");

        Venta venta = new Venta();
        venta.setFecha(new Date());
        venta.getProductos().add(productoVenta1);
        venta.getProductos().add(productoVenta2);
        venta.setVendedorId(new ObjectId("6823b93d2b4a9e356644152e"));
        venta.setFactura(factura);
        venta.setDetallesVenta(detalles);

        // 4. Insertar la venta
        ventasDAO.insertarVenta(venta);
    }

    public void insertarVendedor() {

        Vendedor nuevo = new Vendedor();
        nuevo.setCurp("JUAP800101HDFXXX01");
//        nuevo.setNombreCompleto(new NombreCompleto("Juan", "Pérez", "Lopez"));
        nuevo.setFechaNacimiento(new Date());
        nuevo.setEstadoCivil("Soltero");

        Domicilio domicilio = new Domicilio();
        domicilio.setCalle("Av. Reforma 123");
        domicilio.setDelegacionMunicipio("Benito Juárez");
        domicilio.setCiudadLocalidad("Ciudad de México");
        domicilio.setCodigoPostal("03100");
        nuevo.setDomicilio(domicilio);

        DatosFiscales datosFiscales = new DatosFiscales();
        datosFiscales.setRfc("JUAP800101XXX");
        DomicilioFiscal domicilioFiscal = new DomicilioFiscal();
        domicilioFiscal.setCalle("Av. Reforma 123");
        domicilioFiscal.setCiudadLocalidad("Ciudad de México");
        domicilioFiscal.setDelegacionMunicipio("Benito Juárez");
        domicilioFiscal.setCodigoPostal("03100");
        datosFiscales.setDomicilioFiscal(domicilioFiscal);
        datosFiscales.setCorreo("juan@gmail.com");
        nuevo.setDatosFiscales(datosFiscales);

        vendedorDAO.insertarVendedor(nuevo);
        System.out.println("Vendedor insertado correctamente.");
    }

    public void insertarProveedor() throws PersistenciaException {
        ProveedorInformacionBasica basica = new ProveedorInformacionBasica();
        basica.setNombreProveedor("Amazon Business");

        ProveedorInformacionContacto contacto = new ProveedorInformacionContacto();
        contacto.setContacto("Ricardo Mendez");
        contacto.setTelefono("+55 2345678790");
        contacto.setCorreo("RicardoMendez@gmail.com");
        contacto.setDireccion("Av. Jalisco 123");
        contacto.setPaginaWeb("https://www.ricardeza.com.mx");

        ProveedorInformacionComercial comercial = new ProveedorInformacionComercial();
        comercial.setRfc("AMB980102XXX");
        comercial.setFormaPago("Transferencia electrónica");
        comercial.setTerminoPago("30 días");
        comercial.setMoneda("MXN");

        ProveedorInformacionGestion gestion = new ProveedorInformacionGestion();
        gestion.setFechaAlta(new Date());
        gestion.setEstado("Activo");
        gestion.setComentarios("Proveedor confiable con entrega en tiempo.");

        Proveedor proveedor = new Proveedor();
        proveedor.setBasica(basica);
        proveedor.setContacto(contacto);
        proveedor.setComercial(comercial);
        proveedor.setGestion(gestion);

        proveedorDAO.guardarProveedor(proveedor);
    }

    public static void main(String[] args) throws PersistenciaException {
        DAOPruebas pruebas = new DAOPruebas();
        pruebas.insertarVenta();
    }
}
