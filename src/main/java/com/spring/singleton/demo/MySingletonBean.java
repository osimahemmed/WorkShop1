package com.spring.singleton.demo;

import org.springframework.beans.factory.annotation.Autowired;

public class MySingletonBean {
	
	@Autowired
	private MyPrototypeBean prototypeBean;
	
	
	
	public void showMessage() {
		System.out.println("The Current time is " + prototypeBean.getDateTime());
	}
	
	

}
