/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Interfaces;

import Excepciones.ProveedorException;
import org.bson.types.ObjectId;

/**
 *
 * @author gaspa
 */
public interface INavegador {
    void irAMenuPrincipal();
    void irASeleccionMetodoPago();
    void irAGraciasPorSuCompra();
    void mostrarPanelProveedorDetalles(ObjectId id) throws ProveedorException;
    void mostrarPanelProveedorEditar(ObjectId id) throws ProveedorException;
    public void mostrarPanelProveedorNuevo();
    void mostrarPanelProveedoresLista();
}
