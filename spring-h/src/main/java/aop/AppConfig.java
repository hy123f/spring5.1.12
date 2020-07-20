package aop;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

//@Configuration  //ConfigurationClassPostProcessor
@ComponentScan("aop")
@Aspect
public class AppConfig {
	@Pointcut("execution(* aop.AopObject(..))")
    public void mypoint(){
        //«–√Ê∂®“Â
    }
    @Before("mypoint")
    public void doAround() throws Throwable {
        System.out.println("before logic");
    }
}