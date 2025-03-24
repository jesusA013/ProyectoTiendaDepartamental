package DTOs;

/**
 *
 * @author Knocmare
 */
public class ProductoDTO {
    
    public String nombre;
    public String sku;
    public double precio;
    public String marca;
    public String color;
    public int stock;

    public ProductoDTO() {
    }

    public ProductoDTO(String nombre, String sku, double precio, String marca, String color, int stock) {
        this.nombre = nombre;
        this.sku = sku;
        this.precio = precio;
        this.marca = marca;
        this.color = color;
        this.stock = stock;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getSku() {
        return sku;
    }

    public void setSku(String sku) {
        this.sku = sku;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
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

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }
    
    
    
}
