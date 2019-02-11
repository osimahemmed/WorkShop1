package com.spring.singleton.demo;

import java.time.LocalDateTime;
import java.util.Date;

public class MyPrototypeBean {
	
	private LocalDateTime dateTimeString = LocalDateTime.now();

    public LocalDateTime getDateTime() {
        return dateTimeString;
    }

}
