package Model;

import Helpers.TeamType;
import Utils.CustomHashSet;
import org.bson.types.ObjectId;
import org.mongodb.morphia.annotations.*;

/**
 * Klasa odpowiedzialna za zespół pracowników w danym dziale
 *
 * @author krystian
 */
@Entity(noClassnameStored = true)
public class Team {
    @Id
    private ObjectId id = new ObjectId();

    @Indexed(options = @IndexOptions(unique = true))
    private String teamId;
    private TeamType type;

    @Reference
    private Manager teamLeader;

    @Reference
    private CustomHashSet<OrdinaryEmployee> teamMembers = new CustomHashSet<OrdinaryEmployee>();

    public Team() {
    }

    public Team(TeamType type) {
        this.type = type;
    }

    public Team(TeamType type, CustomHashSet<OrdinaryEmployee> teamMembers) {
        this.type = type;
        this.teamMembers = teamMembers;
    }

    //region Setters
    public void setType(TeamType type) {
        this.type = type;
    }

    public void setTeamMembers(CustomHashSet<OrdinaryEmployee> teamMembers) {
        this.teamMembers = teamMembers;
    }

    public void setTeamId(String teamId) {
        this.teamId = teamId;
    }

    public void setId(ObjectId id) {
        this.id = id;
    }

    public void setTeamLeader(Manager teamLeader) {
        this.teamLeader = teamLeader;
    }
    //endregion

    //region Getters
    public TeamType getType() {
        return type;
    }

    public CustomHashSet<OrdinaryEmployee> getTeamMembers() {
        return teamMembers;
    }

    public String getTeamId() {
        return teamId;
    }

    public Manager getTeamLeader() {
        return teamLeader;
    }
    //endregion


    @Override
    public String toString() {
        return "Team{" +
                "teamId='" + teamId + '\'' +
                ", type=" + type +
                ", teamLeader=" + teamLeader +
                ", teamMembers=" + teamMembers +
                '}';
    }
}
