package com.eguaks.data;

import com.eguaks.types.User;

import java.util.List;

/**
 * Created by JohnSigvald on 09/05/2014.
 */
public interface UserRepository {

    public User findOne(String id);

    User findByName(String username);

    boolean isValid(String name, String password);

    List<User> getAll();
}
