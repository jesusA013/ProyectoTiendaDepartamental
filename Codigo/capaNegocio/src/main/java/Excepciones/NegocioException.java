package Excepciones;

/**
 * NegocioException.java
 *
 * Esta clase implementa la excepcion lanzada por los metodos de las clases de
 * capaNegocio.
 *
 * @author Ángel Ruíz García - 248171
 */
public class NegocioException extends Exception {

    /**
     * Constructor por omision
     */
    public NegocioException() {
        super();
    }

    /**
     * Constructor que establece un mensaje en la excepcion
     *
     * @param msj Mensaje para la excepcion
     */
    public NegocioException(String msj) {
        super(msj);
    }
}
