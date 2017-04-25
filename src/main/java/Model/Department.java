package Model;

import Helpers.DepartmentType;
import Utils.CustomHashSet;

import java.util.HashSet;
import java.util.Set;

/**
 * Klasa odpowiedzialna za dział w firmie
 *
 * @author krystian
 */
public class Department {
    private DepartmentType type;
    private Manager departmentLeader;
    private CustomHashSet<OrdinaryEmployee> departmentMembers = new CustomHashSet<OrdinaryEmployee>();

    public Department(DepartmentType type) {
        this.type = type;
    }

    //region Setters
    public void setType(DepartmentType type) {
        this.type = type;
    }

    public void setDepartmentLeader(Manager departmentLeader) {
        this.departmentLeader = departmentLeader;
    }

    public void setDepartmentMembers(CustomHashSet<OrdinaryEmployee> departmentMembers) {
        this.departmentMembers = departmentMembers;
    }

    public void addDepartmentMember(OrdinaryEmployee newMember) {
        this.departmentMembers.add(newMember);
    }
    //endregion

    //region Getters
    public DepartmentType getType() {
        return type;
    }

    public Manager getDepartmentLeader() {
        return departmentLeader;
    }

    public CustomHashSet<OrdinaryEmployee> getDepartmentMembers() {
        return departmentMembers;
    }
    //endregion

    @Override
    public String toString() {
        return "Department{name='" + type + "}";
    }
}
