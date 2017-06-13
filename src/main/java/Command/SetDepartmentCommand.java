package Command;

import ApplicationUtilitis.ApplicationCore;
import Model.Company;
import Model.Department;

import java.util.Scanner;

/**
 * Created by Bartek on 12.06.2017.
 */
public class SetDepartmentCommand implements Command {
    private ApplicationCore core;

    public SetDepartmentCommand(ApplicationCore core) {
        this.core = core;
    }

    @Override
    public String getCommandName() {
        return "set_department";
    }

    @Override
    public void doAction(String[] args) {
        Scanner scanner = new Scanner(System.in);
        for (Company company : core.getCompanies()) {
            System.out.println(company.toString());
        }
        System.out.println("Company name: ");
        String companyName = scanner.nextLine();


        for (Department department : core.getDepartments()) {
            System.out.println(department.toString());
        }
        System.out.println("Department name: ");
        String departmentName = scanner.nextLine();

        boolean set = false;
        for (Company company : core.getCompanies()) {
            if (company.getName().equals(companyName)) {
                for (Department department : core.getDepartments()) {
                    if (department.getName().equals(departmentName)) {
                        if (!company.getDepartments().contains(department)) {
                            company.getDepartments().add(department);
                            set = true;
                            break;
                        } else {
                            System.out.println("This company include this department");
                            set = true;
                            break;
                        }
                    }
                }
                break;
            }
        }
        if (!set) {
            System.out.println("There is no such company or departments");
        }
    }

    @Override
    public String getShortHelp() {
        return "set_department - set company department";
    }

    @Override
    public String getLongHelp() {
        return "set_department - add department to company";
    }
}