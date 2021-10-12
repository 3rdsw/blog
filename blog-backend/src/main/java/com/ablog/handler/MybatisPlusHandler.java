package com.ablog.handler;

import com.baomidou.mybatisplus.core.handlers.MetaObjectHandler;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.reflection.MetaObject;
import org.springframework.stereotype.Component;

import java.util.Date;


@Slf4j
@Component
public class MybatisPlusHandler implements MetaObjectHandler {

    @Override
    public void insertFill(MetaObject metaObject) {
        log.info("开始插入注入...");
        this.setFieldValByName("date_create", new Date(), metaObject);
        this.setFieldValByName("date_modify", new Date(), metaObject);
        System.out.println(new Date());
    }

    @Override
    public void updateFill(MetaObject metaObject) {
        log.info("开始插入注入...");
        this.setFieldValByName("date_modify", new Date(), metaObject);
    }
}
