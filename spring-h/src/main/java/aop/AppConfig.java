package aop;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@ComponentScan("aop")
@EnableAspectJAutoProxy  /*配置自动为匹配 aspectJ 注解的 Java 类生成代理对象 */
public class AppConfig {
}