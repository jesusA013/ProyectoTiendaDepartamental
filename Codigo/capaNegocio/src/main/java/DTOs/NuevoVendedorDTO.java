package DTOs;

import java.util.Date;

/**
 *
 * @author melis
 */
public class NuevoVendedorDTO {

    private String nombre;
    private String rfc;
    private String domicilio;
    private String curp;
    private Date fechaNacimiento;
    private String ciudad;
    private String municipio;
    private String foto;

    private String telefono;
    private String email;
    private String datosFiscales;
    private Date fechaRegistro;
    private boolean activo;

    public NuevoVendedorDTO(String nombre, String rfc, String domicilio, String curp, Date fechaNacimiento,
            String ciudad, String municipio, String foto, String telefono,
             String email, String datosFiscales, Date fechaRegistro, boolean activo) {
        validarDatoNoVacio(nombre, "el nombre es obligatorio");
        validarDatoNoVacio(rfc, "el RFC es obligatorio");
        validarDatoNoVacio(domicilio, "el domicilio es obligatorio");
        validarDatoNoVacio(curp, "la CURP es obligatorio");
        validarDatoNoVacio(ciudad, "La ciudad es obligatorio");
        validarDatoNoVacio(municipio, "el municipio es obligatorio");
        validarDatoNoVacio(telefono, "El teléfono es obligatorio.");
        validarDatoNoVacio(email, "El correo electrónico es obligatorio.");
        validarDatoNoVacio(datosFiscales, "Los datos fiscales son obligatorios.");

        this.nombre = nombre;
        this.rfc = rfc;
        this.domicilio = domicilio;
        this.curp = curp;
        this.fechaNacimiento = fechaNacimiento;
        this.ciudad = ciudad;
        this.municipio = municipio;
        this.foto = foto;
        this.telefono = telefono;
        this.email = email;
        this.datosFiscales = datosFiscales;
        this.fechaRegistro = fechaRegistro != null ? fechaRegistro : new Date();
        this.activo = activo;

    }

    public NuevoVendedorDTO() {
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getRfc() {
        return rfc;
    }

    public void setRfc(String rfc) {
        this.rfc = rfc;
    }

    public String getDomicilio() {
        return domicilio;
    }

    public void setDomicilio(String domicilio) {
        this.domicilio = domicilio;
    }

    public String getCurp() {
        return curp;
    }

    public void setCurp(String curp) {
        this.curp = curp;
    }

    public Date getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(Date fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    public String getMunicipio() {
        return municipio;
    }

    public void setMunicipio(String municipio) {
        this.municipio = municipio;
    }

    public String getFoto() {
        return foto;
    }

    public void setFoto(String foto) {
        this.foto = foto;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getDatosFiscales() {
        return datosFiscales;
    }

    public void setDatosFiscales(String datosFiscales) {
        this.datosFiscales = datosFiscales;
    }

    public Date getFechaRegistro() {
        return fechaRegistro;
    }

    public void setFechaRegistro(Date fechaRegistro) {
        this.fechaRegistro = fechaRegistro;
    }

    public boolean isActivo() {
        return activo;
    }

    public void setActivo(boolean activo) {
        this.activo = activo;
    }

    private void validarDatoNoVacio(String dato, String mensajeError) {
        if (dato == null || dato.trim().isEmpty()) {
            throw new IllegalArgumentException(mensajeError);
        }
    }

    @Override
    public String toString() {
        return "NuevoVendedorDTO{" + "nombre=" + nombre + ", rfc=" + rfc + ", domicilio=" + domicilio + ", curp=" + curp + ", fechaNacimiento=" + fechaNacimiento + ", ciudad=" + ciudad + ", municipio=" + municipio + ", foto=" + foto + ", telefono=" + telefono + ", email=" + email + ", datosFiscales=" + datosFiscales + ", fechaRegistro=" + fechaRegistro + ", activo=" + activo + '}';
    }
}
