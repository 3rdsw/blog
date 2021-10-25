package com.ablog.controller;

import com.ablog.mapper.UserMapper;
import com.ablog.server.Result;
import com.ablog.server.ResultCode;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.LockedAccountException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import pojo.User;

import java.util.List;

@RestController
public class LoginController {
    @Autowired
    private UserMapper userMapper;

    @PostMapping("/login")
    private Result login(@RequestBody User user)
    {
        Result r = new Result();
        executeLogin(user.getUserName(), user.getUserPassword(), r);
        return r;
    }

    @PostMapping("/register")
    private Result register(@RequestBody User user)
    {
        System.out.println("register");
        Result r = new Result();

        String name = user.getUserName();
        String passward = user.getUserPassword();

        int type = user.getUserType();
        QueryWrapper<User> queryWrapper = new QueryWrapper<User>().eq("user_name", name);
        List<User> res = userMapper.selectList(queryWrapper);
        if(res.isEmpty())
        {
            User user1 = new User();
            user1.setUserName(name);
            user1.setUserPassword(passward);
            user1.setUserType(type);
            userMapper.insert(user);
            r.setResultCode(ResultCode.SUCCESS);
            return r;
        }
        r.setResultCode(ResultCode.USER_Name_More);
        return r;
    }

    private void executeLogin(String name, String password, Result r) {
        Subject subject = SecurityUtils.getSubject();
        UsernamePasswordToken token = new UsernamePasswordToken(name, password);

        try {

            subject.login(token);
            r.setResultCode(ResultCode.SUCCESS);
            System.out.println(subject.getSession().getId());
            r.simple().put("token", subject.getSession().getId());
            r.setData(token);

        } catch (UnknownAccountException e) {
            r.setResultCode(ResultCode.USER_NOT_EXIST);
        } catch (LockedAccountException e) {
            r.setResultCode(ResultCode.USER_ACCOUNT_FORBIDDEN);
        } catch (AuthenticationException e) {
            r.setResultCode(ResultCode.USER_LOGIN_ERROR);
        } catch (Exception e) {
            r.setResultCode(ResultCode.ERROR);
        }
    }

    @GetMapping("/logout")
    public Result logout() {

        Result r = new Result();
        Subject subject = SecurityUtils.getSubject();
        subject.logout();
        r.setResultCode(ResultCode.SUCCESS);
        return r;
    }


}
