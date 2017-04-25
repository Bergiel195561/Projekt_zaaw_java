package Model;

/**
 * Klasa zwykłego pracownika dziedzicząca po abstrakcyjnej klasie pracownika
 *
 * @author Jaromir
 */
public class OrdinaryEmployee extends Employee {


    //region Constructors
    public OrdinaryEmployee() {}
    public OrdinaryEmployee(String name, String surname) {
        super(name, surname);
    }
    public OrdinaryEmployee(String name, String surname, String jobPosition) {
        super(name, surname, jobPosition);
    }
    //endregion

    //region Methods

    @Override
    public String toString() {
        return super.toString() + this.jobPosition + " [" + this.getName() + " " + this.getSurname() + "]";
    }

    //endregion

}
