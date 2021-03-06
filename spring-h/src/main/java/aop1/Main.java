package aop1;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {
	
	public static void main(String[] args) {
		
		AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(AppConfig.class);
//		ApplicationContext ctx = new ClassPathXmlApplicationContext("aop1/applicationContext.xml");

		ArithmeticCalculator arithmeticCalculator = (ArithmeticCalculator) ctx.getBean("arithmeticCalculator");
		
		System.out.println(arithmeticCalculator.getClass().getName());
		
		int result = arithmeticCalculator.add(1, 2);
		System.out.println("result:" + result);
		
		result = arithmeticCalculator.div(1000, 10);
		System.out.println("result:" + result);
	}
	
}
