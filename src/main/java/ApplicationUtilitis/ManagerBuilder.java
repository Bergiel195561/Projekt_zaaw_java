package ApplicationUtilitis;

import Model.Manager;

import java.util.Date;

/**
 * Created by Bartek on 12.06.2017.
 * Klasa tworząca menadżera
 */
public class ManagerBuilder {
    private Manager manager;

    public void createManager(String id) {
        this.manager = new Manager();
        this.manager.setPesel(id);
    }

    public void setManagerName(String name) {
        this.manager.setName(name);
    }

    public void setManagerSurname(String surname) {
        this.manager.setSurname(surname);
    }

    public void setManagerJobPosition() {
        this.manager.setJobPosition("CEO");
    }

    public void setManagerSalary(float salary) {
        this.manager.setSalary(salary);
    }

    public void setManagerHireDate(Date hireDate) {
        this.manager.setHireDate(hireDate);
    }

    public Manager getManager() {
        return manager;
    }
}