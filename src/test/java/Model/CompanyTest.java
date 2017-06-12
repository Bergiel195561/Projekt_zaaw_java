package Model;

import com.sun.corba.se.impl.encoding.BufferManagerFactory;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

/**
 * @author krystian
 */
public class CompanyTest {

    private Company company;

    @Before
    public void setUpBeforeClass() throws Exception {
        this.company = new Company();
    }

    @Test
    public void addDepartmentToCompany() {
        //G iven
        Department d = new Department("Department");
        int expectedDepertmentsCount = 1;

        // When
        company.addDepartment(d);

        // Then
        assertTrue(company.getDepartments().size() == expectedDepertmentsCount);
    }

    @Test
    public void setCeo() {
        // Given
        Manager m = new Manager();
        int expectedCeoCount = 1;

        // When
        company.setCeo(m);

        // Then
        assertNotNull(company.getCeo());
    }
    @Test
    public void setName(){
        // Given
        String name = "CompanyTest";

        // When
        company.setName(name);

        // Then
        assertEquals(company.getName(),name);
    }

    @Test
    public void setStreet(){
        // Given
        String street = "CompanyStreeTest";

        // When
        company.setStreet(street);

        // Then
        assertEquals(company.getStreet(),street);
    }

    @Test
    public void setCity(){
        // Given
        String city = "CompanyCityTest";

        // When
        company.setCity(city);

        // Then
        assertEquals(company.getCity(),city);
    }

    @Test
    public void setPhone(){
        // Given
        String phone = "123456789";

        // When
        company.setPhone(phone);

        // Then
        assertEquals(company.getPhone(),phone);
    }

    @Test
    public void setDepartments() {
        // Given
       List<Department> departments = new ArrayList<>();
       for (int i=0; i<3; i++){
           departments.add(new Department());
       }
       int expectedSize = 3;

        // When
        company.setDepartments(departments);

        // Then
        assertEquals(company.getDepartments().size(),expectedSize);
        assertTrue(company.getDepartments().equals(departments));
    }

    @Test
    public void createCompany(){
        //Given
        List<Department> departments = new ArrayList<>();
        for (int i=0; i<3; i++){
            departments.add(new Department());
        }

        //When
        Company c = new Company("CompanyTest",
                "CompanyStreetTest",
                "CompanyCityTest",
                "123456789",
                departments);

        //Then
        assertNotNull(c);
    }

    @Test
    public void testToString(){
        //Given
        company.setName("Company");
        company.setCity("CompanyCity");
        String expectedResult = "Company{name='Company', " +
                "street='null', " +
                "city='CompanyCity', " +
                "phone='null', " +
                "ceo=null, " +
                "departments=[]}";

        //When
        String result = company.toString();

        //Then
        assertEquals(result,expectedResult);


    }



}