/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Interface;

import DTOs.ProductoDTO;
import BOs.ProductoBO;
import DTOs.ProductoVentaDTO;
import Interfaces.INavegador;
import RegistroVentaException.RegistroException;
import java.util.List;
import javax.swing.JFrame;

/**
 *
 * @author gamae
 */
public interface IRegistroVenta {

    void registrarVenta(JFrame frame, List<ProductoVentaDTO> productos) throws RegistroException;

    boolean validarPago();

    double calcularTotal();

    void cancelarVenta();

    void consultarHistorialVentas();

    void agregarProducto(ProductoDTO producto);

    void eliminarProducto(ProductoDTO producto);

    void incrementarCantidadProducto(int cant);

    void disminuirCantidadProducto(int cant) throws RegistroException;

    ProductoBO consultarCatalogoProducto();

    boolean validarStock();
    void setNavegador(INavegador navegador);
    /**
     * Este metodo hace las operaciones necesarias si nuestra compra se realiza
     * con el metodo de pago tarjeta
     *
     * @return True si fue utilizado, False si no se usó (necesario para el
     * metodo regresarMetodoPago())
     */
    boolean seleccionMetodoPagoTarjeta();

    /**
     * Este metodo hace las operaciones necesarias si nuestra compra se realiza
     * con el metodo de pago efectivo
     *
     * @return True si fue utilizado, False si no se usó (necesario para el
     * metodo regresarMetodoPago())
     */
    boolean seleccionMetodoPagoEfectivo();

    /**
     * Este metodo regresa el metodo de pago antes utilizando validandolo la
     * opción con un Boolean de los metodos seleccionMetodoPagoEfectivo() y
     * seleccionMetodoPagoTarjeta().
     *
     * @throws RegistroException realiza una exception cuando ninguno de los
     * metodos mencionado no han sido usados
     */
    void regresarMetodoPago() throws RegistroException;

    /**
     *
     * @throws RegistroException
     */
    void generarFactura() throws RegistroException;

    void cancelarFacturacion();

    /**
     * Este metodo valida el saber que el RFC está dentro de los parametros
     * permitidos para establecer que puede existir. El RFC debe tener una
     * longitud de 13 caracteres (para personas morales) o 12 caracteres (para
     * personas físicas).
     *
     * @param RFC
     * @return Regresa True si paso las pruebas necesarias
     * @throws RegistroException lanza una exception al no completar la prueba
     * al validar (indicar en el mensaje)
     */
    boolean validarRFC(String RFC) throws RegistroException;

    /**
     * Este metodo valida el saber que el pais está dentro de los parametros
     * permitidos para establecer que puede existir. el nombre no deba tener
     * caracteres numéricos ni especiales (solo letras y espacios)
     *
     * @param pais
     * @return Regresa True si paso las pruebas necesarias
     * @throws RegistroException lanza una exception al no completar la prueba
     * al validar (indicar en el mensaje)
     */
    boolean validarPais(String pais) throws RegistroException;

    /**
     * Este metodo valida el saber que el email está dentro de los parametros
     * permitidos para establecer que puede existir. Debe contener una @
     * (arroba)
     *
     * @param email
     * @return Regresa True si paso las pruebas necesarias
     * @throws RegistroException lanza una exception al no completar la prueba
     * al validar (indicar en el mensaje)
     */
    boolean validarEmail(String email) throws RegistroException;

    /**
     * Este metodo valida el saber que la razón social está dentro de los
     * parametros permitidos para establecer que puede existir. No debe estar
     * vacío y podría tener un límite de longitud (por ejemplo, 50 caracteres).
     * No debe contener caracteres no permitidos como símbolos especiales que no
     * sean necesarios
     *
     * @param razonSocial
     * @return Regresa True si paso las pruebas necesarias
     * @throws RegistroException lanza una exception al no completar la prueba
     * al validar (indicar en el mensaje)
     */
    boolean validarRazonSocial(String razonSocial) throws RegistroException;

