package aop1;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

//@Configuration  //ConfigurationClassPostProcessor
@ComponentScan("aop1")
@EnableAspectJAutoProxy  /*�����Զ�Ϊƥ�� aspectJ ע��� Java �����ɴ������ */
public class AppConfig {
}