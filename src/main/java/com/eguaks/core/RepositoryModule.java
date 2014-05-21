package com.eguaks.core;

import com.eguaks.data.FakeMessageRepository;
import com.eguaks.data.FakeUserRepository;
import com.eguaks.data.MessageRepository;
import com.eguaks.data.UserRepository;
import com.google.inject.AbstractModule;
import com.google.inject.name.Names;

/**
 * Created by jsska on 19.05.2014.
 */
public class RepositoryModule extends AbstractModule {
    @Override
    protected void configure() {
        bind(UserRepository.class).annotatedWith(Names.named("fakeUserRepo")).to(FakeUserRepository.class);
        bind(MessageRepository.class).annotatedWith(Names.named("fakeMessageRepo")).to(FakeMessageRepository.class);
    }
}
