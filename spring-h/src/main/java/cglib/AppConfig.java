package cglib;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

@Configuration  //ConfigurationClassPostProcessor
public class AppConfig {
	
	@Bean
//	@Scope("prototype")
	public Y y() {
		return new Y();
	}
	
	@Bean
	public X x() {
		y();  
		return new X();
	}

}