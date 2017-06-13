package Command;

import ApplicationUtilitis.ApplicationCore;
import ApplicationUtilitis.TeamBuilder;
import Helpers.TeamType;
import Model.Team;

import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Created by Bartek on 12.06.2017.
 * Komenda odpowiedzialna za dodanie team
 */
public class AddTeamCommand implements Command {
    private static Logger logger = Logger.getLogger(AddTeamCommand.class.getName());
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
        System.out.println("Team uniq number: ");
        String teamId = scanner.nextLine();

        System.out.println("Team type: ");
        System.out.println(java.util.Arrays.asList(TeamType.values()));
        String teamType = scanner.nextLine();

        try {
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
                    System.out.println("There is no such team type");
                    break;
            }
        } catch (IllegalArgumentException e) {
            System.out.println("There is no such team type");
            e.printStackTrace();
            logger.log(Level.WARNING, e.getMessage());
        }

        builder.setTeamId(teamId);
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