package CurrencyInfo;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.Spy;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.HashMap;

import static org.junit.Assert.*;
import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;

/**
 * Testy serwisu z walutami
 * z użyciem mockito
 * Created by krystian on 12.06.17.
 */
@RunWith(MockitoJUnitRunner.class)
public class CurrencyInfoServiceTest {

    @Mock
    CurrencyInfoService infoService;

    @Spy
    CurrencyInfoService infoServiceSpy = new CurrencyInfoService();

    @Test
    public void getCurrencyRatesWithoutBase() {
        CurrencyType baseType = null;
        CurrencyModel expected = null;
        when(infoService.getCurrencyRates(baseType)).thenReturn(expected);

        assertEquals(infoService.getCurrencyRates(baseType), expected);
    }

    @Test
    public void getCurrencyRatesWithExistedBase() {
        String dateKey = "date";
        String ratesKey = "rates";

        CurrencyType baseType = CurrencyType.PLN;
        CurrencyModel expected = new CurrencyModel();
        HashMap<CurrencyType, Double> rates = new HashMap<>();

        expected.setBase(baseType);
        expected.setDate("2017-06-12");
        expected.setRates(rates);

        when(infoService.getCurrencyRates(baseType)).thenReturn(expected);

        assertEquals(infoService.getCurrencyRates(baseType), expected);
        assertThat(infoService.getCurrencyRates(baseType))
            .extracting(dateKey)
            .containsSubsequence(expected.getDate());
    }

    @Test
    public void getCurrencyRatesWithRatesArray() {
        int expectedRatesSize = 2;

        CurrencyType baseType = CurrencyType.PLN;
        CurrencyModel expected = new CurrencyModel();
        HashMap<CurrencyType, Double> rates = new HashMap<>();
        rates.put(CurrencyType.CHF, 0.1);
        rates.put(CurrencyType.EUR, 0.2);

        expected.setBase(baseType);
        expected.setDate("2017-06-12");
        expected.setRates(rates);


        when(infoService.getCurrencyRates(baseType)).thenReturn(expected);

        assertEquals(infoService.getCurrencyRates(baseType), expected);
        assertThat(infoService.getCurrencyRates(baseType).getRates())
                .hasSize(expectedRatesSize)
                .containsKeys(CurrencyType.CHF, CurrencyType.EUR);
    }

    @Test
    public void convertTwoTheSameCurrency() {
        CurrencyType baseType = CurrencyType.PLN;
        double baseAmount = 100.0;
        double expectedAmount = 100.0;

        when(infoService.convertCurrency(baseType, baseType, baseAmount)).thenReturn(expectedAmount);

        assertThat(infoService.convertCurrency(baseType, baseType, baseAmount)).isEqualTo(expectedAmount);
    }

    @Test
    public void convertTwoDifferentCurrency() {
        CurrencyType baseType = CurrencyType.PLN;
        CurrencyType targetType = CurrencyType.EUR;
        double baseToTargetRate = 0.2;
        double baseAmount = 100.0;
        double expectedAmount = baseAmount * baseToTargetRate;

        CurrencyModel expected = new CurrencyModel();
        HashMap<CurrencyType, Double> rates = new HashMap<>();
        rates.put(CurrencyType.EUR, baseToTargetRate);

        expected.setBase(baseType);
        expected.setDate("2017-06-12");
        expected.setRates(rates);


        when(infoService.getCurrencyRates(baseType)).thenReturn(expected);

        when(infoService.convertCurrency(baseType, targetType, baseAmount)).thenReturn(expectedAmount);

        assertThat(infoService.convertCurrency(baseType, targetType, baseAmount)).isEqualTo(expectedAmount);
    }

    @Test
    public void convertCurrencyWithNullType() {
        CurrencyType baseType = CurrencyType.PLN;
        CurrencyType targetType = null;
        double baseAmount = 100.0;
        double expectedAmount = 0.0;

        CurrencyModel expected = new CurrencyModel();
        HashMap<CurrencyType, Double> rates = new HashMap<>();

        expected.setBase(baseType);
        expected.setDate("2017-06-12");
        expected.setRates(rates);


        when(infoService.getCurrencyRates(baseType)).thenReturn(expected);

        when(infoService.convertCurrency(baseType, targetType, baseAmount)).thenReturn(expectedAmount);

        assertThat(infoService.convertCurrency(baseType, targetType, baseAmount)).isEqualTo(expectedAmount);
    }

}