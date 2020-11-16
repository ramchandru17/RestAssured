package common;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.*;
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

    // Retrieve JSON information from .json file
    public static JSONObject getJSONObj(String folder, String key) {
        JSONParser parser = new JSONParser();
        JSONObject jsonObject = null;

        try {
            jsonObject = (JSONObject) parser.parse(new FileReader(System.getProperty("user.dir") + File.separator + "src"
                    + File.separator + "main" + File.separator + "resources" + File.separator + folder + File.separator + key + ".json"));
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        }

        return jsonObject;

    }

    // Retrieve Brand information from .json file
    public static String getBrandID(String key) {
        JSONParser parser = new JSONParser();
        JSONObject jsonObject;

        try {
            jsonObject = (JSONObject) parser.parse(new FileReader(System.getProperty("user.dir") + File.separator + "src"
                    + File.separator + "main" + File.separator + "resources" + File.separator + "brand-info.json"));
            return jsonObject.get(key).toString();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return null;
    }
}
