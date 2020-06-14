package com.h.beans.app;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.context.annotation.ComponentScan;

//@ComponentScan("com.h.beans")
public class Appconfig_life implements InitializingBean,DisposableBean{

	public Appconfig_life() {
		System.out.println("Appconfig注册了");
	}

	@Override
	public void afterPropertiesSet() throws Exception {
		System.out.println("hyf_afterPropertiesSet");
	}
	
	@PostConstruct
	public void postConstruct() throws Exception {
		System.out.println("hyf_postConstruct");
	}
	
	@PreDestroy
	public void preDestroy() throws Exception {
		System.out.println("hyf_preDestroy");
	}

	@Override
	public void destroy() throws Exception {
		System.out.println("hyf_destroy");
	}

}
//执行顺序
//Appconfig注册了
//hyf_postConstruct
//hyf_afterPropertiesSet
//hyf_preDestroy
//hyf_destroy

//https://www.cnblogs.com/grey-wolf/p/6627925.html
//spring的一大优点就是扩展性很强，比如，在spring bean 的生命周期中，给我们预留了很多参与bean 的生命周期的方法。
//大致梳理一下，有以下几种：
//通过实现 InitializingBean/DisposableBean 接口来定制初始化之后/销毁之前的操作方法；   
//通过 <bean> 元素的 init-method/destroy-method属性指定初始化之后 /销毁之前调用的操作方法；    这个是在xml文件中进行配置的，现在已经用的不多了了。
//在指定方法上加上@PostConstruct 或@PreDestroy注解来制定该方法是在初始化之后还是销毁之前调用；
//自定义 org.springframework.beans.factory.config.BeanPostProcessor ，来让 spring 回调我们的方法来参与 bean的生命周期。
