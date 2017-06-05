package DB;

import com.mongodb.MongoClient;
import org.mongodb.morphia.Datastore;
import org.mongodb.morphia.Morphia;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Klasa stanowiąca inicjalizator połączenia do MongoDB
 * @author krystian
 */
public class MongoConnector {

    private static Logger logger = Logger.getLogger(MongoConnector.class.getName());
    final String DB_NAME = "java2017";
    final Morphia morphia = new Morphia();
    public final Datastore datastore = morphia.createDatastore(new MongoClient(), DB_NAME);

    public MongoConnector() {
        morphia.mapPackage("Model");
        datastore.ensureIndexes();
    }

    public <T extends Object> void save(T object) {
        try {
            datastore.save(object);
        } catch (Exception e){
            e.printStackTrace();
            logger.log(Level.WARNING, e.getMessage());
        }
    }

    public Datastore getDatastore() {
        return datastore;
    }
}
