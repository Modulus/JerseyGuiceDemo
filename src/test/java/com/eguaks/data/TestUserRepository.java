package com.eguaks.data;

import com.eguaks.types.User;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by jsska on 05.05.2014.
 */
public class TestUserRepository {

    @Test
    public void testFindOne(){
        User user = FakeUserRepository.findOne("1");

        assertEquals(user.getId(), "1");
        assertEquals(user.getName(), "John");
        assertEquals(user.getPassword(), "John1");
    }

    @Test
    public void testFindOneNull(){
        User user = FakeUserRepository.findByName("123");

        assertNull(user);
    }

    @Test
    public void testFindByName(){
        User user = FakeUserRepository.findByName("Jane");

        assertNotNull(user);
        assertEquals(user.getName(), "Jane");

    }

    @Test
    public void testFindByNameNull(){
        User user = FakeUserRepository.findByName("Jljlaksdf");

        assertNull(user);
    }



    @Test
    public void testIsValid(){
        assertTrue(FakeUserRepository.isValid("John", "John1"));
    }

    @Test
    public void testIsValidInvalidPassword(){
        assertFalse(FakeUserRepository.isValid("John", "Fjas"));
        assertFalse(FakeUserRepository.isValid(null, null));
        assertFalse(FakeUserRepository.isValid("John", null));
        assertFalse(FakeUserRepository.isValid(null, "John1"));
    }

}
