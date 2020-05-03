package com.crpdev.spring.config;

import com.crpdev.spring.bean.SimpleDataSource;
import com.crpdev.spring.bean.SimpleJmsSource;
import com.crpdev.spring.bean.SimpleMqSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.PropertySources;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.core.env.Environment;

@Configuration
/**
 * Prior Spring 4
 */
//@PropertySource({"classpath:datasource.properties", "classpath:jms.properties"})
/**
 * Post Spring 4
 */
@PropertySources({
        @PropertySource("classpath:datasource.properties"),
        @PropertySource("classpath:jms.properties")
})
public class PropertyConfig {

    @Autowired
    Environment env;

    @Value("${crpdev.ds.username}")
    private String dbUser;

    @Value("${crpdev.ds.password}")
    private String dbPassword;

    @Value("${crpdev.ds.url")
    private String dbUrl;

    @Value("${crpdev.jms.username}")
    private String jmsUser;

    @Value("${crpdev.jms.password}")
    private String jmsPassword;

    @Value("${crpdev.jms.url")
    private String jmsUrl;

    @Value("${crpdev.mq.username}")
    private String mqUser;

    @Value("${crpdev.mq.password}")
    private String mqPassword;

    @Value("${crpdev.mq.url")
    private String mqUrl;

    @Bean
    public SimpleDataSource dataSource(){
        SimpleDataSource dataSource = new SimpleDataSource(dbUser, dbPassword, dbUrl);
        System.out.println("Value from the environment: " + env.getProperty("crpdev.username"));
        return dataSource;
    }

    @Bean
    public SimpleJmsSource jmsSource(){
        SimpleJmsSource jmsSource = new SimpleJmsSource(jmsUser, jmsPassword, jmsUrl);
        return jmsSource;
    }

    @Bean
    public SimpleMqSource mqSource(){
        SimpleMqSource mqSource = new SimpleMqSource(mqUser, mqPassword, mqUrl);
        return mqSource;
    }

    @Bean
    public static PropertySourcesPlaceholderConfigurer properties(){
        PropertySourcesPlaceholderConfigurer propertySourcesPlaceholderConfigurer = new PropertySourcesPlaceholderConfigurer();
        return propertySourcesPlaceholderConfigurer;
    }
}
