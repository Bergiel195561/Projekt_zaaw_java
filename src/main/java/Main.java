import ApplicationUtilitis.ApplicationCore;
import Command.*;
import DB.CascadeSave;
import DB.MongoConnector;
import Helpers.TeamType;
import Model.*;
import Utils.CustomHashSet;

import java.util.ArrayList;
import java.util.Date;
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
        Main main = new Main(new ApplicationCore(), new CommandResolver(), MongoConnector.getInstance());

        main.start(args);
    }

    public Main(ApplicationCore core, CommandResolver commandResolver, MongoConnector mongoConnector) {
        this.core = core;
        this.commandResolver = commandResolver;
        this.mongoConnector = mongoConnector;
        this.mongoConnector.setDbNameForDefault();
//        this.core.addCompany(mongoConnector.getDatastore().find(Company.class).get());
    }

    private void init() {
        commandResolver.registerCommand(new ActionCommand(core, mongoConnector));
        commandResolver.registerCommand(new GetFromDBCommand(core, mongoConnector));
        commandResolver.registerCommand(new SaveToDBCommand(core, new CascadeSave(mongoConnector)));
        commandResolver.registerCommand(new AddDepartmentCommand(core));
        commandResolver.registerCommand(new RemoveEmployeeCommand(core, mongoConnector));
        commandResolver.registerCommand(new SearchEmployeeByPeselCommand(core));
        commandResolver.registerCommand(new AddManagerCommand(core));
        commandResolver.registerCommand(new SetCompanyManagerCommand(core));
        commandResolver.registerCommand(new AddEmployeeCommand(core));
        commandResolver.registerCommand(new SetEmployeeCommand(core));
        commandResolver.registerCommand(new DisplayCompanyDescriptionCommand(core));
        commandResolver.registerCommand(new SetTeamCommand(core));
        commandResolver.registerCommand(new DisplayDepartmentDescriptionCommand(core));
        commandResolver.registerCommand(new SetTeamManagerCommand(core));
        commandResolver.registerCommand(new DisplayEmployeeDescriptionCommand(core));
        commandResolver.registerCommand(new DisplayEmployeeNumberCommand(core));
        commandResolver.registerCommand(new AddCompanyCommand(core));
        commandResolver.registerCommand(new AddTeamCommand(core));
        commandResolver.registerCommand(new InfoCommand());
        commandResolver.registerCommand(new PrintCommand(core));
        commandResolver.registerCommand(new HelpCommand());
        commandResolver.registerCommand(new GetCurrencyCommand());
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
