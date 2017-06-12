package Model;

import lombok.Data;
import org.bson.types.ObjectId;
import org.mongodb.morphia.annotations.*;

import java.util.ArrayList;
import java.util.List;

/**
 * Klasa przechowujące podstawowe dane o firmie wraz z jej działami
 *
 * @author krystian
 */
@Data
@Entity(noClassnameStored = true)
public class Company {
    @Id
    private ObjectId id = new ObjectId();

    @Indexed(options = @IndexOptions(unique = true))
    private String name;
    private String street;
    private String city;
    private String phone;

    @Reference
    private Manager ceo;

    @Reference
    private List<Department> departments;

    public Company() {
        this.departments = new ArrayList<Department>();
    }

    public Company(String name, String street, String city, String phone, List<Department> departments) {
        this();
        this.name = name;
        this.street = street;
        this.city = city;
        this.phone = phone;
        this.departments = departments;
    }

    //region Setters
    public void addDepartment(Department department) {
        this.departments.add(department);
    }
    //endregion


    //region Getters
    //endregion


    @Override
    public String toString() {
        return "Company{" +
                "name='" + name + '\'' +
                ", street='" + street + '\'' +
                ", city='" + city + '\'' +
                ", phone='" + phone + '\'' +
                ", ceo=" + ceo +
                ", departments=" + departments +
                '}';
    }
}
