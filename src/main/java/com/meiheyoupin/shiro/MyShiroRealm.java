package com.meiheyoupin.shiro;

import com.meiheyoupin.entity.UserAdmin;
import com.meiheyoupin.service.UserAdminService;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.HashSet;
import java.util.Set;


public class MyShiroRealm extends AuthorizingRealm {

    @Autowired
    UserAdminService userAdminService;

    //授权
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
        SimpleAuthorizationInfo info = null;
        String name = principals.toString();
        Set<String> roles = new HashSet<String>();
        info = new SimpleAuthorizationInfo(roles);
        //info.addRole("admin");
        return info;
    }

    //认证
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
        UsernamePasswordToken usernamePasswordToken = (UsernamePasswordToken) token;
        String username = (String) usernamePasswordToken.getPrincipal();
        UserAdmin result = userAdminService.getUserByName(username);
        if (result==null){
            throw new UnknownAccountException("没有找到该账号");
        }
        return new SimpleAuthenticationInfo(username,result.getPassword(),getName());
    }
}