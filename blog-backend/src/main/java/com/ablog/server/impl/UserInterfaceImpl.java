package com.ablog.server.impl;

import com.ablog.mapper.UserMapper;
import com.ablog.server.UserInterface;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
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
    public void delete(Long id) {

        System.out.println(id);
        QueryWrapper<User> queryWrapper = new QueryWrapper<User>().eq("user_id", id);
        userMapper.delete(queryWrapper);

    }

    @Override
    public void update(User user) {

    }

    @Override
    public void select(String name) {

    }
}
