package com.javajaxrs.conf.guice;

import com.google.inject.AbstractModule;

public class ApiModule extends AbstractModule{
    @Override
    protected void configure() {
        install(new LiveConfigModule());
        install(new ConfigModule());
    }
}
