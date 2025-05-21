/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DTOs;

/**
 *
 * @author gaspa
 */
public class SeguroDTO {
    private String numeroSeguro;
    private String tipo;

    public SeguroDTO() {
    }

    public SeguroDTO(String numeroSeguro, String tipo) {
        this.numeroSeguro = numeroSeguro;
        this.tipo = tipo;
    }

    public String getNumeroSeguro() {
        return numeroSeguro;
    }

    public void setNumeroSeguro(String numeroSeguro) {
        this.numeroSeguro = numeroSeguro;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
    
}
