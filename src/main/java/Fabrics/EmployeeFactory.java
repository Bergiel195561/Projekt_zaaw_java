package Fabrics;

import Model.Employee;
import Helpers.EmployeeType;
import Model.Manager;
import Model.OrdinaryEmployee;

import java.util.HashMap;

/**
 * Klasa metody fabryki tworzacej nowy obiekt klasy Employee
 */
public class EmployeeFactory {

    public static Employee getEmployee(EmployeeType employeeType, HashMap<String, String> dataMap){

        if(dataMap != null && dataMap.containsKey("name") && dataMap.containsKey("surname") && dataMap.containsKey("jobPosition")){
            switch(employeeType){

                case OrdinaryEmployee:
                    return new OrdinaryEmployee(dataMap.get("name"), dataMap.get("surname"), dataMap.get("jobPosition"));

                case Manager:
                    return new Manager(dataMap.get("name"), dataMap.get("surname"), dataMap.get("jobPosition"));

                default:
                    break;
            }
        }
        else{

            switch(employeeType){

                case OrdinaryEmployee:
                    return new OrdinaryEmployee();

                case Manager:
                    return new Manager();

                default:
                    break;
            }
        }

        return null;
    }
}
