/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ManejadorVenta;

import BOs.CarritoBO;
import BOs.ProductoBO;
import DTOs.ProductoDTO;
import DTOs.VentaDTO;
import Interface.IRegistroVenta;
import RegistroVentaException.RegistroException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.regex.Pattern;

/**
 *
 * @author gamae
 */
public class ManejadorVenta implements IRegistroVenta {

    //Lista de ProductoDTOs que se mostraran en los JFrames
    private List<ProductoDTO> productos = new ArrayList<>();
    
    private ProductoDTO producto1 = new ProductoDTO("Tenis Air Force 1", "1511617", 100.00, "Nike", "Blanco", 5);
    private ProductoDTO producto2 = new ProductoDTO("Camiseta Adidas", "1511622", 40.00, "Adidas", "Negro", 10);
    private ProductoDTO producto3 = new ProductoDTO("Mochila Under Armour", "1511633", 30.00, "Under Armour", "Azul", 7);
    private ProductoDTO producto4 = new ProductoDTO("Lentes de sol Gucci", "1511634",80.00,"Gucci","Negro", 4);
    private ProductoDTO producto5 = new ProductoDTO("Sudadera Puma", "1511644", 50.00, "Puma", "Rojo", 8);
    
   public ManejadorVenta(){
       productos.add(producto1);
       productos.add(producto2);
       productos.add(producto3);
       productos.add(producto4);
       productos.add(producto5);
   }
   
   public List<ProductoDTO> obtenerProductos(){
       return productos;
   }
    
 
   
   
    @Override
    public boolean validarRFC(String RFC) throws RegistroException {
        if (RFC == null || RFC.isEmpty()) {
            throw new RegistroException("El RFC no puede estar vacío.");
        }
        Pattern longitudPattern = Pattern.compile("^.{12,13}$");

        if (!longitudPattern.matcher(RFC).matches()) {
            throw new RegistroException("El RFC debe tener 12 o 13 caracteres.");
        }

        return true;
    }

    @Override
    public boolean validarPais(String pais) throws RegistroException {
        if (pais == null || pais.isEmpty()) {
            throw new RegistroException("El país no puede estar vacío.");
        }
        Pattern contenidoPattern = Pattern.compile("^[A-Za-zÁÉÍÓÚÑáéíóúñ\\s]+$");

        if (!contenidoPattern.matcher(pais).matches()) {
            throw new RegistroException("El país debe contener solo letras y espacios.");
        }
        return true;
    }

    @Override
    public boolean validarEmail(String email) throws RegistroException {
        if (email == null || email.isEmpty()) {
            throw new RegistroException("El email no puede estar vacío.");
        }
        Pattern estructuraPattern = Pattern.compile("^[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]");
        Pattern espaciosPattern = Pattern.compile("\\s");

        if (!estructuraPattern.matcher(email).matches()) {
            throw new RegistroException("El email debe contener un '@'");
        }
        if (espaciosPattern.matcher(email).find()) {
            throw new RegistroException("El email no debe contener espacios en blanco.");
        }
        return true;
    }

    @Override
    public boolean validarRazonSocial(String razonSocial) throws RegistroException {
        if (razonSocial == null || razonSocial.isEmpty()) {
            throw new RegistroException("La razón social no puede estar vacía.");
        }
        Pattern longitudPattern = Pattern.compile("^.{1,50}$");
        Pattern contenidoPattern = Pattern.compile("^[A-Za-z0-9\\s.,&()-]+$");

        if (!longitudPattern.matcher(razonSocial).matches()) {
            throw new RegistroException("La razón social debe tener entre 1 y 50 caracteres.");
        }
        if (!contenidoPattern.matcher(razonSocial).matches()) {
            throw new RegistroException("La razón social no puede contener caracteres espciales");
        }
        return true;
    }

    @Override
    public boolean validarCalle(String calle) throws RegistroException {
        if (calle == null || calle.isEmpty()) {
            throw new RegistroException("La calle no puede estar vacía.");
        }
        Pattern longitudPattern = Pattern.compile("^.{1,100}$");
        Pattern contenidoPattern = Pattern.compile("^[A-Za-z0-9\\s.-]+$");

        if (!longitudPattern.matcher(calle).matches()) {
            throw new RegistroException("La calle debe tener entre 1 y 100 caracteres.");
        }
        if (!contenidoPattern.matcher(calle).matches()) {
            throw new RegistroException("La calle no puede contener caracteres espciales");
        }
        return true;
    }

    @Override
    public boolean validarNumeroExterior(String numExterior) throws RegistroException {
        if (numExterior == null || numExterior.isEmpty()) {
            throw new RegistroException("El número exterior no puede estar vacío.");
        }
        Pattern contenidoPattern = Pattern.compile("^[A-Za-z0-9]{1,10}$");

        if (!contenidoPattern.matcher(numExterior).matches()) {
            throw new RegistroException("El número exterior debe tener entre 1 y 10 caracteres alfanuméricos.");
        }
        return true;
    }

    /*
    Si no ponemos un numero internos nos va a salir False, dejenlo así no pasa nada
     */
    @Override
    public boolean validarNumeroInterior(String numInterior) throws RegistroException {
        if (numInterior == null) {
            return false;
        }

        Pattern contenidoPattern = Pattern.compile("^[A-Za-z0-9]{0,10}$");

        if (!contenidoPattern.matcher(numInterior).matches()) {
            throw new RegistroException("El número interior debe ser opcional o tener hasta 10 caracteres alfanuméricos.");
        }
        return true;
    }

