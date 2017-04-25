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

    public void displayClassName(){
        System.out.println("I am");
    }

}
