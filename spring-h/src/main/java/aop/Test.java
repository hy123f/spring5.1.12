package aop;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Test {
	
	public static void main(String[] args) {
		AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(AppConfig.class);
		AopObject bean = ac.getBean(AopObject.class);
		bean.aoped();
		ac.close();
	}

}
