package Model;

import Helpers.TeamType;
import Utils.CustomHashSet;
import org.bson.types.ObjectId;
import org.mongodb.morphia.annotations.*;

/**
 * Klasa odpowiedzialna za zespół pracowników w danym dziale
 * @author krystian
 */
@Entity(noClassnameStored = true)
public class Team {
    @Id
    private ObjectId id;

    @Indexed(options = @IndexOptions(unique = true))
    private String teamUniqNumber;
    private TeamType type;

    @Reference
    private Manager departmentLeader;

    @Reference
    private CustomHashSet<OrdinaryEmployee> teamMembers = new CustomHashSet<OrdinaryEmployee>();

    public Team() {
    }

    public Team(TeamType type) {
        this.type = type;
    }

    public Team(TeamType type, Manager departmentLeader, CustomHashSet<OrdinaryEmployee> teamMembers) {
        this.type = type;
        this.departmentLeader = departmentLeader;
        this.teamMembers = teamMembers;
    }

    //region Setters
    public void setType(TeamType type) {
        this.type = type;
    }

    public void setDepartmentLeader(Manager departmentLeader) {
        this.departmentLeader = departmentLeader;
    }

    public void setTeamMembers(CustomHashSet<OrdinaryEmployee> teamMembers) {
        this.teamMembers = teamMembers;
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

    public Manager getDepartmentLeader() {
        return departmentLeader;
    }

    public CustomHashSet<OrdinaryEmployee> getTeamMembers() {
        return teamMembers;
    }

    public String getTeamUniqNumber() {
        return teamUniqNumber;
    }

    //endregion
}
