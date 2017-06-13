package Command;

import ApplicationUtilitis.ApplicationCore;
import Model.Company;
import Statistics.CompanyStatistics;

import java.util.Scanner;

/**
 * Created by Bartek on 13.06.2017.
 */
public class DisplayEmployeeNumberCommand implements Command {
    private ApplicationCore core;

    public DisplayEmployeeNumberCommand(ApplicationCore core) {
        this.core = core;
    }

    @Override
    public String getCommandName() {
        return "display_employee_number";
    }

    @Override
    public void doAction(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Company name: ");
        String companyName = scanner.nextLine();

        boolean set = false;

        for (Company company : core.getCompanies()) {
            if (company.getName().equals(companyName)) {
                System.out.println("Employees number for " + companyName + ": " + CompanyStatistics.getNumberOfEmployees(company));
                set = true;
                break;
            }
        }

        if (!set) {
            System.out.println("There is no such company");
        }
    }

    @Override
    public String getShortHelp() {
        return "display_employee_number - display employee number";
    }

    @Override
    public String getLongHelp() {
        return "display_employee_number - display employee number in company";
    }
}