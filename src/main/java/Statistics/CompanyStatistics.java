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
}
