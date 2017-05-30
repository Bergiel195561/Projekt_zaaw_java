package DB;

import Model.Company;
import com.mongodb.MongoClient;
import org.mongodb.morphia.Datastore;
import org.mongodb.morphia.Morphia;
import org.mongodb.morphia.logging.LoggerFactory;
import org.python.jline.internal.Log;

import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * @author krystian
 */
public class MongoConnector {

    private static Logger logger = Logger.getLogger(MongoConnector.class.getName());
    final String DB_NAME = "java2017";
    final Morphia morphia = new Morphia();
    public final Datastore datastore = morphia.createDatastore(new MongoClient(), DB_NAME);

    public MongoConnector() {
        morphia.map(Company.class);
        datastore.ensureIndexes();

        Company c = new Company("Apple", "Steet", "Łódź", "111222333", new ArrayList<>());
        Company c1 = new Company("Apple2", "Steet", "Łódź", "111222333", new ArrayList<>());
        Company c2 = new Company("Apple3", "Steet", "Łódź", "111222333", new ArrayList<>());
        Company c4 = new Company("Apple", "Steet", "Łódź", "111222333", new ArrayList<>());

        save(c);
        save(c1);
        save(c2);
        save(c4);
    }

    public <T extends Object> void save(T object) {
        try {
            datastore.save(object);
        } catch (Exception e){
            logger.log(Level.WARNING, e.getMessage());
        }
    }
}
