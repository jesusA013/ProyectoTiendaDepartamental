/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DTOs;

/**
 *
 * @author melis
 */
public class VendedorDTO {
    private String idVendedor;
    private String nombre;
        private String apellidos;
    private String rutaFoto;
    private int raiting;

    public VendedorDTO(String idVendedor, String nombre,String apellidos, String rutaFoto, int raiting) {
        this.idVendedor = idVendedor;
        this.nombre = nombre;
       this.apellidos=apellidos;
        this.rutaFoto = rutaFoto;
        this.raiting = raiting;
    }

    public VendedorDTO() {
    }

    public String getIdVendedor() {
        return idVendedor;
    }

    public void setId(String id) {
        this.idVendedor = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getRutaFoto() {
        return rutaFoto;
    }

    public void setRutaFoto(String rutaFoto) {
        this.rutaFoto = rutaFoto;
    }

    public int getRaiting() {
        return raiting;
    }

    public void setRaiting(int raiting) {
        this.raiting = raiting;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    @Override
    public String toString() {
        return "VendedorDTO{" + "idVendedor=" + idVendedor + ", nombre=" + nombre + ", apellidos=" + apellidos + ", rutaFoto=" + rutaFoto + ", raiting=" + raiting + '}';
    }
    
    
    
    
    
}
