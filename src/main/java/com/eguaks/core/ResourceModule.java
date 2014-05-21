package com.eguaks.core;

import com.eguaks.resources.MessageResource;
import com.eguaks.resources.UserResource;
import com.sun.jersey.guice.JerseyServletModule;
import com.sun.jersey.guice.spi.container.servlet.GuiceContainer;
import org.apache.shiro.guice.web.GuiceShiroFilter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ResourceModule extends JerseyServletModule {

    private static final Logger LOGGER = LoggerFactory.getLogger(ResourceModule.class);

    @Override
    protected void configureServlets() {
        LOGGER.info("Binding types");
        bind(MessageResource.class);
        bind(UserResource.class);

        filter("*").through(GuiceShiroFilter.class);
        /**
         * Need to serve content above /, since / will serve static content (ie html/css/js ++)
         * */
         serve("/api/*").with(GuiceContainer.class);

        LOGGER.info("Types available");
    }
}