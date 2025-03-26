/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package control;

/**
 *
 * @author Jesus
 */
import interfaces.*;
import javax.swing.*;

public class ControlNavegacion {

    private static ControlNavegacion instancia;

    private JFrame pantallaActual;

    //Instancias unicas de cada pantalla
    private InicioSesion pantallaInicioSesion;
    private MenuPrincipal pantallaMenuPrincipal;
    private CarritoCompra pantallaCarritoCompra;
    private FacturaDatos pantallaFactura;

    //Creacion de cada pantalla
    public ControlNavegacion() {
        this.pantallaInicioSesion = new InicioSesion();
        this.pantallaMenuPrincipal = new MenuPrincipal();
        this.pantallaCarritoCompra = new CarritoCompra();
        this.pantallaFactura = new FacturaDatos();

    }

    public static ControlNavegacion getInstance() {
        if (instancia == null) {
            instancia = new ControlNavegacion();
        }
        return instancia;
    }

    /**
     * Este metodo
     *
     * @param nuevaPantalla pantalla que posteriormente se quiere mostrar
     */
    public void mostrarPantalla(JFrame nuevaPantalla) {
        if (pantallaActual != null) {
            pantallaActual.setVisible(false);
        }
        pantallaActual = nuevaPantalla;
        pantallaActual.setLocationRelativeTo(null);
        pantallaActual.setVisible(true);
    }

    public void irAInicioSesion() {
        pantallaInicioSesion.LimpiarCampos();
        mostrarPantalla(pantallaInicioSesion);

    }

    public void irAMenuPrincipal() {
        mostrarPantalla(pantallaMenuPrincipal);
    }
    
    public void irACarritoCompra(){
        mostrarPantalla(pantallaCarritoCompra);  
    }
    
    public void irAFacturaDatos(){
        mostrarPantalla(pantallaFactura);
    }
    
  
        
}
