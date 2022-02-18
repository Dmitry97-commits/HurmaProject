package utils;

import org.apache.commons.lang3.RandomStringUtils;

import java.util.Random;

public class RandomUtils {
    public static String RandomString(int length){
        return RandomStringUtils.randomAlphabetic(length);
    }

    public static Integer RandomInt(int max){
        int min = 0;
        int diff = max - min;
        Random random = new Random();
        return random.nextInt(diff + 1) + min;
    }
}
