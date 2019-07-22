package com.javajaxrs.conf.guice;

import com.google.inject.AbstractModule;
import com.google.inject.Provides;
import com.google.inject.Singleton;
import com.javajaxrs.conf.config.Config;
import com.javajaxrs.conf.config.ConfigImpl;
import org.reflections.Reflections;

import javax.ws.rs.Path;

public class ConfigModule extends AbstractModule {
    @Override
    protected void configure() {
        Reflections reflections = new Reflections("com.javajaxrs.conf.api");
        reflections.getTypesAnnotatedWith(Path.class).forEach(this::bind);
    }

    @Provides
    @Singleton
    public Config readConfig(){
        Config config = new ConfigImpl("settings.properties" );
        return config;
    }
}
