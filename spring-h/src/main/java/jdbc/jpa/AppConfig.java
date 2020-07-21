package jdbc.jpa;

import java.beans.PropertyVetoException;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.mchange.v2.c3p0.ComboPooledDataSource;

@Configuration
@ComponentScan("jdbc.jpa")
@EnableTransactionManagement//进入我们开启事务管理的注解，
public class AppConfig {
	
	@Bean
	public DataSource dataSource() throws PropertyVetoException {
		ComboPooledDataSource ds = new ComboPooledDataSource();      
		ds.setUser("root");
		ds.setPassword("root");   
		ds.setDriverClass("com.mysql.jdbc.Driver");
		ds.setJdbcUrl("jdbc:mysql://localhost:3306/jq");
		return ds;
	}
	
	
	@Bean
	public JdbcTemplate jdbcTemplate() throws PropertyVetoException {
		return new JdbcTemplate(dataSource());
	}
	
	/** 加载事务管理器 
	 */
	@Bean
	public PlatformTransactionManager platformTransactionManager() throws PropertyVetoException{
		return new DataSourceTransactionManager(dataSource());
	}
}