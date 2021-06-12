package com.iut.as2021.main;

import com.iut.as2021.bean.DateSingletonBean;
import com.iut.as2021.config.AppConfig;
import com.iut.as2021.interfaces.IMaths;
import com.iut.as2021.mathematics.Maths;
import com.iut.as2021.tools.BeanUtil;
import org.apache.log4j.Logger;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class WeControlMainStart {

	private static final Logger logger = Logger.getLogger(WeControlMainStart.class);

	public static void main(String[] args) throws InterruptedException {
		logger.info("Main DEMO - application");

		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
		context.isActive();

		DateSingletonBean bean = BeanUtil.getBean(DateSingletonBean.class);
		bean.showMessage();
	}
}
