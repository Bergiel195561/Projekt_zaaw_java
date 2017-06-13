package Command;

import ApplicationUtilitis.ApplicationCore;
import ApplicationUtilitis.CompanyBuilder;
import DB.MongoConnector;
import DB.OrdinaryEmployeeDao;
import Model.Company;
import Model.OrdinaryEmployee;

import java.util.List;
import java.util.Scanner;

/**
 * Obsługa dodatkowych akcji dla pracownikow
 */
public class ActionCommand implements Command {

    private ApplicationCore core;
    private MongoConnector mongoConnector;

    public ActionCommand(ApplicationCore core, MongoConnector mongoConnector) {
        this.core = core;
        this.mongoConnector = mongoConnector;
    }

    @Override
    public String getCommandName() {
        return "actions";
    }

    @Override
    public void doAction(String[] args) {

        OrdinaryEmployeeDao employeeDao = new OrdinaryEmployeeDao(mongoConnector.getDatastore());

        System.out.println("1. Search employee by name");
        System.out.println("2. Search employee by pesel");
        System.out.println("3. Search employee with salary greather then");
        System.out.println("4. Increase salary for employee");

        Scanner scanner = new Scanner(System.in);
        int operationNumber = scanner.nextInt();

        switch (operationNumber) {
            case 1:
                System.out.println("Employee name: ");
                String empName = scanner.next();
                OrdinaryEmployee employeeByName = employeeDao.getEmployeeByName(empName);

                if (employeeByName != null) {
                    System.out.println(employeeByName);
                } else {
                    System.out.println("Nie znaleziono pracownika");
                }

                break;
            case 2:
                System.out.println("Employee pesel: ");
                String empPesel = scanner.next();
                OrdinaryEmployee employeeByPesel = employeeDao.getEmployeeByPesel(empPesel);

                if (employeeByPesel != null) {
                    System.out.println(employeeByPesel);
                } else {
                    System.out.println("Nie znaleziono pracownika");
                }

                break;
            case 3:
                System.out.println("Minimum salary: ");
                float salary = scanner.nextFloat();
                List<OrdinaryEmployee> higherSalary = employeeDao.getEmployeesWithHigherSalary(salary);

                if (higherSalary.size() > 0) {
                    for (OrdinaryEmployee e : higherSalary) {
                        System.out.println(e.getName() + " : " + e.getPesel() + " : " + e.getSalary());
                    }
                } else {
                    System.out.println("Nie znaleziono pracownika");
                }

                break;
            case 4:
                System.out.println("Employee Name: ");
                String empName2 = scanner.next();
                OrdinaryEmployee employeeByName2 = employeeDao.getEmployeeByName(empName2);

                System.out.println("Salary increase: ");
                float increase = scanner.nextFloat();

                if (employeeByName2 != null){
                    System.out.println("Pracownik:");
                    System.out.println(employeeByName2.getName() + " : " + employeeByName2.getPesel() + " : " + employeeByName2.getSalary());

                    System.out.println("Podwyżka o " + increase);
                    employeeByName2.setSalary(employeeByName2.getSalary() + increase);
                    employeeDao.increaseSalary(increase, empName2);
                } else {
                    System.out.println("Nie znaleziono pracownika");
                }
                break;
            default:
                System.out.println("Błędna operacja");
                break;
        }
    }

    @Override
    public String getShortHelp() {
        return "actions - make actions";
    }

    @Override
    public String getLongHelp() {
        return "actions - make actions on employee";
    }
}
