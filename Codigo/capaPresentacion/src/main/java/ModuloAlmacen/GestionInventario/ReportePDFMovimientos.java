package ModuloAlmacen.GestionInventario;

import DTOs.MovimientoDTO;
import com.itextpdf.text.Chunk;
import com.itextpdf.text.Document;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;

import java.io.FileOutputStream;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * Clase que genera un reporte PDF de movimientos en el inventario.
 * @author Ángel
 */
public class ReportePDFMovimientos {

    public void generarReporteMovimientos(List<MovimientoDTO> movimientos, String rutaArchivo) {
        Document document = new Document();

        try {
            PdfWriter.getInstance(document, new FileOutputStream(rutaArchivo));
            document.open();

            Font tituloFont = new Font(Font.FontFamily.HELVETICA, 18, Font.BOLD);
            Font subtituloFont = new Font(Font.FontFamily.HELVETICA, 14, Font.BOLD);
            Font textoFont = new Font(Font.FontFamily.HELVETICA, 12);

            // Título
            Paragraph titulo = new Paragraph("Reporte de Movimientos de Inventario", tituloFont);
            titulo.setAlignment(Element.ALIGN_CENTER);
            document.add(titulo);
            document.add(Chunk.NEWLINE);

            // Estadísticas básicas
            int totalMovimientos = movimientos.size();
            long entradas = movimientos.stream().filter(m -> m.getTipoOperacion().equalsIgnoreCase("entrada")).count();
            long salidas = movimientos.stream().filter(m -> m.getTipoOperacion().equalsIgnoreCase("salida")).count();

            Map<String, Long> movimientosPorMes = movimientos.stream()
                    .collect(Collectors.groupingBy(
                            m -> {
                                Calendar cal = Calendar.getInstance();
                                cal.setTime(m.getFecha());
                                return cal.get(Calendar.YEAR) + "-" + (cal.get(Calendar.MONTH) + 1);
                            },
                            Collectors.counting()
                    ));

            Paragraph estadisticas = new Paragraph(
                    "Total de movimientos: " + totalMovimientos + "\n" +
                    "Total entradas: " + entradas + "\n" +
                    "Total salidas: " + salidas + "\n" +
                    "Meses con movimientos registrados: " + movimientosPorMes.size(),
                    textoFont
            );
            document.add(estadisticas);
            document.add(Chunk.NEWLINE);

            // Detalle de movimientos
            document.add(new Paragraph("Detalle de movimientos:", subtituloFont));
            document.add(Chunk.NEWLINE);

            SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy HH:mm");

            for (MovimientoDTO m : movimientos) {
                Paragraph movimiento = new Paragraph();
                movimiento.setFont(textoFont);
                movimiento.add("Fecha: " + sdf.format(m.getFecha()) + "\n");
                movimiento.add("Responsable: " + m.getUsuarioResponsable() + "\n");
                movimiento.add("Producto: " + m.getNombreProducto() + "\n");
                movimiento.add("Tipo de operación: " + m.getTipoOperacion() + "\n");
                movimiento.add("Cantidad: " + m.getCantidad() + "\n");
                movimiento.add("Motivo: " + m.getMotivo() + "\n");
                movimiento.add("ID Cuenta: " + m.getIdCuenta() + "\n");
                movimiento.add("ID Movimiento: " + m.getId().toHexString() + "\n");
                movimiento.add("\n-----------------------------------------\n\n");
                document.add(movimiento);
            }

            document.close();
            System.out.println("Reporte de movimientos generado exitosamente en: " + rutaArchivo);

        } catch (Exception e) {
            System.err.println("Error al generar reporte: " + e.getMessage());
        }
    }
}
