package com.demo.utils;

import org.apache.commons.configuration2.PropertiesConfiguration;

import java.io.File;
import java.util.Properties;

public class Configs {
    private static final PropertiesConfiguration configuration;
    private static String FILENAME = "Config.properties"

    public static void load(){
        configuration = new PropertiesConfiguration("Config.properties");
    }
}
