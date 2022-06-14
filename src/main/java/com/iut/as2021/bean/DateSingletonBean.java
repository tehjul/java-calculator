package com.iut.as2021.bean;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;

public class DateSingletonBean {

    private static final Logger logger = Logger.getLogger(DateSingletonBean.class);

    @Autowired
    private ApplicationContext applicationContext;

    public void showMessage() {
        DateBean bean = applicationContext.getBean(DateBean.class);
        if (logger.isInfoEnabled()) {
            logger.info("Hi, the time is " + bean.getDateTime());
        }
    }
}
