package Command;

import ApplicationUtilitis.ApplicationCore;
import Model.Company;
import Statistics.CompanyStatistics;

import java.util.Scanner;

/**
 * Created by Bartek on 13.06.2017.
 */
public class DisplayCompanyDescriptionCommand implements Command {
    private ApplicationCore core;

    public DisplayCompanyDescriptionCommand(ApplicationCore core) {
        this.core = core;
    }

    @Override
    public String getCommandName() {
        return "company_desc";
    }

    @Override
    public void doAction(String[] args) {
        System.out.println(CompanyStatistics.getWholeCompanyDescription(core.getCompanies().get(0)));
    }

    @Override
    public String getShortHelp() {
        return "company_desc - display company description";
    }

    @Override
    public String getLongHelp() {
        return "company_desc - display company description";
    }
}