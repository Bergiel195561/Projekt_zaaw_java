package Command;

import ApplicationUtilitis.ApplicationCore;
import Model.Department;
import Statistics.CompanyStatistics;

import java.util.Scanner;

/**
 * Created by Bartek on 13.06.2017.
 * Komenda odpowiedzialna za wyswietlenie opisu działu
 */
public class DisplayDepartmentDescriptionCommand implements Command {
    private ApplicationCore core;

    public DisplayDepartmentDescriptionCommand(ApplicationCore core) {
        this.core = core;
    }

    @Override
    public String getCommandName() {
        return "department_desc";
    }

    @Override
    public void doAction(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Department name: ");
        String departmentName = scanner.nextLine();

        boolean set = false;

        for (Department department : core.getDepartments()) {
            if (department.getName().equals(departmentName)) {
                CompanyStatistics.getDepartmentDescription(department);
                set = true;
                break;
            }
        }

        if (!set) {
            System.out.println("There is no such department");
        }
    }

    @Override
    public String getShortHelp() {
        return "department_desc - display department description";
    }

    @Override
    public String getLongHelp() {
        return "department_desc - display codepartmentmpany description";
    }
}