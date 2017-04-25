package ApplicationUtilitis;

import Model.Company;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by bartekstolinski on 25/04/2017.
 */
public class ApplicationCore {

    private Set<Company> companies = new HashSet<>();

    public Set<Company> getCompanies() {
        return companies;
    }

    public void addCompany(Company company) {
        companies.add(company);
    }
}
