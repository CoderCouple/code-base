package com.javajaxrs.conf.app;

import com.google.inject.AbstractModule;
import com.google.inject.Guice;
import com.google.inject.Injector;
import com.google.inject.Provides;
import com.google.inject.name.Named;
import com.google.inject.servlet.RequestScoped;
import com.google.inject.servlet.ServletModule;
import com.javajaxrs.conf.guice.ApiModule;
import org.glassfish.hk2.api.ServiceLocator;
import org.glassfish.jersey.process.internal.RequestContext;
import org.glassfish.jersey.server.ContainerResponse;
import org.glassfish.jersey.server.ResourceConfig;
import org.jvnet.hk2.guice.bridge.api.GuiceBridge;
import org.jvnet.hk2.guice.bridge.api.GuiceIntoHK2Bridge;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.ws.rs.ApplicationPath;
import javax.ws.rs.container.ContainerRequestFilter;
import javax.ws.rs.container.ContainerResponseFilter;

public abstract class BaseApplication extends ResourceConfig {

    private static final Logger logger = LoggerFactory.getLogger(BaseApplication.class);

    public BaseApplication(ServiceLocator serviceLocator) {
        logger.info("Initializing Jersey Application");
        Injector injector = Guice.createInjector(getServletModule());
        packages(true,getPackageNames());
        registerRequestFilters();
        registerResponseFilters();
        initGuiceIntoHK2Bridge(serviceLocator, injector);
        logger.info("Completed Initializing Jersey Application");
    }

    private void initGuiceIntoHK2Bridge(ServiceLocator serviceLocator, Injector injector) {
        logger.info("Initializing the Guice-HK2 bridge");
        GuiceBridge.getGuiceBridge().initializeGuiceBridge(serviceLocator);
        GuiceIntoHK2Bridge guiceBridge = serviceLocator.getService(GuiceIntoHK2Bridge.class);
        guiceBridge.bridgeGuiceInjector(injector);
        logger.info("Completed initializing the Guice-HK2 bridge");
    }

    public abstract String [] getPackageNames();

    public abstract AbstractModule getModule();

    public abstract ContainerRequestFilter registerRequestFilters();

    public abstract ContainerResponseFilter registerResponseFilters();

    public ServletModule getServletModule(){
        logger.info("Initializing Servlet Module");
        return new ServletModule(){
            @Override
            protected void configureServlets(){
                install(getModule());
            }

            @Provides
            @Named("Request_Context")
            @RequestScoped
            public RequestContext provideRequestContext(){
                throw new IllegalStateException("Container Context must me manually seeded.");
            }
        };
    }
}
