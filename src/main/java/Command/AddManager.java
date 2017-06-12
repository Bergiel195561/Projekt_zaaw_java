package Command;

import ApplicationUtilitis.ApplicationCore;
import ApplicationUtilitis.CompanyBuilder;
import Model.Company;

import java.util.Scanner;

/**
 * Created by Bartek on 11.06.2017.
 */
public class AddManager implements Command {

    private ApplicationCore core;

    public AddManager(ApplicationCore core) {
        this.core = core;
    }

    @Override
    public String getCommandName() {
        return "add_manager";
    }

    @Override
    public void doAction(String[] args) {

        Scanner scanner = new Scanner(System.in);

        CompanyBuilder builder = new CompanyBuilder();
        System.out.println("Employee id: ");
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
        return "add_manager - adds a new manager";
    }

    @Override
    public String getLongHelp() {
        return "add_manager - adds a new manager";
    }
}
