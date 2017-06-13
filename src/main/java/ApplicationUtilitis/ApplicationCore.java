package ApplicationUtilitis;

import Model.*;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by bartekstolinski on 25/04/2017.
 */
public class ApplicationCore {

    private Set<Company> companies = new HashSet<>();
    private Set<Department> departments = new HashSet<>();
    private Set<Employee> employees = new HashSet<>();
    private Set<Manager> managers = new HashSet<>();
    private Set<OrdinaryEmployee> ordinaryEmployees = new HashSet<>();
    private Set<Team> teams = new HashSet<>();

    //region Getter
    public Set<Company> getCompanies() {
        return companies;
    }

    public Set<Department> getDepartments() {
        return departments;
    }

    public Set<Employee> getEmployees() {
        return employees;
    }

    public Set<Manager> getManagers() {
        return managers;
    }

    public Set<OrdinaryEmployee> getOrdinaryEmployees() {
        return ordinaryEmployees;
    }

    public Set<Team> getTeams() {
        return teams;
    }

    //endregion

    /**
     * Dodanie nowego Company
     *
     * @param company
     */
    public void addCompany(Company company) {
        companies.add(company);
        for (Department dep : company.getDepartments()) {
            addDepartment(dep);
            for (Team team : dep.getTeams()) {
                addTeam(team);
                for (OrdinaryEmployee emp : team.getTeamMembers()) {
                    addEmployee(emp);
                }
                addManager(team.getTeamLeader());
            }
        }
    }

    /**
     * Dodanie nowego Employee
     *
     * @param employee
     */
    public void addEmployee(Employee employee) {
        employees.add(employee);
    }

    /**
     * Dodanie nowego OrdinaryEmployee
     *
     * @param ordinaryEmployee
     */
    public void addOrdinaryEmployee(OrdinaryEmployee ordinaryEmployee) {
        ordinaryEmployees.add(ordinaryEmployee);
    }

    /**
     * Dodanie nowego Managera
     *
     * @param manager
     */
    public void addManager(Manager manager) {
        managers.add(manager);
    }

    /**
     * Dodanie nowego Team
     *
     * @param team
     */
    public void addTeam(Team team) {
        teams.add(team);
    }

    /**
     * Dodanie nowego Department
     *
     * @param department
     */
    public void addDepartment(Department department) {
        departments.add(department);
    }


    //region Add all

    /**
     * Dodanie listy wszystkich firm
     *
     * @param companies
     */
    public void addAllCompanies(List<Company> companies) {
        this.companies.clear();
        this.companies.addAll(companies);
    }

    /**
     * Dodanie listy wszystkich działów
     *
     * @param departments
     */
    public void addAllDepartments(List<Department> departments) {
        this.departments.clear();
        this.departments.addAll(departments);
    }

    /**
     * Dodanie listyy wszystkich pracowników
     *
     * @param employees
     */
    public void addAllEmployees(List<Employee> employees) {
        this.employees.clear();
        this.employees.addAll(employees);
    }

    /**
     * Dodanie listy wszystkich managerow
     *
     * @param managers
     */
    public void addAllManagers(List<Manager> managers) {
        this.managers.clear();
        this.managers.addAll(managers);
    }

    /**
     * Dodanie listy wszystkich zwykłych pracowników
     *
     * @param ordinaryEmployees
     */
    public void addAllOrdinaryEmployees(List<OrdinaryEmployee> ordinaryEmployees) {
        this.ordinaryEmployees.clear();
        this.ordinaryEmployees.addAll(ordinaryEmployees);
    }

    /**
     * Dodanie listy wszystkich teamow
     *
     * @param teams
     */
    public void addAllTeams(List<Team> teams) {
        this.teams.clear();
        this.teams.addAll(teams);
    }
    //endregion
}
