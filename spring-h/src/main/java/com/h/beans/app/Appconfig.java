package com.h.beans.app;

import org.springframework.context.annotation.ComponentScan;

@ComponentScan("com.h.beans")
public class Appconfig{

	public Appconfig() {
		System.out.println("Appconfigע����");
	}
}
