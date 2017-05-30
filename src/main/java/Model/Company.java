package Model;

import org.bson.types.ObjectId;
import org.mongodb.morphia.annotations.Entity;
import org.mongodb.morphia.annotations.Id;

import java.util.ArrayList;
import java.util.List;

/**
 * Klasa przechowujące podstawowe dane o firmie wraz z jej działami
 *
 * @author krystian
 */
@Entity(noClassnameStored = true)
public class Company {
    @Id
    private ObjectId id;

    private String name;
    private String street;
    private String city;
    private String phone;
    private Manager ceo;
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
    public void setName(String name) {
        this.name = name;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public void setDepartments(List<Department> departments) {
        this.departments = departments;
    }

    public void setCeo(Manager ceo) {
        this.ceo = ceo;
    }

    public void addDepartment(Department department) {
        this.departments.add(department);
    }

    //endregion


    //region Getters
    public String getName() {
        return name;
    }

    public String getStreet() {
        return street;
    }

    public String getCity() {
        return city;
    }

    public String getPhone() {
        return phone;
    }

    public List<Department> getDepartments() {
        return departments;
    }

    public Manager getCeo() {
        return ceo;
    }
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
