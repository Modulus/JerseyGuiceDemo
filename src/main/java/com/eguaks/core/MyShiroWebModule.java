package com.eguaks.core;

import com.google.inject.Provides;
import com.google.inject.Singleton;
import org.apache.shiro.config.Ini;
import org.apache.shiro.guice.web.ShiroWebModule;

import javax.servlet.ServletContext;

/**
* Created by jsska on 06.05.2014.
*/
public class MyShiroWebModule extends ShiroWebModule {

    public MyShiroWebModule(ServletContext servletContext) {
        super(servletContext);
    }

    @Override
    protected void configureShiroWeb() {

//bindRealm().toConstructor(IniRealm.class.getConstructor(Ini.class));
        bindRealm().to(MyShiroRealm.class).in(Singleton.class);
        addFilterChain("/api/**", AUTHC_BASIC);
    }

    @Provides
    Ini loadShiroIni() {
        return Ini.fromResourcePath("classpath:shiro.ini");
    }
}
