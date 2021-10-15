package com.ablog.config;

import com.ablog.mapper.UserMapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;
import pojo.User;

import java.util.List;

public class UserRealm extends AuthorizingRealm {

    @Autowired
    private UserMapper userMapper;

    //授权
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        System.out.println("授权");
        return null;
    }
    //认证
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
        System.out.println("认证");

        UsernamePasswordToken userToken = (UsernamePasswordToken)token;

        System.out.println(userToken.getUsername());

        QueryWrapper<User> queryWrapper = new QueryWrapper<User>().eq("user_name", userToken.getUsername());

        User user = userMapper.selectOne(queryWrapper);

        if (user == null) {
            throw new UnknownAccountException();//没找到帐号
        }
        System.out.println(user);

        return new SimpleAuthenticationInfo("",user.getUserPassword(),"");

    }
}
