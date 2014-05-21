package com.eguaks.core;

import com.eguaks.annotations.WrapMethod;
import com.eguaks.aop.WrapInterceptor;
import com.google.inject.AbstractModule;
import com.google.inject.matcher.Matchers;

/**
 * Created by jsska on 19.05.2014.
 */
public class InterceptorsModule extends AbstractModule {
    @Override
    protected void configure() {
        bindInterceptor(Matchers.any(), Matchers.annotatedWith(WrapMethod.class), new WrapInterceptor());

    }
}
