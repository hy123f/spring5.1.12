//package mvc;
//
//import javax.servlet.ServletContext;
//import javax.servlet.ServletException;
//import javax.servlet.ServletRegistration.Dynamic;
//
//import org.springframework.web.WebApplicationInitializer;
//import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
//import org.springframework.web.servlet.DispatcherServlet;
//
//public class MyWebApplicationInitializer  implements WebApplicationInitializer{
//
//	/**
//	 * 1.当web容器tomcat启动的时候，会调用onStartup
//	 * 1.servletContext  web上下文对象  相当web.xml
//	 * 1.为什么tomcat调用spring写的接口
//	 * 1.spring和tomcat同时遵守了servlet3.0的一个规范，spi  SpringServletContainerInitializer
//	 */
//	@Override
//	public void onStartup(ServletContext servletContext) throws ServletException {
//		// 初始化spring的容器，通过注解的方式 初始化
//		AnnotationConfigWebApplicationContext ac = new AnnotationConfigWebApplicationContext();
//		//  
////		ClassPathXmlApplicationContext
//		ac.setServletContext(servletContext);
//		ac.register(AppConfig.class);
//		ac.refresh();
//		
//		DispatcherServlet servlet = new DispatcherServlet();
//		Dynamic registration = servletContext.addServlet("app", servlet);
//		registration.setLoadOnStartup(1);
//		
//		registration.addMapping("*.do");
//		
//	}
//
//}
