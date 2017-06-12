package DB;

import Model.*;
import Utils.CustomHashSet;
import org.mongodb.morphia.Datastore;

import java.util.List;

/**
 * Klasa odpowiedzialna za kaskadowy zapis do bazy danych
 * Created by krystian on 12.06.17.
 */
public class CascadeSave {

    private MongoConnector connector;

    public CascadeSave(MongoConnector _connector) {
        this.connector = _connector;
    }

    /**
     * Kaskadowy zapis firmy
     * @param company
     */
    public void saveCasdace(Company company) {
        List<Department> departmentList = company.getDepartments();

        for (int i = 0; i < departmentList.size(); i++) {
            CustomHashSet<Team> teams = departmentList.get(i).getTeams();
            for (int j = 0; j < teams.size(); j++) {
                CustomHashSet<OrdinaryEmployee> teamMembers = teams.get(j).getTeamMembers();
                Manager departmentLeader = teams.get(j).getDepartmentLeader();
                saveManager(departmentLeader);
                saveEmployees(teamMembers);
            }
            saveTeams(teams);
        }
        saveDepartments(departmentList);
        saveCompany(company);
    }

    private void saveEmployees(CustomHashSet<OrdinaryEmployee> employeesForSave) {
        employeesForSave.forEach(e -> connector.save(e));
    }

    private void saveManager(Manager managerForSave) {
        connector.save(managerForSave);
    }

    private void saveTeams(CustomHashSet<Team> teamsForSave) {
        teamsForSave.forEach(e -> connector.save(e));
    }

    private void saveDepartments(List<Department> departmentsForSave) {
        departmentsForSave.forEach(e -> connector.save(e));
    }

    private void saveCompany(Company company){
        CompanyDao companyDao = new CompanyDao(connector.getDatastore());
        Company companyByName = companyDao.getCompanyByName(company.getName());
        if (companyByName != null){
            companyByName.setCity(company.getCity());
            companyByName.setPhone(company.getPhone());
            companyByName.setStreet(company.getStreet());
            companyByName.setDepartments(company.getDepartments());
            connector.save(companyByName);
        } else {
            connector.save(company);
        }
    }

}
