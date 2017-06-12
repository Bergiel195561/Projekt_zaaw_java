import ApplicationUtilitis.ApplicationCore;
import Command.Command;
import Command.CommandResolver;
import Command.HelpCommand;
import Command.PrintCommand;
import Command.AddCompanyCommand;
import Command.InfoCommand;
import Command.GetFromDBCommand;
import Command.SaveToDBCommand;
import Command.AddEmployeeCommand;
import Command.AddManagerCommand;
import Command.AddTeamCommand;
import Command.SetCompanyManagerCommand;
import Command.SetEmployeeCommand;
import Command.SetTeamManagerCommand;
import Command.AddDepartmentCommand;
import Command.SetTeamCommand;


import DB.MongoConnector;

import java.util.Scanner;

/**
 * @author Jaromir
 *         Created by apple on 25/04/17.
 */
public class Main {

    private ApplicationCore core;
    private CommandResolver commandResolver;
    private MongoConnector mongoConnector;

    public static void main(String[] args) {
        MongoConnector.setDbNameForDefault();
        Main main = new Main(new ApplicationCore(), new CommandResolver(), new MongoConnector());
        main.start(args);
    }

    public Main(ApplicationCore core, CommandResolver commandResolver, MongoConnector mongoConnector) {
        this.core = core;
        this.commandResolver = commandResolver;
        this.mongoConnector = mongoConnector;
    }

    private void init() {
        commandResolver.registerCommand(new GetFromDBCommand(core, mongoConnector));
        commandResolver.registerCommand(new SaveToDBCommand(core, mongoConnector));
        commandResolver.registerCommand(new AddDepartmentCommand(core));
        commandResolver.registerCommand(new AddManagerCommand(core));
        commandResolver.registerCommand(new SetCompanyManagerCommand(core));
        commandResolver.registerCommand(new AddEmployeeCommand(core));
        commandResolver.registerCommand(new SetEmployeeCommand(core));
        commandResolver.registerCommand(new SetTeamCommand(core));
        commandResolver.registerCommand(new SetTeamManagerCommand(core));
        commandResolver.registerCommand(new AddCompanyCommand(core));
        commandResolver.registerCommand(new AddTeamCommand(core));
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
