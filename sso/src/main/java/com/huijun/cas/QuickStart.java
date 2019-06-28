package com.huijun.cas;

import com.huijun.cas.config.MyRealm;
import org.apache.shiro.realm.Realm;
import org.apache.shiro.spring.web.config.DefaultShiroFilterChainDefinition;
import org.apache.shiro.spring.web.config.ShiroFilterChainDefinition;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

/**
 * @program: cas
 * @description: 启动类
 * @author: Mr.si
 * @create: 2019-06-27 18:30
 **/

@SpringBootApplication
@MapperScan("com.huijun.cas.dao")
public class QuickStart {

    public static void main(String[] args) {
        SpringApplication.run(QuickStart.class,args);
    }

    @Bean
    public Realm getRealm(){
        return new MyRealm();
    }

    @Bean
    public ShiroFilterChainDefinition shiroFilterChainDefinition() {
        DefaultShiroFilterChainDefinition chainDefinition = new DefaultShiroFilterChainDefinition();
        chainDefinition.addPathDefinition("/logout", "logout");
        chainDefinition.addPathDefinition("/login.html", "anon");//可以匿名访问
        chainDefinition.addPathDefinition("/error.html", "anon");//可以匿名访问
        //其它路径均需要登录
        chainDefinition.addPathDefinition("/**", "authc");
        return chainDefinition;
    }
}
