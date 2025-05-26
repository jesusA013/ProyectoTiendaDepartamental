package DTOs;

/**
 *
 * @author gaspa
 */
public class ProductoTablaDTO {

    private String idProducto;
    private String codigo;
    private String nombre;
    private String marca;
    private String color;
    private double precio;
    private int stock;

    public ProductoTablaDTO() {
    }

    public ProductoTablaDTO(String idProducto, String codigo, String nombre, String marca, String color, double precio, int stock) {
        this.idProducto = idProducto;
        this.codigo = codigo;
        this.nombre = nombre;
        this.marca = marca;
        this.color = color;
        this.precio = precio;
        this.stock = stock;
    }

    public String getIdProducto() {
        return idProducto;
    }

    public void setIdProducto(String idProducto) {
        this.idProducto = idProducto;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }
}
