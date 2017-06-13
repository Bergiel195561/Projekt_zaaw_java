package Command;

import ApplicationUtilitis.ApplicationCore;
import Model.Company;
import Statistics.CompanyStatistics;

import java.util.Scanner;

/**
 * Created by Bartek on 13.06.2017.
 * Komenda odpowiedzialna za wyswietlenie opisu firmy
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
        Scanner scanner = new Scanner(System.in);
        System.out.println("Company name: ");
        String companyName = scanner.nextLine();

        boolean set = false;

        for (Company company : core.getCompanies()) {
            if (company.getName().equals(companyName)) {
                System.out.println(CompanyStatistics.getWholeCompanyDescription(company));
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
        return "company_desc - display company description";
    }

    @Override
    public String getLongHelp() {
        return "company_desc - display company description";
    }
}