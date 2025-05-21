/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Interfaz;

//import Entidades.

/**
 *
 * @author melis
 */
public interface IGestorVendedores {
    
    boolean validarFormatoRFC(String rfc);
    boolean validarRFCDuplicado(String rfc);
    boolean validarLongitudMinimaNombre();
    boolean validarLongitudMaximaNombre();
    boolean validarLongitudRFC(String rfc);
    boolean validarFechaNacimientoMes(int mes);
    boolean validarFechaNacimientoAño(int año);
    boolean validarFechaNacimientoDia(int dia);
    boolean validarDomicilio(String domicilio);
    boolean validarLongitudCurp(String curp);
    boolean validarMunicipio(String municipio);
    boolean validarCiudad(String ciudad);
    boolean validarRutaFoto(String foto);
  //  VendedorDTO registrarVendedor(NuevoVendedorDTO nuevoVendedor);
}
