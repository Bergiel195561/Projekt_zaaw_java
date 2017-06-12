package Command;

import ApplicationUtilitis.ApplicationCore;
import ApplicationUtilitis.EmployeeBuilder;
import ApplicationUtilitis.ManagerBuilder;
import Model.Employee;
import Model.Manager;

import java.util.Date;
import java.util.Scanner;

/**
 * Created by Bartek on 12.06.2017.
 */
public class AddManagerCommand implements Command {
    private ApplicationCore core;

    public AddManagerCommand(ApplicationCore core) {
        this.core = core;
    }

    @Override
    public String getCommandName() {
        return "add_manager";
    }

    @Override
    public void doAction(String[] args) {

        Scanner scanner = new Scanner(System.in);

        ManagerBuilder builder = new ManagerBuilder();
        System.out.println("Human id: ");
        String managerId = scanner.nextLine();
        System.out.println("Name: ");
        String managerName = scanner.nextLine();
        System.out.println("Surname: ");
        String managerSurname = scanner.nextLine();
        System.out.println("Salary: ");
        String managerSalary = scanner.nextLine();

        builder.createManager(managerId);
        builder.setManagerName(managerName);
        builder.setManagerSurname(managerSurname);
        builder.setManagerJobPosition();
        builder.setManagerSalary(Float.valueOf(managerSalary));
        builder.setManagerHireDate(new Date());

        Manager manager = builder.getManager();
        core.addManager(manager);
    }

    @Override
    public String getShortHelp() {
        return "add_manager - adds a new manager";
    }

    @Override
    public String getLongHelp() {
        return "add_manager - adds a new manager - human id, name, surname, job position, salary, hire date";
    }
}