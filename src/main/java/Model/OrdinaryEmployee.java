package Model;

import org.mongodb.morphia.annotations.Entity;

/**
 * Klasa zwykłego pracownika dziedzicząca po abstrakcyjnej klasie pracownika
 *
 * @author Jaromir
 */
@Entity(noClassnameStored = true)
public class OrdinaryEmployee extends Employee {


    //region Constructors
    public OrdinaryEmployee() {
    }

    public OrdinaryEmployee(String name, String surname, String humanId) {
        super(name, surname, humanId);
    }

    public OrdinaryEmployee(String name, String surname, String jobPosition, String humanId) {
        super(name, surname, jobPosition, humanId);
    }
    //endregion

    //region Methods

    @Override
    public String toString() {
        return super.toString() + this.jobPosition + " [" + this.getName() + " " + this.getSurname() + "]";
    }

    //endregion

}
