package DB;

import Model.Company;
import com.mongodb.MongoClient;
import org.mongodb.morphia.Datastore;
import org.mongodb.morphia.Morphia;

import java.util.ArrayList;

/**
 * @author krystian
 */
public class MongoConnector {

    final String DB_NAME = "java2017";
    final Morphia morphia = new Morphia();
    public final Datastore datastore = morphia.createDatastore(new MongoClient(), DB_NAME);

    public MongoConnector() {
        morphia.mapPackage("Model.Company");
        datastore.ensureIndexes();

        Company c = new Company("Apple", "Steet", "Łódź", "111222333", new ArrayList<>());
        datastore.save(c);
    }
}
