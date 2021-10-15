package com.ablog.controller;

import com.ablog.server.Result;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.Subject;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;
import java.net.HttpCookie;

@RestController
public class test {

    @GetMapping("/test")
    public Result tes(HttpSession se)
    {
        Result a = new Result();
        Subject user = SecurityUtils.getSubject();
        Session session = user.getSession();
        System.out.println(session.getId());
        a.setMsg("### 后端设计遵循以下理念\n" +
                "\n" +
                "##### 第一层 controller层 侧重拆分\n" +
                "\n" +
                "定义： 直面用户操作\n" +
                "\n" +
                "作用： 1、用户权限校验 2、数据预校验和预处理 3、数据预校验后的用户提示 4、对下一层处理结果的判断处理以及合适的用户提示（ 开发原则： 1、根据不同用户的不同操作进行拆分。 2、时刻摒除垃圾代码 3、适时合并相关的用户操作\n" +
                "\n" +
                "##### 第二层 service层 侧重基于controller的抽象合并\n" +
                "\n" +
                "定义： 业务逻辑处理\n" +
                "\n" +
                "作用： 1、业务逻辑判断与处理 2、数据库层的交互 3、将业务结果进行标准化处理后返回（状态码，状态值，返回值）\n" +
                "注意：无需返回处理结果的成功与否状态，失败系统则统一异常处理。成功就返回，至于成功后的结果类别则通过状态码区分。状态码需枚举统一存储。\n" +
                "\n" +
                "##### 第三层 dao层 侧重拆分\n" +
                "\n" +
                "定义： 数据操作\n" +
                "\n" +
                "作用： 1、数据的增删改查 开发原则： 除了特复杂的sql逻辑之外，其他的都需要遵从： 1、不能参杂具体的业务逻辑 2、返回值需返回实体对象，尽量避免返回map这样的集合对象，防止多人开发时接口调用调试成本增加。");
        return a;
    }

}
