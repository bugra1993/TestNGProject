package com.techproed.utilities;

import java.io.FileInputStream;
import java.util.Properties;

public class ConfigurationReader {

    static Properties properties;

    static {
        try {
            String path = "configuration.properties";
            FileInputStream file = new FileInputStream(path);
            properties = new Properties();
            properties.load(file);
        } catch (Exception e) {

        }
    }

    public static String getProperty(String key) {
        return properties.getProperty(key);
    }


}
