package Model;

/**
 * Klasa zwykłego pracownika dziedzicząca po abstrakcyjnej klasie pracownika
 * @author Jaromir
 */
public class OrdinaryEmployee extends Employee{




    //region Constructors
    public OrdinaryEmployee(){}
    public OrdinaryEmployee(String name, String surname){
        super(name, surname);
    }
    //endregion

    //region Methods

    @Override
    public String toString() {
        return super.toString() + "Ordinary Employee";
    }

    //endregion

}
