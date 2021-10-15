package com.ablog;

import com.ablog.mapper.UserMapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import pojo.User;

@SpringBootTest
class ApplicationTests {

    @Autowired
    private UserMapper userMapper;

    @Test
    void insert() {

        User user = new User();
        user.setUserName("123");
        QueryWrapper<User> queryWrapper = new QueryWrapper<User>().eq("user_name", "123");

        User res = userMapper.selectOne(queryWrapper);

        System.out.println(res);

    }

}
