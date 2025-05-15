/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAOs;

import Entidades.Venta;
import Interfaz.IVentasDAO;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import java.util.List;
import java.util.stream.Collectors;
import org.bson.Document;
import org.bson.types.ObjectId;

/**
 *
 * @author Knocmare
 */
public class VentasDAO implements IVentasDAO {
    private final MongoCollection<Document> coleccion;

    public VentasDAO(MongoDatabase database) {
        this.coleccion = database.getCollection("Ventas");
    }

    @Override
    public void insertarVenta(Venta venta) {
        Document docVenta = new Document("fecha", venta.getFecha())
            .append("productos", venta.getProductos().stream().map(p -> new Document()
                .append("_id", p.getProductoId())
                .append("cantidad", p.getCantidad())
                .append("precioUnitario", p.getPrecioUnitario())
            ).collect(Collectors.toList()))
            .append("vendedorId", venta.getVendedorId())
            .append("Factura", new Document()
                .append("folioFactura", venta.getFactura().getFolioFactura())
                .append("fechaEmision", venta.getFactura().getFechaEmision()))
            .append("detallesVenta", new Document()
                .append("Subtotal", venta.getDetallesVenta().getSubtotal())
                .append("IVA", venta.getDetallesVenta().getIva())
                .append("total", venta.getDetallesVenta().getTotal())
                .append("formaPago", venta.getDetallesVenta().getFormaPago())
                .append("metodoPago", venta.getDetallesVenta().getMetodoPago()));

        coleccion.insertOne(docVenta);
    }

    @Override
    public List<Venta> consultarVentas() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public Venta buscarVentaPorId(ObjectId id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public List<Venta> buscarVentasPorVendedor(ObjectId vendedorId) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
