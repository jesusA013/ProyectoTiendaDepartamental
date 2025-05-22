/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ModuloAdministracion.GestionVendedores;

import DTOs.ProductoVentaDTO;
import DTOs.VendedorDTO;
import DTOs.VentaDTO;
import com.itextpdf.text.Chunk;
import com.itextpdf.text.Document;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;
import java.io.FileOutputStream;
import java.time.ZoneId;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;


/**
 *
 * @author gaspa
 */
public class ReportePDFVendedor {
    
    public void generarReporteVendedor(VendedorDTO vendedor, List<VentaDTO> ventas, String rutaArchivo) {
        Document document = new Document();

        try {
            PdfWriter.getInstance(document, new FileOutputStream(rutaArchivo));
            document.open();

            Font tituloFont = new Font(Font.FontFamily.HELVETICA, 18, Font.BOLD);
            Font subtituloFont = new Font(Font.FontFamily.HELVETICA, 14, Font.BOLD);
            Font textoFont = new Font(Font.FontFamily.HELVETICA, 12);

            // Título
            Paragraph titulo = new Paragraph("Reporte de Vendedor", tituloFont);
            titulo.setAlignment(Element.ALIGN_CENTER);
            document.add(titulo);
            document.add(Chunk.NEWLINE);

            // Datos del vendedor
            Paragraph datosVendedor = new Paragraph(
                "Nombre: " + vendedor.getNombreCompleto().getNombres()+ " " + vendedor.getNombreCompleto().getApellidoPaterno()+ " " + vendedor.getNombreCompleto().getApellidoMaterno() + "\n" +
                "CURP: " + vendedor.getCurp() + "\n" +
                "RFC: " + vendedor.getDatosFiscales().getRfc() + "\n" +
                "Fecha de nacimiento: " + vendedor.getFechaNacimiento() + "\n" +
                "Estado civil: " + vendedor.getEstadoCivil() + "\n" +
                "Seguro: " + vendedor.getSeguro().getNumeroSeguro() + "\n" +
                "Estado: " + vendedor.isActivo(),
                textoFont
            );
            document.add(datosVendedor);
            document.add(Chunk.NEWLINE);

            // Estadísticas de ventas
            int totalVentas = ventas.size();
            double totalDinero = ventas.stream().mapToDouble(v -> v.getDetallesVenta().getTotal()).sum();

            // Agrupar por mes y calcular estadísticas mensuales
            Map<String, Long> ventasPorMes = ventas.stream()
                    .collect(Collectors.groupingBy(
                        v -> {
                            Calendar cal = Calendar.getInstance();
                            cal.setTime(v.getFecha());
                            return cal.get(Calendar.YEAR) + "-" + (cal.get(Calendar.MONTH) + 1); // año-mes
                        },
                        Collectors.counting()
                    ));

            int totalMeses = ventasPorMes.size();
            double promedioMensual = totalMeses > 0 ? (double) totalVentas / totalMeses : 0;

            Paragraph estadisticas = new Paragraph(
                "Total de ventas: " + totalVentas + "\n" +
                "Total acumulado: $" + String.format("%.2f", totalDinero) + "\n" +
                "Ventas mensuales: " + ventasPorMes.size() + "\n" +
                "Promedio de ventas mensual: " + String.format("%.2f", promedioMensual),
                textoFont
            );
            document.add(estadisticas);
            document.add(Chunk.NEWLINE);

            // Detalles de cada venta
            document.add(new Paragraph("Detalle de ventas:", subtituloFont));

            for (VentaDTO venta : ventas) {
                Paragraph ventaInfo = new Paragraph();
                ventaInfo.add("Fecha: " + venta.getFecha().toString() + "\n");
                ventaInfo.add("Folio: " + venta.getFactura().getFolioFactura() + "\n");
                ventaInfo.add("Total: $" + String.format("%.2f", venta.getDetallesVenta().getTotal()) + "\n");
                ventaInfo.add("Productos:\n");

                for (ProductoVentaDTO p : venta.getProductos()) {
                    ventaInfo.add("- " + p.getProducto().getNombre() + " x" + p.getCantidad() +
                            " @ $" + String.format("%.2f", p.getPrecioUnitario()) + "\n");
                }

                ventaInfo.add("\n");
                document.add(ventaInfo);
            }

            document.close();
            System.out.println("Reporte generado exitosamente en: " + rutaArchivo);

        } catch (Exception e) {
            System.err.println("Error al generar reporte: " + e.getMessage());
        }
    }
}
