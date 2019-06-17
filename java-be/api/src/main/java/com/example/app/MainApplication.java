package com.example.app;

import org.glassfish.jersey.server.ResourceConfig;

import javax.ws.rs.ApplicationPath;

@ApplicationPath("api")
public class MainApplication extends ResourceConfig {
    public MainApplication() {
        packages("com.example.api");
    }
}

