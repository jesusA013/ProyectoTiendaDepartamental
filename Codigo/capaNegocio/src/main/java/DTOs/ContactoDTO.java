package DTOs;

/**
 * Angel Beltran
 */
public class ContactoDTO {
    // Atributos
    private String telefono;
    private String correo;
    private String direccion;

    // Constructor vacío
    public ContactoDTO() {
    }

    // Constructor completo
    public ContactoDTO(String telefono, String correo, String direccion) {
        this.telefono = telefono;
        this.correo = correo;
        this.direccion = direccion;
    }

    // Getters y Setters
    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    // Método toString para una representación legible del objeto
    @Override
    public String toString() {
        return "ContactoDTO{" +
                "telefono='" + telefono + '\'' +
                ", correo='" + correo + '\'' +
                ", direccion='" + direccion + '\'' +
                '}';
    }
}
