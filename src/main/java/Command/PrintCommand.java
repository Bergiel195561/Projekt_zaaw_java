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
