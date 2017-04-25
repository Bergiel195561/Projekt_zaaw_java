package Model;

import Utils.CustomHashSet;

/**
 * Klasa odpowiedzialna za dział w firmie
 *
 * @author krystian
 */
public class Department {
    private String name;
    private Manager departmentLeader;
    private CustomHashSet<Team> teams = new CustomHashSet<Team>();

    public Department(String name) {
        this.name = name;
    }

    //region Setters
    public void setName(String name) {
        this.name = name;
    }

    public void setDepartmentLeader(Manager departmentLeader) {
        this.departmentLeader = departmentLeader;
    }

    public void setTeams(CustomHashSet<Team> teams) {
        this.teams = teams;
    }

    public void addTeam(Team newTeam) {
        this.teams.add(newTeam);
    }
    //endregion

    //region Getters
    public String getName() {
        return name;
    }

    public Manager getDepartmentLeader() {
        return departmentLeader;
    }

    public CustomHashSet<Team> getTeams() {
        return teams;
    }
    //endregion

    @Override
    public String toString() {
        return "Department{name='" + name + "}";
    }
}
