package com.javaarchaius.example.live_config;

import com.netflix.config.ConcurrentMapConfiguration;
import com.netflix.config.PollResult;
import com.netflix.config.PolledConfigurationSource;
import org.apache.commons.configuration.PropertiesConfiguration;
import org.apache.commons.configuration.SystemConfiguration;

import javax.inject.Inject;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class DynamicConfigurationSource implements PolledConfigurationSource {

    private static final String  fileName = "app.properties";
    public LiveConfigService configService;

    @Inject
    public DynamicConfigurationSource(LiveConfigService configService) {
        this.configService = configService;
    }

    @Override
    public PollResult poll(boolean initial, Object checkPoint) throws Exception {

        Map<String,Object> prop = new ConcurrentHashMap<>();

        ConcurrentMapConfiguration configFromPropertiesFile =
                new ConcurrentMapConfiguration(new PropertiesConfiguration(fileName));

        configFromPropertiesFile.getProperties().forEach((k,v) -> prop.put((String)k,v));

        ConcurrentMapConfiguration configFromSystemProperties =
                new ConcurrentMapConfiguration(new SystemConfiguration());

        configFromSystemProperties.getProperties().forEach((k,v) -> prop.put((String)k,v));

        Map<String ,Object> dbConf = configService.getAllConfigs();
        prop.putAll(dbConf);

        return PollResult.createFull(prop);
    }
}
