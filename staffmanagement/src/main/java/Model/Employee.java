package Model;

import java.util.Date;

/**
 * Created by apple on 25/04/17.
 */
public abstract class Employee {

    protected String name;
    protected String surname;
    protected String jobPosition;
    protected float salary;
    protected Date hireDate;
    protected int departmentId;

    //region Getters
    public String getName() {return name;}
    public String getSurname() {return surname;}
    public String getJobPosition() {return jobPosition;}
    public float getSalary() {return salary;}
    public Date getHireDate() {return hireDate;}
    public int getDepartmentId() {return departmentId;}
    //endregion

    //region Setters
    public void setName(String name) {this.name = name;}
    public void setSurname(String surname) {this.surname = surname;}
    public void setJobPosition(String jobPosition) {this.jobPosition = jobPosition;}
    public void setSalary(float salary) {this.salary = salary;}
    public void setHireDate(Date hireDate) {this.hireDate = hireDate;}
    public void setDepartmentId(int departmentId) {this.departmentId = departmentId;}
    //endregion

    //region Constructors
    public Employee(String name, String surname){
        this.name = name;
        this.surname = surname;
    }
    //endregion

    public void display(){
        System.out.print("I am ");
    }

}
