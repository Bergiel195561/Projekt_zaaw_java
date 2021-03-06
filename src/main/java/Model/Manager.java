package Model;


import org.bson.types.ObjectId;
import org.mongodb.morphia.annotations.Entity;
import org.mongodb.morphia.annotations.Id;

/**
 * Klasa dyrektora dziedzicząca po abstrakcyjnej klasie pracownika
 *
 * @author Jaromir
 */

@Entity(noClassnameStored = true)
public class Manager extends Employee {

    //region Constructors

    public Manager() {
    }

    public Manager(String name, String surname, String humanId) {
        super(name, surname, humanId);
    }

    public Manager(String name, String surname, String jobPosition, String humanId) {
        super(name, surname, jobPosition, humanId);
    }
    //endregion

    //region Methods

    @Override
    public String toString() {
        return "Manager{" +
                "\n\tpesel='" + pesel + '\'' +
                "\n\tname='" + name + '\'' +
                "\n\tsurname='" + surname + '\'' +
                "\n\tjobPosition='" + jobPosition + '\'' +
                "\n\tsalary=" + salary +
                "\n\thireDate=" + hireDate +
                "\n}\n";
    }

    //endregion

}
