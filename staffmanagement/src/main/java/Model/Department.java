package Model;

/**
 * Klasa odpowiedzialna za dział w firmie
 * @author krystian
 */
public class Department {
    private String name;

    public Department(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Department{name='" + name + "}";
    }
}
