package Interfaces;

import Excepciones.ProveedorException;

/**
 *
 * @author gaspa
 */
public interface INavegador {

    void irAMenuPrincipal();

    void irASeleccionMetodoPago();

    void irVentaFinalizada(String id);

    void irFacturaFinalizada(String id);

    void mostrarPanelProveedorDetalles(String id) throws ProveedorException;

    void mostrarPanelProveedorEditar(String id) throws ProveedorException;

    public void mostrarPanelProveedorNuevo();

    void mostrarPanelProveedoresLista();
}
