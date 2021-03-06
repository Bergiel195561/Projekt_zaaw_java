package Model;

import Utils.CustomHashSet;
import org.bson.types.ObjectId;
import org.mongodb.morphia.annotations.*;

/**
 * Klasa odpowiedzialna za dział w firmie
 *
 * @author krystian
 */
@Entity(noClassnameStored = true)
public class Department {
    @Id
    private ObjectId id = new ObjectId();

    @Indexed(options = @IndexOptions(unique = true))
    private String name;

    @Reference
    private CustomHashSet<Team> teams = new CustomHashSet<Team>();

    public Department() {
    }

    public Department(String name) {
        this.name = name;
    }

    //region Setters
    public void setName(String name) {
        this.name = name;
    }

    public void setTeams(CustomHashSet<Team> teams) {
        this.teams = teams;
    }

    public void addTeam(Team newTeam) {
        this.teams.add(newTeam);
    }
    //endregion

    //region Getters
    public String getName() {
        return name;
    }

    public CustomHashSet<Team> getTeams() {
        return teams;
    }
    //endregion

    @Override
    public String toString() {

        return "Department{" +
                "\n\tname='" + name + '\'' +
                "\n\tteams= \n" + teams +
                "\n}\n";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Department that = (Department) o;

        if (id != null ? !id.equals(that.id) : that.id != null) return false;
        if (name != null ? !name.equals(that.name) : that.name != null) return false;
        return teams != null ? teams.equals(that.teams) : that.teams == null;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (teams != null ? teams.hashCode() : 0);
        return result;
    }
}
