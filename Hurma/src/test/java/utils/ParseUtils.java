package utils;

import java.util.Arrays;
import java.util.List;

public class ParseUtils {

    public static List<String> getCredFromText(String text, String expectedText){
        int startIndex = text.indexOf(expectedText);
        int endIndex = startIndex+16;
        String substr = text.substring(startIndex,endIndex);
        return List.of(substr.split(" "));
    }

    public static Integer getAgeFromText(String text){
        return Integer.valueOf(List.of(text.split(" ")).get(3).substring(1));
    }
}
