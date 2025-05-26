package DAOs;

import Entidades.DatosFiscales;
import Entidades.Domicilio;
import Entidades.DomicilioFiscal;
import Entidades.Vendedor;
import Interfaz.IVendedorDAO;
import java.util.List;
import java.util.UUID;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

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

    @Test
    public void testInsertarConsultarActualizarEliminarVendedor() {
        // Crear vendedor
        Vendedor vendedor = new Vendedor();
        String idVendedor = UUID.randomUUID().toString();
        vendedor.setIdVendedor(idVendedor);
        vendedor.setNombreCompleto("Juan Pérez López");
        vendedor.setCurp("JUAP800101HDFXXX01");

        // Datos opcionales
        Domicilio domicilio = new Domicilio();
        domicilio.setCalle("Av. Reforma 123");
        domicilio.setDelegacionMunicipio("Benito Juárez");
        domicilio.setCiudadLocalidad("Ciudad de México");
        domicilio.setCodigoPostal("03100");
        vendedor.setDomicilio(domicilio);
        vendedor.setRfc("JUAP800101XXX");

        // Insertar
        Vendedor insertado = vendedorDAO.insertarVendedor(vendedor);
        assertNotNull(insertado);
        assertEquals(idVendedor, insertado.getIdVendedor());

        // Consultar por ID
        Vendedor consultado = vendedorDAO.buscarPorId(idVendedor);
        assertNotNull(consultado);
        assertEquals("Juan Pérez López", consultado.getNombreCompleto());

        // Consultar todos
        List<Vendedor> listaVendedores = vendedorDAO.obtenerTodos();
        assertNotNull(listaVendedores);
        assertFalse(listaVendedores.isEmpty());

        // Buscar por CURP
        Vendedor encontradoPorCurp = vendedorDAO.buscarPorCURP("JUAP800101HDFXXX01");
        assertNotNull(encontradoPorCurp);
        assertEquals(idVendedor, encontradoPorCurp.getIdVendedor());

        // Actualizar
        consultado.setNombreCompleto("Pedro López");
        boolean actualizado = vendedorDAO.actualizarVendedor(consultado);
        assertTrue(actualizado);

        Vendedor actualizadoVendedor = vendedorDAO.buscarPorId(idVendedor);
        assertEquals("Pedro López", actualizadoVendedor.getNombreCompleto());

        // Eliminar
        Vendedor eliminado = vendedorDAO.eliminarVendedor(idVendedor);
        assertNotNull(eliminado);
        assertEquals("Pedro López", eliminado.getNombreCompleto());

        // Verificar que ya no exista
        Vendedor consultadoDespuesDeEliminar = vendedorDAO.buscarPorId(idVendedor);
        assertNull(consultadoDespuesDeEliminar);
    }
}
