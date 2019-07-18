package com.javajaxrs.conf.guice;

import com.google.inject.AbstractModule;
import com.google.inject.Provides;
import com.google.inject.Singleton;
import com.javajaxrs.conf.config.Config;
import com.javajaxrs.conf.config.ConfigImpl;

public class ConfigModule extends AbstractModule {
    @Override
    protected void configure() {

    }

    @Provides
    @Singleton
    public Config readConfig(){
        Config config = new ConfigImpl("settings.properties" );
        return config;
    }
}
