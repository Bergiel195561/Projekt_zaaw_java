package Model;

import Helpers.TeamType;
import Utils.CustomHashSet;
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
        // Given
        int expectedTeamCount = 1;
        TeamType expectedTeamType = TeamType.DEV;
        Team team = new Team(expectedTeamType);

        // When
        department.addTeam(team);

        // Then
        assertEquals(expectedTeamCount,department.getTeams().size());
        assertEquals(expectedTeamType,department.getTeams().get(0).getType());
    }

    @Test
    public void setName() {
        // Given
        String name = "DepartmentTest";

        // When
        department.setName(name);

        // Then
        assertEquals(name,department.getName());
    }



    @Test
    public void setTeams() {
        //Given
        CustomHashSet<Team> teams = new CustomHashSet<>();
        int expectedSize = 3;
        for (int i = 0; i < 3; i++) {
            teams.add(new Team());
        }

        //When
        department.setTeams(teams);

        //Then
        assertEquals(expectedSize,department.getTeams().size());
        assertNotNull(department.getTeams());

    }

    @Test
    public void createDepartment() {

        //When
        Department d = new Department();

        //Then
        assertNotNull(d);
    }

    @Test
    public void testToString(){
        //Given
        String expectedResult = "Department{" +
                "\n\tname='" + "Department" + '\'' +
                "\n\tteams= \n" + "[]" +
                "\n}\n";;

        //When
        String result = department.toString();

        //Then
        assertEquals(expectedResult,result);
    }

    @Test
    public void testEquals(){
        //Given
        boolean expectedResult = true;

        //When
        boolean result = department.equals(department);

        //Then
        assertEquals(expectedResult,result);
    }

    @Test
    public void testNonEquals(){
        //Given
        Department department2 = new Department();
        boolean expectedResult = false;

        //When
        boolean result = department.equals(department2);

        //Then
        assertEquals(expectedResult,result);
    }

    @Test
    public void testEqualsNullObject(){
        //Given
        boolean expectedResult = false;

        //When
        boolean result = department.equals(null);

        //Then
        assertEquals(expectedResult,result);
    }



}