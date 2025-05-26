package DTOs;

import java.util.Date;

/**
 *
 * @author melis
 */
public class NuevoVendedorDTO {

    private String nombre;
    private String apellido;
    private String rfc;
    private String domicilio;
    private String curp;
    private Date fechaNacimientoDia;
    private Date fechaNacimientoMes;
    private Date fechaNacimientoAño;
    private String ciudad;
    private String municipio;
    private String foto;

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
        this.apellido = apellido;
        this.fechaNacimientoDia = fechaNacimientoDia;
        this.fechaNacimientoMes = fechaNacimientoMes;
        this.fechaNacimientoAño = fechaNacimientoAño;
        this.rfc = rfc;
        this.domicilio = domicilio;
        this.curp = curp;
        this.ciudad = ciudad;
        this.municipio = municipio;
        this.foto = foto;
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

    private void validarFechaNacimiento(int dia, int mes, int año) {
        if (dia < 1 || dia > 31) {
            throw new IllegalArgumentException("El día de nacimiento debe estar entre 1 y 31.");
        }
        if (mes < 1 || mes > 12) {
            throw new IllegalArgumentException("El mes de nacimiento debe estar entre 1 y 12.");
        }
        if (año < 1900 || año > 2025) {
            throw new IllegalArgumentException("El año de nacimiento debe estar entre 1900 y 2025.");
        }
    }

    private void validarDatoNoVacio(String dato, String mensajeError) {
        if (dato == null || dato.trim().isEmpty()) {
            throw new IllegalArgumentException(mensajeError);
        }
    }

    public Date getFechaNacimientoDia() {
        return fechaNacimientoDia;
    }

    public void setFechaNacimientoDia(Date fechaNacimientoDia) {
        this.fechaNacimientoDia = fechaNacimientoDia;
    }

    public Date getFechaNacimientoMes() {
        return fechaNacimientoMes;
    }

    public void setFechaNacimientoMes(Date fechaNacimientoMes) {
        this.fechaNacimientoMes = fechaNacimientoMes;
    }

    public Date getFechaNacimientoAño() {
        return fechaNacimientoAño;
    }

    public void setFechaNacimientoAño(Date fechaNacimientoAño) {
        this.fechaNacimientoAño = fechaNacimientoAño;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    @Override
    public String toString() {
        return "NuevoVendedorDTO{" + "nombre=" + nombre + ", apellido=" + apellido + ", rfc=" + rfc + ", domicilio=" + domicilio + ", curp=" + curp + ", fechaNacimientoDia=" + fechaNacimientoDia + ", fechaNacimientoMes=" + fechaNacimientoMes + ", fechaNacimientoA\u00f1o=" + fechaNacimientoAño + ", ciudad=" + ciudad + ", municipio=" + municipio + ", foto=" + foto + ", fechaRegistro=" + fechaRegistro + ", activo=" + activo + '}';
    }

}
