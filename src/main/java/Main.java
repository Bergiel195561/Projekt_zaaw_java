import ApplicationUtilitis.ApplicationCore;
import Command.Command;
import Command.CommandResolver;
import Command.HelpCommand;
import Command.PrintCommand;
import Command.AddCompanyCommand;
import Command.InfoCommand;
import DB.MongoConnector;

import java.util.Scanner;

/**
 * @author Jaromir
 *         Created by apple on 25/04/17.
 */
public class Main {

    private ApplicationCore core;
    private CommandResolver commandResolver;

    public static void main(String[] args) {
        MongoConnector m = new MongoConnector();
        Main main = new Main(new ApplicationCore(), new CommandResolver());
        main.start(args);

//        Employee employee1 = EmployeeFactory.getEmployee(EmployeeType.OrdinaryEmployee);
//        Employee employee2 = EmployeeFactory.getEmployee(EmployeeType.Manager);

//        System.out.println(employee1.toString());
//        System.out.println(employee2.toString());

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
