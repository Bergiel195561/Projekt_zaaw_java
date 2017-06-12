package Model;

import org.bson.types.ObjectId;
import org.mongodb.morphia.annotations.Id;
import org.mongodb.morphia.annotations.IndexOptions;
import org.mongodb.morphia.annotations.Indexed;

import java.util.Date;

/**
 * Klasa abstrakcyjna modelu pracownika
 *
 * @author Jaromir
 */

public abstract class Employee {
    @Id
    private ObjectId id = new ObjectId();


    @Indexed(options = @IndexOptions(unique = true))
    protected String pesel;
    protected String name;
    protected String surname;
    protected String jobPosition;
    protected float salary;
    protected Date hireDate;
    protected int departmentId;

    //region Getters

    public String getPesel() {return pesel;}

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public String getJobPosition() {
        if(jobPosition == null) return "none";
        return jobPosition;
    }

    public float getSalary() {
        return salary;
    }

    public Date getHireDate() {
        return hireDate;
    }

    public int getDepartmentId() {
        return departmentId;
    }
    //endregion

    //region Setters

    public void setPesel(String pesel) {
        this.pesel = pesel;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public void setJobPosition(String jobPosition) {
        this.jobPosition = jobPosition;
    }

    public void setSalary(float salary) {
        this.salary = salary;
    }

    public void setHireDate(Date hireDate) {
        this.hireDate = hireDate;
    }

    public void setDepartmentId(int departmentId) {
        this.departmentId = departmentId;
    }
    //endregion

    //region Constructors
    public Employee() {
    }

    public Employee(String name, String surname, String humanId) {
        this.pesel = humanId;
        this.name = name;
        this.surname = surname;
    }

    public Employee(String name, String surname, String jobPosition, String humanId) {
        this.pesel = humanId;
        this.name = name;
        this.surname = surname;
        this.jobPosition = jobPosition;
    }
    //endregion


    @Override
    public String toString() {
        return "I am ";
    }
}
