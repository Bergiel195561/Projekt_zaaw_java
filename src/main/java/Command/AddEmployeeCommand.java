package Command;

import ApplicationUtilitis.ApplicationCore;
import ApplicationUtilitis.EmployeeBuilder;
import Model.Employee;

import java.util.Date;
import java.util.Scanner;

/**
 * Created by Bartek on 12.06.2017.
 */
public class AddEmployeeCommand implements Command {

    private ApplicationCore core;

    public AddEmployeeCommand(ApplicationCore core) {
        this.core = core;
    }

    @Override
    public String getCommandName() {
        return "add_employee";
    }

    @Override
    public void doAction(String[] args) {

        Scanner scanner = new Scanner(System.in);

        EmployeeBuilder builder = new EmployeeBuilder();
        System.out.println("Human id: ");
        String employeeId = scanner.nextLine();
        System.out.println("Name: ");
        String employeeName = scanner.nextLine();
        System.out.println("Surname: ");
        String employeeSurname = scanner.nextLine();
        System.out.println("Job position: ");
        String employeeJobPosition = scanner.nextLine();
        System.out.println("Salary: ");
        String employeeSalary = scanner.nextLine();

        builder.createEmployee(employeeId);
        builder.setEmployeeName(employeeName);
        builder.setEmployeeSurname(employeeSurname);
        builder.setEmployeeJobPosition(employeeJobPosition);
        builder.setEmployeeSalary(Float.valueOf(employeeSalary));
        builder.setEmployeeHireDate(new Date());

        Employee employee = builder.getEmployee();
        core.addEmployee(employee);
    }

    @Override
    public String getShortHelp() {
        return "add_employee - adds a new employee";
    }

    @Override
    public String getLongHelp() {
        return "add_employee - adds a new employee - human id, name, surname, job position, salary, hire date";
    }
}