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

    public VendedorDTO(String idVendedor, String nombre, String apellidos, String rutaFoto, int raiting) {
        this.idVendedor = idVendedor;
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.rutaFoto = rutaFoto;
        this.raiting = raiting;
    }

    public String getIdVendedor() {
        return idVendedor;
    }

    public void setIdVendedor(String idVendedor) {
        this.idVendedor = idVendedor;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
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
