package Model;

import org.junit.Before;
import org.junit.Test;

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
        // When
        Department d = new Department("Department");
        int expectedDepertmentsCount = 1;

        // Given
        company.addDepartment(d);

        // Then
        assertTrue(company.getDepartments().size() == expectedDepertmentsCount);
    }

}