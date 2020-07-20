package com.h.beans.app;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.context.annotation.ComponentScan;

//@ComponentScan("com.h.beans")
public class Appconfig_life implements InitializingBean,DisposableBean{

	public Appconfig_life() {
		System.out.println("Appconfigע����");
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
//ִ��˳��
//Appconfigע����
//hyf_postConstruct
//hyf_afterPropertiesSet
//hyf_preDestroy
//hyf_destroy

//https://www.cnblogs.com/grey-wolf/p/6627925.html
//spring��һ���ŵ������չ�Ժ�ǿ�����磬��spring bean �����������У�������Ԥ���˺ܶ����bean ���������ڵķ�����
//��������һ�£������¼��֣�
//ͨ��ʵ�� InitializingBean/DisposableBean �ӿ������Ƴ�ʼ��֮��/����֮ǰ�Ĳ���������   
//ͨ�� <bean> Ԫ�ص� init-method/destroy-method����ָ����ʼ��֮�� /����֮ǰ���õĲ���������    �������xml�ļ��н������õģ������Ѿ��õĲ������ˡ�
//��ָ�������ϼ���@PostConstruct ��@PreDestroyע�����ƶ��÷������ڳ�ʼ��֮��������֮ǰ���ã�
//�Զ��� org.springframework.beans.factory.config.BeanPostProcessor ������ spring �ص����ǵķ��������� bean���������ڡ�
