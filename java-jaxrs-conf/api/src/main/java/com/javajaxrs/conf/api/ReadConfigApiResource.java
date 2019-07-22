package com.javajaxrs.conf.api;


import com.javaarchaius.example.live_config.LiveConfig;
import com.javaarchaius.example.live_config.LiveConfigService;
import com.javajaxrs.conf.config.Config;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("v1")
@Produces(MediaType.APPLICATION_JSON)
public class ReadConfigApiResource extends BaseApiResource {

    @Inject
    public ReadConfigApiResource(final Config config, final LiveConfigService liveConfigService, final LiveConfig liveConfig) {
        super(config,liveConfigService,liveConfig);
    }

    @GET
    @Path("/read/{configName}")
    public Response readConfig(@PathParam("configName") String configName){
        return  syncGet(configName);
    }

    @GET
    @Path("/write/{configName}-{configValue}")
    public Response readConfig(@PathParam("configName") String configName, @PathParam("configValue") String configValue){
        return  syncGet(configName,configValue);
    }

}

