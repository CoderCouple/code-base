package com.javajaxrs.conf.config;

import org.apache.commons.lang3.ClassUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

public class ConfigImpl implements Config {

    private static final Logger logger = LoggerFactory.getLogger(ConfigImpl.class);
    private Properties properties;

    public ConfigImpl(String fileName){
        ConfigReader configReader = new ConfigReader();
        this.properties = configReader.loadProperties(fileName);
    }

    @Override
    public String getConfigAsString(String key) throws ConfigNotFoundException {
       Object prop = this.properties.get(key);
       if(prop == null)
           return null;
       else if(prop instanceof String)
           return (String) prop;
       else throw new ConfigNotFoundException(getErrorMessage(key));
    }

    @Override
    public String getConfigAsStringWithDefault(String key, String defaultValue) {
        Object prop = this.properties.get(key);
        if(prop == null)
            return defaultValue;
        else if(prop instanceof String)
            return (String)prop;
        else throw new ConfigNotFoundException(getErrorMessage(key));

    }

    @Override
    public Integer getConfigAsInteger(String key) {
        Object prop = this.properties.get(key);
        if(prop == null)
            return null;
        else if(ClassUtils.isAssignable(prop.getClass(),Integer.class)){
            return (Integer) prop;
        } else throw new ConfigNotFoundException(getErrorMessage(key));
    }

    @Override
    public Integer getConfigAsIntegerWithDefault(String key, Integer defaultValue) {
        Object prop = this.properties.get(key);
        if(prop == null)
            return defaultValue;
        else if(ClassUtils.isAssignable(prop.getClass(),Integer.class)){
            return (Integer) prop;
        } else throw new ConfigNotFoundException(getErrorMessage(key));
    }

    @Override
    public Boolean getConfigAsBoolean(String key) {
        Object prop = this.properties.get(key);
        if(prop == null)
            return null;
        else if(ClassUtils.isAssignable(prop.getClass(),Boolean.class)){
            return (Boolean) prop;
        } else throw new ConfigNotFoundException(getErrorMessage(key));
    }

    @Override
    public Boolean getConfigAsBooleanWithDefault(String key, Boolean defaultValue) {
        Object prop = this.properties.get(key);
        if(prop == null)
            return defaultValue;
        else if(ClassUtils.isAssignable(prop.getClass(),Boolean.class)){
            return (Boolean) prop;
        } else throw new ConfigNotFoundException(getErrorMessage(key));
    }

    @Override
    public Double getConfigAsDouble(String key) {
        Object prop = this.properties.get(key);
        if(prop == null)
            return null;
        else if(ClassUtils.isAssignable(prop.getClass(),Double.class)){
            return (Double) prop;
        } else throw new ConfigNotFoundException(getErrorMessage(key));
    }

    @Override
    public Double getConfigAsDoubleWithDefault(String key, Double defaultValue) {
        Object prop = this.properties.get(key);
        if(prop == null)
            return defaultValue;
        else if(ClassUtils.isAssignable(prop.getClass(),Double.class)){
            return (Double) prop;
        } else throw new ConfigNotFoundException(getErrorMessage(key));
    }

    @Override
    public Map<String, Object> getAllConfig() {
      Map<String,Object> propMap = new HashMap<>();
      properties.forEach((k,v) -> propMap.put((String)k,v));
      return propMap;
    }

    public String getErrorMessage(String key){
        StringBuilder sb = new StringBuilder();
        sb.append("Key ").append(key).append("not found !");
        return sb.toString();
    }
}
