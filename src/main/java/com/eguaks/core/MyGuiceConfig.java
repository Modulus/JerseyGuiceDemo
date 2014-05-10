package com.eguaks.core;

import com.eguaks.data.FakeMessageRepository;
import com.eguaks.data.FakeUserRepository;
import com.eguaks.data.MessageRepository;
import com.eguaks.data.UserRepository;
import com.eguaks.resources.MessageResource;
import com.eguaks.resources.UserResource;
import com.sun.jersey.guice.JerseyServletModule;
import com.sun.jersey.guice.spi.container.servlet.GuiceContainer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class MyGuiceConfig extends JerseyServletModule {

    private static final Logger LOGGER = LoggerFactory.getLogger(MyGuiceConfig.class);

    @Override
    protected void configureServlets() {
        LOGGER.info("Binding types");
        bind(MessageResource.class);
        bind(UserResource.class);
        bind(UserRepository.class).to(FakeUserRepository.class);
        bind(MessageRepository.class).to(FakeMessageRepository.class);
//        bind(MessageRepository.class).annotatedWith(Names.named("fakeMessageRepo")).to(FakeMessageRepository.class);
//        bind(PersonResource.class).annotatedWith(Names.named("personResource")).to(GreeterImpl.class);
//        bind(Greeter.class).annotatedWith(Names.named("greeterv2")).to(com.eguaks.types.v2.GreeterVersion2Impl.class);
//        bind(GreeterV2.class).annotatedWith(Names.named("greeterv2")).to(com.eguaks.types.v2.GreeterVersion2Impl.class);

        /**
         * Need to serve content above /, since / will serve static content (ie html/css/js ++)
         * */
         serve("/api/*").with(GuiceContainer.class);
        LOGGER.info("Types available");
    }
}