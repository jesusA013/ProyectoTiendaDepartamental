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
    private String id;
    private String nombre;
    private String rutaFoto;
    private int raiting;

    public VendedorDTO(String id, String nombre, String rutaFoto, int raiting) {
        this.id = id;
        this.nombre = nombre;
        this.rutaFoto = rutaFoto;
        this.raiting = raiting;
    }

    public VendedorDTO() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
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
    
    
    
}
