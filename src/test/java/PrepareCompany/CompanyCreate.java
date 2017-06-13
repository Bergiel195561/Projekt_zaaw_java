package PrepareCompany;

import Helpers.TeamType;
import Model.*;
import Utils.CustomHashSet;

import java.util.ArrayList;
import java.util.Date;

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

        Team t3 = new Team(TeamType.UX);
        t3.setTeamUniqNumber("UX123");

        Manager ma = new Manager("Andrzej", "Nowak", "11122212345");
        CustomHashSet<OrdinaryEmployee> list = new CustomHashSet<>();
        for (int i = 0; i < 5; i++){
            OrdinaryEmployee a = new OrdinaryEmployee("Andrzej" + i, "Nowak" + i, i + "1111112345");
            a.setSalary(1000 * i);
            a.setHireDate(new Date());
            list.add(a);
        }

        t.setTeamMembers(list);
        t.setTeamLeader(ma);
        CustomHashSet<OrdinaryEmployee> list2 = new CustomHashSet<>();
        for (int i = 0; i < 5; i++){
            OrdinaryEmployee a = new OrdinaryEmployee("Super" + i, "Nowak" + i, i + "2111112345");
            a.setSalary(1100 * i);
            a.setHireDate(new Date());
            list2.add(a);
        }
        t2.setTeamMembers(list2);
        t2.setTeamLeader(ma);

        CustomHashSet<OrdinaryEmployee> list3 = new CustomHashSet<>();
        for (int i = 0; i < 11; i++){
            OrdinaryEmployee a = new OrdinaryEmployee("UxMaster" + i, "Kowalski" + i, i + "3111112345");
            a.setSalary(1500 * i);
            a.setHireDate(new Date());
            list3.add(a);
        }
        t3.setTeamMembers(list3);
        t3.setTeamLeader(ma);

        d.addTeam(t);

        d2.addTeam(t2);

        d2.addTeam(t3);

        c.addDepartment(d);
        c.addDepartment(d2);

        return c;
    }

}
