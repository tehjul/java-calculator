package com.iut.as2021.config;

import com.iut.as2021.bean.DateBean;
import com.iut.as2021.bean.DateSingletonBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Scope;

import static org.springframework.beans.factory.config.ConfigurableBeanFactory.SCOPE_PROTOTYPE;

@ComponentScan(basePackages = {"com.iut.as2021.bean, com.iut.as2021.tools"})
public class AppConfig {

    @Bean
    @Scope(SCOPE_PROTOTYPE)
    public DateBean prototypeBean() {
        return new DateBean();
    }

    @Bean
    public DateSingletonBean singletonBean() {
        return new DateSingletonBean();
    }
}
