package ApplicationUtilitis;

import Model.Company;
import Model.Department;
import Model.Manager;
import Model.OrdinaryEmployee;

/**
 * Created by bartekstolinski on 25/04/2017.
 * Klasa tworząca firmę
 */
public class CompanyBuilder {
    private Company company;

    public void createCompany(String name) {
        this.company = new Company();
        this.company.setName(name);
    }

    public void setCompanyStreet(String street) {
        this.company.setStreet(street);
    }

    public void setCompanyCity(String city) {
        this.company.setCity(city);
    }

    public void setCompanyPhone(String phone) {
        this.company.setPhone(phone);
    }

    public Company getCompany() {
        return company;
    }
}