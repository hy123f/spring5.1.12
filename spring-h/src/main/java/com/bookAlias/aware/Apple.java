package com.bookAlias.aware;

import org.springframework.beans.factory.BeanNameAware;
import org.springframework.beans.factory.InitializingBean;

public class Apple implements BeanNameAware,InitializingBean {

    private String id;
    private String name;

    // ����Aware�ӿڵ����࣬ʵ���˵ķ�������Bean�ĳ�ʼ���׶α�����  //AbstractAutowireCapableBeanFactory
    public void setBeanName(String name) {  
        this.id = name;
    }

    // ����ʵ��InitializingBean�ӿڵ�Bean����Ҫʵ�����������Ŀ�������Ը�ֵ֮������һЩ�ƺ���
    //�˷����ڳ�ʼ������֮ǰִ�С�
    public void afterPropertiesSet() throws Exception {
        System.out.println("Do Anything");
        this.name = "����������������B";
    }

    // �Զ����Bean��ʼ������
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