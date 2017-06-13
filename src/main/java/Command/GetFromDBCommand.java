package Command;

import ApplicationUtilitis.ApplicationCore;
import DB.MongoConnector;
import Model.*;

import java.util.List;

/**
 * Created by Bartek on 10.06.2017.
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
        if (companies.size() == 0) {
            companies.add(new Company());
        }
        core.addAllCompanies(companies);
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
