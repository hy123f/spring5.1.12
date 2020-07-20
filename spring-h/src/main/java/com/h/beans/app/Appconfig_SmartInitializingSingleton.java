package com.h.beans.app;

import org.springframework.beans.factory.SmartInitializingSingleton;
import org.springframework.context.annotation.ComponentScan;

@ComponentScan("com.h.beans")
public class Appconfig_SmartInitializingSingleton implements SmartInitializingSingleton{

	public Appconfig_SmartInitializingSingleton() {
		System.out.println("Appconfig×¢²áÁË");
	}

	@Override
	public void afterSingletonsInstantiated() {
		System.out.println("afterSingletonsInstantiated");
	}
	
}
