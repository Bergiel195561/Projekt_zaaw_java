package ApplicationUtilitis;

import Model.Employee;

import java.util.Date;

/**
 * Created by Bartek on 11.06.2017.
 */
public class EmployeeBuilder {
    private Employee employee;

    public void createEmployee(String id) {
        this.employee = new Employee();
        this.employee.setHumanId(id);
    }

    public void setEmployeeName(String name) {
        this.employee.setName(name);
    }

    public void setEmployeeSurname(String surname) {
        this.employee.setSurname(surname);
    }

    public void setEmployeeJobPosition(String jobPosition) {
        this.employee.setJobPosition(jobPosition);
    }

    public void setEmployeeSalary(float salary) {
        this.employee.setSalary(salary);
    }

    public void setEmployeeHireDate(Date hireDate) {
        this.employee.setHireDate(hireDate);
    }

    public Employee getEmployee() {
        return employee;
    }
}