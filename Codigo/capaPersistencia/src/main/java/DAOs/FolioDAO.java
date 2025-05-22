package DAOs;

import DTOs.*;

import java.util.ArrayList;
import java.util.List;

/**
 * FolioDAO.java
 *
 * Angel Beltran
 */
public class FolioDAO {

    private static FolioDAO instance;
    private List<FolioDTO> folios;

    private FolioDAO() {
        this.folios = new ArrayList<>();
    }

    public static FolioDAO getInstance() {
        if (instance == null) {
            instance = new FolioDAO();
        }
        return instance;
    }

    public void crearFolio(FolioDTO folioDTO) {
        folios.add(folioDTO);
    }

    public void asociarProductos(String numeroFolio, List<ProductoDTO> productos) {
        for (FolioDTO folio : folios) {
            if (folio.getNumeroFolio().equals(numeroFolio)) {
                folio.getProductos().addAll(productos);
                for (ProductoDTO producto : productos) {
                    producto.setStock(producto.getStock()); // Simula actualización de stock
                }
                break;
            }
        }
    }

    public List<FolioDTO> obtenerFolios() {
        return new ArrayList<>(folios);
    }
}
