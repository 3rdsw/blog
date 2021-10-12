package com.ablog.controller;

import com.ablog.mapper.UserMapper;
import com.ablog.server.Result;
import com.ablog.server.ResultCode;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import pojo.User;

import javax.servlet.http.HttpSession;
import java.util.List;

@RestController
public class LoginController {
    @Autowired
    private UserMapper userMapper;

    @PostMapping("/login")
    private Result login(@RequestBody User user, HttpSession session)
    {
        System.out.println("login");
        Result r = new Result();
        String name = user.getUser_name();
        String passward = user.getUser_password();
        QueryWrapper<User> queryWrapper = new QueryWrapper<User>().eq("user_name", name)
                .eq("user_password", passward);
        List<User> res = userMapper.selectList(queryWrapper);
        if(res.isEmpty())
        {
            r.setResultCode(ResultCode.ERROR);
            return r;
        }
        session.setAttribute("user", "yes");
        r.setResultCode(ResultCode.SUCCESS);

        return r;
    }

    @PostMapping("/register")
    private Result register(@RequestBody User user)
    {
        System.out.println("register");
        Result r = new Result();
        String name = user.getUser_name();
        String passward = user.getUser_password();
        int type = user.getUser_type();
        QueryWrapper<User> queryWrapper = new QueryWrapper<User>().eq("user_name", name);
        List<User> res = userMapper.selectList(queryWrapper);
        if(res.isEmpty())
        {
            User user1 = new User();
            user1.setUser_name(name);
            user1.setUser_password(passward);
            user1.setUser_type(type);
            userMapper.insert(user);
            r.setResultCode(ResultCode.SUCCESS);
            return r;
        }
        r.setResultCode(ResultCode.ERROR);
        return r;
    }

}
