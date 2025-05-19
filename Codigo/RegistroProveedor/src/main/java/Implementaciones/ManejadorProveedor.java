package Implementaciones;

import BOs.ProveedorBO;
import DTOs.ProveedorDTO;
import DTOs.ProveedorInformacionBasicaDTO;
import DTOs.ProveedorInformacionComercialDTO;
import DTOs.ProveedorInformacionContactoDTO;
import DTOs.ProveedorInformacionGestionDTO;
import DTOs.ProveedorTablaDTO;
import Excepciones.NegocioException;
import Exception.ProveedorException;
import Interfaces.IProveedorBO;
import ModuloAlmacen.GestionProveedores.*;
import Utilidades.JButtonCellEditor;
import Utilidades.JButtonRenderer;
import control.ControlNavegacion;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;
import org.bson.types.ObjectId;

/**
 * ManejadorProveedor.java
 *
 * Esta clase implementa todas las funciones relacionas con la Gestion de
 * Proveedores.
 *
 * @author Ángel Ruíz García - 00000248171
 */
public class ManejadorProveedor implements IManejadorProveedor {
    
    private final IProveedorBO proveedorNegocio = new ProveedorBO();
    private static ManejadorProveedor instancia;
    
    public static ManejadorProveedor getInstance() {
        if (instancia == null) {
            instancia = new ManejadorProveedor();
        }
        return instancia;
    }
    
