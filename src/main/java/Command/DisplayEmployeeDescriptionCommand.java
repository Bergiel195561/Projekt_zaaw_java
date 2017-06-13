package Command;

import ApplicationUtilitis.ApplicationCore;
import Model.Department;
import Model.Team;
import Statistics.CompanyStatistics;

import java.util.Scanner;

/**
 * Created by Bartek on 13.06.2017.
 *  * Komenda odpowiedzialna za wyswietlenie opisu pracownika
 */
public class DisplayEmployeeDescriptionCommand implements Command {
    private ApplicationCore core;

    public DisplayEmployeeDescriptionCommand(ApplicationCore core) {
        this.core = core;
    }

    @Override
    public String getCommandName() {
        return "employee_desc";
    }

    @Override
    public void doAction(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Team uniq number: ");
        String teamId = scanner.nextLine();

        boolean set = false;

        for (Team team : core.getTeams()) {
            if (team.getTeamUniqNumber().equals(teamId)) {
                System.out.println(CompanyStatistics.listAllEmployeesFromTeam(team));
                set = true;
                break;
            }
        }

        if (!set) {
            System.out.println("There is no such team");
        }
    }

    @Override
    public String getShortHelp() {
        return "employee_desc - display employee description";
    }

    @Override
    public String getLongHelp() {
        return "employee_desc - display employee description";
    }
}