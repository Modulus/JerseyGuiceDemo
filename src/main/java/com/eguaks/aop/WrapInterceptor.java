package com.eguaks.aop;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by Modulus on 14.05.2014.
 * NB: In order for this to work, the method being wrapped, needs to be in an
 * instance injected by @Inject
 */
public class WrapInterceptor implements MethodInterceptor{

    private final static Logger LOGGER = LoggerFactory.getLogger(WrapInterceptor.class);

    @Override
    public Object invoke(MethodInvocation methodInvocation) throws Throwable {
        LOGGER.trace("Wrapping method call");

        Object result = methodInvocation.proceed();

        LOGGER.trace(String.format("Method call finished with %s", result));
        return result;
    }
}
