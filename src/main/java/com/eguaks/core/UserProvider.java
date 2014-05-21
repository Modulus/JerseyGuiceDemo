package com.eguaks.core;

import com.eguaks.data.FakeUserRepository;
import com.eguaks.data.UserRepository;
import com.eguaks.types.User;

import javax.annotation.PreDestroy;

/**
 * Created by jsska on 21.05.2014.
 */
public class UserProvider {

    private static UserRepository repo = new FakeUserRepository();

    public User loadUserByLoginName(String username) {
        FakeUserRepository repo = new FakeUserRepository();
        return repo.findByName(username);
    }

    public User loadById(String id) {
        FakeUserRepository repo = new FakeUserRepository();
        return repo.findOne(id);
    }

    @PreDestroy
    public void destroy(){
        repo = null;
    }
}
