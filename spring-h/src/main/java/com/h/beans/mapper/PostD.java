package com.h.beans.mapper;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.support.GenericBeanDefinition;
import org.springframework.stereotype.Component;

import com.h.beans.services.AbService;
//@Component
public class PostD implements BeanFactoryPostProcessor{

	@Override
	public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException {
		// TODO Auto-generated method stub
		GenericBeanDefinition beanDefinition = (GenericBeanDefinition)beanFactory.getBeanDefinition("aaService");
		beanDefinition.setBeanClass(AbService.class);
		
	}

}
