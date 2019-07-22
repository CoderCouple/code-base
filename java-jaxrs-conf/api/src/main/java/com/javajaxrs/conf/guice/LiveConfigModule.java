package com.javajaxrs.conf.guice;

import com.google.inject.AbstractModule;
import com.javaarchaius.example.live_config.DynamicConfigurationSource;
import com.netflix.config.PolledConfigurationSource;

public class LiveConfigModule extends AbstractModule {
    @Override
    protected void configure() {
        bind(PolledConfigurationSource.class).to(DynamicConfigurationSource.class);
    }
}
