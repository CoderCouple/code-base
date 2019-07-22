package com.javaarchaius.example.live_config;


import com.google.inject.ImplementedBy;

@ImplementedBy(LiveConfigImpl.class)
public interface LiveConfig {

    Boolean getBooleanProperty(String key);

    Boolean getBooleanProperty(String key, Boolean defaultValue);

    Integer getIntProperty(String key);

    Integer getIntProperty(String key, Integer defaultValue);

    String getStringProperty(String key);

    String getStringProperty(String key, String defaultValue);

    Double getDoubleProperty(String key);

    Double getDoubleProperty(String key, Double defaultValue);

    Long getLongProperty(String key);

    Long getLongProperty(String key, Long defaultValue);

}
