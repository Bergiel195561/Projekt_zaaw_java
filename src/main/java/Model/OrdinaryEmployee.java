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


    @Override
    public boolean equals(Object o) {
        return super.equals(o);
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }
}
