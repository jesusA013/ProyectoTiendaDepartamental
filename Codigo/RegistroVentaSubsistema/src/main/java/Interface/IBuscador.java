/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Interface;

import DTOs.ProductoDTO;
import RegistroVentaException.BuscadorException;
import java.util.List;

/**
 *
 * @author gamae
 */
public interface IBuscador {

    /**
     * Este es usado para caso al intentar solo buscar una marca; Trata sobre
     * regresar una lista de los productos con la marca especificada en el
     * parametro. Tanto este metodo como los demás, son utilizados para el
     * metodo "buscar" el cual es la convinación de cada una de las anteriores.
     *
     * ES UN METODO UN POCO PESADO, POR FAVOR USARLO Y GUARDAR SU RETURN EN UNA
     * VARIABLE PARA NO ESTARLO LLAMARLO MUCHAS VECES.
     *
     * @param Marca Marca a ser filtrada para su busqueda
     * @return Regresa una List con las marcas filtradas por el parametro
     */
    List buscarMarca(String Marca);

    /**
     * Este es usado para caso al intentar solo buscar el SKU en los productos;
     * Trata sobre regresar un unico valor que sea el producto con
     * el SKU especificada en el parametro. Tanto este metodo como los demás,
     * son utilizados para el metodo "buscar" el cual es la convinación de cada
     * una de las anteriores.
     *
     * ES UN METODO UN POCO PESADO, POR FAVOR USARLO Y GUARDAR SU RETURN EN UNA
     * VARIABLE PARA NO ESTARLO LLAMARLO MUCHAS VECES.
     *
     * @param SKU SKU a ser filtrada para su busqueda
     * @return Regresa una List con las marcas filtradas por el parametro
     */
     ProductoDTO buscarSKU(String SKU);

    /**
     * Este es usado para caso al intentar solo buscar nombres; Trata sobre
     * regresar una lista de los productos con el nombre especificado en el
     * parametro, ej. si buscas "lentes" regresara una lista con productos que
     * contengan en su nombre "lentes" (lentes de sol, lentes de ver, lentes de
     * homosexual....)
     *
     * Tanto este metodo como los demás, son utilizados para el metodo "buscar"
     * el cual es la convinación de cada una de las anteriores.
     *
     * ES UN METODO UN POCO PESADO, POR FAVOR USARLO Y GUARDAR SU RETURN EN UNA
     * VARIABLE PARA NO ESTARLO LLAMARLO MUCHAS VECES.
     *
     * @param nombre nombre a ser filtrada para su busqueda
     * @return Regresa una List con el nombre filtradas por el parametro
     */
    List buscarNombre(String nombre);

    /**
     *
     * Este es usado para buscar productos como si fuera un buscador normal, es
     * la conbinación de los 3 buscadores juntos (buscarSKU, buscarMarca,
     * buscarNombre), Trata sobre regresar una lista de los productos con la
     * marca especificada en el parametro
     *
     * ES UN METODO UN POCO PESADO, POR FAVOR USARLO Y GUARDAR SU RETURN EN UNA
     * VARIABLE PARA NO ESTARLO LLAMARLO MUCHAS VECES.
     *
     *
    RIABLE PARA NO ESTARLO LLAMARLO MUCHAS VECES.
     *
     * @param prod marca,SKU o palabra clave a buscar
     * @return Regresa una List con las marcas filtradas por el parametro
     * @throws RegistroVentaException.BuscadorException Arroja una exception tipo
     * BuscadorException cuando no es encontrado ningun producto con el parametro dado
     */
    List buscar(String prod) throws BuscadorException;

}
