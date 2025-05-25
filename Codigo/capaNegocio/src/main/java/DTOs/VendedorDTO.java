package DTOs;

/**
 *
 * @author melis
 */
public class VendedorDTO {

    private String idVendedorDTO;
    private String nombre;
    private String rutaFoto;
    private int raiting;

    public VendedorDTO(String idVendedorDTO, String nombre, String rutaFoto, int raiting) {
        this.idVendedorDTO = idVendedorDTO;
        this.nombre = nombre;
        this.rutaFoto = rutaFoto;
        this.raiting = raiting;
    }

    public VendedorDTO() {
    }

    public String getIdVendedorDTO() {
        return idVendedorDTO;
    }

    public void setIdVendedorDTO(String idVendedorDTO) {
        this.idVendedorDTO = idVendedorDTO;
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
