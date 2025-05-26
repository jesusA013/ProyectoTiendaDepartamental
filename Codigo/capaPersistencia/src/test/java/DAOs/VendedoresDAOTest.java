package DAOs;

import Entidades.DatosFiscales;
import Entidades.Domicilio;
import Entidades.DomicilioFiscal;
import Entidades.Vendedor;
import Interfaz.IVendedorDAO;
import java.util.Date;
import java.util.List;
import java.util.UUID;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;

/**
 *
 * @author gaspa
 */
public class VendedoresDAOTest {

    private IVendedorDAO vendedorDAO;

    @BeforeEach
    public void setup() {
        vendedorDAO = new VendedorDAO();
    }

    @AfterAll
    public static void tearDownClass() {
    }

    //@Test
    public void insertarVendedor() {
        Vendedor nuevo = new Vendedor();
        nuevo.setCurp("JUAP800101HDFXXX01");
        nuevo.setNombreCompleto("Juan Pérez Lopez");
//        nuevo.setFechaNacimiento(new Date());
//        nuevo.setEstadoCivil("Soltero");

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
//        nuevo.setDatosFiscales(datosFiscales);

        vendedorDAO.insertarVendedor(nuevo);
        assertNotNull(nuevo.getIdVendedor());
    }

    //@Test
    public void consultarVendedores() {
        Vendedor v = new Vendedor();
        v.setCurp("JUAP800101HDFXXX01");
        v.setNombreCompleto("Juan Pérez Lopez");
        vendedorDAO.insertarVendedor(v);

        List<Vendedor> listaVendedores = vendedorDAO.obtenerTodos();
        System.out.println("Lista de vendedores: " + listaVendedores);
        assertNotNull(listaVendedores);
        assertFalse(listaVendedores.isEmpty());
    }

    @Test
    public void testInsertarConsultarActualizarEliminarVendedor() {
        Vendedor vendedor = new Vendedor();
        vendedor.setIdVendedor(UUID.randomUUID().toString());
        vendedor.setNombreCompleto("Juan Pérez López");
        vendedor.setCurp("JUAP800101HDFXXX01");

        Vendedor insertado = vendedorDAO.insertarVendedor(vendedor);
        assertNotNull(insertado.getIdVendedor());

        // Consultar
        Vendedor consultado = vendedorDAO.buscarPorId(insertado.getIdVendedor());
        assertEquals("Juan Pérez López", consultado.getNombreCompleto());

        // Actualizar
//        consultado.setNombreCompleto("Pedro López");
//        Vendedor actualizado = vendedorDAO.actualizarVendedor(consultado);
//        assertEquals("Pedro López", actualizado.getNombreCompleto());
//
//        // Eliminar
//        Vendedor eliminado = vendedorDAO.eliminarVendedor(actualizado.getIdVendedor());
//        assertNotNull(eliminado);
//        assertNull(vendedorDAO.buscarPorId(eliminado.getIdVendedor()));
    }
}
