package Command;

import ApplicationUtilitis.ApplicationCore;
import Model.Department;
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
        for (Department d : core.getCompanies().get(0).getDepartments()){
            System.out.println("Dział: " + d.getName());
            System.out.println("UniqID : TeamType");
            System.out.println("-----------------\n");
            for (Team team : d.getTeams()) {
                System.out.println(team.getTeamUniqNumber() + " : " + team.getType());
            }
            System.out.println("\n");
        }

        System.out.println("Team uniq number: ");
        String teamId = scanner.nextLine();


        for (OrdinaryEmployee ordinaryEmployee : core.getOrdinaryEmployees()) {
            System.out.println(ordinaryEmployee.getName() + " : " + ordinaryEmployee.getPesel());
        }

        System.out.println("Employee pesel: ");
        String employeeHumanId = scanner.nextLine();


        OrdinaryEmployee foundEmployee = null;
        boolean set = false;
        for (Department d : core.getCompanies().get(0).getDepartments()){
            for (Team team : d.getTeams()) {
                if (team.getTeamUniqNumber().equals(teamId)) {
                    for (OrdinaryEmployee ordinaryEmployee : core.getOrdinaryEmployees()) {
                        if (ordinaryEmployee.getPesel().equals(employeeHumanId)) {
                            if (!team.getTeamMembers().contains(ordinaryEmployee)){
                                team.getTeamMembers().add(ordinaryEmployee);
                                set = true;
                                foundEmployee = ordinaryEmployee;
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
        }

        if (!set){
            System.out.println("There is no such team or employee");
        } else {
            core.getOrdinaryEmployees().remove(foundEmployee);
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