    /**
     * Este metodo valida el saber que la calle está dentro de los parametros
     * permitidos para establecer que puede existir.No debe estar vacía y puede
     * limitarse a caracteres alfanuméricos y ciertos símbolos (como el guion o
     * punto). Puedes establecer un límite máximo de longitud, como 100
     * caracteres.
     *
     * @param calle
     * @return Regresa True si paso las pruebas necesarias
     * @throws RegistroException lanza una exception al no completar la prueba
     * al validar (indicar en el mensaje)
     */
    boolean validarCalle(String calle) throws RegistroException;

    /**
     * Este metodo valida el saber que el numero externo está dentro de los
     * parametros permitidos para establecer que puede existir.Debe ser un
     * número o una combinación válida alfanumérica. No debe contener caracteres
     * no permitidos como símbolos especiales
     *
     * @param numExterior
     * @return Regresa True si paso las pruebas necesarias
     * @throws RegistroException lanza una exception al no completar la prueba
     * al validar (indicar en el mensaje)
     */
    boolean validarNumeroExterior(String numExterior) throws RegistroException;

    /**
     * Este metodo valida el saber que el numero interior está dentro de los
     * parametros permitidos para establecer que puede existir. Puede estar
     * vacío (opcional) o Debe ser un número o una combinación válida
     * alfanumérica.
     *
     * @param numInterior
     * @return Regresa True si paso las pruebas necesarias
     * @throws RegistroException lanza una exception al no completar la prueba
     * al validar (indicar en el mensaje)
     */
    boolean validarNumeroInterior(String numInterior) throws RegistroException;

    /**
     * Este metodo valida el saber que la colonia está dentro de los parametros
     * permitidos para establecer que puede existir.Validar que no esté vacía y
     * que solo tenga caracteres alfanuméricos y espacios.Puede haber un límite
     * de longitud, por ejemplo, 100 caracteres
     *
     * @param colonia
     * @return Regresa True si paso las pruebas necesarias
     * @throws RegistroException lanza una exception al no completar la prueba
     * al validar (indicar en el mensaje)
     */
    boolean validarColonia(String colonia) throws RegistroException;

    /**
     * Este metodo valida el saber que el codigo postal está dentro de los
     * parametros permitidos para establecer que puede existir.Debe tener
     * exactamente 5 dígitos. Solo debe contener números (0-9)
     *
     * @param codPostal
     * @return Regresa True si paso las pruebas necesarias
     * @throws RegistroException lanza una exception al no completar la prueba
     * al validar (indicar en el mensaje)
     */
    boolean validarCodigoPostal(String codPostal) throws RegistroException;

    /**
     * Este metodo valida el saber que el municipio está dentro de los
     * parametros permitidos para establecer que puede existir.Debe ser un texto
     * no vacío. Validar que no tenga caracteres prohibidos y establecer un
     * límite de longitud, como 100 caracteres.
     *
     * @param deleMunicipio
     * @return Regresa True si paso las pruebas necesarias
     * @throws RegistroException lanza una exception al no completar la prueba
     * al validar (indicar en el mensaje)
     */
    boolean validarDelegacionMunicipio(String deleMunicipio) throws RegistroException;

    /**
     * Este metodo valida el saber que la ciudad o localidad está dentro de los
     * parametros permitidos para establecer que puede existir.Debe ser un texto
     * no vacío. Validar que no tenga caracteres prohibidos y establecer un
     * límite de longitud, como 100 caracteres.
     *
     * @param ciudadLocalidad
     * @return Regresa True si paso las pruebas necesarias
     * @throws RegistroException lanza una exception al no completar la prueba
     * al validar (indicar en el mensaje)
     */
    boolean validarCiudadLocalidad(String ciudadLocalidad) throws RegistroException;

    /**
     * Este metodo valida el saber que el estado está dentro de los parametros
     * permitidos para establecer que puede existir.Validar que sea uno de los
     * estados reconocidos (puedes usar una lista predefinida). No debe incluir
     * caracteres numéricos o especiales
     *
     * @param estado
     * @return Regresa True si paso las pruebas necesarias
     * @throws RegistroException lanza una exception al no completar la prueba
     * al validar (indicar en el mensaje)
     */
    boolean validarEstado(String estado) throws RegistroException;

}
