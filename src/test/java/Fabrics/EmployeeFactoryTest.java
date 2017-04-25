package Fabrics;

import Helpers.EmployeeType;
import Model.Employee;
import Model.Manager;
import Model.OrdinaryEmployee;
import org.junit.Test;

import java.util.HashMap;
import java.util.StringJoiner;

import static org.assertj.core.api.Assertions.*;
import static org.junit.Assert.*;

/**
 * Created by apple on 25/04/17.
 */
public class EmployeeFactoryTest {


    @Test
    public void getEmployeeCheckIfProperClassIsCreated() throws Exception {
        //Given
        Employee manager;
        Employee ordinaryEmployee;

        //When
        manager = EmployeeFactory.getEmployee(EmployeeType.Manager, null);
        ordinaryEmployee = EmployeeFactory.getEmployee(EmployeeType.OrdinaryEmployee, null);

        //Then
        assertThat(manager.getClass()).isEqualTo(Manager.class);
        assertThat(ordinaryEmployee.getClass()).isEqualTo(OrdinaryEmployee.class);
    }

    @Test
    public void getEmployeeCheckIfProperClassIsCreatedWhenNotEnoughDataPassed() throws Exception {
        //Given
        Employee ordinaryEmployee;
        HashMap<String, String> data = new HashMap<String, String>(){{
            put("name", "Jan");
            put("surname", "Kowalski");
        }};

        //When
        ordinaryEmployee = EmployeeFactory.getEmployee(EmployeeType.OrdinaryEmployee, data);

        //Then
        assertThat(ordinaryEmployee.getName()).isNull();
    }

    @Test
    public void getEmployeeCheckIfClassContainsFieldsWhenEnoughDataPassed() throws Exception {
        //Given
        Employee manager;
        String expectedName = "Jan", expectedSurname = "Kowalski", expectedJobTitle = "Manager";
        HashMap<String, String> data = new HashMap<String, String>(){{
            put("name", expectedName);
            put("surname", expectedSurname);
            put("jobPosition", expectedJobTitle);
        }};
        //When
        manager = EmployeeFactory.getEmployee(EmployeeType.Manager, data);

        //Then
        assertThat(manager).extracting("name", "surname", "jobPosition")
                .contains(expectedName, expectedSurname, expectedJobTitle);
    }

}