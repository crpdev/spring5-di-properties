package com.crpdev.spring;

import com.crpdev.spring.bean.SimpleDataSource;
import com.crpdev.spring.bean.SimpleJmsSource;
import com.crpdev.spring.bean.SimpleMqSource;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class Spring5DiPropertiesApplication {

    public static void main(String[] args) {
        ApplicationContext ctx = SpringApplication.run(Spring5DiPropertiesApplication.class, args);
        SimpleDataSource dataSource = ctx.getBean(SimpleDataSource.class);
        SimpleJmsSource jmsSource = ctx.getBean(SimpleJmsSource.class);
        SimpleMqSource mqSource = ctx.getBean(SimpleMqSource.class);


        System.out.println("DS user: " + dataSource.getUser());
        System.out.println("JMS user: " + jmsSource.getUser());
        System.out.println("MQ user: " + mqSource.getUser());

    }

}
