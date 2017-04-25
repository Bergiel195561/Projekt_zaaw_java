package Fabrics;

import Model.Employee;
import Helpers.EmployeeType;
import Model.Manager;
import Model.OrdinaryEmployee;

/**
 * Klasa metody fabryki tworzacej nowy obiekt klasy Employee
 */
public class EmployeeFactory {

    public static Employee getEmployee(EmployeeType employeeType){
        switch(employeeType){

            case OrdinaryEmployee:
                return new OrdinaryEmployee();

            case Manager:
                return new Manager();

            default:
                break;
        }
        return null;
    }
}
