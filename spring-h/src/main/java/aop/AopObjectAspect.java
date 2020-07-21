package aop;

import java.util.Arrays;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

/**
 * ����ʹ�� @Order ע��ָ����������ȼ�, ֵԽС���ȼ�Խ��
 */
@Aspect
@Component
public class AopObjectAspect {
	
	/**
	 * ����һ������, ���������������ʽ. һ���, �÷������ٲ���Ҫ���������Ĵ���. 
	 * ʹ�� @Pointcut �������������ʽ. 
	 * ���������ֱ֪ͨ��ʹ�÷����������õ�ǰ���������ʽ. 
	 */
	@Pointcut("execution(public int aop.AopObject.*(..))")
	public void pointcut(){}
	
	/**
	 * �� com.atguigu.spring.aop.ArithmeticCalculator �ӿڵ�ÿһ��ʵ�����ÿһ��������ʼ֮ǰִ��һ�δ���
	 */
	@Before("pointcut()")
	public void beforeMethod(JoinPoint joinPoint){
		System.out.println("beforeMethod");
	}
}


