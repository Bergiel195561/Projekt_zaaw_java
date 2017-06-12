package Command;

import ApplicationUtilitis.ApplicationCore;
import Model.OrdinaryEmployee;
import Model.Team;

import java.util.Scanner;

/**
 * Created by Bartek on 12.06.2017.
 */
public class SetEmployeeCommand implements Command {
    private ApplicationCore core;

    public SetEmployeeCommand(ApplicationCore core) {
        this.core = core;
    }

    @Override
    public String getCommandName() {
        return "set_employee";
    }

    @Override
    public void doAction(String[] args) {
        Scanner scanner = new Scanner(System.in);
        for (Team team : core.getTeams()) {
            System.out.println(team.toString());
        }

        System.out.println("Team uniq number: ");
        String teamId = scanner.nextLine();


        for (OrdinaryEmployee ordinaryEmployee : core.getOrdinaryEmployees()) {
            System.out.println(ordinaryEmployee.toString());
        }

        System.out.println("Employee pesel: ");
        String employeeHumanId = scanner.nextLine();


        boolean set = false;
        for (Team team : core.getTeams()) {
            if (team.getTeamUniqNumber().equals(teamId)) {
                for (OrdinaryEmployee ordinaryEmployee : core.getOrdinaryEmployees()) {
                    if (ordinaryEmployee.getPesel().equals(employeeHumanId)) {
                        if (!team.getTeamMembers().contains(ordinaryEmployee)){
                            team.getTeamMembers().add(ordinaryEmployee);
                            set = true;
                            break;
                        }
                        else {
                            System.out.println("This team employs this man");
                            set = true;
                            break;
                        }
                    }
                }
                break;
            }
        }
        if (!set){
            System.out.println("There is no such team or employee");
        }
    }

    @Override
    public String getShortHelp() {
        return "set_employee - set employee";
    }

    @Override
    public String getLongHelp() {
        return "set_employee - set employee to team";
    }
}