package com.ablog;

import com.ablog.mapper.UserMapper;
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
        user.setUser_email("616321565@qq.com");
        user.setUser_name("3rdsw");
        user.setUser_password("123456");

        int result = userMapper.insert(user);
        System.out.println(result);
        System.out.println(user);

    }

}
