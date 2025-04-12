/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Observer;

import Interface.inventarioObservador;

/**
 *
 * @author melis
 */
public class AlertaBajoStock implements inventarioObservador {

    private int limiteStock;

    /*
    *Constructor por omision
     */
    public AlertaBajoStock() {
    }

    /*
    *Constructor que iniciliza los atributos
     */
    public AlertaBajoStock(int limiteStock) {
        this.limiteStock = limiteStock;
    }

    /*
implementacion del metodo de la interfaz que condiuciona 
    el manejo de las piezas    */
    @Override
    public void actualizar(String producto, int nuevoStock) {
        if (nuevoStock < limiteStock) {
            System.out.println("Unidades insoficientes");
        }
    }

}
