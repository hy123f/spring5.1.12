package mvc;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;

@Configuration
@ComponentScan("mvc")
public class AppConfig  extends WebMvcConfigurationSupport{

	@Autowired
	private ArgamentResovel argamentResovel;
	
	public void addArgamentResovel(List<HandlerMethodArgumentResolver> resolve) {
		resolve.add(null);
	}
	
}
