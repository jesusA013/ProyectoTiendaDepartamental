package DAOs;

import Interfaz.IConexion;
import com.mongodb.ConnectionString;
import com.mongodb.MongoClientSettings;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoDatabase;
import static org.bson.codecs.configuration.CodecRegistries.fromProviders;
import static org.bson.codecs.configuration.CodecRegistries.fromRegistries;
import org.bson.codecs.configuration.CodecRegistry;
import org.bson.codecs.pojo.PojoCodecProvider;

/**
 *
 * @author gaspa
 */
public class Conexion implements IConexion {

    @Override
    public MongoDatabase conexion() {
        // Configura el proveedor de códecs para trabajar con objetos Java y MongoDB
        CodecRegistry pojoCodecRegistry = fromProviders(PojoCodecProvider.builder().automatic(true).build());

        // Combina el proveedor de códecs POJO con el registro de códecs predeterminado de MongoDB
        CodecRegistry codecRegistry = fromRegistries(MongoClientSettings.getDefaultCodecRegistry(), pojoCodecRegistry);

        // Configura la cadena de conexión a la base de datos MongoDB local
        ConnectionString cadenaConexion = new ConnectionString("mongodb://localhost/27017");

        // Configura los ajustes del cliente MongoDB, incluyendo la cadena de conexión y el registro de códecs
        MongoClientSettings clientsSettings = MongoClientSettings.builder()
                .applyConnectionString(cadenaConexion)
                .codecRegistry(codecRegistry)
                .build();

        // Crea un cliente MongoDB utilizando los ajustes configurados
        MongoClient dbServer = MongoClients.create(clientsSettings);

        // Obtiene la base de datos específica del cliente MongoDB
        return dbServer.getDatabase("TiendaDepartamental");
    }
}
