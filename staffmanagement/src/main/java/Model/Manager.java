package Model;


/**
 * Klasa dyrektora dziedzicząca po abstrakcyjnej klasie pracownika
 * @author Jaromir
 */

public class Manager extends Employee {

    private int companyId;

    //region Setters
    public void setCompanyId(int companyId) {this.companyId = companyId;}
    //endregion



    //region Getters
    public int getCompanyId() {return companyId;}
    //endregion

    //region Constructors
    public Manager(String name, String surname){
        super(name, surname);
    }
    //endregion

    //region Methods

    @Override
    public String toString() {
        return super.toString() + "Manager";
    }

    //endregion

}
