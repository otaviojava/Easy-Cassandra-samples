package org.javabahia.cassandra.spring.cv.context;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

public class SpringApplicationContext implements ApplicationContextAware {

	private static ApplicationContext appContext;

    private SpringApplicationContext() {}
    
	@Override
	public void setApplicationContext(ApplicationContext applicationContext)
			throws BeansException {
		appContext = applicationContext;

	}

	public static Object getBean(String beanName) {
		return appContext.getBean(beanName);
	}

}