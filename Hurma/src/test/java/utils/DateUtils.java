package utils;

import java.util.Arrays;
import java.util.Date;

public class DateUtils {
    public static String getTodayDate(){
        Date date = new Date();
        return String.format("%s%s",date.toString().charAt(8),date.toString().charAt(9));
    }
}
