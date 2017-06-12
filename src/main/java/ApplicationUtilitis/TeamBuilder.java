package ApplicationUtilitis;

import Helpers.TeamType;
import Model.Team;


/**
 * Created by Bartek on 12.06.2017.
 */
public class TeamBuilder {
    private Team team;

    public void createTeam(TeamType teamType) {
        this.team = new Team();
        this.team.setType(teamType);
    }

    public void setTeamId(String teamId) {
        this.team.setTeamId(teamId);
    }

    public Team getTeam() {
        return team;
    }
}