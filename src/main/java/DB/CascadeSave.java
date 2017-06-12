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
     * Kaskadowy zapis firmy wraz ze wszystkimi jej elementami
     * w odpowiedniej kolejności wymuszonej zależnościami między
     * elementami firmy
     * @param company Firma do zapisania w bazie
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

    /**
     * Zapis pracowników w bazie
     * @param employeesForSave Pracownicy do zapisu w bazie
     */
    private void saveEmployees(CustomHashSet<OrdinaryEmployee> employeesForSave) {
        employeesForSave.forEach(e -> connector.save(e));
    }

    /**
     * Zapis managera zespołu w bazie
     * @param managerForSave Manager do zapisu w bazie
     */
    private void saveManager(Manager managerForSave) {
        connector.save(managerForSave);
    }

    /**
     * Zapis teamów w bazie
     * @param teamsForSave Zespoły do zapisu w bazie
     */
    private void saveTeams(CustomHashSet<Team> teamsForSave) {
        teamsForSave.forEach(e -> connector.save(e));
    }

    /**
     * Zapis działów w bazie
     * @param departmentsForSave Lista działów do zapisu w bazie
     */
    private void saveDepartments(List<Department> departmentsForSave) {
        departmentsForSave.forEach(e -> connector.save(e));
    }

    /**
     * Zapis firmy w bazie, jeżeli firma istnieje to aktualizujemy
     * @param company Firma do zapisu w bazie
     */
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
