package com.testspring.app;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Created by Praktykant on 02.09.14.
 */

@Configuration
public class AnotherBeansConfig {

    @Bean
    public HelloWorldBean helloWorldBean() {
        return new HelloWorldBean();
    }
}
