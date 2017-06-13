package Command;

import ApplicationUtilitis.ApplicationCore;
import DB.MongoConnector;
import Model.*;

import java.util.List;

/**
 * Created by Bartek on 10.06.2017.
 * Komenda odpowiedzialna za pobranie z bazy
 */
public class GetFromDBCommand implements Command {
    private ApplicationCore core;
    private MongoConnector mongoConnector;

    public GetFromDBCommand(ApplicationCore core, MongoConnector mongoConnector) {
        this.core = core;
        this.mongoConnector = mongoConnector;
    }

    @Override
    public String getCommandName() {
        return "get_from_db";
    }

    @Override
    public void doAction(String[] args) {
        List<Company> companies = mongoConnector.getDatastore().find(Company.class).asList();
        core.addAllCompanies(companies);

        List<Department> departments = mongoConnector.getDatastore().find(Department.class).asList();
        core.addAllDepartments(departments);

        List<Employee> employees = mongoConnector.getDatastore().find(Employee.class).asList();
        core.addAllEmployees(employees);

        List<Manager> managers = mongoConnector.getDatastore().find(Manager.class).asList();
        core.addAllManagers(managers);

        List<OrdinaryEmployee> ordinaryEmployees = mongoConnector.getDatastore().find(OrdinaryEmployee.class).asList();
        core.addAllOrdinaryEmployees(ordinaryEmployees);

        List<Team> teams = mongoConnector.getDatastore().find(Team.class).asList();
        core.addAllTeams(teams);
    }

    @Override
    public String getShortHelp() {
        return "get_from_db - get data from database";
    }

    @Override
    public String getLongHelp() {
        return "get_from_db - get all data from database";
    }
}
