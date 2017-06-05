package DB;

import Model.Company;
import com.mongodb.MongoClient;
import org.mongodb.morphia.Datastore;
import org.mongodb.morphia.Morphia;
import org.mongodb.morphia.dao.BasicDAO;
import org.mongodb.morphia.query.Query;

/**
 * DAO dla firm
 * Created by krystian on 06.06.17.
 */
public class CompanyDao extends BasicDAO<Company, String> {

    public CompanyDao(Class<Company> entityClass, Datastore ds) {
        super(entityClass, ds);
    }

    /**
     * Pobieranie firmy po nazwie
     * @param companyName Nazwa szukanej firmy
     * @return Objekt klasy Company
     */
    public Company getCompanyByName(String companyName){
        Query<Company> query = createQuery().
                field("name").equal(companyName);

        return query.get();
    }
}
