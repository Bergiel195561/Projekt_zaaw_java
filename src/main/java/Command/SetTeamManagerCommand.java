package Command;

import ApplicationUtilitis.ApplicationCore;
import Model.Manager;
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
        for (Team team : core.getTeams()) {
            System.out.println(team.toString());
        }

        System.out.println("Team uniq numer: ");
        String teamId = scanner.nextLine();


        for (Manager manager : core.getManagers()) {
            System.out.println(manager.toString());
        }

        System.out.println("Manager pesel: ");
        String managerHumanId = scanner.nextLine();

        boolean set = false;

        for (Team team : core.getTeams()) {
            if (team.getTeamUniqNumber().equals(teamId)) {
                for (Manager manager : core.getManagers()) {
                    if (manager.getPesel().equals(managerHumanId)) {
                        team.setTeamLeader(manager);
                        set = true;
                        break;
                    }
                }
                break;
            }
        }

        if (!set) {
            System.out.println("There is no such team or manager");
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