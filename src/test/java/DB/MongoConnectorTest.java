package DB;

import Model.Company;
import com.mongodb.DuplicateKeyException;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.*;

/**
 * Created by krystian on 06.06.17.
 */
public class MongoConnectorTest {

    private static MongoConnector mongoConnector;
    private List<Company> companyList = new ArrayList<>();

    @Rule
    public ExpectedException thrown = ExpectedException.none();

    @BeforeClass
    public static void initDb(){
        MongoConnector.setDbName("Java2017_Test");
        mongoConnector = new MongoConnector();
        mongoConnector.getDatastore().getDB().dropDatabase();
    }

    @AfterClass
    public static void changeDb(){
        MongoConnector.setDbNameForDefault();
    }

    @Test
    public void addCompanyToDatabase(){
        String companyName = "Firma";
        String companyCity = "Miasto";

        Company c = new Company();
        c.setName(companyName);
        c.setCity(companyCity);

        Company companyFromDb = mongoConnector.getDatastore().find(Company.class).get();
        assertThat(companyFromDb).isNull();
        mongoConnector.save(c);

        Company companyFromDbAfterSave = mongoConnector.getDatastore().find(Company.class).get();
        assertThat(companyFromDbAfterSave).isNotNull();
        assertThat(companyFromDbAfterSave.getName()).isEqualTo(companyName);

        mongoConnector.getDatastore().delete(c);
    }

    @Test
    public void addCompanyToDatabaseWithTheSameName(){
        String companyName = "FirmaNowa";
        int expectedCountCompanies = 1;
        int firstCompany = 0;

        Company c = new Company();
        c.setName(companyName);

        Company c1 = new Company();
        c1.setName(companyName);

        mongoConnector.save(c);
        mongoConnector.save(c1);

        List<Company> companies = mongoConnector.getDatastore().find(Company.class).asList();

        assertThat(companies.size() == expectedCountCompanies);
        assertEquals(companies.get(firstCompany).getName(), companyName);

        mongoConnector.getDatastore().delete(c);
        mongoConnector.getDatastore().delete(c1);
    }

    @Test
    public void getCompanyByName(){
        String companyName = "FirmaNowa";
        String companyNameSecond = "FirmaNowa2";
        int expectedCountCompanies = 2;
        int firstCompany = 0;
        CompanyDao dao = new CompanyDao(mongoConnector.getDatastore());

        Company c = new Company();
        c.setName(companyName);

        Company c1 = new Company();
        c1.setName(companyNameSecond);

        mongoConnector.save(c);
        mongoConnector.save(c1);

        Company company = dao.getCompanyByName(companyNameSecond);
        List<Company> companies = mongoConnector.getDatastore().find(Company.class).asList();

        assertThat(companies.size() == expectedCountCompanies);
        assertEquals(company.getName(), companyNameSecond);

        mongoConnector.getDatastore().delete(c);
        mongoConnector.getDatastore().delete(c1);
    }

}