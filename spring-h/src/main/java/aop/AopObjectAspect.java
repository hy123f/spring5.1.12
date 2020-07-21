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
 * 可以使用 @Order 注解指定切面的优先级, 值越小优先级越高
 */
@Aspect
@Component
public class AopObjectAspect {
	
	/**
	 * 定义一个方法, 用于声明切入点表达式. 一般地, 该方法中再不需要添入其他的代码. 
	 * 使用 @Pointcut 来声明切入点表达式. 
	 * 后面的其他通知直接使用方法名来引用当前的切入点表达式. 
	 */
	@Pointcut("execution(public int aop.AopObject.*(..))")
	public void pointcut(){}
	
	/**
	 * 在 com.atguigu.spring.aop.ArithmeticCalculator 接口的每一个实现类的每一个方法开始之前执行一段代码
	 */
	@Before("pointcut()")
	public void beforeMethod(JoinPoint joinPoint){
		System.out.println("beforeMethod");
	}
}


