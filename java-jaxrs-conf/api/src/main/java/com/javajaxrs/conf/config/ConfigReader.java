package com.javajaxrs.conf.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import static com.javajaxrs.conf.config.Constants.RESOURCE_SETTINGS_FILE_PATH;

public class ConfigReader {

    private static final Logger logger = LoggerFactory.getLogger(ConfigReader.class);

    public Properties loadProperties(String fileName){
        Properties properties = new Properties();
        if(fileName != null){
            InputStream stream = this.getClass().getClassLoader().getResourceAsStream(RESOURCE_SETTINGS_FILE_PATH+"/"+fileName);
            try {
                properties.load(stream);
            } catch (IOException e) {
                logger.error("Error reading the config file !");
                e.printStackTrace();
            }
        }
        return properties;
    }

}
