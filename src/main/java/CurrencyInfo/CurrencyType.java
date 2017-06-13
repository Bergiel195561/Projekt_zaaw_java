package CurrencyInfo;

/**
 * Klasa przechowująca podstawowe oznaczenia walut światowych
 * Created by krystian on 12.06.17.
 */
public enum CurrencyType {
    USD, EUR, PLN, GBP, CHF;

    public static CurrencyType getCurrencyFromDesc(String desc){
        String description = desc.toUpperCase();
        switch(description){
            case "USD":
                return USD;
            case "EUR":
                return EUR;
            case "PLN":
                return PLN;
            case "GBP":
                return  GBP;
            case "CHF":
                return CHF;
        }
        return null;
    }

    public static String getCurrencyTypesDesc(){
        return "USD, EUR, PLN, GBP, CHF";
    }
}
