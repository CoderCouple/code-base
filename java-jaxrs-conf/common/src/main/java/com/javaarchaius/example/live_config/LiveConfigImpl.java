package com.javaarchaius.example.live_config;

import com.google.inject.Inject;
import com.netflix.config.*;


public class LiveConfigImpl implements LiveConfig {

    private PolledConfigurationSource source;
    AbstractPollingScheduler scheduler;
    DynamicConfiguration configuration;
    private static final int INITIAL_DELAY=1000;
    private static final int FIXED_DELAY=30000;

    @Inject
    public LiveConfigImpl(PolledConfigurationSource dynamicConfigurationSource) {
        source = dynamicConfigurationSource;
        scheduler = new FixedDelayPollingScheduler(INITIAL_DELAY,FIXED_DELAY,false);
        configuration = new DynamicConfiguration(source, scheduler);
        initializeConfigManager();
    }

    private void initializeConfigManager(){
        ConfigurationManager.install(configuration);
    }


    @Override
    public Boolean getBooleanProperty(String key) {
        return getBooleanProperty(key, null);
    }

    @Override
    public Boolean getBooleanProperty(String key, Boolean defaultValue) {
        validate(key, defaultValue);
        final DynamicBooleanProperty property = DynamicPropertyFactory.getInstance().getBooleanProperty(key, defaultValue);
        return property.get();
    }

    @Override
    public Integer getIntProperty(String key) {
        return getIntProperty(key, null);
    }

    @Override
    public Integer getIntProperty(String key, Integer defaultValue) {
        validate(key, defaultValue);
        final DynamicIntProperty property = DynamicPropertyFactory.getInstance().getIntProperty(key, defaultValue);
        return property.get();
    }

    @Override
    public String getStringProperty(String key) {
        return getStringProperty(key, null);
    }

    @Override
    public String getStringProperty(String key, String defaultValue) {
        validate(key, defaultValue);
        final DynamicStringProperty property = DynamicPropertyFactory.getInstance().getStringProperty(key, defaultValue);
        return property.get();
    }

    @Override
    public Double getDoubleProperty(String key) {
        return getDoubleProperty(key, null);
    }

    @Override
    public Double getDoubleProperty(String key, Double defaultValue) {
        validate(key, defaultValue);
        final DynamicDoubleProperty property = DynamicPropertyFactory.getInstance().getDoubleProperty(key, defaultValue);
        return property.get();
    }

    @Override
    public Long getLongProperty(String key) {
        return getLongProperty(key, null);
    }

    @Override
    public Long getLongProperty(String key, Long defaultValue) {
        validate(key, defaultValue);
        final DynamicLongProperty property = DynamicPropertyFactory.getInstance().getLongProperty(key, defaultValue);
        return property.get();
    }

    private void validate(String key, Object val){
        if (key ==null && val == null)
            try {
                throw new Exception("Invalid key - value pair");
            } catch (Exception e) {
                e.printStackTrace();
            }
    }
}
