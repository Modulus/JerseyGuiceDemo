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
        User user = UserRepository.findOne("1");

        assertEquals(user.getId(), "1");
        assertEquals(user.getName(), "John");
        assertEquals(user.getPassword(), "John1");
    }

    @Test
    public void testFindOneNull(){
        User user = UserRepository.findByName("123");

        assertNull(user);
    }

    @Test
    public void testFindByName(){
        User user = UserRepository.findByName("Jane");

        assertNotNull(user);
        assertEquals(user.getName(), "Jane");

    }

    @Test
    public void testFindByNameNull(){
        User user = UserRepository.findByName("Jljlaksdf");

        assertNull(user);
    }



    @Test
    public void testIsValid(){
        assertTrue(UserRepository.isValid("John", "John1"));
    }

    @Test
    public void testIsValidInvalidPassword(){
        assertFalse(UserRepository.isValid("John", "Fjas"));
        assertFalse(UserRepository.isValid(null, null));
        assertFalse(UserRepository.isValid("John", null));
        assertFalse(UserRepository.isValid(null, "John1"));
    }

}
