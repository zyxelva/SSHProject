package com.grgbanking.initialize;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * 以静态变量保存Spring ApplicationContext,可在任意代码中取出ApplicaitonContext
 *
 * @author Tom
 * @date 2016年10月27日 上午11:17:01
 *
 * @version 1.0 2016年10月27日 Tom create
 *
 * @copyright Copyright © 2016 广电运通 All rights reserved.
 */
public class SpringContextHolder implements ApplicationContextAware {

	private static ApplicationContext applicationContext;

	/**
	 * 非web应用中加载公共基础信息模块
	 */
	public static void loadApplicationContext() {
		applicationContext = new ClassPathXmlApplicationContext("classpath:conf/applicationContext.xml");
	}

	/**
	 * 实现ApplicationContextAware接口的context注入函数, 将其存入静态变量.
	 *
	 * @param applicationContext
	 *            applicationContext
	 */
	@Override
    public void setApplicationContext(ApplicationContext applicationContext) {
		SpringContextHolder.setValue(applicationContext);
	}

	/**
	 *
	 * @param applicationContext
	 */
	public static void setValue(ApplicationContext applicationContext) {
		SpringContextHolder.applicationContext = applicationContext;
	}

	/**
	 * 取得存储在静态变量中的ApplicationContext.
	 *
	 * @return applicationContext
	 */
	public static ApplicationContext getApplicationContext() {
		checkApplicationContext();
		return applicationContext;
	}

	/**
	 * 从静态变量ApplicationContext中取得Bean, 自动转型为所赋值对象的类型.
	 *
	 * @param <T>
	 *            泛型参数对象
	 * @param name
	 *            bean的名字
	 * @return Bean
	 */
	@SuppressWarnings("unchecked")
	public static <T> T getBean(String name) {
		checkApplicationContext();
		return (T) applicationContext.getBean(name);
	}

	/**
	 * 从静态变量ApplicationContext中取得Bean, 自动转型为所赋值对象的类型.
	 *
	 * @param <T>
	 *            泛型参数对象
	 * @param clazz
	 *            类的名字
	 * @return bean
	 */
	@SuppressWarnings("unchecked")
	public static <T> T getBean(Class<T> clazz) {
		checkApplicationContext();
		return (T) applicationContext.getBeansOfType(clazz);
	}

	private static void checkApplicationContext() {
		if (applicationContext == null) {
            throw new IllegalStateException(
					"applicaitonContext not inject,please in applicationContext.xml define SpringContextUtil");
        }
	}
}
