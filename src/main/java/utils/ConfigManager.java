package utils;

import java.io.*;
import java.util.Properties;

public class ConfigManager {

    private static Properties properties;


    public static void loadProperties() throws FileNotFoundException {

         properties = new Properties();
         try(InputStream input = ConfigManager.class.getClassLoader().getResourceAsStream("config.properties"))
            {
            properties.load(input);
        }
            catch (IOException e) {
                e.printStackTrace();
                throw new RuntimeException("Could not load config.properties file");
            }

    }

    public static String getProperties(String key) throws FileNotFoundException {

        if (properties == null) {
            loadProperties();
        }
        return properties.getProperty(key);
    }

    public static void setProperties(String key, String value) throws FileNotFoundException {
        try(FileOutputStream output = new FileOutputStream("src/test/resources/outputData.properties"))
        {
            properties.setProperty(key, value);
            properties.store(output, "updated property file");
        }
        catch (IOException e) {
            e.printStackTrace();
            throw new RuntimeException("Could not load outputData.properties file");
        }
    }

}
