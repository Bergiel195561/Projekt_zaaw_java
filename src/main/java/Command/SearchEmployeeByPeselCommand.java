package Command;

import ApplicationUtilitis.ApplicationCore;
import Model.OrdinaryEmployee;

import java.util.Scanner;

/**
 * Created by Bartek on 13.06.2017.
 * Komenda odpowiedzialna za pobranie pracownika po peselu
 */
public class SearchEmployeeByPeselCommand implements Command {
    private ApplicationCore core;

    public SearchEmployeeByPeselCommand(ApplicationCore core) {
        this.core = core;
    }

    @Override
    public String getCommandName() {
        return "search_employee";
    }

    @Override
    public void doAction(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Employee pesel: ");
        String employeePesel = scanner.nextLine();


        boolean set = false;
        for (OrdinaryEmployee ordinaryEmployee : core.getOrdinaryEmployees()) {
            if (ordinaryEmployee.getPesel().toLowerCase().contains(employeePesel.toLowerCase())) {
                System.out.println(ordinaryEmployee.toString());
                set = true;
            }
        }

        if (!set) {
            System.out.println("There is no such employee");
        }
    }

    @Override
    public String getShortHelp() {
        return "search_employee - search employee";
    }

    @Override
    public String getLongHelp() {
        return "search_employee - search employee by pesel";
    }
}