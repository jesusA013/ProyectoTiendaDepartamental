package Entidades;



/**
 * ProductoVenta.java
 *
 *
 *
 * @author Knocmare y Angel Beltran en la 2da Version
 */

public class ProductoVenta {

    // Atributos 

    
   
    private int idProductoVenta; // Clave primaria de esta línea específica. 

    // Relaciones (Foreign Keys) 


    private int idCarrito; 

    
    private Producto producto; // Referencia directa a la entidad Producto

    // --- Datos específicos de la línea de venta ---

 
    private int cantidad; 

   
    private double precioUnitarioVenta; // Precio unitario al momento de agregar/vender

   
    private double importe; // Importe total de la línea (cantidad * precioUnitarioVenta)

   
    public ProductoVenta() {
    }

    /**
     * 
     *
     * @param idCarrito El ID del carrito al que pertenece esta línea.
     * @param producto La entidad Producto base asociada a esta línea.
     * @param cantidad La cantidad de unidades de este producto.
     * @param precioUnitarioVenta El precio unitario al momento de agregar al carrito/venta.
     */
    public ProductoVenta(int idCarrito, Producto producto, int cantidad, double precioUnitarioVenta) {
        if (producto == null) {
            throw new IllegalArgumentException("El producto no puede ser nulo al crear ProductoVenta");
        }
        this.idCarrito = idCarrito;
        this.producto = producto;
        this.cantidad = cantidad;
        this.precioUnitarioVenta = precioUnitarioVenta;
        this.calcularImporte(); // Calcula el importe al crear la instancia
    }

    // --- Getters y Setters ---

    public int getIdProductoVenta() {
        return idProductoVenta;
    }

    public void setIdProductoVenta(int idProductoVenta) {
        this.idProductoVenta = idProductoVenta;
    }

    public int getIdCarrito() {
        return idCarrito;
    }

    public void setIdCarrito(int idCarrito) {
        this.idCarrito = idCarrito;
    }

    public Producto getProducto() {
        return producto;
    }

    public void setProducto(Producto producto) {
        
        this.producto = producto;
    }

    public int getCantidad() {
        return cantidad;
    }

    /**
     * Establece la cantidad de productos y recalcula automáticamente el importe.
     * @param cantidad 
     */
    public void setCantidad(int cantidad) {
        if (cantidad < 0) {
            throw new IllegalArgumentException("La cantidad no puede ser negativa.");
        }
        this.cantidad = cantidad;
        this.calcularImporte(); // Recalcula el importe cuando cambia la cantidad
    }

    public double getPrecioUnitarioVenta() {
        return precioUnitarioVenta;
    }

    /**
     * Establece el precio unitario de venta y recalcula automáticamente el importe.
     * @param precioUnitarioVenta 
     */
    public void setPrecioUnitarioVenta(double precioUnitarioVenta) {
         if (precioUnitarioVenta < 0) {
            throw new IllegalArgumentException("El precio unitario no puede ser negativo.");
        }
        this.precioUnitarioVenta = precioUnitarioVenta;
        this.calcularImporte(); // Recalcula el importe cuando cambia el precio
    }

    public double getImporte() {
        return importe;
    }

    private void calcularImporte() {
        this.importe = (double) this.cantidad * this.precioUnitarioVenta;
    
    }

    // --- Métodos Utilitarios ---

    @Override
    public String toString() {
        return "ProductoVenta{" + "idProductoVenta=" + idProductoVenta + ", idCarrito=" + idCarrito + ", producto=" + producto + ", cantidad=" + cantidad + ", precioUnitarioVenta=" + precioUnitarioVenta + ", importe=" + importe + '}';
    }

    

   
}
