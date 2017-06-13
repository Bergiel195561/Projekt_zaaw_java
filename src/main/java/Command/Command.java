package Command;

/**
 * Created by bartekstolinski on 25/04/2017.
 * Interfejs poleceń
 */
public interface Command {

    String getCommandName();

    String getShortHelp();

    String getLongHelp();

    void doAction(String[] args);
}
