package jdbc.jpa;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Test {
	
	public static void main(String[] args) {
		AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(AppConfig.class);
		CarService bean = ac.getBean(CarService.class);
		bean.insert();
		
		ac.close();
	}

}
