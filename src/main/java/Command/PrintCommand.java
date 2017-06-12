package Command;

import ApplicationUtilitis.ApplicationCore;
import Model.Company;
import Model.Employee;
import Model.Manager;

/**
 * Created by bartekstolinski on 25/04/2017.
 */
public class PrintCommand implements Command {

    private ApplicationCore core;

    public PrintCommand(ApplicationCore core) {
        this.core = core;
    }

    @Override
    public String getCommandName() {
        return "print";
    }

    @Override
    public void doAction(String[] args) {
        for (Company company : core.getCompanies()) {
            System.out.println(company.toString());
        }

        System.out.println();

        for (Employee employee : core.getEmployees()) {
            System.out.println(employee.toString());
        }

        System.out.println();

        for (Manager manager : core.getManagers()) {
            System.out.println(manager.toString());
        }
    }

    @Override
    public String getShortHelp() {
        return "print - displays all companies";
    }

    @Override
    public String getLongHelp() {
        return "print - displays all companies, CEO, departments";
    }

}
