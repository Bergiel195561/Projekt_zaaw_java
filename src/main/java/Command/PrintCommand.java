package Command;

import ApplicationUtilitis.ApplicationCore;
import Model.*;

/**
 * Created by bartekstolinski on 25/04/2017.
 * Komenda odpowiedzialna za wyswietlanie
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

        for (Department department : core.getDepartments()) {
            System.out.println(department.toString());
        }

        System.out.println();

        for (OrdinaryEmployee ordinaryEmployee : core.getOrdinaryEmployees()) {
            System.out.println(ordinaryEmployee.toString());
        }

        System.out.println();

        for (Manager manager : core.getManagers()) {
            System.out.println(manager.toString());
        }

        System.out.println();

        for (Team team : core.getTeams()) {
            System.out.println(team.toString());
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