    /**
     * Este metodo estable los botones de la tabla de proveedores.
     * @param tablaProveedores
     */
    @Override
    public void configuracionInicialTabla(JTable tablaProveedores) {
        ActionListener onDetallesClickListener = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    //Metodo para detalles
                    ControlNavegacion.getInstance().mostrarPanelProveedorDetalles(getIdSeleccionadoTabla(tablaProveedores));
                } catch (ProveedorException ex) {
                    System.out.println(ex.getMessage());
                }
            }
        };
        int indiceColumnaDetalles = 5;
        TableColumnModel modeloColumnas = tablaProveedores.getColumnModel();
        modeloColumnas.getColumn(indiceColumnaDetalles)
                .setCellRenderer(new JButtonRenderer("Detalles"));
        modeloColumnas.getColumn(indiceColumnaDetalles)
                .setCellEditor(new JButtonCellEditor("Detalles", onDetallesClickListener));

        ActionListener onEditarClickListener = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    //Metodo para editar
                    ControlNavegacion.getInstance().mostrarPanelProveedorEditar(getIdSeleccionadoTabla(tablaProveedores));
                } catch (ProveedorException ex) {
                    System.out.println(ex.getMessage());
                }
            }
        };
        int indiceColumnaEditar = 6;
        modeloColumnas = tablaProveedores.getColumnModel();
        modeloColumnas.getColumn(indiceColumnaEditar)
                .setCellRenderer(new JButtonRenderer("Editar"));
        modeloColumnas.getColumn(indiceColumnaEditar)
                .setCellEditor(new JButtonCellEditor("Editar", onEditarClickListener));
    }

    @Override
    public ObjectId getIdSeleccionadoTabla(JTable tablaProveedores) {
        int filaSeleccionada = tablaProveedores.getSelectedRow();
        if (filaSeleccionada != -1) {
            String idStr = tablaProveedores.getValueAt(filaSeleccionada, 0).toString();
            return new ObjectId(idStr);
        }
        return null;
    }

    @Override
    public void buscarTabla(JTable tablaProveedores) {
        try {
            List<ProveedorTablaDTO> proveedorTablaLista = this.proveedorNegocio.obtenerListaProveedores();
            DefaultTableModel modelo = (DefaultTableModel) tablaProveedores.getModel();
            modelo.setRowCount(0);
            this.cargarListaProveedores(proveedorTablaLista, tablaProveedores);
        } catch (NegocioException ex) {
            System.out.println(ex.getMessage());
        }
    }
    
    private void cargarListaProveedores(List<ProveedorTablaDTO> listaProveedores, JTable tablaProveedores) {
        DefaultTableModel modeloTabla = (DefaultTableModel) tablaProveedores.getModel();

        if (!listaProveedores.isEmpty()) {
            listaProveedores.forEach(row -> {
                Object[] fila = new Object[5];
                fila[0] = row.getIdProveedor();
                fila[1] = row.getNombreProveedor();
                fila[2] = row.getTelefono();
                fila[3] = row.getCorreo();
                fila[4] = row.getEstado();

                modeloTabla.addRow(fila);
            });
        }
    }

    @Override
    public void registrarProveedor(JPanel panel, String nombreProveedor,
            String contacto, String telefono, String correo, String direccion,
            String paginaWeb, String rfc, String formaPago, String terminoPago,
            String moneda, String estado, String comentarios) throws ProveedorException {
        ProveedorInformacionBasicaDTO basicaNuevo = new ProveedorInformacionBasicaDTO();
        if (!validarNombre(nombreProveedor)) {
            JOptionPane.showMessageDialog(null, "El nombre del proveedor no puede estar vacio", "Nombre vacio", JOptionPane.ERROR_MESSAGE);
            return;
        } else {
            basicaNuevo.setNombreProveedor(nombreProveedor);
        }

        ProveedorInformacionContactoDTO contactoNuevo = new ProveedorInformacionContactoDTO();
        contactoNuevo.setContacto(contacto);
        if (!validarTelefono(telefono)) {
            JOptionPane.showMessageDialog(null, "El telefono no puede estar vacio ni tener letras", "Telefono", JOptionPane.ERROR_MESSAGE);
            return;
        } else {
            contactoNuevo.setTelefono(telefono);
        }
        if (!validarCorreo(correo)) {
            JOptionPane.showMessageDialog(null, "El correo no puede estar vacio ni tener el formato incorrecto, efemplo: nombre.apellido@dominio.mx", "Correo", JOptionPane.ERROR_MESSAGE);
            return;
        } else {
            contactoNuevo.setCorreo(correo);
        }
        if (!validarDireccion(direccion)) {
            JOptionPane.showMessageDialog(null, "La dirección no puede estar vacia", "Dirección", JOptionPane.ERROR_MESSAGE);
            return;
        } else {
            contactoNuevo.setDireccion(direccion);
        }
        contactoNuevo.setPaginaWeb(paginaWeb);

        ProveedorInformacionComercialDTO comercialNuevo = new ProveedorInformacionComercialDTO();
        if (!validarRFC(rfc)) {
            JOptionPane.showMessageDialog(null, "El RFC no puede estar vacio ni tener el formato incorrecto, ejemplo: GOCJ800101AAA", "RFC", JOptionPane.ERROR_MESSAGE);
            return;
        } else {
            comercialNuevo.setRfc(rfc);
        }
        if (!validarFormaPago(formaPago)) {
            JOptionPane.showMessageDialog(null, "La forma de pago no puede estar vacia", "Forma de Pago", JOptionPane.ERROR_MESSAGE);
            return;
        } else {
            comercialNuevo.setFormaPago(formaPago);
        }
        comercialNuevo.setTerminoPago(terminoPago);
        comercialNuevo.setMoneda(moneda);

        ProveedorInformacionGestionDTO gestionNuevo = new ProveedorInformacionGestionDTO();
        gestionNuevo.setFechaAlta(new Date());
        gestionNuevo.setEstado(estado);
        gestionNuevo.setComentarios(comentarios);

        ProveedorDTO proveedorNuevo = new ProveedorDTO();
        proveedorNuevo.setBasica(basicaNuevo);
        proveedorNuevo.setContacto(contactoNuevo);
        proveedorNuevo.setComercial(comercialNuevo);
        proveedorNuevo.setGestion(gestionNuevo);

        try {
            ProveedorDTO resultado = this.proveedorNegocio.guardarProveedor(proveedorNuevo);
            JOptionPane.showMessageDialog(panel, "Proveedor guardado con éxito con el ID: " + resultado.getIdProveedor());
            ControlNavegacion.getInstance().mostrarPanelProveedoresLista();
        } catch (NegocioException ex) {
            JOptionPane.showMessageDialog(panel, "Error al guardar el proveedor: " + ex.getMessage());
        }
    }

    @Override
    public ProveedorDTO obtenerProveedor(ObjectId id) throws ProveedorException {
        try {
            return this.proveedorNegocio.obtenerProveedorPorId(id);
        } catch (NegocioException ex) {
            throw new ProveedorException("Error " + ex.getMessage());
        }
    }

    @Override
    public void editarProveedor(JPanel panel, ObjectId id, String nombreProveedor,
            String contacto, String telefono, String correo, String direccion,
            String paginaWeb, String rfc, String formaPago, String terminoPago,
            String moneda, Date fecha, String estado, String comentarios) throws ProveedorException {
        ProveedorInformacionBasicaDTO basicaActualizado = new ProveedorInformacionBasicaDTO();
        if (!validarNombre(nombreProveedor)) {
            JOptionPane.showMessageDialog(null, "El nombre del proveedor no puede estar vacio", "Nombre vacio", JOptionPane.ERROR_MESSAGE);
            return;
        } else {
            basicaActualizado.setNombreProveedor(nombreProveedor);
        }

        ProveedorInformacionContactoDTO contactoActualizado = new ProveedorInformacionContactoDTO();
        contactoActualizado.setContacto(contacto);
        if (!validarTelefono(telefono)) {
            JOptionPane.showMessageDialog(null, "El telefono no puede estar vacio ni tener letras", "Telefono", JOptionPane.ERROR_MESSAGE);
            return;
        } else {
            contactoActualizado.setTelefono(telefono);
        }
        if (!validarCorreo(correo)) {
            JOptionPane.showMessageDialog(null, "El correo no puede estar vacio ni tener el formato incorrecto, efemplo: nombre.apellido@dominio.mx", "Correo", JOptionPane.ERROR_MESSAGE);
            return;
        } else {
            contactoActualizado.setCorreo(correo);
        }
        if (!validarDireccion(direccion)) {
            JOptionPane.showMessageDialog(null, "La dirección no puede estar vacia", "Dirección", JOptionPane.ERROR_MESSAGE);
            return;
        } else {
            contactoActualizado.setDireccion(direccion);
        }
        contactoActualizado.setPaginaWeb(paginaWeb);

        ProveedorInformacionComercialDTO comercialActualizado = new ProveedorInformacionComercialDTO();
        if (!validarRFC(rfc)) {
            JOptionPane.showMessageDialog(null, "El RFC no puede estar vacio ni tener el formato incorrecto, ejemplo: GOCJ800101AAA", "RFC", JOptionPane.ERROR_MESSAGE);
            return;
        } else {
            comercialActualizado.setRfc(rfc);
        }
        if (!validarFormaPago(formaPago)) {
            JOptionPane.showMessageDialog(null, "La forma de pago no puede estar vacia", "Forma de Pago", JOptionPane.ERROR_MESSAGE);
            return;
        } else {
            comercialActualizado.setFormaPago(formaPago);
        }
        comercialActualizado.setTerminoPago(terminoPago);
        comercialActualizado.setMoneda(moneda);

        ProveedorInformacionGestionDTO gestionActualizado = new ProveedorInformacionGestionDTO();
        gestionActualizado.setFechaAlta(fecha);
        gestionActualizado.setEstado(estado);
        gestionActualizado.setComentarios(comentarios);

        ProveedorDTO proveedorActualizado = new ProveedorDTO();
        proveedorActualizado.setIdProveedor(id);
        proveedorActualizado.setBasica(basicaActualizado);
        proveedorActualizado.setContacto(contactoActualizado);
        proveedorActualizado.setComercial(comercialActualizado);
        proveedorActualizado.setGestion(gestionActualizado);

        try {
            ProveedorDTO resultado = this.proveedorNegocio.editarProveedor(proveedorActualizado);
            JOptionPane.showMessageDialog(panel, "Proveedor Actualizado con éxito con el ID: " + resultado.getIdProveedor());
            ControlNavegacion.getInstance().mostrarPanelProveedoresLista();
        } catch (NegocioException ex) {
            JOptionPane.showMessageDialog(panel, "Error al actualizado el proveedor: " + ex.getMessage());
        }
    }
    
