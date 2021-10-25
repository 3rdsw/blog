package com.ablog.server.impl;

import com.ablog.mapper.UserMapper;
import com.ablog.server.Result;
import com.ablog.server.UserInterface;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import pojo.User;

@Component
public class UserInterfaceImpl implements UserInterface {

    @Autowired
    private UserMapper userMapper;

    @Override
    public void add(User user) {

    }

    @Override
    public void delete(User user) {

        QueryWrapper<User> queryWrapper = new QueryWrapper<User>().eq("user_id", user.getUserId());
        userMapper.delete(queryWrapper);

    }

    @Override
    public void update(User user) {

    }

    @Override
    public void select(User user) {

    }
}
