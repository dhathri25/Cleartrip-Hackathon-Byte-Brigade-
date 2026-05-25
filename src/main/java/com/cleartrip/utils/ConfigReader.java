package com.cleartrip.utils;

import java.io.FileInputStream;
import java.util.Properties;

public class ConfigReader {
    private Properties prop;

    public ConfigReader() {
        try {
            // Updated to look into src/main/resources since that's where the file is placed in your structure
            String configPath = System.getProperty("user.dir") + "/src/main/resources/config.properties";
            FileInputStream fis = new FileInputStream(configPath);
            prop = new Properties();
            prop.load(fis);
            System.out.println("Configuration properties loaded successfully from: " + configPath);
        } catch (Exception e) {
            System.err.println("CRITICAL ERROR: Could not load config.properties file!");
            e.printStackTrace();
        }
    }

    public String getProperty(String key) {
        if (prop == null) {
            return null;
        }
        return prop.getProperty(key);
    }
}