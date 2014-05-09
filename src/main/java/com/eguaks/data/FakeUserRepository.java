package com.eguaks.data;

import com.eguaks.types.User;

import javax.enterprise.inject.Alternative;
import javax.inject.Named;
import javax.inject.Singleton;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * Created by jsska on 05.05.2014.
 */

@Singleton
@Alternative
@Named("fakeUserRepo")
public class FakeUserRepository {

    private List<User> users;

    public FakeUserRepository(){
        users = createUsers();
    }

    public User findOne(String id){

        Optional<User> match = users.stream().filter( user -> user.getId().equals(id)).distinct().findFirst();

        if(match.isPresent()){
            return match.get();
        }
        return null;
    }

    public User findByName(String username){

        Optional<User> match = users.stream().filter(user -> user.getName().equalsIgnoreCase(username)).findFirst();

        if(match.isPresent()){
            return match.get();
        }
        return null;
    }

    public boolean isValid(String name, String password){
        User user = findByName(name);

        if(name != null && password != null){
            if(user != null && user.getPassword() != null && user.getPassword().equals(password)){
                return true;
            }
        }

        return false;

    }



    public static List<User> createUsers(){
        List<User> users = new ArrayList<>();
        users.add(new User("1", "John", "John1"));
        users.add(new User("2", "Jane", "Jane2"));
        users.add(new User("3", "Nils", "Nils3"));
        users.add(new User("4", "Trine", "Trine4"));

        return users;
    }



}
