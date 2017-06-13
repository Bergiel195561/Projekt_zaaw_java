package Command;

import ApplicationUtilitis.ApplicationCore;
import DB.MongoConnector;
import DB.OrdinaryEmployeeDao;
import Model.*;
import Statistics.CompanyStatistics;
import Utils.CustomHashSet;

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
        OrdinaryEmployeeDao dao = new OrdinaryEmployeeDao(mongoConnector.getDatastore());

        Scanner scanner = new Scanner(System.in);

        CustomHashSet<OrdinaryEmployee> employees = CompanyStatistics.getEmployees(core.getCompanies().get(0));

        for (Employee employee : employees) {
            System.out.println(employee.getName() + " : " + employee.getPesel());
        }

        System.out.println("Employee pesel: ");
        String employeePesel = scanner.nextLine();
        OrdinaryEmployee employeeByPesel = dao.getEmployeeByPesel(employeePesel);

        if (employeeByPesel != null){
            for (Department d : core.getCompanies().get(0).getDepartments()){
                for (Team t : d.getTeams()){
                    t.getTeamMembers().removeIf(ordinaryEmployee -> {
                        if (ordinaryEmployee.getPesel().equals(employeePesel)) {
                            return true;
                        } else {
                            return false;
                        }
                    });
                }
            }
        } else {
            System.out.println("Nie znaleziono pracownika do usuniecia");
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