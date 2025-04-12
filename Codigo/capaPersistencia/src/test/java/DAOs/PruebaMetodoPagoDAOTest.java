/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package DAOs;

import Entidades.MetodoEfectivo;
import Entidades.MetodoTarjeta;

/**
 *
 * @author Knocmare
 */
public class PruebaMetodoPagoDAOTest {
    
    public PruebaMetodoPagoDAOTest() {
    }

    /**
     * Prueba de la clase MetodoEfectivoDAO y MetodoTarjetaDAO.
     */
    @org.junit.jupiter.api.Test
    public void prueba() throws Exception {
        IMetodoPagoDAO tarjetaDAO = new MetodoTarjetaDAO();
        IMetodoPagoDAO efectivoDAO = new MetodoEfectivoDAO();
        
        tarjetaDAO.guardarMetodoPago(new MetodoTarjeta(1, 180.00, "1234", 12, 2030, 123));
        efectivoDAO.guardarMetodoPago(new MetodoEfectivo(2, 150.00, 200.00, 50.00));

        System.out.println("Tarjeta: " + tarjetaDAO.obtenerMetodoPagoPorId(1).getTotal());
        System.out.println("Efectivo: " + efectivoDAO.obtenerMetodoPagoPorId(2).getTotal());
    }
    
}
