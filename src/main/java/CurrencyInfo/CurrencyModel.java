package CurrencyInfo;

import com.fasterxml.jackson.databind.JsonNode;
import lombok.Data;

import java.util.*;

/**
 * Model danych otrzymywanych przy pomocy API walutowego
 * Created by krystian on 12.06.17.
 */
@Data
public class CurrencyModel {

    /**
     * Nazwa klucza w JsonNode odpowiadająca bazowej walucie
     */
    private final String BASE_KEY = "base";

    /**
     * Nazwa klucza w JsonNode odpowiadająca dacie notowania
     */
    private final String DATE_KEY = "date";

    /**
     * Nazwa klucza w JsonNode odpowiadająca przelicznika na inne waluty
     */
    private final String RATES_KEY = "rates";

    private CurrencyType base;
    private String date;
    private HashMap<CurrencyType, Double> rates;

    /**
     * Wyszukiwanie symbolu waluty po nazwie
     *
     * @param base String zawierajacy skrót waluty
     * @return Obiekt klasy CurrencyType z wyszukana walutą lub PLN
     */
    private CurrencyType findCurrencyType(String base) {
        Optional<CurrencyType> currencySymbol = Arrays.stream(CurrencyType.values()).filter(e -> e.name().equalsIgnoreCase(base)).findFirst();
        if (currencySymbol.isPresent()) {
            return currencySymbol.get();
        } else {
            return CurrencyType.PLN;
        }
    }

    /**
     * Generowanie HashMapy z symbolem waluty i jej wartością względem bazowej
     *
     * @param ratesNode JsonNode z notowaniami walut
     */
    private void generateRatesHashMap(JsonNode ratesNode) {
        rates = new HashMap<>();
        if (ratesNode.isObject()) {
            Iterator<Map.Entry<String, JsonNode>> ratesPair = ratesNode.fields();
            while (ratesPair.hasNext()) {
                Map.Entry<String, JsonNode> currentRate = ratesPair.next();

                rates.put(findCurrencyType(currentRate.getKey()), currentRate.getValue().asDouble(0.0));

            }
        }
    }

    /**
     * Tworzenie i inicjalizowanie pól klasy wartościami z JsonNode
     *
     * @param source JsonNode z bazowymi wartościami
     */
    public CurrencyModel(JsonNode source) {
        this.base = findCurrencyType(source.get(BASE_KEY).asText(""));
        this.date = source.get(DATE_KEY).asText("");
        JsonNode ratesNode = source.get(RATES_KEY);
        generateRatesHashMap(ratesNode);
    }

    /**
     * Pobieranie ile bazowej waluty potrzeba na kupienie jednej lokalnej waluty
     * @param rate Proporcja bazowej waluty do lokalnej
     * @param localCurrency Lokalna waluta
     * @return 
     */
    private String getNumberOfBaseCurrencyForOther(Double rate, CurrencyType localCurrency) {
        double localForBaseCurrency = 1 / rate;
        return "  :::  1 " + localCurrency + " = " + String.format(Locale.ROOT, "%.2f", localForBaseCurrency) + " " + base;
    }

    @Override
    public String toString() {
        String ratesStrings = "";
        for (Map.Entry<CurrencyType, Double> ratesEntry : rates.entrySet()) {
            ratesStrings += ratesEntry.getKey() + " : " + ratesEntry.getValue() + ""
                    + getNumberOfBaseCurrencyForOther(ratesEntry.getValue(), ratesEntry.getKey()) + "\n";
        }

        return "Currency Info: \n" +
                "Base currency = " + base + "\n" +
                "Date = " + date + "\n" +
                ratesStrings;
    }
}
