package Implementaciones;

import BOs.ProveedorBO;
import DTOs.ProveedorDTO;
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
import java.util.List;
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
    public ProveedorDTO registrarProveedor(ProveedorDTO proveedorDTO) throws ProveedorException {
        try {
            return this.proveedorNegocio.guardarProveedor(proveedorDTO);
        } catch (NegocioException ex) {
            throw new ProveedorException("Error " + ex.getMessage());
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
    public ProveedorDTO editarProveedor(ProveedorDTO proveedorDTO) throws ProveedorException {
        try {
            return this.proveedorNegocio.editarProveedor(proveedorDTO);
        } catch (NegocioException ex) {
            throw new ProveedorException("Error " + ex.getMessage());
        }
    }
    
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
     * @param id 
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
//
//    private void eliminar() {
//        Long id = this.getIdSeleccionadoTabla();
//        System.out.println("El id que se va a eliminar es " + id);
//
//        int confirmacion = JOptionPane.showConfirmDialog(this, 
//                "¿Estás seguro de que deseas eliminar el estudiante con el id institucional: " + id + "?", 
//                "Confirmar eliminación", JOptionPane.YES_NO_OPTION);
//
//        if (confirmacion == JOptionPane.YES_OPTION) {
//            try {
//                estudianteNegocio.eliminar(id);
//                JOptionPane.showMessageDialog(this, "Estudiante eliminado con éxito con el id institucional: " + id);
//            } catch (NegocioException e) {
//                JOptionPane.showMessageDialog(this, "Error al eliminar el estudiante: " + e.getMessage());
//            }
//        } else {
//            JOptionPane.showMessageDialog(this, "Eliminación cancelada.");
//        }
//    }
//
//    private Long getIdSeleccionadoTabla() {
//        int indiceFilaSeleccionada = this.tablaEstudiantes.getSelectedRow();
//        if (indiceFilaSeleccionada != -1) {
//
//            EstudianteTablaDTO estudianteSeleccionado = estudiantesLista.get(indiceFilaSeleccionada);
//
//            return estudianteSeleccionado.getIdEstudiante();
//        } else {
//            return 0L;
//        }
//    }
    
}
