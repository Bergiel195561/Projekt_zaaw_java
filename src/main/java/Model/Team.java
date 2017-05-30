package Model;

import Helpers.TeamType;
import Utils.CustomHashSet;
import org.bson.types.ObjectId;
import org.mongodb.morphia.annotations.Entity;
import org.mongodb.morphia.annotations.Id;
import org.mongodb.morphia.annotations.Reference;

/**
 * Klasa odpowiedzialna za zespół pracowników w danym dziale
 * @author krystian
 */
@Entity(noClassnameStored = true)
public class Team {
    @Id
    private ObjectId id;

    private TeamType type;

    @Reference
    private Manager departmentLeader;
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
    //endregion

    //region Getters
    public TeamType getType() {
        return type;
    }

    public Manager getDepartmentLeader() {
        return departmentLeader;
    }

    public CustomHashSet<OrdinaryEmployee> getTeamMembers() {
        return teamMembers;
    }
    //endregion
}
