package com.eguaks.data;

import com.eguaks.annotations.WrapMethod;
import com.eguaks.types.User;
import org.apache.shiro.authz.Permission;
import org.apache.shiro.authz.SimpleRole;
import org.apache.shiro.authz.permission.WildcardPermission;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.enterprise.inject.Alternative;
import javax.inject.Named;
import javax.inject.Singleton;
import javax.swing.text.html.Option;
import java.time.LocalDate;
import java.util.*;

/**
 * Created by jsska on 05.05.2014.
 */


@Singleton
@Alternative
@Named("fakeUserRepo")
public class FakeUserRepository implements UserRepository {

    private static final Logger LOGGER = LoggerFactory.getLogger(FakeUserRepository.class);

    private static List<User> users = createUsers();

    public FakeUserRepository(){

    }

    /*
    * Test AOP on
    * */
    @WrapMethod
    @Override
    public User findOne(String id){
        LOGGER.debug(String.format("Trying to find user with id [%s]", id));
        Optional<User> match = users.stream().filter( user -> user.getId().equals(id)).distinct().findFirst();

        if(match.isPresent()){
            LOGGER.debug(String.format("Found user"));
            return match.get();
        }
        LOGGER.debug(String.format("Did not find user with id [%s]", id));
        return null;
    }

    @Override
    public User findByName(String username){

        Optional<User> match = users.stream().filter(user -> user.getName().equalsIgnoreCase(username)).findFirst();

        if(match.isPresent()){
            return match.get();
        }
        return null;
    }

    @Override
    public boolean isValid(String name, String password){
        User user = findByName(name);

        if(name != null && password != null){
            if(user != null && user.getPassword() != null && user.getPassword().equals(password)){
                return true;
            }
        }

        return false;

    }

    @Override
    public List<User> getAll() {
        return users;
    }

    @Override
    public void update(User user) {
        List<User> users = createUsers();
        Optional<User> actual = users.stream().filter( u -> u.getId().equals(user.getId())).findFirst();
        if(actual.isPresent()){
            User actualUser = actual.get();
            actualUser.setCaption(user.getCaption());
        }
    }


    static List<User> createUsers(){
        List<User> users = new ArrayList<>();
        Set<SimpleRole> roles = new HashSet<>();
        SimpleRole role = new SimpleRole();
        role.setName("ADMIN");
        Permission permission = new WildcardPermission("*");
        Set<Permission> permissions = new HashSet<>();
        permissions.add(permission);
        role.setPermissions(permissions);
        roles.add(role);

        User user1 = new User("1", "John", "John1", LocalDate.now());
        user1.setRoles(roles);

        users.add(user1);
        users.add(new User("2", "Jane", "Jane2", LocalDate.of(1981, 1, 4)));
        users.add(new User("3", "Nils", "Nils3", LocalDate.of(1972, 6, 27)));
        users.add(new User("4", "Trine", "Trine4", LocalDate.now()));

        return users;
    }



}
