package Command;

/**
 * Created by bartekstolinski on 25/04/2017.
 */
public class InfoCommand implements Command {

    @Override
    public String getCommandName() {
        return "info";
    }

    @Override
    public void doAction(String[] args) {
        System.out.println("Staff Management System");
    }

    @Override
    public String getShortHelp() {
        return "info - information about the system";
    }

    @Override
    public String getLongHelp() {
        return "info - information about the system";
    }

}
