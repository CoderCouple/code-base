package com.javajaxrs.conf.api;

import com.javaarchaius.example.live_config.LiveConfig;
import com.javaarchaius.example.live_config.LiveConfigService;
import com.javajaxrs.conf.config.Config;
import org.glassfish.jersey.server.ResourceConfig;

import javax.ws.rs.core.Response;

public abstract class BaseApiResource extends ResourceConfig {
    Config config;
    LiveConfigService liveConfigService;
    LiveConfig liveConfig;

    public BaseApiResource(final Config config, final LiveConfigService liveConfigService, final LiveConfig liveConfig) {
        this.config = config;
        this.liveConfigService = liveConfigService;
        this.liveConfig = liveConfig;
    }

    public Response syncGet(String key){
        String val = liveConfig.getStringProperty(key);
        return Response.ok("Key : "+key+", value : "+val).build();
    }

    public Response syncGet(String key, String val){
        liveConfigService.setConfig(key,val);
        return Response.ok("Key : "+key+", value : "+val).build();
    }
    public Response syncPost(String key){
        return Response.ok("Key : "+key+", value : "+config.getConfigAsString(key)).build();
    }

}
