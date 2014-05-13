//package com.eguaks.core;
//
//
////import com.google.common.collect.ImmutableSet;
//import org.apache.shiro.authc.*;
//import org.apache.shiro.authz.AuthorizationException;
//import org.apache.shiro.authz.AuthorizationInfo;
//import org.apache.shiro.realm.AuthorizingRealm;
//import org.apache.shiro.subject.PrincipalCollection;
//import sun.reflect.generics.reflectiveObjects.NotImplementedException;
//
///**
//* Created by jsska on 06.05.2014.
//*/
//public class MyShiroRealm extends AuthorizingRealm {
//    @Override
//    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
//        if (principals == null) {
//            throw new AuthorizationException("PrincipalCollection method argument cannot be null.");
//        }
//        String username = (String) principals.fromRealm(getName()).iterator().next();
////        Set<String> roleNames = ImmutableSet.of();
////        if (username != null) {
////            roleNames = ImmutableSet.of("admin", "user");
////        }
////        return new SimpleAuthorizationInfo(roleNames);
//        throw new NotImplementedException();
//    }
//
//    @Override
//    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
//        UsernamePasswordToken upToken = (UsernamePasswordToken) token;
//
//        String username = upToken.getUsername();
//
//        if (username == null) {
//            throw new AccountException("Null usernames are not allowed by this realm.");
//        }
//        String password = "password";
//        return new SimpleAuthenticationInfo(username, password, this.getName());
//    }
//}
