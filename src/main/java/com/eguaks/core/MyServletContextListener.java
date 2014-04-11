package com.eguaks.core;

import com.google.inject.Guice;
import com.google.inject.Injector;
import com.google.inject.servlet.GuiceServletContextListener;

public class MyServletContextListener extends GuiceServletContextListener {

    @Override
    protected Injector getInjector() {
        return Guice.createInjector(new MyGuiceConfig());
    }
}