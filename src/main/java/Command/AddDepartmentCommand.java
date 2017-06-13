package Command;

import ApplicationUtilitis.ApplicationCore;
import ApplicationUtilitis.DepartmentBuilder;
import Model.Department;

import java.util.Scanner;

/**
 * Created by Bartek on 12.06.2017.
 * Komenda odpowiedzialna za dodanie działu
 */
public class AddDepartmentCommand implements Command {

    private ApplicationCore core;

    public AddDepartmentCommand(ApplicationCore core) {
        this.core = core;
    }

    @Override
    public String getCommandName() {
        return "add_department";
    }

    @Override
    public void doAction(String[] args) {

        Scanner scanner = new Scanner(System.in);

        DepartmentBuilder builder = new DepartmentBuilder();
        System.out.println("Department name: ");
        String departmentName = scanner.nextLine();
        builder.createDepartment(departmentName);

        Department department = builder.getDepartment();
        core.addDepartment(department);


    }

    @Override
    public String getShortHelp() {
        return "add_department - adds a new department";
    }

    @Override
    public String getLongHelp() {
        return "add_department - adds a new department";
    }
}
