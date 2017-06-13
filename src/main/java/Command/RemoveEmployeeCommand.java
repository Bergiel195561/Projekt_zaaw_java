package Command;

import ApplicationUtilitis.ApplicationCore;
import DB.MongoConnector;
import Model.*;

import java.util.Scanner;

/**
 * Created by Bartek on 13.06.2017.
 * Komenda odpowiedzialna za usuwanie pracownika
 */
public class RemoveEmployeeCommand implements Command {
    private ApplicationCore core;
    private MongoConnector mongoConnector;


    public RemoveEmployeeCommand(ApplicationCore core, MongoConnector mongoConnector) {
        this.core = core;
        this.mongoConnector = mongoConnector;
    }

    @Override
    public String getCommandName() {
        return "remove_employee";
    }

    @Override
    public void doAction(String[] args) {
        Scanner scanner = new Scanner(System.in);
        for (Employee employee : core.getEmployees()) {
            System.out.println(employee.toString());
        }

        System.out.println("Employee pesel: ");
        String employeePesel = scanner.nextLine();

        int size = core.getOrdinaryEmployees().size();
        for (Team team : core.getTeams()) {
            team.getTeamMembers().removeIf(ordinaryEmployee -> {
                if (ordinaryEmployee.getPesel().equals(employeePesel)) {
                    mongoConnector.getDatastore().delete(ordinaryEmployee);
                    return true;
                } else return false;
            });
        }

        core.getOrdinaryEmployees().removeIf(ordinaryEmployee -> {
            if (ordinaryEmployee.getPesel().equals(employeePesel)) {
                mongoConnector.getDatastore().delete(ordinaryEmployee);
                return true;
            } else return false;
        });

        if (core.getOrdinaryEmployees().size() == size) {
            System.out.println("There is no such employee");
        }
    }

    @Override
    public String getShortHelp() {
        return "remove_employee - remove employee";
    }

    @Override
    public String getLongHelp() {
        return "remove_employee - remove employee from app and database";
    }
}