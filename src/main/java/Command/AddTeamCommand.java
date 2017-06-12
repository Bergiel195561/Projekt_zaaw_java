package Command;

import ApplicationUtilitis.ApplicationCore;
import ApplicationUtilitis.TeamBuilder;
import Helpers.TeamType;
import Model.Team;

import java.util.Scanner;

/**
 * Created by Bartek on 12.06.2017.
 */
public class AddTeamCommand implements Command {
    private ApplicationCore core;

    public AddTeamCommand(ApplicationCore core) {
        this.core = core;
    }

    @Override
    public String getCommandName() {
        return "add_team";
    }

    @Override
    public void doAction(String[] args) {

        Scanner scanner = new Scanner(System.in);

        TeamBuilder builder = new TeamBuilder();
        System.out.println("Team type: ");
        System.out.println(java.util.Arrays.asList(TeamType.values()));
        String teamType = scanner.nextLine();


        switch (TeamType.valueOf(teamType)) {
            case DEV:
                builder.createTeam(TeamType.DEV);
                break;

            case ADV:
                builder.createTeam(TeamType.ADV);
                break;

            case QA:
                builder.createTeam(TeamType.QA);
                break;

            case UX:
                builder.createTeam(TeamType.UX);
                break;

            case TESTERS:
                builder.createTeam(TeamType.TESTERS);
                break;

            default:
                System.out.println("Nie ma takiego działu");
                break;
        }

        Team team = builder.getTeam();
        core.addTeam(team);
    }

    @Override
    public String getShortHelp() {
        return "add_team - adds a new team";
    }

    @Override
    public String getLongHelp() {
        return "add_team - adds a new team";
    }
}