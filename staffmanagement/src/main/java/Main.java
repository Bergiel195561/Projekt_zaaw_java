import Model.Manager;

/**
 * @author Jaromir
 * Created by apple on 25/04/17.
 */
public class Main {
    public static void main (String[] args){

        Manager manager = new Manager("Jan", "Kowalski");
        System.out.println(manager.toString());

    }
}
