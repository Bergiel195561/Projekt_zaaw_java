package Model;

/**
 * Created by apple on 25/04/17.
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
    public void display() {
        super.display();
        System.out.println("Manager");
    }
    //endregion

}
