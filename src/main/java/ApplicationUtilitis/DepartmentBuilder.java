package ApplicationUtilitis;

import Model.Department;

/**
 * Created by Bartek on 12.06.2017.
 */
public class DepartmentBuilder {
    private Department department;

    public void createDepartment(String departmentName) {
        this.department = new Department();
        this.department.setName(departmentName);
    }

    public Department getDepartment() {
        return department;
    }
}