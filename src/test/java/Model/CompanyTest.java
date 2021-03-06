package Model;

import com.sun.corba.se.impl.encoding.BufferManagerFactory;
import org.junit.Before;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

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
    public void setName() {
        // Given
        String name = "CompanyTest";

        // When
        company.setName(name);

        // Then
        assertEquals(name, company.getName());
    }

    @Test
    public void setStreet() {
        // Given
        String street = "CompanyStreeTest";

        // When
        company.setStreet(street);

        // Then
        assertEquals(street, company.getStreet());
    }

    @Test
    public void setCity() {
        // Given
        String city = "CompanyCityTest";

        // When
        company.setCity(city);

        // Then
        assertEquals(company.getCity(), city);
    }

    @Test
    public void setPhone() {
        // Given
        String phone = "123456789";

        // When
        company.setPhone(phone);

        // Then
        assertEquals(phone, company.getPhone());
    }

    @Test
    public void setDepartments() {
        // Given
        List<Department> departments = new ArrayList<>();
        for (int i = 0; i < 3; i++) {
            departments.add(new Department());
        }
        int expectedSize = 3;

        // When
        company.setDepartments(departments);

        // Then
        assertEquals(expectedSize, company.getDepartments().size());
        assertTrue(company.getDepartments().equals(departments));
    }

    @Test
    public void createCompany() {
        //Given
        List<Department> departments = new ArrayList<>();
        for (int i = 0; i < 3; i++) {
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
    public void testToString() {
        //Given
        company.setName("Company");
        company.setCity("CompanyCity");
        String expectedResult = "Company{" +
                "\n\tname='" + "Company" + '\'' +
                "\n\tstreet='" + "null" + '\'' +
                "\n\tcity='" + "CompanyCity" + '\'' +
                "\n\tphone='" + "null" + '\'' +
                "\n\tceo=" + "null" +
                "\n\tdepartments=" + "[]" +
                "\n}\n";

        //When
        String result = company.toString();

        //Then
        assertThat(expectedResult).containsSequence(result);
    }

    @Test
    public void getIdTest() {
        //When
        Object result = company.getId();

        //Then
        assertNotNull(result);
    }


}