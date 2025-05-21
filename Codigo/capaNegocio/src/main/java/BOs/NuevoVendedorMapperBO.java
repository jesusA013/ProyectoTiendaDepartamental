/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BOs;

import DTOs.NuevoVendedorDTO;
import Entidades.Vendedor;

/**
 *
 * @author melis
 */

public class NuevoVendedorMapperBO {
//

    public static Vendedor convertirEntidad(NuevoVendedorDTO nuevoVendedor) {
        return new Vendedor(
                null, // Se generará en la BD
                nuevoVendedor.getNombre(),
                nuevoVendedor.getRfc(),
                nuevoVendedor.getDomicilio(),
                nuevoVendedor.getCurp(),
                nuevoVendedor.getCiudad(),
                nuevoVendedor.getMunicipio(),
                nuevoVendedor.getRutaFoto(),
                0.0, // Total de ventas inicializado en 0
                5 // Rating inicial por defecto
        );
    }

    public static NuevoVendedorDTO convertirDTO(Vendedor vendedor) {
        return new NuevoVendedorDTO(
                vendedor.getNombreCompleto(),
                vendedor.getRfc(),
                vendedor.getDomicilio(),
                null, // No almacenamos fecha de nacimiento en Vendedor
                vendedor.getCurp(),
                vendedor.getCiudad(),
                vendedor.getMunicipio(),
                vendedor.getFoto()
        );
    }
}
