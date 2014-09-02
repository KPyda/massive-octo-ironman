package com.testspring.app;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.Scope;

/**
 * Created by Praktykant on 02.09.14.
 */

@Configuration
public class BeansConfig {

    @Bean(initMethod = "init", destroyMethod = "cleanup")
    public InnerBean innerBean() {
        return new InnerBean();
    }

    @Bean(initMethod = "init", destroyMethod = "cleanup")
    @Scope("prototype")
    public OuterBean outerBean() {
        return new OuterBean(new InnerBean());
    }

}
