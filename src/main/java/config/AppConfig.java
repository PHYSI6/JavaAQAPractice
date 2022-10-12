package config;

import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class AppConfig {
    public static String getProperty(String name){
        return new AppConfig().getPropertyValue(name);
    }
    public String getPropertyValue(String propertyName){
        Properties properties = new Properties();
        try {
            properties.load(new FileReader("src/main/resources/properties/application.properties"));
            return properties.getProperty(propertyName);
        } catch (IOException e) {
            System.out.println(e);
        }
        return null;
    }
}
