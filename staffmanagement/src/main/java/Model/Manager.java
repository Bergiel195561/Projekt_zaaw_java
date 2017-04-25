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

    public Manager(){}
    public Manager(String name, String surname){
        super(name, surname);
    }
    public Manager(String name, String surname, String jobPosition){
        super(name, surname, jobPosition);
    }
    //endregion

    //region Methods

    @Override
    public String toString() {
        return super.toString() + this.jobPosition + " ["+ this.getName()+" "+this.getSurname() +"]";
    }

    //endregion

}
