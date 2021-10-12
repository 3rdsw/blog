package com.ablog.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@MapperScan("com.ablog.mapper")
public class MybatisPlusConfig{
}
