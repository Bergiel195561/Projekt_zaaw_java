package Model;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.Date;

import static org.junit.Assert.*;

/**
 * Created by Maciej on 13.06.2017.
 */
public class EmployeeTest {

    private Employee employee;

    @Before
    public void setUp() throws Exception {
        this.employee = new Employee();
    }

    @Test
    public void setPesel(){
        //Given
        String pesel = "95082105853";

        //When
        employee.setPesel(pesel);

        //Then
        assertNotNull(employee.getPesel());
        assertEquals(pesel,employee.getPesel());
    }

    @Test
    public void setName(){
        //Given
        String name = "Employee";

        //When
        employee.setName(name);

        //Then
        assertNotNull(employee.getName());
        assertEquals(name,employee.getName());
    }

    @Test
    public void setSurname(){
        //Given
        String surname = "Employee";

        //When
        employee.setSurname(surname);

        //Then
        assertNotNull(employee.getSurname());
        assertEquals(surname,employee.getSurname());
    }

    @Test
    public void setJobPosition(){
        //Given
        String position = "Driver";

        //When
        employee.setJobPosition(position);

        //Then
        assertNotNull(employee.getJobPosition());
        assertEquals(position,employee.getJobPosition());
    }

    @Test
    public void setSalary(){
        //Given
        Float salary = 100.0f;

        //When
        employee.setSalary(salary);

        //Then
        assertNotNull(employee.getSalary());
        assertEquals(salary, employee.getSalary(), 0.01);
    }

    @Test
    public void setHireDate(){
        //Given
        Date date = new Date();

        //When
        employee.setHireDate(date);

        //Then
        assertNotNull(employee.getHireDate());
        assertEquals(date,employee.getHireDate());
    }

    @Test
    public void testEquals(){
        //Given
        boolean expectedResult = true;

        //When
        boolean result = employee.equals(employee);

        //Then
        assertEquals(expectedResult,result);
    }

    @Test
    public void testNonEquals(){
        //Given
        Employee employee2 = new Employee();
        boolean expectedResult = false;

        //When
        boolean result = employee.equals(employee2);

        //Then
        assertEquals(expectedResult,result);
    }

    @Test
    public void testEqualsNullObject(){
        //Given
        boolean expectedResult = false;

        //When
        boolean result = employee.equals(null);

        //Then
        assertEquals(expectedResult,result);
    }

    @Test
    public void testEqualsSalary(){
        //Given
        Employee employee2 = employee;
        employee.setSalary(100.0f);
        employee2.setSalary(100.0f);
        boolean expectedResult = false;

        //When
        boolean result = employee.equals(null);

        //Then
        assertEquals(expectedResult,result);
    }


    @Test
    public void hashCodeTest(){
        //Given
        Employee x = new Employee("Employee","Employee","1");
        Employee y = new Employee("Employee","Employee","1");

        //When
        int result = x.hashCode();
        int result2 = y.hashCode();

        //Then
        assertFalse(x.hashCode()==y.hashCode());

    }

    @Test
    public void getEmptyJobPosition(){
        //Given
        String expected = "none";

        //When
        String result = employee.getJobPosition();

        //Then
        assertEquals(expected,result);
    }

}
