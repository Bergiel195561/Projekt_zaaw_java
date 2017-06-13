package DB;

import Model.Company;
import Model.OrdinaryEmployee;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Spy;
import org.mockito.runners.MockitoJUnitRunner;
import org.mongodb.morphia.Key;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;

/**
 * Testy bazy przy użyciu mockito
 * Created by krystian on 13.06.17.
 */
@RunWith(MockitoJUnitRunner.class)
public class DBMockito {

    @Mock
    CompanyDao dao;

    @Mock
    OrdinaryEmployeeDao daoEmp;

    @Test
    public void getCompanyFromDb() {
        // given
        String companyName = "Firma";
        String companyCity = "Miasto";

        Company c = new Company();
        c.setName(companyName);
        c.setCity(companyCity);

        // when
        when(dao.findCompany()).thenReturn(c);
        Company companyFromDb = dao.findCompany();

        // then
        assertThat(companyFromDb).isNotNull();
        assertThat(companyFromDb.getName()).isEqualTo(companyName);
    }

    @Test
    public void getCompaniesFromDb() {
        // given
        int expectedCompaniesNumber = 3;
        String companyName = "Firma";
        String companyCity = "Miasto";
        List<Company> companyList = new ArrayList<>();

        for (int i = 0; i < expectedCompaniesNumber; i++) {
            companyList.add(new Company(companyName + i, "Steet", companyCity + i, "111", new ArrayList<>()));
        }

        // when
        when(dao.findAllCompanies()).thenReturn(companyList);
        List<Company> companiesFromDB = dao.findAllCompanies();

        // then
        assertThat(companiesFromDB).hasSize(expectedCompaniesNumber);
        assertThat(companiesFromDB).containsSequence(companyList.toArray(new Company[companyList.size()]));
    }

    @Test
    public void getCompaniesByNameFromDb() {
        // given
        int expectedCompaniesNumber = 3;
        String companyName = "Firma";
        int expectedCompany = 0;
        String expectedCompanyName = "Firma0";
        String companyCity = "Miasto";
        List<Company> companyList = new ArrayList<>();

        for (int i = 0; i < expectedCompaniesNumber; i++) {
            companyList.add(new Company(companyName + i, "Steet", companyCity + i, "111", new ArrayList<>()));
        }

        // when
        when(dao.getCompanyByName(expectedCompanyName)).thenReturn(companyList.get(expectedCompany));
        Company companiesFromDB = dao.getCompanyByName(expectedCompanyName);

        // then
        assertThat(companiesFromDB).isNotNull();
        assertThat(companiesFromDB.getName()).isEqualTo(expectedCompanyName);
    }

    @Test
    public void getEmployeeByName() {
        String employeeName = "Kowalski";
        OrdinaryEmployee e = new OrdinaryEmployee();
        e.setName(employeeName);

        when(daoEmp.getEmployeeByName(employeeName)).thenReturn(e);
        OrdinaryEmployee empFromDb = daoEmp.getEmployeeByName(employeeName);


        assertThat(empFromDb).isNotNull();
        assertEquals(empFromDb.getName(), employeeName);
    }

    @Test
    public void getEmployeeByWrongName() {
        OrdinaryEmployee expected = null;
        String employeeName = "Kowalski";
        String searchName = "Judasz";
        OrdinaryEmployee e = new OrdinaryEmployee();
        e.setName(employeeName);

        when(daoEmp.getEmployeeByName(searchName)).thenReturn(expected);
        OrdinaryEmployee empFromDb = daoEmp.getEmployeeByName(searchName);


        assertThat(empFromDb).isNull();
    }

    @Test
    public void getEmployeeByPesel() {
        String employeePesel = "11111122334";
        OrdinaryEmployee e = new OrdinaryEmployee();
        e.setPesel(employeePesel);

        when(daoEmp.getEmployeeByPesel(employeePesel)).thenReturn(e);
        OrdinaryEmployee empFromDb = daoEmp.getEmployeeByPesel(employeePesel);


        assertThat(empFromDb).isNotNull();
        assertThat(empFromDb.getPesel()).isEqualTo(employeePesel);
    }

    @Test
    public void getEmployeeByWrongPesel() {
        OrdinaryEmployee expected = null;
        String employeePesel = "11111122334";
        String wrongPeselPesel = "222";
        OrdinaryEmployee e = new OrdinaryEmployee();
        e.setPesel(employeePesel);

        when(daoEmp.getEmployeeByPesel(wrongPeselPesel)).thenReturn(expected);
        OrdinaryEmployee empFromDb = daoEmp.getEmployeeByPesel(wrongPeselPesel);


        assertThat(empFromDb).isNull();
    }

    @Test
    public void getEmployeesWithHigherSalary() {
        List<OrdinaryEmployee> employees = new ArrayList<>();
        List<OrdinaryEmployee> expectedEmployees = new ArrayList<>();
        String name = "Andrzej";
        String pesel = "100";
        float baseSalary = 100.0f;
        float minimumSalaray = 300.0f;
        int employeesNumber = 5;

        for (int i = 0; i < employeesNumber; i++){
            OrdinaryEmployee employee = new OrdinaryEmployee(name + i, name, pesel + i);
            employee.setSalary(baseSalary * i);
            if (employee.getSalary() >= minimumSalaray){
                expectedEmployees.add(employee);
            }
            employees.add(employee);
        }

        when(daoEmp.getEmployeesWithHigherSalary(minimumSalaray)).thenReturn(expectedEmployees);
        List<OrdinaryEmployee> richEmployees = daoEmp.getEmployeesWithHigherSalary(minimumSalaray);

        assertThat(richEmployees).hasSize(expectedEmployees.size());
        assertThat(richEmployees).filteredOn(e -> e.getSalary() >= minimumSalaray).hasSize(expectedEmployees.size());
        assertThat(richEmployees).filteredOn(e -> e.getSalary() < minimumSalaray).hasSize(0);
    }

    @Test
    public void getEmptyEmployeesWithHigherSalary() {
        List<OrdinaryEmployee> employees = new ArrayList<>();
        List<OrdinaryEmployee> expectedEmployees = new ArrayList<>();
        String name = "Andrzej";
        String pesel = "100";
        float baseSalary = 100.0f;
        float minimumSalaray = 1000.0f;
        int employeesNumber = 5;

        for (int i = 0; i < employeesNumber; i++){
            OrdinaryEmployee employee = new OrdinaryEmployee(name + i, name, pesel + i);
            employee.setSalary(baseSalary * i);
            if (employee.getSalary() >= minimumSalaray){
                expectedEmployees.add(employee);
            }
            employees.add(employee);
        }

        when(daoEmp.getEmployeesWithHigherSalary(minimumSalaray)).thenReturn(expectedEmployees);
        List<OrdinaryEmployee> richEmployees = daoEmp.getEmployeesWithHigherSalary(minimumSalaray);

        assertThat(richEmployees).hasSize(expectedEmployees.size());
    }


}
