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

}
