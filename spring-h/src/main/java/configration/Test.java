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
//		���ȥ��config
//		System.out.println(appConfig);//ֻ��һ�������Ķ���
		
		ac.close();
		
//	    AppConfig app1 = null;
//	    AppConfig app = Proxy.ne;
//	    app.y();//�����yִֻ��һ�顣   ���������δ���
//	    app.z();//ͨ��������ʵ�֣�����ı��ڲ��ķ�����   ��z����Y�ķ�����ע�͵���
	}

}
