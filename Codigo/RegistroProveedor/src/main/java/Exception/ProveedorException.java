/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Exception;

/**
 * ProveedorException.java
 *
 * Esta clase implementa la excepcion lanzada por los metodos de la clase
 * ManejadorProveedor
 *
 * @author Ángel Ruíz García - 248171
 */
public class ProveedorException extends Exception {

    /**
     * Constructor por omisión.
     */
    public ProveedorException() {
    }

    /**
     * Constructor que establece un mensaje en la excepcion.
     *
     * @param message Mensaje de error de la excepción
     */
    public ProveedorException(String message) {
        super(message);
    }

}
