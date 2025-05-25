package Exception;

/**
 * PersistenciaException.java
 *
 * Esta clase implementa la excepcion lanzada por los metodos de la capa
 * persistencia.
 *
 * @author Ángel Ruíz García - 00000248171
 */
public class PersistenciaException extends Exception {

    /**
     * Constructor por ausencia.
     */
    public PersistenciaException() {
    }

    /**
     * Constructor que establece un mensaje en la excepcion
     *
     * @param message Mensaje para la excepcion
     */
    public PersistenciaException(String message) {
        super(message);
    }

}
