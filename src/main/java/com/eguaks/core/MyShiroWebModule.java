package com.eguaks.core;

import com.google.inject.Provides;
import com.google.inject.Singleton;
import org.apache.shiro.config.Ini;
import org.apache.shiro.guice.web.ShiroWebModule;
import org.apache.shiro.realm.text.IniRealm;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.ServletContext;

/**
* Created by jsska on 06.05.2014.
*/
public class MyShiroWebModule extends ShiroWebModule {

    private static final Logger LOGGER = LoggerFactory.getLogger(MyShiroWebModule.class);

    public MyShiroWebModule(ServletContext servletContext) {
        super(servletContext);
    }

    @Override
    protected void configureShiroWeb() {

        try {
            bindRealm().toConstructor(IniRealm.class.getConstructor(Ini.class));
        } catch (NoSuchMethodException e) {
            LOGGER.error("Failed to bind realm:", e);
        }
        bindRealm().to(MyShiroRealm.class).in(Singleton.class);
        addFilterChain("/**", AUTHC_BASIC, config(PERMS, "yes"));


    }

    @Provides
    Ini loadShiroIni() {
        return Ini.fromResourcePath("classpath:shiro.ini");
    }
}
