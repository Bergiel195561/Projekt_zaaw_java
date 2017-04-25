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
        OrdinaryEmployee employee = new OrdinaryEmployee("Name", "Surname");
        int expectedMembersCount = 1;

        // Given
        department.addDepartmentMember(employee);

        // Then
        assertEquals(department.getDepartmentMembers().size(), expectedMembersCount);
    }

}