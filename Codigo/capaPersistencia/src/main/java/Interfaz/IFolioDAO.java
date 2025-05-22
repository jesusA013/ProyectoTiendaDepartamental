package Interfaz;

import Entidades.Folio;
import Exception.PersistenciaException;
import java.util.List;
import org.bson.types.ObjectId;

/**
 * IFolioDAO.java Esta clase implementa los metodos de la DAO de Folio.
 *
 * @author Ángel Ruíz García - 00000248171
 */
public interface IFolioDAO {
    
    Folio insertarFolio(Folio folio) throws PersistenciaException;
    
    Folio actualizarFolio(Folio folio) throws PersistenciaException;
    
    Folio eliminarFolio(ObjectId id) throws PersistenciaException;
    
    Folio buscarPorId(ObjectId id) throws PersistenciaException;
    
    List<Folio> buscarTodos() throws PersistenciaException;
    
}
