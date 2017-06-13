package Command;

import ApplicationUtilitis.ApplicationCore;
import Model.Department;
import Model.OrdinaryEmployee;
import Model.Team;

import java.util.Scanner;

/**
 * Created by Bartek on 12.06.2017.
 * Komenda odpowiedzialna za ustawienie teamu
 */
public class SetTeamCommand implements Command {
    private ApplicationCore core;

    public SetTeamCommand(ApplicationCore core) {
        this.core = core;
    }

    @Override
    public String getCommandName() {
        return "set_team";
    }

    @Override
    public void doAction(String[] args) {
        Scanner scanner = new Scanner(System.in);
        for (Department department : core.getCompanies().get(0).getDepartments()) {
            System.out.println(department.getName());
        }

        System.out.println("Department name: ");
        String departmentName = scanner.nextLine();

        for (Team team : core.getTeams()) {
            System.out.println(team.getTeamUniqNumber());
        }

        System.out.println("Team uniq number: ");
        String teamId = scanner.nextLine();


        Team foundTeam = null;
        boolean set = false;
        for (Department department : core.getCompanies().get(0).getDepartments()) {
            if (department.getName().equals(departmentName)) {
                for (Team team : core.getTeams()) {
                    if (team.getTeamUniqNumber().equals(teamId)) {
                        if (!department.getTeams().contains(team)) {
                            department.getTeams().add(team);
                            set = true;
                            foundTeam = team;
                            break;
                        } else {
                            System.out.println("This department include this team");
                            set = true;
                            break;
                        }
                    }
                }
                break;
            }
        }
        if (!set) {
            System.out.println("There is no such department or team");
        } else {
            core.getTeams().remove(foundTeam);
        }
    }

    @Override
    public String getShortHelp() {
        return "set_team - set department team";
    }

    @Override
    public String getLongHelp() {
        return "set_team - add team to department";
    }
}