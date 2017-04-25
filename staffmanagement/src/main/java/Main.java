import Fabrics.EmployeeFactory;
import Helpers.EmployeeType;
import Model.Employee;
import Model.Manager;

/**
 * @author Jaromir
 * Created by apple on 25/04/17.
 */
public class Main {
    public static void main (String[] args){

        Employee employee1 = EmployeeFactory.getEmployee(EmployeeType.OrdinaryEmployee);
        Employee employee2 = EmployeeFactory.getEmployee(EmployeeType.Manager);

        System.out.println(employee1.toString());
        System.out.println(employee2.toString());

    }
}