    @Override
    public boolean validarColonia(String colonia) throws RegistroException {
        if (colonia == null || colonia.isEmpty()) {
            throw new RegistroException("La colonia no puede estar vacía.");
        }
        Pattern longitudPattern = Pattern.compile("^.{1,100}$");
        Pattern contenidoPattern = Pattern.compile("^[A-Za-z0-9\\s]+$");

        if (!longitudPattern.matcher(colonia).matches()) {
            throw new RegistroException("La colonia debe tener entre 1 y 100 caracteres.");
        }
        if (!contenidoPattern.matcher(colonia).matches()) {
            throw new RegistroException("La colonia no puede contener caracteres especiales");
        }
        return true;
    }

    @Override
    public boolean validarCodigoPostal(String codPostal) throws RegistroException {
        if (codPostal == null || codPostal.isEmpty()) {
            throw new RegistroException("El código postal no puede estar vacío.");
        }
        Pattern longitudPattern = Pattern.compile("^\\d{5}$");

        if (!longitudPattern.matcher(codPostal).matches()) {
            throw new RegistroException("El código postal debe tener 5 dígitos.");
        }
        return true;

    }

    @Override
    public boolean validarDelegacionMunicipio(String deleMunicipio) throws RegistroException {
        if (deleMunicipio == null || deleMunicipio.isEmpty()) {
            throw new RegistroException("La delegación/municipio no puede estar vacía.");
        }
        Pattern longitudPattern = Pattern.compile("^.{1,100}$");
        Pattern contenidoPattern = Pattern.compile("^[A-Za-z0-9\\s]+$");

        if (!longitudPattern.matcher(deleMunicipio).matches()) {
            throw new RegistroException("La delegación/municipio debe tener entre 1 y 100 caracteres.");
        }
        if (!contenidoPattern.matcher(deleMunicipio).matches()) {
            throw new RegistroException("La delegación/municipio no puede contener caracteres especiales.");
        }
        return true;
    }

    @Override
    public boolean validarCiudadLocalidad(String ciudadLocalidad) throws RegistroException {
        if (ciudadLocalidad == null || ciudadLocalidad.isEmpty()) {
            throw new RegistroException("La ciudad/localidad no puede estar vacía.");
        }
        Pattern longitudPattern = Pattern.compile("^.{1,100}$");
        Pattern contenidoPattern = Pattern.compile("^[A-Za-z0-9\\s]+$");

        if (!longitudPattern.matcher(ciudadLocalidad).matches()) {
            throw new RegistroException("La ciudad/localidad debe tener entre 1 y 100 caracteres.");
        }
        if (!contenidoPattern.matcher(ciudadLocalidad).matches()) {
            throw new RegistroException("La ciudad/localidad no puede tener caracteres especiales.");
        }
        return true;
    }

    private class Estados {

        static LinkedList<String> estados = new LinkedList<>();

        public Estados() {
            estados.add("Aguascalientes");
            estados.add("Baja California");
            estados.add("Baja California Sur");
            estados.add("Campeche");
            estados.add("Chiapas");
            estados.add("Chihuahua");
            estados.add("Ciudad de México");
            estados.add("Coahuila");
            estados.add("Colima");
            estados.add("Durango");
            estados.add("Estado de México");
            estados.add("Guanajuato");
            estados.add("Guerrero");
            estados.add("Hidalgo");
            estados.add("Jalisco");
            estados.add("Michoacán");
            estados.add("Morelos");
            estados.add("Nayarit");
            estados.add("Nuevo León");
            estados.add("Oaxaca");
            estados.add("Puebla");
            estados.add("Querétaro");
            estados.add("Quintana Roo");
            estados.add("San Luis Potosí");
            estados.add("Sinaloa");
            estados.add("Sonora");
            estados.add("Tabasco");
            estados.add("Tamaulipas");
            estados.add("Tlaxcala");
            estados.add("Veracruz");
            estados.add("Yucatán");
            estados.add("Zacatecas");

        }

    }

    @Override
    public boolean validarEstado(String estado) throws RegistroException {
        if (estado == null || estado.isEmpty()) {
            throw new RegistroException("El estado no puede estar vacío.");
        }
        Pattern contenidoPattern = Pattern.compile("^[A-Za-zÁÉÍÓÚÑáéíóúñ\\s]+$");

        if (!contenidoPattern.matcher(estado).matches()) {
            throw new RegistroException("El estado debe contener solo letras y espacios.");
        }

        if (!Estados.estados.contains(estado)) {
            throw new RegistroException("El estado tiene que existir en el territorio mexicano");
        }
        return true;
    }

    @Override
    public boolean validarPago() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public double calcularTotal() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void cancelarVenta() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void consultarHistorialVentas() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void agregarProducto(ProductoDTO producto) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void eliminarProducto(ProductoDTO producto) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void incrementarCantidadProducto(int cant) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void disminuirCantidadProducto(int cant) throws RegistroException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public ProductoBO consultarCatalogoProducto() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public boolean validarStock() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public CarritoBO regresarCarrito() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public boolean seleccionMetodoPagoTarjeta() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public boolean seleccionMetodoPagoEfectivo() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void regresarMetodoPago() throws RegistroException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void generarFactura() throws RegistroException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void cancelarFacturacion() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void registrarVenta() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

}
