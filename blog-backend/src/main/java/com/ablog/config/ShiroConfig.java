package com.ablog.config;

import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.LinkedHashMap;

@Configuration
public class ShiroConfig {

    //ShiroFilterFactoryBean
    @Bean
    public ShiroFilterFactoryBean shiroFilterFactoryBean(@Qualifier("SecurityManager") DefaultWebSecurityManager securityManager)
    {
        ShiroFilterFactoryBean FactoryBean = new ShiroFilterFactoryBean();
        FactoryBean.setSecurityManager(securityManager);

        LinkedHashMap<String, String> filtrMap = new LinkedHashMap<>();
        filtrMap.put("login", "anon");
        filtrMap.put("/**/*", "authc");
        FactoryBean.setFilterChainDefinitionMap(filtrMap);

        return FactoryBean;
    }

    //DefaultWebSessionManager
    @Bean(name = "SecurityManager")
    public DefaultWebSecurityManager defaultWebSecurityManager(@Qualifier("UserRealm") UserRealm userRealm)
    {
        DefaultWebSecurityManager securityManager = new DefaultWebSecurityManager();
        securityManager.setRealm(userRealm);
        return securityManager;
    }

    //realm
    @Bean
    public UserRealm UserRealm()
    {
        return new UserRealm();
    }

}
