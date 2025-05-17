package DAOs;

import Entidades.Proveedor;
import Entidades.ProveedorInformacionBasica;
import Entidades.ProveedorInformacionComercial;
import Entidades.ProveedorInformacionContacto;
import Entidades.ProveedorInformacionGestion;
import Exception.PersistenciaException;
import Interfaz.IConexion;
import Interfaz.IProveedorDAO;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;

/**
 *
 * @author Ángel Ruíz García - 00000248171
 */
public class ProveedorDAOTest {
    
    IConexion Mongo;
    IProveedorDAO proveedorDAO;
    public ProveedorDAOTest() {
        
    }
    
    @BeforeEach
    public void setup() {
        Mongo = new Conexion();
        Mongo.conexion().getCollection("Proveedores").drop();
        proveedorDAO = new ProveedorDAO(Mongo.conexion());
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
        
        Proveedor insertado = proveedorDAO.guardarProveedor(proveedor);
        assertNotNull(insertado.getIdProveedor());

        // Consultar
        Proveedor consultado = proveedorDAO.obtenerProveedorPorId(insertado.getIdProveedor());
        assertEquals("Amazon Business", consultado.getBasica().getNombreProveedor());

        // Actualizar
        consultado.getBasica().setNombreProveedor("Procter & Gamble");
        Proveedor actualizado = proveedorDAO.editarProveedor(consultado);
        assertEquals("Procter & Gamble", actualizado.getBasica().getNombreProveedor());
    }
    
}
