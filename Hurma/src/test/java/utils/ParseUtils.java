package utils;

import java.util.List;

public class ParseUtils {

    public static List<String> getCredFromText(String text, String expectedText){

        int startIndex = text.indexOf(expectedText);
        int endIndex = startIndex+16;
        String substr = text.substring(startIndex,endIndex);
        return List.of(substr.split(" "));
    }

}
