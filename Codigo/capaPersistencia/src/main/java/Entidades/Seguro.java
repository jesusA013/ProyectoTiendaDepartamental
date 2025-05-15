/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Entidades;

/**
 *
 * @author gaspa
 */
public class Seguro {
    private String numeroSeguro;
    private String tipo;

    public Seguro() {
    }

    public Seguro(String numeroSeguro, String tipo) {
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

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Seguro{");
        sb.append("numeroSeguro=").append(numeroSeguro);
        sb.append(", tipo=").append(tipo);
        sb.append('}');
        return sb.toString();
    }
}