//    @Override
//    public void limpiarCamposProveedor() {
//        txtNombreProveedor.setText("");
//
//        txtContacto.setText("");
//        txtTelefono.setText("");
//        txtCorreo.setText("");
//        txtDireccion.setText("");
//        txtPaginaWeb.setText("");
//
//        txtRFC.setText("");
//        txtFormaPago.getText();
//        txtTerminoPago.getText();
//        cboMoneda.setSelectedIndex(0);
//
//        cboEstado.setSelectedIndex(0);
//        txtComentarios.setText("");
//    }
    
    @Override
    public void restaurarCamposEditar(ObjectId id) {
        try {
            ProveedorDTO proveedor = obtenerProveedor(id);
            //ProveedoresPanelEditar.getInstancia(this).setCampos(proveedor);
        } catch (ProveedorException ex) {
            System.err.println("Error al obtener proveedor: " + ex.getMessage());
        }
    }
    
    /**
     * 
     * @param id ID del proveedor
     */
    @Override
    public void restaurarCamposDetalles(ObjectId id) {
        try {
            ProveedorDTO proveedor = obtenerProveedor(id);
            //ProveedoresPanelDetalles.getInstancia(this).setCampos(proveedor);
        } catch (ProveedorException ex) {
            System.err.println("Error al obtener proveedor: " + ex.getMessage());
        }
    }
    
    private boolean validarNombre(String nombreProveedor) {
        return !(nombreProveedor == null || nombreProveedor.trim().isEmpty());
    }
    
    private boolean validarTelefono(String telefono) {
        if (telefono == null || telefono.trim().isEmpty()) {
            return false;
        }
        
        return telefono.matches("\\d{10}");
    }
    
    private boolean validarCorreo(String correo) {
        if (correo == null || correo.trim().isEmpty()) {
            return false;
        }
        
        // Expresión regular simple para validar formato de correo electrónico
        return correo.matches("^[\\w.-]+@[\\w.-]+\\.[a-zA-Z]{2,}$");
    }
    
    private boolean validarDireccion(String direccion) {
        return direccion != null && !direccion.trim().isEmpty();
    }
    
    private boolean validarRFC(String rfc) {
        if (rfc == null || rfc.trim().isEmpty()) {
            return false;
        }

        // Expresión regular para RFC válido (13 caracteres para personas físicas, 12 para morales)
        return rfc.matches("^[A-ZÑ&]{3,4}\\d{6}[A-Z0-9]{3}$");
    }
    
    private boolean validarFormaPago(String formaPago) {
        return !(formaPago == null || formaPago.trim().isEmpty());
    }
    
}
