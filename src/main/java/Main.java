import ApplicationUtilitis.ApplicationCore;
import Command.Command;
import Command.CommandResolver;
import Command.HelpCommand;
import Command.PrintCommand;
import Command.AddCompanyCommand;
import Command.InfoCommand;
import DB.CascadeSave;
import DB.CompanyDao;
import DB.MongoConnector;
import Helpers.TeamType;
import Model.*;
import Utils.CustomHashSet;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * @author Jaromir
 *         Created by apple on 25/04/17.
 */
public class Main {

    private ApplicationCore core;
    private CommandResolver commandResolver;

    public static void main(String[] args) {
        MongoConnector m = MongoConnector.getInstance();


        Company c = new Company("Nazwa", "Uliczna", "Miasto", "111222333", new ArrayList<>());
        Department d = new Department("Kozaki");
        Department d2 = new Department("Spaślaki");

        Team t = new Team(TeamType.DEV);
        t.setTeamUniqNumber("DEV123");
        Team t2 = new Team(TeamType.TESTERS);
        t2.setTeamUniqNumber("TESTERS123");

        Manager ma = new Manager("Andrzej", "Nowak", "11122212345");
        CustomHashSet<OrdinaryEmployee> list = new CustomHashSet<>();
        for (int i = 0; i < 5; i++){
            OrdinaryEmployee a = new OrdinaryEmployee("Andrzej" + i, "Nowak" + i, i + "1111112345");
            list.add(a);
        }

        t.setTeamMembers(list);
        CustomHashSet<OrdinaryEmployee> list2 = new CustomHashSet<>();
        for (int i = 0; i < 5; i++){
            OrdinaryEmployee a = new OrdinaryEmployee("Super" + i, "Nowak" + i, i + "2111112345");
            list2.add(a);
        }
        t2.setTeamMembers(list2);
        t.setDepartmentLeader(ma);
        t2.setDepartmentLeader(ma);

        d.addTeam(t);

        d2.addTeam(t2);

        c.addDepartment(d);
        c.addDepartment(d2);

        System.out.println(c);

        CascadeSave cascadeSave = new CascadeSave(m);
        cascadeSave.saveCasdace(c);

        Main main = new Main(new ApplicationCore(), new CommandResolver());
        main.start(args);
    }

    public Main(ApplicationCore core, CommandResolver commandResolver) {
        this.core = core;
        this.commandResolver = commandResolver;
    }

    private void init() {
        commandResolver.registerCommand(new AddCompanyCommand(core));
        commandResolver.registerCommand(new InfoCommand());
        commandResolver.registerCommand(new PrintCommand(core));
        commandResolver.registerCommand(new HelpCommand());
    }

    public void start(String[] args) {
        init();

        System.out.println("--- Staff Management System ---");
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("> ");
            String line = scanner.nextLine();
            String[] arguments = line.split(" ");
            String cmd = arguments[0];

            if ("exit".equals(cmd)) {
                break;
            }

            Command command = commandResolver.resolve(cmd);
            command.doAction(arguments);
        }
    }
}
