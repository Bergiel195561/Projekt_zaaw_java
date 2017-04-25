import Model.Company;
import Model.Department;
import Model.Manager;
import Model.OrdinaryEmployee;

import java.util.ArrayList;

/**
 * Created by bartekstolinski on 25/04/2017.
 */
public class CompanyBuilder {
    private Company company;

    public void createCompany(String name, String street, String city, String phone) {
        this.company = new Company(name, street, city, phone, new ArrayList<>());
    }

    public void addDepartment(String departmentName) {
        this.company.addDepartment(new Department(departmentName));
    }

    public void setCompanyCeo(String ceoName, String ceoSurname) {
        this.company.setCeo(new Manager(ceoName, ceoSurname, "CEO")); //TODO enum
    }

    public void setDepartmentManager(Integer departmentId, String managerName, String managerSurname, String managerJobPosition) {
        this.company.getDepartments().get(departmentId).setDepartmentLeader(new Manager(managerName, managerSurname, managerJobPosition));
    }

    public void addOrdinaryEmployeeToDepartment(Integer departmentId, String employeeName, String employeeSurname, String employeeJobPosition) {
        this.company.getDepartments().get(departmentId).addDepartmentMember(new OrdinaryEmployee(employeeName, employeeSurname, employeeJobPosition));
    }

    public Company getCompany() {
        return company;
    }
}