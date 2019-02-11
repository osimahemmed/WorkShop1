package com.spring.singleton.demo;

import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;

@Configuration
public class AppConfig {
	
	@Bean
	@Scope(value = ConfigurableBeanFactory.SCOPE_PROTOTYPE, proxyMode=ScopedProxyMode.TARGET_CLASS)
	public MyPrototypeBean prototypeBean() {
		return new MyPrototypeBean();
	}

	@Bean
	@Scope(ConfigurableBeanFactory.SCOPE_SINGLETON)
	public MySingletonBean singletonBean() {
		return new MySingletonBean();
	}
	
	public static void main(String[] args) throws InterruptedException {
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
		
		MySingletonBean bean = context.getBean(MySingletonBean.class);
		
		bean.showMessage();
		
		Thread.sleep(2000);
		
		bean.showMessage();
		
		context.close();
	}
	
}
