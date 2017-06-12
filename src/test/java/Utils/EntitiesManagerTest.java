package Utils;

import DB.MongoConnector;
import Model.OrdinaryEmployee;
import org.junit.*;

import java.util.Optional;

import static Utils.EntitiesManager.*;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.assertj.core.api.Assertions.assertThat;

/**
 * Created by apple on 12/06/17.
 */
public class EntitiesManagerTest {

    private static MongoConnector mongoConnector;

    private static OrdinaryEmployee employeeFirst;
    private static OrdinaryEmployee employeeSecond;
    private static OrdinaryEmployee employeeThird;
    private static String EXPECTED_PESEL = "90080739100";
    private static String DIFFERENT_PESEL = "90034539100";

    @BeforeClass
    public static void  setUp() throws Exception {
        mongoConnector = MongoConnector.getInstance();
        employeeFirst = new OrdinaryEmployee("Maciej", "Kowalski", "90080739100");
        employeeSecond = new OrdinaryEmployee("Tomasz", "Zieliński", "91020739098");
        employeeThird = new OrdinaryEmployee("Jakub", "Madej", "87082039098");

        mongoConnector.getDatastore().save(employeeFirst);
        mongoConnector.getDatastore().save(employeeSecond);
        mongoConnector.getDatastore().save(employeeThird);
    }

    @AfterClass
    public static void tearDown() throws Exception {
        mongoConnector.getDatastore().delete(employeeFirst);
        mongoConnector.getDatastore().delete(employeeSecond);
        mongoConnector.getDatastore().delete(employeeThird);

        mongoConnector.setDbNameForDefault();
    }

    @Test
    public void getEmployeesByPeselShouldBeTrue() throws Exception {
        //given
        String pesel = EXPECTED_PESEL;

        //when
        Optional<OrdinaryEmployee> employee = getEmployeeByPesel(pesel);

        //then
        assertTrue(employee.isPresent());
        assertThat(employee.get())
                .isOfAnyClassIn(OrdinaryEmployee.class)
                .extracting("name").contains("Maciej");
        assertThat(employee.get()).hasFieldOrPropertyWithValue("surname", "Kowalski")
                .hasFieldOrPropertyWithValue("pesel", pesel);



    }

    @Test
    public void getEmployeesByPeselShouldReturnEmptyOptional() throws Exception {
        //given
        String pesel = DIFFERENT_PESEL;

        //when
        Optional<OrdinaryEmployee> employee = getEmployeeByPesel(pesel);

        //then
        assertFalse(employee.isPresent());
        assertThat(employee)
                .isOfAnyClassIn(Optional.class);
    }

}