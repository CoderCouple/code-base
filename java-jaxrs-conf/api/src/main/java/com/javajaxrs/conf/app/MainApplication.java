package com.javajaxrs.conf.app;

import com.google.inject.AbstractModule;

import com.javajaxrs.conf.guice.ApiModule;
import org.glassfish.hk2.api.ServiceLocator;

import javax.inject.Inject;
import javax.ws.rs.ApplicationPath;
import javax.ws.rs.container.ContainerRequestFilter;
import javax.ws.rs.container.ContainerResponseFilter;

@ApplicationPath("api")
public class MainApplication extends BaseApplication {

    @Inject
    public MainApplication(ServiceLocator serviceLocator) {
       super(serviceLocator);
    }

    @Override
    public String[] getPackageNames() {
        return new String[] {"com.javajaxrs.conf"};
    }

    @Override
    public AbstractModule getModule() {
        return new ApiModule();
    }

    @Override
    public ContainerRequestFilter registerRequestFilters() {
        return null;
    }

    @Override
    public ContainerResponseFilter registerResponseFilters() {
        return null;
    }

}
