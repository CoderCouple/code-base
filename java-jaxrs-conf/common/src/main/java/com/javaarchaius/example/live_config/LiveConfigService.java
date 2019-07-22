package com.javaarchaius.example.live_config;

import com.google.inject.ImplementedBy;

import java.util.Map;

@ImplementedBy(LiveConfigServiceImpl.class)
public interface LiveConfigService {

    void setConfig(String key, Object val);

    Map<String ,Object> getConfig(String key);

    Map<String ,Object> getAllConfigs();

}
