package DB;

import Helpers.TeamType;
import Model.*;
import PrepareCompany.CompanyCreate;
import com.mongodb.DuplicateKeyException;
import com.sun.org.apache.xpath.internal.operations.Or;
import org.junit.*;
import org.junit.rules.ExpectedException;
import org.mongodb.morphia.query.Query;

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
    public static void initDb() {
        mongoConnector = MongoConnector.getInstance();
        mongoConnector.setDbName("Java2017_Test1");
        mongoConnector.getDatastore().getDB().dropDatabase();
    }

    @Before
    public void clearDb() {
        mongoConnector.getDatastore().getDB().dropDatabase();
    }

    @AfterClass
    public static void changeDb() {
        mongoConnector.setDbNameForDefault();
    }

    @Test
    public void addCompanyToDatabase() {
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
    public void addCompanyToDatabaseWithTheSameName() {
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
    public void getCompanyByName() {
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

    @Test
    public void getEmployeeByName() {
        String employeeName = "Kowalski";
        int expectedCountEmployees = 1;
        OrdinaryEmployeeDao dao = new OrdinaryEmployeeDao(mongoConnector.getDatastore());

        OrdinaryEmployee e = new OrdinaryEmployee();
        e.setName(employeeName);

        mongoConnector.save(e);

        OrdinaryEmployee employee = dao.getEmployeeByName(employeeName);
        List<OrdinaryEmployee> employees = mongoConnector.getDatastore().find(OrdinaryEmployee.class).asList();

        assertThat(employees.size() == 1);
        assertEquals(employee.getName(), "Kowalski");

        mongoConnector.getDatastore().delete(e);
    }

    @Test
    public void getEmployeesWithHigherSalary() {
        int expectedEmployeesCount = 3;
        int expectedEmployeesWithHigher = 2;

        OrdinaryEmployee emp = new OrdinaryEmployee();
        emp.setSalary(1000);
        OrdinaryEmployee emp1 = new OrdinaryEmployee();
        emp1.setSalary(3000);
        OrdinaryEmployee emp2 = new OrdinaryEmployee();
        emp2.setSalary(3000);

        OrdinaryEmployeeDao dao = new OrdinaryEmployeeDao(mongoConnector.getDatastore());

        mongoConnector.save(emp);
        mongoConnector.save(emp1);
        mongoConnector.save(emp2);

        List<OrdinaryEmployee> employeesWithHigherSalary = dao.getEmployeesWithHigherSalary(2500);
        List<OrdinaryEmployee> employees = mongoConnector.getDatastore().find(OrdinaryEmployee.class).asList();

        assertThat(employees.size() == expectedEmployeesCount);
        assertThat(employeesWithHigherSalary.size() == expectedEmployeesWithHigher);

        mongoConnector.getDatastore().delete(emp);
        mongoConnector.getDatastore().delete(emp1);
        mongoConnector.getDatastore().delete(emp2);
    }

    @Test
    public void increaseSalary() {
        String employeeName = "Kowalski";
        float initialSalary = 1000;
        float bonusSalary = 1000;
        OrdinaryEmployee emp = new OrdinaryEmployee();
        emp.setName(employeeName);
        emp.setSalary(initialSalary);

        OrdinaryEmployeeDao dao = new OrdinaryEmployeeDao(mongoConnector.getDatastore());

        mongoConnector.save(emp);

        dao.increaseSalary(bonusSalary, employeeName);
        OrdinaryEmployee employee = dao.getEmployeeByName(employeeName);

        assertEquals(initialSalary + bonusSalary, employee.getSalary(), 0.001);

        mongoConnector.getDatastore().delete(emp);

    }

    @Test
    public void getEmployeeByPesel() {
        //given
        String basePesel = "90097823456";
        OrdinaryEmployee employee1 = new OrdinaryEmployee("Jan", "Kowalski", basePesel);
        OrdinaryEmployee employee2 = new OrdinaryEmployee("Maciej", "Lipka", "90097823452");
        OrdinaryEmployeeDao dao = new OrdinaryEmployeeDao(mongoConnector.getDatastore());
        dao.save(employee1);
        dao.save(employee2);

        //when
        OrdinaryEmployee expectedEmployee = dao.getEmployeeByPesel(basePesel);

        //then
        assertThat(expectedEmployee)
                .isNotNull()
                .isOfAnyClassIn(OrdinaryEmployee.class)
                .extracting("name")
                .containsSequence("Jan");

        dao.delete(employee1);
        dao.delete(employee2);

    }

    @Test
    public void saveCompanyCascade() {
        //given
        Company company = CompanyCreate.getBigCompany();
        String expectedCompanyName = company.getName();

        //when
        CascadeSave cascadeSave = new CascadeSave(mongoConnector);
        cascadeSave.saveCasdace(company);

        //then
        Company companyFromDB = mongoConnector.getDatastore().find(Company.class).get();
        assertThat(companyFromDB.getName()).isEqualTo(expectedCompanyName);
    }

    @Test
    public void saveCompanyCascadeDepartmentContains() {
        //given
        Company company = CompanyCreate.getBigCompany();
        List<Department> departmentList = company.getDepartments();
        int expectedDepartmentsNumber = departmentList.size();

        //when
        CascadeSave cascadeSave = new CascadeSave(mongoConnector);
        cascadeSave.saveCasdace(company);

        //then
        Company companyFromDB = mongoConnector.getDatastore().find(Company.class).get();
        assertThat(companyFromDB.getDepartments())
                .hasSize(expectedDepartmentsNumber);
    }

    @Test
    public void saveCompanyCascadeDouble() {
        //given
        Company company = CompanyCreate.getBigCompany();
        List<Department> departmentList = company.getDepartments();
        int expectedCompanyNumber = 1;

        //when
        CascadeSave cascadeSave = new CascadeSave(mongoConnector);
        cascadeSave.saveCasdace(company);
        cascadeSave.saveCasdace(company);

        //then
        Query<Company> query = mongoConnector.getDatastore().createQuery(Company.class);
        List<Company> companies = query.asList();
        assertThat(companies)
                .hasSize(expectedCompanyNumber);
    }

    @Test
    public void addUniqueEmployeeToDB() {
        //given
        OrdinaryEmployee employee = new OrdinaryEmployee("Andrzej", "Nowak", "11122233322");

        //when
        mongoConnector.save(employee);

        //then
        OrdinaryEmployee ordinaryEmployee = mongoConnector.getDatastore().find(OrdinaryEmployee.class).get();
        assertThat(ordinaryEmployee)
                .isNotNull()
                .isOfAnyClassIn(OrdinaryEmployee.class)
                .extracting("name")
                .containsSequence(employee.getName());
    }

    @Test
    public void addDuplicateEmployeeToDB() {
        //given
        OrdinaryEmployee employee = new OrdinaryEmployee("Andrzej", "Nowak", "11122233322");
        int expectedEmployeesNumber = 1;

        //when
        mongoConnector.save(employee);
        mongoConnector.save(employee);

        //then
        Query<OrdinaryEmployee> query = mongoConnector.getDatastore().createQuery(OrdinaryEmployee.class);
        List<OrdinaryEmployee> employees = query.asList();

        assertThat(employees)
                .hasSize(expectedEmployeesNumber);
    }

    @Test
    public void addUniqueTeamToDB() {
        //given
        String teamUniq = "DevOps01";
        String key = "teamUniqNumber";
        Team team = new Team(TeamType.DEV);
        team.setTeamUniqNumber(teamUniq);

        //when
        mongoConnector.save(team);

        //then
        Team teamDb = mongoConnector.getDatastore().find(Team.class).get();
        assertThat(teamDb)
                .isNotNull()
                .isOfAnyClassIn(Team.class)
                .extracting(key)
                .containsSequence(teamUniq);
    }

    @Test
    public void addDuplicateTeamToDB() {
        //given
        String teamUniq = "DevOps01";
        int expectedTeamsNumber = 1;
        Team team = new Team(TeamType.DEV);
        team.setTeamUniqNumber(teamUniq);

        //when
        mongoConnector.save(team);
        mongoConnector.save(team);

        //then
        Query<Team> query = mongoConnector.getDatastore().createQuery(Team.class);
        List<Team> teams = query.asList();

        assertThat(teams)
                .hasSize(expectedTeamsNumber);
    }


}