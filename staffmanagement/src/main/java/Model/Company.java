package Model;

import java.util.ArrayList;
import java.util.List;

/**
 * Klasa przechowujące podstawowe dane o firmie wraz z jej działami
 * @author krystian
 */
public class Company {
    private String name;
    private String street;
    private String city;
    private String phone;
    private List<ArrayList> departments;

    public Company() {

    }

    public Company(String name, String street, String city, String phone, List<ArrayList> departments) {
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

    public void setDepartments(List<ArrayList> departments) {
        this.departments = departments;
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

    public List<ArrayList> getDepartments() {
        return departments;
    }
    //endregion


    @Override
    public String toString() {
        return "Company{" +
                "name='" + name + '\'' +
                ", street='" + street + '\'' +
                ", city='" + city + '\'' +
                ", phone='" + phone + '\'' +
                ", departments=" + departments +
                '}';
    }
}
