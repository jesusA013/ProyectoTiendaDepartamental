package Entidades;

import java.util.Date;
import org.bson.types.ObjectId;

/**
 *
 * @author Ángel Ruíz García - 00000248171
 */
public class Folio {

    private ObjectId id;
    private Date fecha;
    private ObjectId idProveedor;

    public Folio() {
    }

    public ObjectId getId() {
        return id;
    }

    public void setId(ObjectId id) {
        this.id = id;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public ObjectId getIdProveedor() {
        return idProveedor;
    }

    public void setIdProveedor(ObjectId idProveedor) {
        this.idProveedor = idProveedor;
    }

    @Override
    public String toString() {
        return "Folio{" + "id=" + id + ", fecha=" + fecha + ", idProveedor=" + idProveedor + '}';
    }
}
