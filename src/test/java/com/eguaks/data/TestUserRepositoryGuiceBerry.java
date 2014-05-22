package com.eguaks.data;

import com.eguaks.env.FakeRepoEnv;
import com.google.guiceberry.junit4.GuiceBerryRule;
import org.junit.Rule;
import org.junit.Test;

import javax.inject.Inject;
import javax.inject.Named;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

/**
 * Created by jsska on 22.05.2014.
 */
public class TestUserRepositoryGuiceBerry {

    @Rule
    public GuiceBerryRule guiceBerryRule = new GuiceBerryRule(FakeRepoEnv.class);

    @Inject
    @Named("fakeUserRepo")
    private UserRepository userRepository;

    @Test
    public void testInstance(){
        assertNotNull(userRepository);
        assertTrue(FakeUserRepository.class.isAssignableFrom(userRepository.getClass()));
    }

    @Test
    public void testCreateUsers(){

    }

}
