package DB;

import Model.Company;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;

/**
 * Testy bazy przy użyciu mockito
 * Created by krystian on 13.06.17.
 */
@RunWith(MockitoJUnitRunner.class)
public class DBMockito {

    @Mock
    CompanyDao dao;

    @Test
    public void getCompanyFromDb(){
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

}
