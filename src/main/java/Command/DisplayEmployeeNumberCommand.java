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
        Company company = core.getCompanies().get(0);
        System.out.println("Employees number for " + company.getName() + ": " + CompanyStatistics.getNumberOfEmployees(company));
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