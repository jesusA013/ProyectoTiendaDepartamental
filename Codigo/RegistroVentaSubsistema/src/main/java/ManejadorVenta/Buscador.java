/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ManejadorVenta;

import DTOs.ProductoDTO;
import Interface.IBuscador;
import RegistroVentaException.BuscadorException;
import java.util.LinkedList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author gamae
 */
public class Buscador implements IBuscador {

    List<ProductoDTO> listaBuscador = new LinkedList<>();

    public Buscador() {

    }

    @Override
    public List buscarMarca(String marca) {

        List<ProductoDTO> productosSeleccionados = new LinkedList<>();

        for (ProductoDTO producto : listaBuscador) {
            if (producto.getMarca().equalsIgnoreCase(marca)) {
                productosSeleccionados.add(producto);
            }

        }
   
        return productosSeleccionados;

    }

    @Override
    public ProductoDTO buscarSKU(String SKU) {

        List<ProductoDTO> productosSeleccionados = new LinkedList<>();

        for (ProductoDTO producto : listaBuscador) {
            if (producto.getMarca().equalsIgnoreCase(SKU)) {
                
                return producto;
            }

        }
        return null;

    }

    @Override
    public List buscarNombre(String nombre) {

        List<ProductoDTO> productosSeleccionados = new LinkedList<>();

        Pattern pattern = Pattern.compile(".*" + nombre + ".*", Pattern.CASE_INSENSITIVE);

        for (ProductoDTO producto : listaBuscador) {
            Matcher matcher = pattern.matcher(producto.getNombre());
            if (matcher.matches()) {
                productosSeleccionados.add(producto);
            }

        }

        return productosSeleccionados;

    }

    public List buscar(String prod) throws BuscadorException {
        List<ProductoDTO> productosSeleccionados = new LinkedList<>();

        productosSeleccionados.add(buscarSKU(prod));
        if (productosSeleccionados != null || productosSeleccionados.isEmpty()) {
            return productosSeleccionados;
        }
        productosSeleccionados = buscarMarca(prod);
        if (productosSeleccionados != null || productosSeleccionados.isEmpty()) {
            return productosSeleccionados;
        }
        productosSeleccionados = buscarNombre(prod);
        if (productosSeleccionados != null || productosSeleccionados.isEmpty()) {
            return productosSeleccionados;
        }
        
        throw new BuscadorException("No hay resultados para: "+prod);
        
        
    }

}
