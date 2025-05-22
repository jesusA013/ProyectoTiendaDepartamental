package Entidades;

/**
 * Angel Beltran
 */
public class FolioProducto {

    private int idFolio;
    private int idProducto;
    private int cantidad;

    /**
     * Constructor por ausencia
     */
    public FolioProducto() {
    }

    /**
     * Constructor de la relación folio-producto.
     *
     * @param idFolio ID del folio
     * @param idProducto ID del producto
     * @param cantidad Cantidad de este producto en el folio
     */
    public FolioProducto(int idFolio, int idProducto, int cantidad) {
        this.idFolio = idFolio;
        this.idProducto = idProducto;
        this.cantidad = cantidad;
    }

    /**
     * Regresa el ID del folio.
     *
     * @return ID del folio
     */
    public int getIdFolio() {
        return idFolio;
    }

    /**
     * Establece el ID del folio.
     *
     * @param idFolio ID del folio
     */
    public void setIdFolio(int idFolio) {
        this.idFolio = idFolio;
    }

    /**
     * Regresa el ID del producto.
     *
     * @return ID del producto
     */
    public int getIdProducto() {
        return idProducto;
    }

    /**
     * Establece el ID del producto.
     *
     * @param idProducto ID del producto
     */
    public void setIdProducto(int idProducto) {
        this.idProducto = idProducto;
    }

    /**
     * Regresa la cantidad de este producto en el folio.
     *
     * @return Cantidad de este producto
     */
    public int getCantidad() {
        return cantidad;
    }

    /**
     * Establece la cantidad de este producto en el folio.
     *
     * @param cantidad Cantidad de este producto
     */
    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    /**
     * Regresa una cadena con todos los datos de la relación folio-producto.
     *
     * @return Cadena con todos los datos de la relación
     */
    @Override
    public String toString() {
        return "FolioProducto{" + "idFolio=" + idFolio + ", idProducto=" + idProducto + ", cantidad=" + cantidad + '}';
    }
}
