package Model;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @author krystian
 */
public class DepartmentTest {

    private Department department;

    @Before
    public void setUp() throws Exception {
        this.department = new Department("Department");
    }

    @Test
    public void addMemberToDepartment() {
        // When
        int expectedMembersCount = 1;
        String expectedMemberName = "Name";
        OrdinaryEmployee employee = new OrdinaryEmployee(expectedMemberName, "Surname");

        // Given
        department.addDepartmentMember(employee);

        // Then
        assertEquals(department.getDepartmentMembers().size(), expectedMembersCount);
        assertEquals(department.getDepartmentMembers().get(0).getName(), expectedMemberName);
    }

}