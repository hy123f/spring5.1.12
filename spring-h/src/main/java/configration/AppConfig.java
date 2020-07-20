package configration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
//表面这个注解是没有什么作用的。
@Configuration   //为了确保@Bean的对象是单例。            让这个类是一个代理对象。可以去修改里面的方法。   full和site
//@ComponentScan("configration")
public class AppConfig {
	
	@Bean
	public Y y() {
		return new Y();
	}
	
	@Bean
	public Z z() {
		y();  //实际y的构造方法只是执行一遍。
		return new Z();
	}

}//具体看逻辑，而不是具体的逻辑。   processon.com  制图的链接
//AppConfig什么时候被代理。
//AppConfig他最后是要被实例化的，--bean--proxy object
//      先有一个类--proxy  class
//           这个代理类怎么来的
//                 spring中如何根据一个类来产生对象。----这个时候已经有一个代理类。


//spring3.0以后，不支持通过接口注入，   我们平时的，是通过类型注入。
//现在只支持构造方法，bytype，byname。

//mybatis的mappscan扩展了spring的注解。。