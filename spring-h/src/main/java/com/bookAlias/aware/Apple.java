package com.bookAlias.aware;

import org.springframework.beans.factory.BeanNameAware;
import org.springframework.beans.factory.InitializingBean;

public class Apple implements BeanNameAware,InitializingBean {

    private String id;
    private String name;

    // 对于Aware接口的子类，实现了的方法会在Bean的初始化阶段被调用  //AbstractAutowireCapableBeanFactory
    public void setBeanName(String name) {  
        this.id = name;
    }

    // 对于实现InitializingBean接口的Bean，需要实现这个方法，目的是属性赋值之后做的一些善后工作
    //此方法在初始化方法之前执行。
    public void afterPropertiesSet() throws Exception {
        System.out.println("Do Anything");
        this.name = "我这里设置了属性B";
    }

    // 自定义的Bean初始化方法
    public void myInitMethod(){
        System.out.println("Do Something");
    }

    
    
    
    
    
    
    
    
    
    
    
    
	/**
	 * @return the id
	 */
	public String getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(String id) {
		this.id = id;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}
}