package Command;

import ApplicationUtilitis.ApplicationCore;
import Model.Company;
import Model.Manager;

import java.util.Scanner;

/**
 * Created by Bartek on 12.06.2017.
 */
public class SetManagerCommand implements Command {
    private ApplicationCore core;

    public SetManagerCommand(ApplicationCore core) {
        this.core = core;
    }

    @Override
    public String getCommandName() {
        return "set_manager";
    }

    @Override
    public void doAction(String[] args) {
        Scanner scanner = new Scanner(System.in);
        for (Company company : core.getCompanies()) {
            System.out.println(company.toString());
        }

        System.out.println("Company name: ");
        String companyName = scanner.nextLine();


        for (Manager manager : core.getManagers()) {
            System.out.println(manager.toString());
        }

        System.out.println("Manager human id: ");
        String managerHumanId = scanner.nextLine();


        for (Company company : core.getCompanies()) {
            if (company.getName().equals(companyName)) {
                for (Manager manager : core.getManagers()) {
                    if (manager.getHumanId().equals(managerHumanId)) {
                        company.setCeo(manager);
                        break;
                    }
                }
                break;
            }
        }
    }

    @Override
    public String getShortHelp() {
        return "set_manager - set company manager";
    }

    @Override
    public String getLongHelp() {
        return "set_manager - set company manager";
    }
}