package Statistics;

import Helpers.TeamType;
import Model.Company;
import Model.Department;
import Model.OrdinaryEmployee;
import Model.Team;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.*;

/**
 * Created by apple on 12/06/17.
 */
public class CompanyStatisticsTest {

    private Company company;
    @Before
    public void setUp() throws Exception {
        OrdinaryEmployee employeeFirst = new OrdinaryEmployee("Maciej", "Kowalski", "90080739100");
        OrdinaryEmployee employeeSecond = new OrdinaryEmployee("Tomasz", "Zieliński", "91020739098");
        OrdinaryEmployee employeeThird = new OrdinaryEmployee("Jakub", "Madej", "87082039098");
        Team team = new Team(TeamType.DEV);
        team.getTeamMembers().add(employeeFirst);
        team.getTeamMembers().add(employeeSecond);
        team.getTeamMembers().add(employeeThird);
        Department department = new Department("IT");
        department.getTeams().add(team);

        company = new Company();
        company.addDepartment(department);
    }

    @After
    public void tearDown() throws Exception {

    }

    @Test
    public void getNumberOfEmployeesShouldBeTrue() throws Exception {
        //given
        int expectedSize = 3;
        //when
        int resultSize =  CompanyStatistics.getNumberOfEmployees(company);

        //then
        assertThat(resultSize).isEqualTo(expectedSize);
    }

}