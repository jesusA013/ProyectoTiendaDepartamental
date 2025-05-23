package Excepciones;

/**
 * ProveedorException.java
 * 
 * Esta clase implementa la excepcion lanzada por los metodos de las clases que
 * implementan la interfaz IManejadorProveedor.
 * 
 * @author Ángel Ruíz García - 00000248171
 */
public class ProveedorException extends Exception {
    
    /**
     * Constructor por omision.
     */
    public ProveedorException() {
    }

    /**
     * Constructor que establece un mensaje en la excepcion
     *
     * @param message Mensaje para la excepcion
     */
    public ProveedorException(String message) {
        super(message);
    }
}
