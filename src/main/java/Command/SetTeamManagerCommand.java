package Command;

import ApplicationUtilitis.ApplicationCore;
import Model.Department;
import Model.Manager;
import Model.OrdinaryEmployee;
import Model.Team;

import java.util.Scanner;

/**
 * Created by Bartek on 12.06.2017.
 */
public class SetTeamManagerCommand implements Command {
    private ApplicationCore core;

    public SetTeamManagerCommand(ApplicationCore core) {
        this.core = core;
    }

    @Override
    public String getCommandName() {
        return "set_team_manager";
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
        System.out.println("Team uniq numer: ");
        String teamId = scanner.nextLine();

        for (Manager manager : core.getManagers()) {
            System.out.println(manager.getPesel() + " " + manager.getName());
        }

        System.out.println("Manager pesel: ");
        String managerHumanId = scanner.nextLine();

        boolean set = false;
        Manager foundManager = null;
        for (Department department : core.getCompanies().get(0).getDepartments()) {
            for (Team team : department.getTeams()) {
                if (team.getTeamUniqNumber().equals(teamId)) {
                    for (Manager manager : core.getManagers()) {
                        if (manager.getPesel().equals(managerHumanId)) {
                            team.setTeamLeader(manager);
                            set = true;
                            foundManager = manager;
                            break;
                        }
                    }
                    break;
                }
            }
        }

        if (!set) {
            System.out.println("There is no such team or manager");
        } else {
            core.getManagers().remove(foundManager);
        }
    }

    @Override
    public String getShortHelp() {
        return "set_team_manager - set team manager";
    }

    @Override
    public String getLongHelp() {
        return "set_team_manager - set team manager";
    }
}