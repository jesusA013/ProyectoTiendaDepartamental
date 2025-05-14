package Implementaciones;

import BOs.ProveedorBO;
import DTOs.ProveedorTablaDTO;
import Excepciones.NegocioException;
import Interfaces.IProveedorBO;
import ModuloAlmacen.GestionProveedores.*;
import Utilidades.JButtonCellEditor;
import Utilidades.JButtonRenderer;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;

/**
 * ManejadorProveedor.java
 *
 * Esta clase implementa todas las funciones relacionas con la Gestion de
 * Proveedores.
 *
 * @author Ángel Ruíz García - 00000248171
 */
public class ManejadorProveedor implements IManejadorProveedor {
    
    private final JTable tablaProveedores = ListaProveedores.getInstancia().getTablaProveedores();
    private final IProveedorBO proveedorNegocio = new ProveedorBO();

    /**
     * Este metodo estable los botones de la tabla de proveedores.
     */
    @Override
    public void configuracionInicialTabla() {
        ActionListener onEditarClickListener = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //Metodo para detalles
                //detallesProveedor();
            }
        };
        int indiceColumnaDetalles = 5;
        TableColumnModel modeloColumnas = tablaProveedores.getColumnModel();
        modeloColumnas.getColumn(indiceColumnaDetalles)
                .setCellRenderer(new JButtonRenderer("Detalles"));
        modeloColumnas.getColumn(indiceColumnaDetalles)
                .setCellEditor(new JButtonCellEditor("Detalles", onEditarClickListener));

        ActionListener onEliminarClickListener = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //Metodo para editar
                //editarProveedor();
            }
        };
        int indiceColumnaEditar = 6;
        modeloColumnas = tablaProveedores.getColumnModel();
        modeloColumnas.getColumn(indiceColumnaEditar)
                .setCellRenderer(new JButtonRenderer("Editar"));
        modeloColumnas.getColumn(indiceColumnaEditar)
                .setCellEditor(new JButtonCellEditor("Editar", onEliminarClickListener));
    }

    @Override
    public void getIdSeleccionadoTabla() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void buscarTabla() {
        try {
            List<ProveedorTablaDTO> proveedorTablaLista = this.proveedorNegocio.listaProveedores();
            DefaultTableModel modelo = (DefaultTableModel) this.tablaProveedores.getModel();
            modelo.setRowCount(0);
            this.cargarListaProveedores(proveedorTablaLista);
        } catch (NegocioException ex) {
            System.out.println(ex.getMessage());
        }
    }
    
    private void cargarListaProveedores(List<ProveedorTablaDTO> listaProveedores) {
        DefaultTableModel modeloTabla = (DefaultTableModel) this.tablaProveedores.getModel();

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
    
    
}
