package com.ablog.server;

import pojo.User;

public interface UserInterface {

    void add(User user);

    void delete(Long id);

    void update(User user);

    void select(String name);

}
