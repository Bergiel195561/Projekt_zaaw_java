package Model;

/**
 * Created by apple on 25/04/17.
 */
public class OrdinaryEmployee extends Employee{

    @Override
    public void displayClassName() {
        super.displayClassName();
        System.out.println("Ordinary Employee");
    }
}
