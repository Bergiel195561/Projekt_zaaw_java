package Utils;

import DB.MongoConnector;
import DB.OrdinaryEmployeeDao;
import Model.Employee;
import Model.OrdinaryEmployee;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * Klasa obsługująca metody dostępu do różnych Obiektow w bazie danych
 *
 * Created by apple on 12/06/17.
 */
public class EntitiesManager {

    private static MongoConnector mongoConnector;

    static{
        mongoConnector = MongoConnector.getInstance();
    }


    /**
     * Metoda zwracająca pracownika o nr pesel podanym w argumencie
     * @param pesel
     * @return
     */
    public static Optional<OrdinaryEmployee> getEmployeeByPesel(String pesel){

        List<OrdinaryEmployee> employees = mongoConnector.getDatastore().find(OrdinaryEmployee.class).asList();
        Optional<OrdinaryEmployee> employee = employees.stream()
                .filter(e -> e.getPesel().equalsIgnoreCase(pesel))
                .findFirst();

        return  employee;
    }

}
