package DB;

import Model.Company;
import com.mongodb.MongoClient;
import org.mongodb.morphia.Datastore;
import org.mongodb.morphia.Morphia;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Klasa stanowiąca inicjalizator połączenia do MongoDB
 *
 * @author krystian
 */
public class MongoConnector {

    //Singleton methods
    private static MongoConnector instance = null;
    private static Object mutex = new Object();

    private MongoConnector() {
        morphia.mapPackage("Model");
        datastore.ensureIndexes();
    }

    public static MongoConnector getInstance() {
        if (instance == null) {
            synchronized (mutex) {
                if (instance == null) instance = new MongoConnector();
            }
        }
        return instance;
    }

    private static Logger logger = Logger.getLogger(MongoConnector.class.getName());
    public static String DB_NAME = "java2017";
    final Morphia morphia = new Morphia();
    public final Datastore datastore = morphia.createDatastore(new MongoClient(), DB_NAME);

    public void setDbNameForDefault() {
        DB_NAME = "java2017";
    }

    public void setDbName(String dbName) {
        DB_NAME = dbName;
    }

    public <T extends Object> void save(T object) {
        try {
            datastore.save(object);
        } catch (Exception e) {
//            e.printStackTrace();
            logger.log(Level.WARNING, e.getMessage());
        }
    }

    public Datastore getDatastore() {
        return datastore;
    }
}
