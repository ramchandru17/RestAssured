package common;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * Common class to hold the common utility functions
 */

public class Utility {

    // Reads Properties file which returns value for the supplied key
    public static String getProp(String key) {

        try {
            InputStream inputStream = new FileInputStream(new File(System.getProperty("user.dir") + File.separator + "src"
                    + File.separator + "main" + File.separator + "resources" + File.separator + "API.properties"));
            Properties appProperties = new Properties();

            appProperties.load(inputStream);
            return appProperties.getProperty(key);
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }
}
