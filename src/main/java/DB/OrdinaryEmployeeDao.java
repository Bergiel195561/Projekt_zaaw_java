package DB;

import Model.Employee;
import Model.OrdinaryEmployee;
import org.mongodb.morphia.Datastore;
import org.mongodb.morphia.dao.BasicDAO;
import org.mongodb.morphia.query.Query;
import org.mongodb.morphia.query.UpdateOperations;

import java.util.List;

/**
 * Dao dla Employee
 * Created by Maciej on 10.06.2017.
 */
public class OrdinaryEmployeeDao extends BasicDAO<OrdinaryEmployee, String> {

    protected OrdinaryEmployeeDao(Datastore ds) {
        super(ds);
    }

    /**
     * Pobieranie pracownika po nazwisku
     * @param employeeSurname Nazwa szukanej firmy
     * @return Objekt klasy Company
     */
    public OrdinaryEmployee getEmployeeByName(String employeeSurname){
        Query<OrdinaryEmployee> query = createQuery().
                field("name").
                equal(employeeSurname);

        return query.get();
    }

    /**
     * Pobieranie pracowników z pensją większą od danej
     * @param salary Nazwa szukanej firmy
     * @return Lista OrdinaryEmployee
     */
    public List<OrdinaryEmployee> getEmployeesWithHigherSalary(float salary){
        List<OrdinaryEmployee> query = createQuery().
                field("salary").
                greaterThanOrEq(salary).
                asList();

        return query;
    }

    /**
     * Zwiekszanie pracownikowi o danym nazwisku pensji o dana wartosc
     * @param bonus,employeeSurname bonus wartosc podwyzki, employeeSurname nazwisko pracownika
     */
    public void increaseSalary(float bonus, String employeeSurname){
        float finalSalary;
        Query<OrdinaryEmployee> query = createQuery().
                field("name").
                equal(employeeSurname);

        finalSalary = query.get().
                getSalary() + bonus;

        UpdateOperations<OrdinaryEmployee> updateOperations = createUpdateOperations().
                set("salary", finalSalary);
        getDatastore().update(query,updateOperations);
    }




}
