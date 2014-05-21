package com.eguaks.core;


//import com.google.common.collect.ImmutableSet;

import com.eguaks.types.User;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.*;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by jsska on 06.05.2014.
 */
public class MyShiroRealm extends AuthorizingRealm {

    private static Logger LOGGER = LoggerFactory.getLogger(MyShiroRealm.class);

    private UserProvider userProvider;

    public MyShiroRealm() {
        userProvider = new UserProvider();
    }

    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
        Set<String> roles			= new HashSet<String>();
        Set<Permission>		permissions		= new HashSet<Permission>();
        Collection<User> principalsList	= principals.byType(User.class);

        if (principalsList.isEmpty()) {
            throw new AuthorizationException("Empty principals list!");
        }
        //LOADING STUFF FOR PRINCIPAL
        for (User userPrincipal : principalsList) {


                User user = this.userProvider.loadById(userPrincipal.getId());

                Set<SimpleRole> userRoles	= user.getRoles();
                for (SimpleRole r : userRoles) {
                    roles.add(r.getName());
                    Set<Permission> userPermissions	= r.getPermissions();
                    userPermissions.stream().filter(permission -> !permissions.contains(permission)).forEach(permissions::add);
                }

        }
        //THIS IS THE MAIN CODE YOU NEED TO DO !!!!
        SimpleAuthorizationInfo info = new SimpleAuthorizationInfo(roles);
        info.setRoles(roles); //fill in roles
        info.setObjectPermissions(permissions); //add permisions (MUST IMPLEMENT SHIRO PERMISSION INTERFACE)

        return info;
    }

    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
        UsernamePasswordToken upToken = (UsernamePasswordToken) token;

        User user = null;


        user = this.userProvider.loadUserByLoginName(upToken.getUsername());
//

        if (user == null) {
            throw new AuthenticationException("Login name [" + upToken.getUsername() + "] not found!");
        }
        LOGGER.info("Found user with username [{}]", upToken.getUsername());

        return new SimpleAuthenticationInfo(user, user.getPassword(), getName());
    }
}
