package com.meiheyoupin.shiro;

import com.meiheyoupin.entity.UserAdmin;
import com.meiheyoupin.service.UserAdminService;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;


public class MyShiroRealm extends AuthorizingRealm {

    @Autowired
    UserAdminService userAdminService;

    //授权
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
        SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
        String name = principals.toString();
        info.addRole("admin");
        return info;
    }

    //认证
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
        UsernamePasswordToken usernamePasswordToken = (UsernamePasswordToken) token;
        String username = (String) usernamePasswordToken.getPrincipal();
        String password = new String((char[]) token.getCredentials());
        UserAdmin userAdmin = new UserAdmin(username,password);
        UserAdmin result = userAdminService.getUserByPassword(userAdmin);
        if (result==null){
            System.out.println("用户名密码错误");
        }
        return new SimpleAuthenticationInfo(username,password,getName());
    }
}
