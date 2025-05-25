package DAOs;

import Entidades.Proveedor;
import Entidades.ProveedorInformacionBasica;
import Entidades.ProveedorInformacionComercial;
import Entidades.ProveedorInformacionContacto;
import Entidades.ProveedorInformacionGestion;
import Exception.PersistenciaException;
import Interfaz.IProveedorDAO;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Prueba adaptada para DAO en memoria.
 */
public class ProveedorDAOTest {

    IProveedorDAO proveedorDAO;

    @BeforeEach
    public void setup() {
        proveedorDAO = new ProveedorDAO();
    }

    @Test
    public void testInsertarConsultarActualizarProveedor() throws PersistenciaException {
        ProveedorInformacionBasica basica = new ProveedorInformacionBasica();
        basica.setNombreProveedor("Amazon Business");

        ProveedorInformacionContacto contacto = new ProveedorInformacionContacto();
        ProveedorInformacionComercial comercial = new ProveedorInformacionComercial();
        ProveedorInformacionGestion gestion = new ProveedorInformacionGestion();

        Proveedor proveedor = new Proveedor();
        proveedor.setBasica(basica);
        proveedor.setContacto(contacto);
        proveedor.setComercial(comercial);
        proveedor.setGestion(gestion);

        // Insertar
        Proveedor insertado = proveedorDAO.guardarProveedor(proveedor);
        assertNotNull(insertado.getIdProveedor());

        // Consultar
        Proveedor consultado = proveedorDAO.obtenerProveedorPorId(insertado.getIdProveedor());
        assertNotNull(consultado);
        assertEquals("Amazon Business", consultado.getBasica().getNombreProveedor());

        // Actualizar
        consultado.getBasica().setNombreProveedor("Procter & Gamble");
        Proveedor actualizado = proveedorDAO.editarProveedor(consultado);
        assertEquals("Procter & Gamble", actualizado.getBasica().getNombreProveedor());
    }
}
