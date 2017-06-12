package PrepareCompany;

import Helpers.TeamType;
import Model.*;
import Utils.CustomHashSet;

import java.util.ArrayList;

/**
 * Created by krystian on 12.06.17.
 */
public class CompanyCreate {

    public static Company getBigCompany(){

        Company c = new Company("Nazwa", "Ulica", "Miasto", "111222333", new ArrayList<>());
        Department d = new Department("Kozaki");
        Department d2 = new Department("Spaślaki");

        Team t = new Team(TeamType.DEV);
        t.setTeamUniqNumber("DEV123");
        Team t2 = new Team(TeamType.TESTERS);
        t2.setTeamUniqNumber("TESTERS123");

        Manager ma = new Manager("Andrzej", "Nowak", "11122212345");
        CustomHashSet<OrdinaryEmployee> list = new CustomHashSet<>();
        for (int i = 0; i < 5; i++){
            OrdinaryEmployee a = new OrdinaryEmployee("Andrzej" + i, "Nowak" + i, i + "1111112345");
            list.add(a);
        }

        t.setTeamMembers(list);
        CustomHashSet<OrdinaryEmployee> list2 = new CustomHashSet<>();
        for (int i = 0; i < 5; i++){
            OrdinaryEmployee a = new OrdinaryEmployee("Super" + i, "Nowak" + i, i + "2111112345");
            list2.add(a);
        }
        t2.setTeamMembers(list2);

        d.addTeam(t);

        d2.addTeam(t2);

        c.addDepartment(d);
        c.addDepartment(d2);

        return c;
    }

}
