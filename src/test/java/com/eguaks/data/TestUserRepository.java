package com.eguaks.data;

import com.eguaks.types.User;
import org.jglue.cdiunit.ActivatedAlternatives;
import org.jglue.cdiunit.CdiRunner;
import org.junit.Test;
import org.junit.runner.RunWith;

import javax.inject.Inject;
import javax.inject.Named;

import static org.junit.Assert.*;

/**
 * Created by jsska on 05.05.2014.
 */
@RunWith(CdiRunner.class)
@ActivatedAlternatives(value = {FakeUserRepository.class})
public class TestUserRepository {

    @Inject
    @Named("fakeUserRepo")
    private UserRepository userRepo;

    @Test
    public void verifyInstance(){
        assertTrue(userRepo.getClass().isAssignableFrom(FakeUserRepository.class));
    }

    @Test
    public void testFindOne(){
        User user = userRepo.findOne("1");

        assertEquals(user.getId(), "1");
        assertEquals(user.getName(), "John");
        assertEquals(user.getPassword(), "John1");
    }

    @Test
    public void testFindOneNull(){
        User user = userRepo.findByName("123");

        assertNull(user);
    }

    @Test
    public void testFindByName(){
        User user = userRepo.findByName("Jane");

        assertNotNull(user);
        assertEquals(user.getName(), "Jane");

    }

    @Test
    public void testFindByNameNull(){
        User user = userRepo.findByName("Jljlaksdf");

        assertNull(user);
    }



    @Test
    public void testIsValid(){
        assertTrue(userRepo.isValid("John", "John1"));
    }

    @Test
    public void testIsValidInvalidPassword(){
        assertFalse(userRepo.isValid("John", "Fjas"));
        assertFalse(userRepo.isValid(null, null));
        assertFalse(userRepo.isValid("John", null));
        assertFalse(userRepo.isValid(null, "John1"));
    }

}
