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
