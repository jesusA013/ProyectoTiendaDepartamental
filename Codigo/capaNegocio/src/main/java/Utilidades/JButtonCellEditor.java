package Utilidades;

import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.EventObject;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.event.CellEditorListener;
import javax.swing.table.TableCellEditor;

/**
 * JButtonCellEditor.java
 *
 * La claseJButtonCellEditor implementa la interfaz TableCellEditor y permite
 * insertar un JButton funcional en una celda de una JTable. Al presionar el
 * botón, se ejecuta un ActionListener proporcionado, el cual recibe como
 * comando el número de fila donde se hizo clic.
 *
 * @author Ángel Ruíz García - 00000248171
 */
public class JButtonCellEditor implements TableCellEditor {
    
    private final JButton button;
    private int row;
    private ActionListener actionListener;
    private String textoFijo;

    /**
     * Constructor que inicializa el editor con un texto fijo y una acción.
     *
     * @param textoFijo Texto que se mostrará en el botón de cada celda.
     * @param actionListener Acción que se ejecutará al hacer clic en el botón.
     */
    public JButtonCellEditor(String textoFijo, ActionListener actionListener) {
        this.button = new JButton();
        this.textoFijo = textoFijo;
        this.actionListener = actionListener;

        this.button.addActionListener((ActionEvent evt) -> {
            this.actionListener.actionPerformed(
                    new ActionEvent(this.button, ActionEvent.ACTION_PERFORMED, String.valueOf(this.row))
            );
        });
    }

    /**
     * Constructor que inicializa el editor sin texto fijo.
     *
     * @param actionListener Acción que se ejecutará al hacer clic en el botón.
     */
    public JButtonCellEditor(ActionListener actionListener) {
        this(null, actionListener); // Sin texto fijo
    }

    /**
     * Devuelve el componente del botón que será usado como editor de la celda.
     *
     * @param table Tabla en la que se edita la celda.
     * @param value Valor de la celda que se está editando.
     * @param isSelected Verdadero si la celda está seleccionada.
     * @param row Fila de la celda que se está editando.
     * @param column Columna de la celda que se está editando.
     * @return Componente JButton que editará la celda.
     */
    @Override
    public Component getTableCellEditorComponent(JTable table, Object value, boolean isSelected, int row, int column) {
        this.row = row;
        
        // Si no se especificó texto fijo, usa el valor de la celda
        if (textoFijo == null || textoFijo.trim().isEmpty()) {
            button.setText(value != null ? value.toString() : "");
        } else {
            button.setText(textoFijo);
        }

        return this.button;
    }
    
    /**
     * Retorna el valor del editor.
     *
     * @return Devuelve verdadero como marcador simbólico. El valor real se
     * maneja a través del ActionListener.
     */
    @Override public Object getCellEditorValue() { return true; }
    @Override public boolean isCellEditable(EventObject anEvent) { return true; }
    @Override public boolean shouldSelectCell(EventObject anEvent) { return true; }
    @Override public boolean stopCellEditing() { return true; }
    @Override public void cancelCellEditing() {}
    @Override public void addCellEditorListener(CellEditorListener l) {}
    @Override public void removeCellEditorListener(CellEditorListener l) {}
}
