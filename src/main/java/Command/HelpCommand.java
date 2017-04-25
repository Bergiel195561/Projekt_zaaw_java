package Command;

import java.util.*;

/**
 * Created by bartekstolinski on 25/04/2017.
 */
public class HelpCommand implements Command {

    private Map<String, Command> commandsMap;

    @Override
    public String getCommandName() {
        return "help";
    }

    @Override
    public void doAction(String[] args) {

        if (args.length == 1) {
            printShortHelpMessages();

        } else if (args.length == 2) {
            String helpCommand = args[1];
            if (commandsMap.containsKey(helpCommand)) {
                System.out.println(commandsMap.get(helpCommand).getLongHelp());
            } else {
                printShortHelpMessages();
            }
        } else {
            printShortHelpMessages();
        }
    }

    private void printShortHelpMessages() {
        Collection<Command> commands = commandsMap.values();

        List<String> shortHelpMessages = new ArrayList<String>();
        for (Command command : commands) {
            shortHelpMessages.add(command.getShortHelp());
        }

        Collections.sort(shortHelpMessages);
        System.out.println("Available commands are: ");
        for (String shortHelpMessage : shortHelpMessages) {
            System.out.println(shortHelpMessage);
        }
    }

    @Override
    public String getShortHelp() {
        return "help - help";
    }

    @Override
    public String getLongHelp() {
        return "help - help LONG DESCRIPTION";
    }

    void setCommandsMap(Map<String, Command> commandsMap) {
        this.commandsMap = commandsMap;
    }
}
