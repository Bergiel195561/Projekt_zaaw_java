package Command;

import ApplicationUtilitis.ApplicationCore;
import Model.Department;
import Model.Team;
import Statistics.CompanyStatistics;

import java.util.Scanner;

/**
 * Created by Bartek on 13.06.2017.
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
        for (Department d : core.getCompanies().get(0).getDepartments()) {
            System.out.println("Dział: " + d.getName());
            System.out.println("UniqID : TeamType");
            System.out.println("-----------------\n");
            for (Team team : d.getTeams()) {
                System.out.println(team.getTeamUniqNumber() + " : " + team.getType());
            }
            System.out.println("\n\n");
        }
        System.out.println("Team uniq number: ");
        String teamId = scanner.nextLine();

        boolean set = false;
        for (Department d : core.getCompanies().get(0).getDepartments()) {
            for (Team team : d.getTeams()) {
                if (team.getTeamUniqNumber().equals(teamId)) {
                    System.out.println(CompanyStatistics.listAllEmployeesFromTeam(team));
                    set = true;
                    break;
                }
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