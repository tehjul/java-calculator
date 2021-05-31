package com.iut.as2021.config;

import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.ClassPathResource;

import static com.iut.as2021.config.IutConstants.APPLICATION_CONTEXT_FILE;

public class BeanManager {
    private BeanManager() {

    }

    @Deprecated
    public static Object getBean(String name) {
        XmlBeanFactory beanFactory = new XmlBeanFactory(new ClassPathResource(APPLICATION_CONTEXT_FILE));
        return beanFactory.getBean(name);
    }

    public static Object getNewBean(String name) {
        DefaultListableBeanFactory bf = new DefaultListableBeanFactory();
        XmlBeanDefinitionReader reader = new XmlBeanDefinitionReader(bf);
        reader.loadBeanDefinitions(APPLICATION_CONTEXT_FILE);
        return bf.getBean(name);
    }
}
