package com.javajaxrs.conf.config;

import java.util.Map;

public interface Config {

    String getConfigAsString(String key) throws ConfigNotFoundException;

    String getConfigAsStringWithDefault(String key, String defaultValue);

    Integer getConfigAsInteger(String key);

    Integer getConfigAsIntegerWithDefault(String key, Integer defaultValue);

    Boolean getConfigAsBoolean(String key);

    Boolean getConfigAsBooleanWithDefault(String key, Boolean defaultValue);

    Double getConfigAsDouble(String key);

    Double getConfigAsDoubleWithDefault(String key, Double defaultValue);

    Map<String, Object> getAllConfig();

}
