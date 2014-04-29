package com.eguaks.core;

import com.google.inject.Guice;
import com.google.inject.Injector;
import com.google.inject.servlet.GuiceServletContextListener;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class MyServletContextListener extends GuiceServletContextListener {
    private static final Logger LOGGER = LoggerFactory.getLogger(MyServletContextListener.class);

    @Override
    protected Injector getInjector() {
        LOGGER.info("Creating context");
        Injector injector =  Guice.createInjector(new MyGuiceConfig());
        LOGGER.info("Context created successfully");
        return injector;
    }
}