package Utils;

import DB.MongoConnector;
import Model.OrdinaryEmployee;
import org.junit.*;

import java.util.Optional;

import static Utils.EntitiesManager.*;
import static org.junit.Assert.assertTrue;
import static org.assertj.core.api.Assertions.assertThat;

/**
 * Created by apple on 12/06/17.
 */
public class EntitiesManagerTest {

    private static MongoConnector mongoConnector;

    @BeforeClass
    public static void  setUp() throws Exception {
        mongoConnector = MongoConnector.getInstance();
    }

    @AfterClass
    public static void tearDown() throws Exception {
        mongoConnector.setDbNameForDefault();
    }

    @Test
    public void getEmployeesByPeselShouldBeTrue() throws Exception {
        //given
        String pesel = "90080739100";
        OrdinaryEmployee employeeFirst = new OrdinaryEmployee("Maciej", "Kowalski", pesel);
        OrdinaryEmployee employeeSecond = new OrdinaryEmployee("Tomasz", "Zieliński", "91020739098");
        OrdinaryEmployee employeeThird = new OrdinaryEmployee("Jakub", "Madej", "87082039098");
        mongoConnector.getDatastore().save(employeeFirst);
        mongoConnector.getDatastore().save(employeeSecond);
        mongoConnector.getDatastore().save(employeeThird);

        //when
        Optional<OrdinaryEmployee> employee = getEmployeeByPesel(pesel);

        //then
        assertTrue(employee.isPresent());
        assertThat(employee.get())
                .isOfAnyClassIn(OrdinaryEmployee.class)
                .extracting("name").contains("Maciej");
        assertThat(employee.get()).hasFieldOrPropertyWithValue("surname", "Kowalski")
                .hasFieldOrPropertyWithValue("pesel", pesel);

        mongoConnector.getDatastore().delete(employeeFirst);
        mongoConnector.getDatastore().delete(employeeSecond);
        mongoConnector.getDatastore().delete(employeeThird);

    }

}