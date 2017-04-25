package Model;

import Helpers.TeamType;
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
    public void addTeam() {
        // When
        int expectedTeamCount = 1;
        TeamType expectedTeamType = TeamType.DEV;
        Team team = new Team(expectedTeamType);

        // Given
        department.addTeam(team);

        // Then
        assertEquals(department.getTeams().size(), expectedTeamCount);
        assertEquals(department.getTeams().get(0).getType(), expectedTeamType);
    }

}