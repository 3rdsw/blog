package com.ablog.server.status;

import org.springframework.stereotype.Component;

import javax.servlet.http.HttpSession;

@Component
public class login {
    boolean islogin(HttpSession session)
    {
        if (session.getAttribute("User") == "yes")
        {
            return true;
        }
        return false;
    }
}
