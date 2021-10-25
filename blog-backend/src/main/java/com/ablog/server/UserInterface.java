package com.ablog.server;

import org.apache.shiro.authc.UsernamePasswordToken;
import pojo.User;

public interface UserInterface {

    void add(User user);

    void delete(User user);

    void update(User user);

    void select(User user);

}
