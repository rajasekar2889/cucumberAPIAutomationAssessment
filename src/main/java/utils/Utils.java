package utils;

import io.restassured.response.Response;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

public class Utils {

    public String getCurrentDate(){
        return LocalDate.now().toString();
    }

    public String getFutureDate(){

        return LocalDate.now().plusYears(1).toString();
    }

    public String getOldDate(){

        return LocalDate.now().minusYears(1).toString();
    }

    public String baseUri(){

        return "https://api.ratesapi.io/api/";
    }


}
