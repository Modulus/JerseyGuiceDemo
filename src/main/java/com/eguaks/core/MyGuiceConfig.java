package com.eguaks.core;

import com.eguaks.resources.GreeterResource;
import com.eguaks.resources.MessageResource;
import com.eguaks.types.Greeter;
import com.eguaks.types.GreeterImpl;
import com.eguaks.types.v2.GreeterV2;
import com.google.inject.name.Names;
import com.sun.jersey.guice.JerseyServletModule;
import com.sun.jersey.guice.spi.container.servlet.GuiceContainer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class MyGuiceConfig extends JerseyServletModule {

    private static final Logger LOGGER = LoggerFactory.getLogger(MyGuiceConfig.class);

    @Override
    protected void configureServlets() {
        LOGGER.info("Binding types");
        bind(GreeterResource.class);
        bind(MessageResource.class);
        bind(Greeter.class).annotatedWith(Names.named("greeterv1")).to(GreeterImpl.class);
        bind(Greeter.class).annotatedWith(Names.named("greeterv2")).to(com.eguaks.types.v2.GreeterVersion2Impl.class);
        bind(GreeterV2.class).annotatedWith(Names.named("greeterv2")).to(com.eguaks.types.v2.GreeterVersion2Impl.class);
//        bind(org.apache.shiro.mgt.SecurityManager.class).to(DefaultWebSecurityManager.class);


        /**
         * Need to serve content above /, since / will serve static content (ie html/css/js ++)
         * */
         serve("/api/*").with(GuiceContainer.class);
        LOGGER.info("Types available");
    }
}