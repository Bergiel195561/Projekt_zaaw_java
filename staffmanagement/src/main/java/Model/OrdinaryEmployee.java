package Model;

/**
 * Created by apple on 25/04/17.
 */
public class OrdinaryEmployee extends Employee{




    //region Constructors
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
