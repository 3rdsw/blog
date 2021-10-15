package com.ablog.controller;

import com.ablog.server.impl.UserInterfaceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    @Autowired
    private UserInterfaceImpl userInterface;

    @GetMapping("/delete/{id}")
    public void delete(@PathVariable("id") Long id)
    {
        userInterface.delete(id);
    }

}
