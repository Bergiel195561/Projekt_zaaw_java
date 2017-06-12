package Model;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class OrdinaryEmployeeTest {

    String name;
    String surname;
    String humanId;

    @Before
    public void setUp() throws Exception {
        name = "Manager";
        surname = "Manager";
        humanId = "ManagerId";
    }

    @Test
    public void createOrdinaryEmployee() {
        //When
        OrdinaryEmployee ordEmp = new OrdinaryEmployee(name, surname, humanId);

        //Then
        assertNotNull(ordEmp);
    }

    @Test
    public void createOrdinaryEmployeeWithJobPosition() {
        //Given
        String jobPosition = "Ordinary";

        //When
        OrdinaryEmployee ordEmp = new OrdinaryEmployee(name, surname, jobPosition, humanId);

        //Then
        assertNotNull(ordEmp);
    }


    @Test
    public void testEqualsEmpty() {
        //Given
        OrdinaryEmployee ordEmp = new OrdinaryEmployee();
        boolean expectedBool = true;

        //When
        boolean result = ordEmp.equals(ordEmp);

        //Then
        assertEquals(expectedBool, result);
    }

    @Test
    public void testEqualsNonEqual() {
        //Given
        OrdinaryEmployee ordEmp = new OrdinaryEmployee(name, surname, humanId);
        OrdinaryEmployee ordEmp2 = new OrdinaryEmployee("Inne", "Inne", "Inne");
        boolean expectedBool = false;

        //When
        boolean result = ordEmp.equals(ordEmp2);

        //Then
        assertEquals(expectedBool, result);
    }

    @Test
    public void testHashCode() {
        OrdinaryEmployee ordEmp = new OrdinaryEmployee();

        int result = ordEmp.hashCode();
    }
}

//public int hashCode() {


