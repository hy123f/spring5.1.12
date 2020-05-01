package com.h.beans.test;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.h.beans.app.Appconfig;
import com.h.beans.services.AaService;

public class Test {
	
	public static void main(String[] args) {
		AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(Appconfig.class);
		AaService bean = ac.getBean(AaService.class);
		System.out.println(bean.toString());
		ac.close();
	}

}
