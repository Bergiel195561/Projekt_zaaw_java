package Statistics;

import Model.Company;
import Model.Department;
import Model.OrdinaryEmployee;
import Model.Team;
import com.sun.tools.doclets.formats.html.SourceToHTMLConverter;

import java.util.HashSet;

/**
 * Created by apple on 12/06/17.
 */
public class CompanyStatistics {

    public static int getNumberOfEmployees(Company company){
        HashSet<OrdinaryEmployee> employees = new HashSet<>();
        for (Department dep: company.getDepartments()) {
            for (Team team: dep.getTeams() ){
                for (OrdinaryEmployee emp : team.getTeamMembers()) {
                    employees.add(emp);
                }
            }
        }
        return employees.size();
    }

    public static String getWholeCompanyDescription(Company company){
        StringBuilder builder = new StringBuilder();
        builder.append("Company "+ company.getName() + "\n");
        for (Department dep: company.getDepartments()) {
            builder.append("\n Department " + dep.getName() + "\n");
            for (Team team: dep.getTeams() ){
                builder.append("\t Team " + team.getTypeDescription() + " " + team.getTeamMembers().size() + " pracownik\\ów" + "\n");
            }
        }
        return builder.toString();
    }

    public static void getDepartmentDescription(Department department){
        HashSet<OrdinaryEmployee> set = new HashSet<>();
        for (Team team: department.getTeams()) {
            for(OrdinaryEmployee emp: team.getTeamMembers()){
                set.add(emp);
            }
        }
        String leftAlignFormat = "| %-15s | %-15d | %-18d |%n";
        System.out.format("+-----------------+-----------------+--------------------+%n");
        System.out.format("| Department name | Number of teams | Number of employees|%n");
        System.out.format("+-----------------+-----------------+--------------------+%n");
        System.out.format(leftAlignFormat, department.getName(), department.getTeams().size(), set.size());
        System.out.format("+-----------------+-----------------+--------------------+%n");

    }

    public static String listAllEmployeesFromTeam(Team team){
        StringBuilder builder = new StringBuilder();
        builder.append("Employees of " + team.getTypeDescription() + " department");
        for (OrdinaryEmployee emp: team.getTeamMembers()) {
            builder.append("Name: " + emp.getName() + "\n");
            builder.append("Surname: " + emp.getSurname() + "\n");
            builder.append("Pesel: " + emp.getPesel() + "\n");
            builder.append("----------------------------------------------");
        }

        return builder.toString();
    }


}
