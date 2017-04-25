package Model;

import java.util.HashSet;
import java.util.Set;

/**
 * Klasa odpowiedzialna za dział w firmie
 *
 * @author krystian
 */
public class Department {
    private String name;
    private Manager departmentLeader;
    private Set<OrdinaryEmployee> departmentMembers = new HashSet<OrdinaryEmployee>();

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

    public void setDepartmentMembers(Set<OrdinaryEmployee> departmentMembers) {
        this.departmentMembers = departmentMembers;
    }

    public void addDepartmentMember(OrdinaryEmployee newMember) {
        this.departmentMembers.add(newMember);
    }
    //endregion

    //region Getters
    public String getName() {
        return name;
    }

    public Manager getDepartmentLeader() {
        return departmentLeader;
    }

    public Set<OrdinaryEmployee> getDepartmentMembers() {
        return departmentMembers;
    }
    //endregion

    @Override
    public String toString() {
        return "Department{name='" + name + "}";
    }
}
