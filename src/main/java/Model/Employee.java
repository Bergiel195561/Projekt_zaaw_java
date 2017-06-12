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

public class Employee {
    @Id
    private ObjectId id = new ObjectId();


    @Indexed(options = @IndexOptions(unique = true))
    protected String pesel;
    protected String name;
    protected String surname;
    protected String jobPosition;
    protected float salary;
    protected Date hireDate;

    //region Getters

    public String getPesel() {
        return pesel;
    }

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
        return "Employee{" +
                "pesel='" + pesel + '\'' +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", jobPosition='" + jobPosition + '\'' +
                ", salary=" + salary +
                ", hireDate=" + hireDate +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Employee employee = (Employee) o;

        if (Float.compare(employee.salary, salary) != 0) return false;
        if (id != null ? !id.equals(employee.id) : employee.id != null) return false;
        if (pesel != null ? !pesel.equals(employee.pesel) : employee.pesel != null) return false;
        if (name != null ? !name.equals(employee.name) : employee.name != null) return false;
        if (surname != null ? !surname.equals(employee.surname) : employee.surname != null) return false;
        if (jobPosition != null ? !jobPosition.equals(employee.jobPosition) : employee.jobPosition != null)
            return false;
        return hireDate != null ? hireDate.equals(employee.hireDate) : employee.hireDate == null;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (pesel != null ? pesel.hashCode() : 0);
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (surname != null ? surname.hashCode() : 0);
        result = 31 * result + (jobPosition != null ? jobPosition.hashCode() : 0);
        result = 31 * result + (salary != +0.0f ? Float.floatToIntBits(salary) : 0);
        result = 31 * result + (hireDate != null ? hireDate.hashCode() : 0);
        return result;
    }
}
