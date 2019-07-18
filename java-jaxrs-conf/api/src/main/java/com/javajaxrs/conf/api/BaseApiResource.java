package com.javajaxrs.conf.api;

import com.javajaxrs.conf.config.Config;
import com.javajaxrs.conf.res.ResponseGenerator;
import org.glassfish.jersey.server.ResourceConfig;

import javax.ws.rs.core.Response;

public abstract class BaseApiResource extends ResourceConfig {
    Config config;

    public BaseApiResource(Config config) {
        this.config = config;
    }

    public Response syncGet(String key){
        return Response.ok("Key : "+key+", value : "+config.getConfigAsString(key)).build();
    }

    public Response syncPost(String key){
        return Response.ok("Key : "+key+", value : "+config.getConfigAsString(key)).build();
    }

}
