package utils;

import org.checkerframework.checker.units.qual.K;

import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Properties;

public class ResourcesUtils {

    public static String getResources(String name, String key) throws Exception {
        Properties props=new Properties();
        props.load(new InputStreamReader(new FileInputStream(String.format("src/test/java/resources/%s.properties",name))));
        return props.getProperty(key);
    }
}
