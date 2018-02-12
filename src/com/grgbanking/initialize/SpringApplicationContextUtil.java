package com.grgbanking.initialize;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

@Component
public class SpringApplicationContextUtil implements ApplicationContextAware {

	private static ApplicationContext applicationContext;

	@Override
	public void setApplicationContext(
			ApplicationContext context)
			throws BeansException {
		SpringApplicationContextUtil.applicationContext = context;
	}

	public static ApplicationContext getContext(){

		return applicationContext;
	}

	public final static Object getBean(String beanName){
		return applicationContext.getBean(beanName);
	}

	public final static Object getBean(String beanName,Class<?> requiredType){
		return applicationContext.getBean(beanName,requiredType);
	}
}