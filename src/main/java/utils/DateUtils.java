package utils;

import java.time.LocalDate;

public class DateUtils {

    public String getCurrentDate(){
        return LocalDate.now().toString();
    };

    public String getFutureDate(){
        return LocalDate.now().plusYears(1).toString();
    };

    public String getOldDate(){
        return LocalDate.now().minusYears(1).toString();
    };


}
