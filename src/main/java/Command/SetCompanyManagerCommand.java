package Command;

import ApplicationUtilitis.ApplicationCore;
import Model.Company;
import Model.Manager;

import java.util.Scanner;

/**
 * Created by Bartek on 12.06.2017.
 * Komenda odpowiedzialna za ustawienie mendzare
 */
public class SetCompanyManagerCommand implements Command {
    private ApplicationCore core;

    public SetCompanyManagerCommand(ApplicationCore core) {
        this.core = core;
    }

    @Override
    public String getCommandName() {
        return "set_company_manager";
    }

    @Override
    public void doAction(String[] args) {
        Scanner scanner = new Scanner(System.in);

        for (Manager manager : core.getManagers()) {
            System.out.println(manager.getPesel());
        }

        System.out.println("Manager pesel: ");
        String managerHumanId = scanner.nextLine();

        boolean set = false;
        Manager foudManager = null;
        for (Manager manager : core.getManagers()) {
            if (manager.getPesel().equals(managerHumanId)) {
                core.getCompanies().get(0).setCeo(manager);
                set = true;
                foudManager = manager;
                break;
            }
        }


        if (!set) {
            System.out.println("There is no such manager");
        } else {
            core.getManagers().remove(foudManager);
        }
    }

    @Override
    public String getShortHelp() {
        return "set_company_manager - set company manager";
    }

    @Override
    public String getLongHelp() {
        return "set_company_manager - set company manager";
    }
}