package CurrencyInfo;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.ParseException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Klasa odpowiedzialna za pobieranie aktualnej wartości walut
 * Created by krystian on 12.06.17.
 */
public class CurrencyInfoService {

    private final ObjectMapper objectMapper = new ObjectMapper();
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
        try {
            HttpClient httpClient = HttpClients.createDefault();
            HttpGet request = new HttpGet(API_URL + url + "&symbols=" + compareSymbols);
            request.addHeader("ResourceVersion", "v3");

            HttpResponse response = httpClient.execute(request);
            if (response.getStatusLine().getStatusCode() == HttpStatus.SC_OK) {
                String responseBody = EntityUtils.toString(response.getEntity(), "UTF-8");
                JsonNode responseJson = objectMapper.readTree(responseBody);

                System.out.println(responseJson);

            } else {
                System.out.println(
                        "Oops something went wrong\nHttp response code: " + response.getStatusLine().getStatusCode() + "\nHttp response body: "
                                + EntityUtils.toString(response.getEntity()));
            }

        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Oops something went wrong\n");
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }

}