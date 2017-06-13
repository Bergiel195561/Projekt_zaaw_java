package Statistics;

import Model.Company;
import Model.Department;
import Model.OrdinaryEmployee;
import Model.Team;

import java.util.HashSet;

/**
 * Created by apple on 12/06/17.
 *
 * Klasa pobierająca dane i filtrująca je
 */
public class CompanyStatistics {

    /**
     * Metoda pobierająca liczbę pracowników z danego company
     *
     * @param company wybrana Firma
     * @return employee.size() ilośc pracowników
     */
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

    /**
     * Metoda zwaracająca dokładny opis firmy
     *
     * @param company
     * @return dokładny opis firmy
     */
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

    /**
     * Metoda zwaracająca dokładny opis działu
     *
     * @param department
     * @return dokładny opis działu
     */
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

    /**
     * Metoda zwaracająca listę pracowników z danego działu jako String
     *
     * @param team
     * @return String lista pracowników
     */
    public static String listAllEmployeesFromTeam(Team team){
        StringBuilder builder = new StringBuilder();
        builder.append("Employees of " + team.getTypeDescription() + " department \n");
        builder.append("---------------------------------------------- \n");
        for (OrdinaryEmployee emp: team.getTeamMembers()) {
            builder.append("Name: " + emp.getName() + "\n");
            builder.append("Surname: " + emp.getSurname() + "\n");
            builder.append("Pesel: " + emp.getPesel() + "\n");
            builder.append("---------------------------------------------- \n");
        }

        return builder.toString();
    }


}
