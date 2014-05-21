package com.eguaks.core;

import com.google.inject.AbstractModule;
import com.google.inject.name.Names;

/**
 * Created by jsska on 19.05.2014.
 */
public class ConfigModule extends AbstractModule {
    @Override
    protected void configure() {
        bind(String.class).annotatedWith(Names.named("server.address")).toInstance("myfakebox.com");
        bind(Integer.class).annotatedWith(Names.named("timeout")).toInstance(300);
    }
}
