package com.eguaks.env;

import com.eguaks.annotations.WrapMethod;
import com.eguaks.aop.WrapInterceptor;
import com.eguaks.data.FakeMessageRepository;
import com.eguaks.data.FakeUserRepository;
import com.eguaks.data.MessageRepository;
import com.eguaks.data.UserRepository;
import com.google.guiceberry.GuiceBerryModule;
import com.google.inject.AbstractModule;
import com.google.inject.matcher.Matchers;
import com.google.inject.name.Names;

/**
 * Created by jsska on 22.05.2014.
 */
public class FakeRepoEnv extends AbstractModule {
    @Override
    protected void configure() {
        install(new GuiceBerryModule());
//        bind(GuiceBerryEnvMain.class).to(FakeRepoMain.class);
        bind(UserRepository.class).annotatedWith(Names.named("fakeUserRepo")).to(FakeUserRepository.class);
        bind(MessageRepository.class).annotatedWith(Names.named("fakeMessageRepo")).to(FakeMessageRepository.class);
        bindInterceptor(Matchers.any(), Matchers.annotatedWith(WrapMethod.class), new WrapInterceptor());
    }
      //Don't need to run a server yet!
//    static class FakeRepoMain implements GuiceBerryEnvMain {
//
//        @Override
//        public void run() {
//
//        }
//    }
}
