package BOs;

import DAOs.ProveedorDAO;
import DTOs.ProveedorDTO;
import Entidades.Proveedor;
import Interfaces.IProveedorBO;
import Interfaz.IProveedorDAO;
import java.util.List;

/**
 * ProveedorBO.java
 *
 * Esta clase objectos negocio actua como intermediario con la DAO de
 * Proveedores.
 *
 * @author Ángel Ruíz García - 00000248171
 */
public class ProveedorBO implements IProveedorBO {

    private IProveedorDAO proveedorDAO;
    //MongoDatabase database;

    /**
     * Inicializa el atributo al valor de su parámetro.
     */
    public ProveedorBO() {
        //this.proveedorDAO = new ProveedorDAO();
    }

    @Override
    public ProveedorDTO guardarProveedor(ProveedorDTO proveedorDTO) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public ProveedorDTO editarProveedor(ProveedorDTO proveedorDTO) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    public ProveedorDTO obtenerProveedorPorId(Object idProveedor) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public List<ProveedorDTO> listaProveedor() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    private ProveedorDTO convertirDTO(Proveedor proveedor) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    private Proveedor convertirEntidad(ProveedorDTO proveedorDTO) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

}
