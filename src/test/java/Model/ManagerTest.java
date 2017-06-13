package Model;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class ManagerTest {

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
    public void createManager() {
        //When
        Manager man = new Manager(name, surname, humanId);

        //Then
        assertNotNull(man);
    }

    @Test
    public void createManagerWithJobPosition(){
        //Given
        String jobPosition = "Manager";

        //Then
        Manager man = new Manager(name, surname, jobPosition, humanId);

        assertNotNull(man);
    }


    @Test
    public void testToString() {
        //Given
        Manager man = new Manager(name, surname, humanId);
        String expectedResult = "Manager{" +
                "\n\tpesel='" + "ManagerId" + '\'' +
                "\n\tname='" + "Manager" + '\'' +
                "\n\tsurname='" + "Manager" + '\'' +
                "\n\tjobPosition='" + null + '\'' +
                "\n\tsalary=" + 0.0 +
                "\n\thireDate=" + null +
                "\n}\n";

        //When
        String result = man.toString();

        //Then
        assertEquals(expectedResult,result);
    }



}
