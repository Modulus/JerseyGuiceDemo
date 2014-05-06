package com.eguaks.data;

import com.eguaks.types.User;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * Created by jsska on 05.05.2014.
 */
public class UserRepository {

    public static User findOne(String id){
        List<User> users = createUsers();

        Optional<User> match = users.stream().filter( user -> user.getId().equals(id)).distinct().findFirst();

        if(match.isPresent()){
            return match.get();
        }
        return null;
    }

    public static User findByName(String username){
        List<User> users = createUsers();

        Optional<User> match = users.stream().filter(user -> user.getName().equalsIgnoreCase(username)).findFirst();

        if(match.isPresent()){
            return match.get();
        }
        return null;
    }

    public static boolean isValid(String name, String password){
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
