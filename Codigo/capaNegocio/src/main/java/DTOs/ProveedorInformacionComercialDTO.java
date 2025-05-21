package DTOs;

import org.bson.types.ObjectId;

/**
 * ProveedorInformacionComercialDTO.java
 *
 * Representa un objeto de transferencia de datos (DTO) que contiene la
 * información comercial de un proveedor.
 *
 * @author Ángel Ruíz García - 00000248171
 */
public class ProveedorInformacionComercialDTO {

    private ObjectId idComercial;
    private String rfc;
    private String formaPago;
    private String terminoPago;
    private String moneda;

    /**
     * Constructor por omision.
     */
    public ProveedorInformacionComercialDTO() {
    }

    /**
     * Constructor de la información comercial del proveedor de objeto de
     * transferencia de datos.
     *
     * @param idComercial ID de la información comercial del proveedor
     * @param rfc RFC del proveedor
     * @param formaPago Forma de pago del proveedor
     * @param terminoPago Termino de pago del proveedor
     * @param moneda Tipo de moneda
     */
    public ProveedorInformacionComercialDTO(ObjectId idComercial, String rfc, String formaPago, String terminoPago, String moneda) {
        this.idComercial = idComercial;
        this.rfc = rfc;
        this.formaPago = formaPago;
        this.terminoPago = terminoPago;
        this.moneda = moneda;
    }

    /**
     * Regresa el ID de la información comercial del proveedor.
     *
     * @return ID de la información comercial del proveedor
     */
    public ObjectId getIdComercial() {
        return idComercial;
    }

    /**
     * Establece el ID de la información comercial del proveedor.
     *
     * @param idComercial ID de la información comercial del proveedor
     */
    public void setIdComercial(ObjectId idComercial) {
        this.idComercial = idComercial;
    }

    /**
     * Regresa el RFC del proveedor.
     *
     * @return RFC del proveedor
     */
    public String getRfc() {
        return rfc;
    }

    /**
     * Establece el RFC del proveedor.
     *
     * @param rfc RFC del proveedor
     */
    public void setRfc(String rfc) {
        this.rfc = rfc;
    }

    /**
     * Regresa la forma de pago del proveedor.
     *
     * @return Forma de pago del proveedor
     */
    public String getFormaPago() {
        return formaPago;
    }

    /**
     * Establece la forma de pago del proveedor.
     *
     * @param formaPago Forma de pago del proveedor
     */
    public void setFormaPago(String formaPago) {
        this.formaPago = formaPago;
    }

    /**
     * Regresa el termino de pago del proveedor.
     *
     * @return Termino de pago del proveedor
     */
    public String getTerminoPago() {
        return terminoPago;
    }

    /**
     * Establece el termino de pago del proveedor.
     *
     * @param terminoPago Termino de pago del proveedor
     */
    public void setTerminoPago(String terminoPago) {
        this.terminoPago = terminoPago;
    }

    /**
     * Regresa el tipo de moneda con la se puede pagar.
     *
     * @return Tipo de moneda
     */
    public String getMoneda() {
        return moneda;
    }

    /**
     * Establece el tipo de moneda con la se puede pagar.
     *
     * @param moneda Tipo de moneda
     */
    public void setMoneda(String moneda) {
        this.moneda = moneda;
    }

    /**
     * Regresa una cadena con el valor de los atributos.
     *
     * @return Cadena con el valor de los atributos
     */
    @Override
    public String toString() {
        return "ProveedorInformacionComercial{" + "idComercial=" + idComercial + ", rfc=" + rfc + ", formaPago=" + formaPago + ", terminoPago=" + terminoPago + ", moneda=" + moneda + '}';
    }
}
