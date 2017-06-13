package Command;

import ApplicationUtilitis.ApplicationCore;
import ApplicationUtilitis.CompanyBuilder;
import Model.Company;

import java.util.Scanner;

/**
 * Created by bartekstolinski on 25/04/2017.
 * Komenda odpowiedzialna za dodanie firmy
 */
public class AddCompanyCommand implements Command {

    private ApplicationCore core;

    public AddCompanyCommand(ApplicationCore core) {
        this.core = core;
    }

    @Override
    public String getCommandName() {
        return "add_company";
    }

    @Override
    public void doAction(String[] args) {

        Scanner scanner = new Scanner(System.in);

        CompanyBuilder builder = new CompanyBuilder();
        System.out.println("Company name: ");
        String companyName = scanner.nextLine();
        System.out.println("Company city: ");
        String companyCity = scanner.nextLine();
        System.out.println("Company street: ");
        String companyStreet = scanner.nextLine();
        System.out.println("Company phone: ");
        String companyPhone = scanner.nextLine();
        builder.createCompany(companyName);
        builder.setCompanyCity(companyCity);
        builder.setCompanyStreet(companyStreet);
        builder.setCompanyPhone(companyPhone);

        Company company = builder.getCompany();
        core.addCompany(company);
    }

    @Override
    public String getShortHelp() {
        return "add_company - adds a new company";
    }

    @Override
    public String getLongHelp() {
        return "add_company - adds a new company with CEO, departments";
    }
}
