package Utilidades;

import java.awt.Component;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.table.TableCellRenderer;

/**
 * JButtonRenderer.java
 *
 * Esta clase implementa la interfaz TableCellRenderer para permitir que una
 * celda de una JTable se renderice como un JButton. Puede usarse un texto fijo
 * para todos los botones o, en su defecto, usar el valor de la celda como texto
 * del botón.
 *
 * @author Ángel Ruíz García - 00000248171
 */
public class JButtonRenderer implements TableCellRenderer {
    
    private final String textoFijo;

    /**
     * Constructor que inicializa el renderizador con un texto fijo.
     *
     * @param textoFijo Texto que se mostrará en el botón de cada celda.
     */
    public JButtonRenderer(String textoFijo) {
        this.textoFijo = textoFijo;
    }

    /**
     * Retorna el componente que se usará para renderizar la celda. En este
     * caso, se devuelve un JButton con el texto especificado.
     *
     * @param table La tabla que se está renderizando.
     * @param value El valor de la celda a renderizar.
     * @param isSelected Verdadero si la celda está seleccionada.
     * @param hasFocus Verdadero si la celda tiene el foco del teclado.
     * @param row El número de fila de la celda que se está renderizando.
     * @param column El número de columna de la celda que se está renderizando.
     * @return El componente que debe usarse para dibujar la celda.
     */
    @Override
    public Component getTableCellRendererComponent(
            JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {

        JButton button = new JButton();

        // Usar texto de la celda si no hay texto fijo
        if (textoFijo == null || textoFijo.trim().isEmpty()) {
            button.setText(value != null ? value.toString() : "");
        } else {
            button.setText(textoFijo);
        }

        return button;
    }
}
