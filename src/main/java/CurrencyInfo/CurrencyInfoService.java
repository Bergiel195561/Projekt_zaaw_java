package CurrencyInfo;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Klasa odpowiedzialna za pobieranie aktualnej wartości walut
 * Created by krystian on 12.06.17.
 */
public class CurrencyInfoService {
    private final String API_URL = "http://api.fixer.io/";

    /**
     * Usuwanie ostatniego znaku ze stringa
     * @param str String z którego usuwany ostatni znak
     * @return String
     */
    private static String removeLastChar(String str) {
        return str.substring(0, str.length() - 1);
    }

    /**
     * Tworzenie listy symboli dla których pokazać wartość bazowej waluty
     * @param baseType Bazowy typ waluty, nie występuje w zwracanej wartości
     * @return
     */
    private String generateCurrencySymbols(CurrencyType baseType) {
        String symbols = "";
        List<CurrencyType> compareSymbols = Arrays.stream(CurrencyType.values())
                .filter(e -> !e.name().equalsIgnoreCase(baseType.name()))
                .collect(Collectors.toList());

        for (CurrencyType c : compareSymbols){
            symbols += c.name() + ",";
        };

        symbols = removeLastChar(symbols);

        return symbols;
    }

    public void getCurrencyRates(CurrencyType baseType) {
        String url = "latest?base=" + baseType;
        String compareSymbols = generateCurrencySymbols(baseType);
    }

}