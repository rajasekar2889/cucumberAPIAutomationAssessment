package main.java.utils;

import io.restassured.path.json.JsonPath;
import org.apache.commons.io.IOUtils;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
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

    public static JsonPath rawToJson(String response){
        JsonPath jp = new JsonPath(response);
        return jp;
    }

    public static String jsonToString(String path) throws IOException {

//        FileInputStream fis = new FileInputStream(path);
//        String payLoad = IOUtils.toString(fis,"UTF-8");
//        return payLoad;
       return new String(Files.readAllBytes(Paths.get(path)));

    }


}
