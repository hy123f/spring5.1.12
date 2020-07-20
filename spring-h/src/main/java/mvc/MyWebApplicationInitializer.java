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
//	 * 1.��web����tomcat������ʱ�򣬻����onStartup
//	 * 1.servletContext  web�����Ķ���  �൱web.xml
//	 * 1.Ϊʲôtomcat����springд�Ľӿ�
//	 * 1.spring��tomcatͬʱ������servlet3.0��һ���淶��spi  SpringServletContainerInitializer
//	 */
//	@Override
//	public void onStartup(ServletContext servletContext) throws ServletException {
//		// ��ʼ��spring��������ͨ��ע��ķ�ʽ ��ʼ��
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
