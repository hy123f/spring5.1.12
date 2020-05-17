package configration;

import java.lang.reflect.Proxy;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Test {
	
	public static void main(String[] args) {
		AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(AppConfig.class);
//		Y y = ac.getBean(Y.class);
//		System.out.println(y);
		
//		AppConfig appConfig = ac.getBean(AppConfig.class);
//		System.out.println(appConfig);//configration.AppConfig$$EnhancerBySpringCGLIB$$b242a0d@181e731e
//		如果去掉config
//		System.out.println(appConfig);//只是一个单独的对象。
		
		ac.close();
		
//	    AppConfig app1 = null;
//	    AppConfig app = Proxy.ne;
//	    app.y();//如何让y只执行一遍。   如果是你如何处理。
//	    app.z();//通过代理来实现，比如改变内部的方法。   把z调用Y的方法给注释掉。
	}

}
