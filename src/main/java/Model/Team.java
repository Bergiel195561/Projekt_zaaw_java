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
    private String teamUniqNumber;
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

    public void setTeamLeader(Manager teamLeader) {
        this.teamLeader = teamLeader;
    }

    public void setTeamUniqNumber(String teamUniqNumber) {
        this.teamUniqNumber = teamUniqNumber;
    }
    //endregion

    //region Getters
    public TeamType getType() {
        return type;
    }

    public String getTypeDescription() {
        switch(this.type){
            case ADV:
                return "ADV";
            case DEV:
                return "DEV";
            case QA:
                return "QA";
            case TESTERS:
                return "TESTERS";
            case UX:
                return "UX";
            default:
                return "Not identified";
        }
    }

    public CustomHashSet<OrdinaryEmployee> getTeamMembers() {
        return teamMembers;
    }

    public Manager getTeamLeader() {
        return teamLeader;
    }

    public String getTeamUniqNumber() {
        return teamUniqNumber;
    }
    //endregion


    @Override
    public String toString() {
        return "Team{" +
                "teamUniqNumber='" + teamUniqNumber + '\'' +
                ", type=" + type +
                ", teamLeader=" + teamLeader +
                ", teamMembers=" + teamMembers +
                '}';
    }
}
