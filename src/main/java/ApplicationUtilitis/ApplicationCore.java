package ApplicationUtilitis;

import Model.*;
import Utils.CustomHashSet;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by bartekstolinski on 25/04/2017.
 */
public class ApplicationCore {

    private CustomHashSet<Company> companies = new CustomHashSet<>();
    private Set<Department> departments = new HashSet<>();
    private Set<Employee> employees = new HashSet<>();
    private Set<Manager> managers = new HashSet<>();
    private Set<OrdinaryEmployee> ordinaryEmployees = new HashSet<>();
    private Set<Team> teams = new HashSet<>();

    //region Getter
    public CustomHashSet<Company> getCompanies() {
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


    public void addCompany(Company company) {
        companies.add(company);
        for (Department dep: company.getDepartments()) {
            addDepartment(dep);
            for (Team team: dep.getTeams()) {
                addTeam(team);
                for(OrdinaryEmployee emp : team.getTeamMembers()){
                    addEmployee(emp);
                }
                addManager(team.getTeamLeader());
            }
        }
    }

    public void addEmployee(Employee employee) {
        employees.add(employee);
    }

    public void addOrdinaryEmployee(OrdinaryEmployee ordinaryEmployee) {
        ordinaryEmployees.add(ordinaryEmployee);
    }

    public void addManager(Manager manager) {
        managers.add(manager);
    }

    public void addTeam(Team team) {
        teams.add(team);
    }

    public void addDepartment(Department department) {
        companies.get(0).addDepartment(department);
        departments.add(department);
    }


    //region Add all
    public void addAllCompanies(List<Company> companies) {
        this.companies.clear();
        this.companies.addAll(companies);
    }

    public void addAllDepartments(List<Department> departments) {
        this.departments.clear();
        this.departments.addAll(departments);
    }

    public void addAllEmployees(List<Employee> employees) {
        this.employees.clear();
        this.employees.addAll(employees);
    }

    public void addAllManagers(List<Manager> managers) {
        this.managers.clear();
        this.managers.addAll(managers);
    }

    public void addAllOrdinaryEmployees(List<OrdinaryEmployee> ordinaryEmployees) {
        this.ordinaryEmployees.clear();
        this.ordinaryEmployees.addAll(ordinaryEmployees);
    }

    public void addAllTeams(List<Team> teams) {
        this.teams.clear();
        this.teams.addAll(teams);
    }
    //endregion
}
