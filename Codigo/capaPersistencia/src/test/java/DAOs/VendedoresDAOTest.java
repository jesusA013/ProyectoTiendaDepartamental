/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package DAOs;

import Entidades.DatosFiscales;
import Entidades.Domicilio;
import Entidades.DomicilioFiscal;
import Entidades.NombreCompleto;
import Entidades.Vendedor;
import Interfaz.IConexion;
import Interfaz.IVendedorDAO;
import java.util.Date;
import java.util.List;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;

/**
 *
 * @author gaspa
 */
public class VendedoresDAOTest {
    IConexion Mongo = new Conexion();
    IVendedorDAO vendedorDAO = new VendedorDAO(Mongo.conexion());
    public VendedoresDAOTest() {
        
    }
    
    @BeforeEach
    public void setup() {
        IConexion Mongo = new Conexion();
        Mongo.conexion().getCollection("Vendedores").drop();
        IVendedorDAO vendedorDAO = new VendedorDAO(Mongo.conexion());
       
    }
    
    @AfterAll
    public static void tearDownClass() {
    }
    //@Test
    public void insertarVendedor(){
        Vendedor nuevo = new Vendedor();
        nuevo.setCurp("JUAP800101HDFXXX01");
        nuevo.setNombreCompleto(new NombreCompleto("Juan", "Pérez", "Lopez"));
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
    }
    //@Test
    public void consultarVendedores(){
        List<Vendedor> listaVendedores = vendedorDAO.obtenerTodos();
        System.out.println("Lista de vendedores: "+listaVendedores);
        assertNotNull(listaVendedores);
    }
    @Test
    public void testInsertarConsultarActualizarEliminarVendedor() {
        Vendedor vendedor = new Vendedor();
        vendedor.setNombreCompleto(new NombreCompleto("Juan", "Pérez", "López"));
        vendedor.setCurp("JUAP800101HDFXXX01");

        Vendedor insertado = vendedorDAO.insertarVendedor(vendedor);
        assertNotNull(insertado.getId());

        // Consultar
        Vendedor consultado = vendedorDAO.buscarPorId(insertado.getId());
        assertEquals("Juan", consultado.getNombreCompleto().getNombres());

        // Actualizar
        consultado.getNombreCompleto().setNombres("Pedro");
        Vendedor actualizado = vendedorDAO.actualizarVendedor(consultado);
        assertEquals("Pedro", actualizado.getNombreCompleto().getNombres());

        // Eliminar
        Vendedor eliminado = vendedorDAO.eliminarVendedor(actualizado.getId());
        assertNotNull(eliminado);
        assertNull(vendedorDAO.buscarPorId(eliminado.getId()));
    }
}
