package com.demo.utils;

import org.apache.commons.configuration2.PropertiesConfiguration;
import org.apache.log4j.Logger;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class Configs {
    static Properties properties = new Properties();
    private static Logger LOGGER = Logger.getLogger(Configs.class);
    private static String FILENAME = "Config.properties";

    public static void load(){
        try (FileInputStream fin = new FileInputStream(new File(FILENAME))){
            properties.load(fin);
        } catch (IOException e) {
            LOGGER.info("Exception occurred while loading config.properties " + e.getMessage());
        }
    }

    public static String get(String key) {
        try {
            return get(key,null);
        } catch (Exception e) {
            return null;
        }
    }

    public static String get(String key,String defaultVal) {
        try {
            return properties.getProperty(key,defaultVal);
        } catch (Exception e) {
            return null;
        }
    }

    public static String set(String key, String value) {
        try {
            String previousValue = (String) properties.setProperty(key, value);
            LOGGER.info(previousValue);
            return previousValue;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
