package com.eguaks.types.v2;

import com.eguaks.types.Greeter;

/**
 * Created by jsska on 10.04.2014.
 */
public interface GreeterV2 extends Greeter {
    PersonVersion2Impl getGreeting(String firstname, String lastname);

}
