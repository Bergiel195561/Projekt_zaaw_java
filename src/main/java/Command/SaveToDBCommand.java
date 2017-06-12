package Command;

import ApplicationUtilitis.ApplicationCore;
import DB.MongoConnector;
import Model.*;

/**
 * Created by Bartek on 11.06.2017.
 */
public class SaveToDBCommand implements Command {
    private ApplicationCore core;
    private MongoConnector mongoConnector;

    public SaveToDBCommand(ApplicationCore core, MongoConnector mongoConnector) {
        this.core = core;
        this.mongoConnector = mongoConnector;
    }

    @Override
    public String getCommandName() {
        return "save_to_db";
    }

    @Override
    public void doAction(String[] args) {
        for (Company company : core.getCompanies()) {
            mongoConnector.save(company);
        }

        for (Department department : core.getDepartments()) {
            mongoConnector.save(department);
        }

        for (Employee employee : core.getEmployees()) {
            mongoConnector.save(employee);
        }

        for (Manager manager : core.getManagers()) {
            mongoConnector.save(manager);
        }

        for (OrdinaryEmployee ordinaryEmployee : core.getOrdinaryEmployees()) {
            mongoConnector.save(ordinaryEmployee);
        }

        for (Team team : core.getTeams()) {
            mongoConnector.save(team);
        }

    }

    @Override
    public String getShortHelp() {
        return "save_to_db - save data to database";
    }

    @Override
    public String getLongHelp() {
        return "save_to_db - save all data to database";
    }
}