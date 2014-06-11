package com.eguaks.core;

import com.google.inject.Guice;
import com.google.inject.Injector;
import com.google.inject.servlet.GuiceServletContextListener;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.guice.aop.ShiroAopModule;
import org.apache.shiro.mgt.SecurityManager;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;

public class MyServletContextListener extends GuiceServletContextListener  {
    private static final Logger LOGGER = LoggerFactory.getLogger(MyServletContextListener.class);
    private ServletContext servletContext;

    @Override
    protected Injector getInjector() {
        LOGGER.info("Creating context");
        Injector injector =  Guice.createInjector(
                new MyShiroWebModule(servletContext),
                new ShiroAopModule(),
                new ResourceModule(),
                new InterceptorsModule(),
                new RepositoryModule());
        LOGGER.info("Context created successfully");

        SecurityManager securityManager = injector.getInstance(SecurityManager.class);
        SecurityUtils.setSecurityManager( securityManager);

        return injector;
    }

    /**
     * Hook in the context
     * */
    @Override
    public void contextInitialized(ServletContextEvent servletContextEvent) {
        servletContext = servletContextEvent.getServletContext();
        super.contextInitialized(servletContextEvent);
    }
}