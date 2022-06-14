package com.iut.as2021.config;

import com.iut.as2021.dao.entity.EntityMathResultat;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ComponentScans;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;

@Configuration
@EnableTransactionManagement
@ComponentScans(value = { @ComponentScan("com.iut.as2021") })
public class HibernateConfig {

    @Autowired
    private ApplicationContext context;

    private static final String CONFIGURATION_FILE = "classpath:hibernate.cfg.xml";

    @Bean
    public LocalSessionFactoryBean getSessionFactory() {
        LocalSessionFactoryBean factoryBean = new LocalSessionFactoryBean();
        factoryBean.setConfigLocation(context.getResource(CONFIGURATION_FILE));
        factoryBean.setAnnotatedClasses(HibernateConfig.getEntitiesClass());
        return factoryBean;
    }

    @Bean
    public HibernateTransactionManager getTransactionManager() {
        HibernateTransactionManager transactionManager = new HibernateTransactionManager();
        transactionManager.setSessionFactory(getSessionFactory().getObject());
        return transactionManager;
    }

    public static Class<?>[] getEntitiesClass() {
        return new Class<?>[] {EntityMathResultat.class};
    }
}
