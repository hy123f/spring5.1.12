package cglib;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Test {
	
	public static void main(String[] args) {
		AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(AppConfig.class);
		Y y = ac.getBean(Y.class);
		System.out.println(y);
		
		
		ac.close();
		
	}

}
