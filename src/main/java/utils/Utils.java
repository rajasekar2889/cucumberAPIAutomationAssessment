package utils;

import java.time.LocalDate;

public class Utils {

    //List of available currencies
    public String[] getCurrencyList() {
        return new String[]{"GBP", "HKD", "IDR", "ILS", "DKK", "INR", "CHF", "MXN", "CZK", "SGD", "THB", "HRK", "MYR", "NOK", "CNY", "BGN", "PHP", "SEK", "PLN", "ZAR", "CAD", "ISK", "BRL", "RON", "NZD", "TRY", "JPY", "RUB", "KRW", "USD", "HUF", "AUD"};
    }
    //Method to get current date
    public String getCurrentDate(){
        return LocalDate.now().toString();
    }
    //Method to get future date
    public String getFutureDate(){

        return LocalDate.now().plusYears(1).toString();
    }
    //Method to get old date
    public String getOldDate(){

        return LocalDate.now().minusYears(1).toString();
    }

    //Base Uri
    public String baseUri(){

        return "https://api.ratesapi.io/api/";
    }


}
