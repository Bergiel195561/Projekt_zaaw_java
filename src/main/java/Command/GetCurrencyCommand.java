package Command;

import CurrencyInfo.CurrencyInfoService;
import CurrencyInfo.CurrencyModel;
import CurrencyInfo.CurrencyType;

import java.util.Scanner;

/**
 * Created by apple on 13/06/17.
 */
public class GetCurrencyCommand implements Command {

    @Override
    public String getCommandName() {
        return "get_currency";
    }

    @Override
    public String getShortHelp() {
        return "get_currency - get current currency";
    }

    @Override
    public String getLongHelp() {
        return  "get_currency - get current currency";
    }

    @Override
    public void doAction(String[] args) {
        Scanner scanner = new Scanner(System.in);
        CurrencyInfoService service = new CurrencyInfoService();
        if(args.length > 1){
            if(args[1].equalsIgnoreCase("convert")){
                System.out.println("Enter base currency [USD, PLN, CHF, EUR, GBP]");
                String baseCurrency = scanner.next();
                CurrencyType baseType = CurrencyType.getCurrencyFromDesc(baseCurrency);
                if(baseType == null){
                    System.out.println("No such currency.");
                    return;
                }

                System.out.println("Enter target currency");
                String targetCurrency = scanner.next();
                CurrencyType targetType = CurrencyType.getCurrencyFromDesc(targetCurrency);
                if(targetType == null){
                    System.out.println("No such currency.");
                    return;
                }
                System.out.println("Enter amount.");
                Double amount = Double.parseDouble(scanner.next());
                double result = service.convertCurrency(baseType, targetType, amount);
                if(result == 0.0){
                    System.out.println("Conversion went wrong.");
                    return;
                }
                System.out.format(amount + " " + baseCurrency + " is equals " + result + " " + targetCurrency);

            }
            else{
                System.out.println("Command not known.");
            }
        }
        else{

            System.out.println("Choose currency from:");
            System.out.println(CurrencyType.getCurrencyTypesDesc());
            String type = scanner.nextLine();

            CurrencyModel model = service.getCurrencyRates(CurrencyType.getCurrencyFromDesc(type));
            if(model != null){
                model.toString();
            }
            else{
                System.out.println("Something went wrong with network connection");
            }
        }


    }
}
