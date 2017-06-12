package Utils;

import DB.MongoConnector;
import DB.OrdinaryEmployeeDao;
import Model.Employee;
import Model.OrdinaryEmployee;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * Created by apple on 12/06/17.
 */
public class EntitiesManager {

    private static MongoConnector mongoConnector;

    static{
        mongoConnector = MongoConnector.getInstance();
    }

    public static Optional<OrdinaryEmployee> getEmployeesByPesel(String pesel){

        List<OrdinaryEmployee> employees = mongoConnector.getDatastore().find(OrdinaryEmployee.class).asList();
        Optional<OrdinaryEmployee> employee = employees.stream()
                .filter(e -> e.getName().equalsIgnoreCase(pesel))
                .findFirst();

        return  employee;
    }

}
