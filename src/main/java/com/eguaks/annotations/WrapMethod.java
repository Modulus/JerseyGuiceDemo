package com.eguaks.annotations;

/**
 * Created by Modulus on 14.05.2014.
 */

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
public @interface WrapMethod {
    /**
     * https://code.google.com/p/google-guice/wiki/AOP
     * For more info
     * */
}
