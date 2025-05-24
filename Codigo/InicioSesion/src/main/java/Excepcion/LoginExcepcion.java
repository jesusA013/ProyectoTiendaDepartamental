package Excepcion;

/**
 * LoginExcepcion.java
 *
 * Esta clase implementa la excepcion lanzada por los metodos de las clases que
 * implementan la interfaz IInicioSesion.
 *
 * @author Ángel Ruíz García - 00000248171
 */
public class LoginExcepcion extends Exception {

    /**
     * Constructor por omision.
     */
    public LoginExcepcion() {
    }

    /**
     * Constructor que establece un mensaje en la excepcion
     *
     * @param message Mensaje para la excepcion
     */
    public LoginExcepcion(String message) {
        super(message);
    }

}
