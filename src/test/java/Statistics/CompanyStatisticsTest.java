package Statistics;

import Helpers.TeamType;
import Model.Company;
import Model.Department;
import Model.OrdinaryEmployee;
import Model.Team;
import org.assertj.core.api.Fail;
import org.junit.*;
import org.junit.rules.ExpectedException;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

import static com.sun.tools.doclets.formats.html.markup.HtmlStyle.description;
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
        Team teamDev = new Team(TeamType.DEV);
        Team teamTesters = new Team(TeamType.TESTERS);
        teamDev.getTeamMembers().add(employeeFirst);
        teamDev.getTeamMembers().add(employeeSecond);
        teamTesters.getTeamMembers().add(employeeThird);
        Department department = new Department("IT");
        department.getTeams().add(teamDev);
        department.getTeams().add(teamTesters);

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

    @Test()
    public void getNumberOfEmployeesShouldBeFalse() throws Exception {
        //given
        int expectedSize = 2;

        //when
        int resultSize =  CompanyStatistics.getNumberOfEmployees(company);
        //then
        assertThat(resultSize).isNotEqualTo(expectedSize);
    }


    @Test
    public void getWholeCompanyDescriptionShouldNotBeNull(){
        //given
        String description;
        //when
        description = CompanyStatistics.getWholeCompanyDescription(company);
        //then
        assertThat(description).isNotNull();
    }

    @Test
    public void getWholeCompanyDescriptionShouldContainDepName(){
        //given
        String description;
        String expectedDepartmentName = "IT";
        //when
        description = CompanyStatistics.getWholeCompanyDescription(company);
        //then
        assertThat(description).contains(expectedDepartmentName);
    }

    @Test
    public void getWholeCompanyDescriptionShouldContainSequence(){
        //given
        String description;
        String expectedDepartmentName = "IT";
        String expectedTeamName = "DEV";
        String expectedTeamName1 = "TESTERS";
        //when
        description = CompanyStatistics.getWholeCompanyDescription(company);
        //then
        assertThat(description).containsSequence(expectedDepartmentName, expectedTeamName, expectedTeamName1);
    }

    @Test(expected = AssertionError.class)
    public void getWholeCompanyDescriptionShouldFail(){
        //given
        String description;
        String expectedDepartmentName = "Marketing";
        String expectedTeamName = "DEV";
        String expectedTeamName1 = "TESTERS";
        //when
        description = CompanyStatistics.getWholeCompanyDescription(company);
        //then
        assertThat(description).containsSequence(expectedDepartmentName, expectedTeamName, expectedTeamName1);

    }

    @Test
    public void getDepartmentDescriptionShould(){
        //given
//        Department dep = company.getDepartments().stream()
//                .filter(d -> d.getName()).equals("IT");
        //when
        CompanyStatistics.getDepartmentDescription(company.getDepartments().get(0));

    }


}